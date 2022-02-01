package com.tencent.av.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.qav.log.AVLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeCodec
  implements IMediaCodecCallback
{
  public static final String AVCPPS = "csd-1";
  public static final String AVCSPS = "csd-0";
  public static final String BOTTOM = "crop-bottom";
  public static final String HEVCVPSSPSPPS = "csd-0";
  public static final String LEFT = "crop-left";
  public static final String RIGHT = "crop-right";
  public static final String SLICEHEIGHT = "slice-height";
  public static final String STRIDE = "stride";
  private static final String TAG = "NativeCodec";
  public static final String TOP = "crop-top";
  private static AVCCaps gAVCDecoderCaps;
  private static AVCCaps gAVCEncoderCaps;
  private static AVCCaps gHEVCDecoderCaps;
  private static AVCCaps gHEVCEncoderCaps;
  private static boolean mUseAsyncAPI = false;
  private int mBitRate;
  private AndroidCodec mCodec;
  private AtomicBoolean mCodersExit = new AtomicBoolean(false);
  private int mColorFormat;
  private boolean mDebugDelay = false;
  private Map<Long, Long> mDebugDelayMap;
  private Map<Integer, Long> mDebugDelayMap2;
  private Map<Long, Integer> mDebugIndexMap;
  private boolean mDecoder;
  private MediaFormat mFormat = null;
  private int mFrameInverval = 40000;
  private int mFrameRate = 20;
  private int mHeight = 240;
  private long mLastEncFrameTime = 0L;
  private String mMime;
  private int mNativeContext = 0;
  private List<AndroidCodec.InputBufferData> mPendingInputBuffers = new ArrayList();
  private long mTimeStamp = 0L;
  private int mTotalDecInFrameNum = 0;
  private int mTotalDecOutFrameNum = 0;
  private int mTryAgainLaterCount = 0;
  private int mTryAgainLaterCount2 = 0;
  private int mWidth = 320;
  private int setBitRatePending = 0;
  private boolean setIFramePending = false;
  
  public NativeCodec(String paramString, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    this.mNativeContext = paramInt;
    mUseAsyncAPI = DeviceCheck.isSupportAsyncAPI();
    this.mDecoder = paramBoolean;
    this.mMime = paramString;
    this.mWidth = ((Integer)paramMap.get("width")).intValue();
    this.mHeight = ((Integer)paramMap.get("height")).intValue();
    if (this.mDecoder) {}
    for (;;)
    {
      try
      {
        paramInt = this.mWidth;
        int i = this.mHeight;
        this.mFormat = MediaFormat.createVideoFormat(paramString, paramInt, i);
        if (paramString.contains(AndroidCodec.AVC_CODEC_MIME))
        {
          this.mFormat.setInteger("max-input-size", paramInt * i);
          this.mFormat.setInteger("color-format", 21);
          this.mFormat.setInteger("frame-rate", 25);
          ByteBuffer localByteBuffer1 = (ByteBuffer)paramMap.get("csd-0");
          ByteBuffer localByteBuffer2 = (ByteBuffer)paramMap.get("csd-1");
          this.mFormat.setByteBuffer("csd-0", localByteBuffer1);
          this.mFormat.setByteBuffer("csd-1", localByteBuffer2);
        }
        if (paramString.contains(AndroidCodec.HEVC_CODEC_MIME))
        {
          this.mFormat.setInteger("max-input-size", paramInt * i);
          this.mFormat.setInteger("color-format", 21);
          this.mFormat.setInteger("frame-rate", 25);
          paramString = (ByteBuffer)paramMap.get("csd-0");
          this.mFormat.setByteBuffer("csd-0", paramString);
        }
        createDecCodec();
      }
      catch (Exception paramString)
      {
        this.mCodec = null;
        AVLog.e("NativeCodec", "NativeCodec create decoder fail.", paramString);
        continue;
      }
      if (this.mDebugDelay)
      {
        this.mDebugDelayMap = new HashMap();
        this.mDebugDelayMap2 = new HashMap();
        this.mDebugIndexMap = new HashMap();
      }
      return;
      try
      {
        this.mBitRate = ((Integer)paramMap.get("bitrate")).intValue();
        this.mFrameRate = ((Integer)paramMap.get("frame-rate")).intValue();
        createEncCodec();
      }
      catch (Exception paramString)
      {
        this.mCodec = null;
        AVLog.e("NativeCodec", "NativeCodec create encoder fail.", paramString);
      }
    }
  }
  
  private void calcDelay(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mDebugDelay)
    {
      Object localObject = (Long)this.mDebugDelayMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        AVLog.d("NativeCodec", String.format("calcDelay small %s takes:%sms", new Object[] { Long.valueOf(paramBufferInfo.presentationTimeUs), Long.valueOf(System.currentTimeMillis() - ((Long)localObject).longValue()) }));
        this.mDebugDelayMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      localObject = (Integer)this.mDebugIndexMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        Long localLong = (Long)this.mDebugDelayMap2.get(localObject);
        if (localLong != null)
        {
          AVLog.d("NativeCodec", String.format("calcDelay big %s takes:%sms", new Object[] { Long.valueOf(paramBufferInfo.presentationTimeUs), Long.valueOf(System.currentTimeMillis() - localLong.longValue()) }));
          this.mDebugDelayMap2.remove(localObject);
        }
        this.mDebugIndexMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  private void createDecCodec()
  {
    this.mCodec = new AndroidCodec();
    List localList;
    if (this.mDecoder)
    {
      localList = AndroidCodec.getDecoderInfos(this.mMime);
      if (localList.size() != 0) {
        break label38;
      }
    }
    label38:
    label191:
    for (;;)
    {
      return;
      MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localMediaCodecInfo;
        if (i >= localList.size()) {
          break label130;
        }
        localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject != null) {
          break;
        }
        i += 1;
      }
      if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19))
      {
        localObject = (MediaCodecInfo)localList.get(i);
        this.mFormat.setInteger("color-format", 19);
      }
      for (;;)
      {
        if (this.mCodec.init(this.mFormat, ((MediaCodecInfo)localObject).getName(), this)) {
          break label191;
        }
        this.mCodec = null;
        return;
        if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
          break;
        }
        localObject = (MediaCodecInfo)localList.get(i);
        this.mFormat.setInteger("color-format", 21);
      }
    }
  }
  
  private void createEncCodec()
  {
    int k;
    int i;
    int j;
    Object localObject;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    if (this.mCodec == null) {
      try
      {
        List localList = AndroidCodec.getEncoderInfos(this.mMime);
        this.mColorFormat = 21;
        k = 0;
        i = 0;
        j = k;
        if (i < localList.size())
        {
          localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
          if (localObject == null) {
            break label525;
          }
          if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
            break label252;
          }
          this.mColorFormat = 21;
        }
        for (j = i;; j = i)
        {
          localObject = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
          ((MediaFormat)localObject).setInteger("color-format", this.mColorFormat);
          ((MediaFormat)localObject).setInteger("frame-rate", this.mFrameRate);
          ((MediaFormat)localObject).setInteger("bitrate", this.mBitRate);
          i = 30;
          if (this.mFrameRate * 30 > 255) {
            i = 255 / this.mFrameRate;
          }
          ((MediaFormat)localObject).setInteger("i-frame-interval", i);
          localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(j), this.mMime);
          if (localCodecCapabilities == null) {
            break;
          }
          if (!this.mMime.contains(AndroidCodec.AVC_CODEC_MIME)) {
            break label346;
          }
          i = 0;
          if (i >= localCodecCapabilities.profileLevels.length) {
            break label346;
          }
          switch (localCodecCapabilities.profileLevels[i].profile)
          {
          case 1: 
            label252:
            if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
              break label525;
            }
            this.mColorFormat = 19;
          }
        }
        k = 512;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (512 < localCodecCapabilities.profileLevels[i].level) {
          k = localCodecCapabilities.profileLevels[i].level;
        }
        ((MediaFormat)localObject).setInteger("level", k);
      }
      catch (Exception localException)
      {
        this.mCodec = null;
        AVLog.e("NativeCodec", "createEncCodec fail.", localException);
      }
    } else {
      return;
    }
    label346:
    if (this.mMime.contains(AndroidCodec.HEVC_CODEC_MIME)) {
      i = 0;
    }
    for (;;)
    {
      if (i < localCodecCapabilities.profileLevels.length) {}
      switch (localCodecCapabilities.profileLevels[i].profile)
      {
      case 1: 
        k = 16384;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (16384 < localCodecCapabilities.profileLevels[i].level) {
          k = localCodecCapabilities.profileLevels[i].level;
        }
        ((MediaFormat)localObject).setInteger("level", k);
        break label539;
        this.mFormat = ((MediaFormat)localObject);
        if (this.mFrameRate > 0) {}
        for (this.mFrameInverval = (1000000 / this.mFrameRate);; this.mFrameInverval = 40000)
        {
          this.mCodec = new AndroidCodec();
          this.mCodec.init(this.mFormat, ((MediaCodecInfo)localException.get(j)).getName(), this);
          return;
        }
        i += 1;
        break;
        i += 1;
        break;
      default: 
        label525:
        label539:
        i += 1;
      }
    }
  }
  
  private boolean dequeueLastFrame(int paramInt)
  {
    if (this.mCodec == null)
    {
      AVLog.e("NativeCodec", "dequeueLastDecFrame mCodec is null.");
      return false;
    }
    paramInt = 0;
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        AndroidCodec.BufferData localBufferData1 = this.mCodec.getInputBuffer();
        AndroidCodec.BufferData localBufferData2 = localBufferData1;
        if (localBufferData1 == null)
        {
          i = paramInt + 1;
          dequeueOutFrameMore(3000000L);
          localBufferData1 = this.mCodec.getInputBuffer();
          if (localBufferData1 != null) {
            localBufferData2 = localBufferData1;
          }
        }
        else
        {
          localBufferData2.buffer = null;
          this.mCodec.queueInputBuffer(localBufferData2.index, 0, 0L, 4);
          j = 0;
          i = 0;
          paramInt = 0;
          if ((paramInt != 0) || (i >= 10)) {
            break;
          }
          k = i + 1;
          localBufferData1 = this.mCodec.dequeueOutputBuffer();
          i = k;
          if (localBufferData1 == null) {
            continue;
          }
          i = k;
          if (localBufferData1.index < 0) {
            continue;
          }
          i = k;
          if (!localBufferData1.success) {
            continue;
          }
          if ((localBufferData1.format != null) && (localBufferData1.buffer != null)) {
            break label206;
          }
          this.mCodec.releaseOutputBuffer(localBufferData1.index);
          i = k;
          continue;
        }
        paramInt = i;
      }
      catch (Exception localException)
      {
        AVLog.e("NativeCodec", "dequeueLastDecFrame fail.", localException);
        return false;
      }
      if (i > 8)
      {
        return false;
        label206:
        if ((localException.info.flags & 0x4) != 0)
        {
          paramInt = 1;
          i = k;
        }
        else
        {
          setFrame(localException.buffer, localException.info.size, localException.format);
          this.mCodec.releaseOutputBuffer(localException.index);
          j += 1;
          i = k;
        }
      }
    }
    return true;
  }
  
  private boolean dequeueOutFrameMore(long paramLong)
  {
    long l1 = 0L;
    while (l1 < paramLong)
    {
      long l2 = System.nanoTime();
      AndroidCodec.BufferData localBufferData = this.mCodec.dequeueDecoderOutputBuffer(3000L);
      l2 = l1 + (System.nanoTime() - l2);
      l1 = l2;
      if (localBufferData != null)
      {
        l1 = l2;
        if (localBufferData.index != -1)
        {
          l1 = l2;
          if (localBufferData.index >= 0)
          {
            l1 = l2;
            if (localBufferData.success) {
              if ((localBufferData.format == null) || (localBufferData.buffer == null))
              {
                this.mCodec.releaseOutputBuffer(localBufferData.index);
                l1 = l2;
              }
              else
              {
                setFrame(localBufferData.buffer, localBufferData.info.size, localBufferData.format);
                this.mCodec.releaseOutputBuffer(localBufferData.index);
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = getIntValuesImp("NativeCodec", paramString1, paramString2, paramBoolean);
    AVLog.d("NativeCodec", String.format("getIntValues mime=%s key=%s isDecoder=%s value=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
    return i;
  }
  
  private static int getIntValuesImp(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    label172:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return 0;
                        if (!"supportAsync".equalsIgnoreCase(paramString3)) {
                          break;
                        }
                      } while (!mUseAsyncAPI);
                      return 1;
                      if (!paramString2.equalsIgnoreCase(AndroidCodec.AVC_CODEC_MIME)) {
                        break label172;
                      }
                      if (!paramBoolean) {
                        break;
                      }
                      if (gAVCDecoderCaps == null) {
                        initAVCDecoderCaps(paramString1);
                      }
                    } while (gAVCDecoderCaps == null);
                    if (paramString3.equalsIgnoreCase("width")) {
                      return gAVCDecoderCaps.width;
                    }
                    if (paramString3.equalsIgnoreCase("height")) {
                      return gAVCDecoderCaps.height;
                    }
                  } while (!paramString3.equalsIgnoreCase("profile"));
                  return gAVCDecoderCaps.profile;
                  if (gAVCEncoderCaps == null) {
                    initAVCEncoderCaps(paramString1);
                  }
                } while (gAVCEncoderCaps == null);
                if (paramString3.equalsIgnoreCase("width")) {
                  return gAVCEncoderCaps.width;
                }
                if (paramString3.equalsIgnoreCase("height")) {
                  return gAVCEncoderCaps.height;
                }
              } while (!paramString3.equalsIgnoreCase("profile"));
              return gAVCEncoderCaps.profile;
            } while (!paramString2.equalsIgnoreCase(AndroidCodec.HEVC_CODEC_MIME));
            if (!paramBoolean) {
              break;
            }
            if (gHEVCDecoderCaps == null) {
              initHevcDecoderCaps(paramString1);
            }
          } while (gHEVCDecoderCaps == null);
          if (paramString3.equalsIgnoreCase("width")) {
            return gHEVCDecoderCaps.width;
          }
          if (paramString3.equalsIgnoreCase("height")) {
            return gHEVCDecoderCaps.height;
          }
        } while (!paramString3.equalsIgnoreCase("profile"));
        return gHEVCDecoderCaps.profile;
        if (gHEVCEncoderCaps == null) {
          initHevcEncoderCaps();
        }
      } while (gHEVCEncoderCaps == null);
      if (paramString3.equalsIgnoreCase("width")) {
        return gHEVCEncoderCaps.width;
      }
      if (paramString3.equalsIgnoreCase("height")) {
        return gHEVCEncoderCaps.height;
      }
    } while (!paramString3.equalsIgnoreCase("profile"));
    return gHEVCEncoderCaps.profile;
  }
  
  public static native int getVersion();
  
  private static void initAVCDecoderCaps(String paramString)
  {
    paramString = AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME);
    if (paramString.size() == 0) {}
    int i;
    do
    {
      do
      {
        return;
        paramString = AndroidCodec.getCodecCapabilities((MediaCodecInfo)paramString.get(0), AndroidCodec.AVC_CODEC_MIME);
      } while ((paramString == null) || (paramString.profileLevels == null));
      gAVCDecoderCaps = new AVCCaps();
      i = 0;
    } while (i >= paramString.profileLevels.length);
    switch (paramString.profileLevels[i].profile)
    {
    default: 
      label140:
      switch (paramString.profileLevels[i].level)
      {
      default: 
        if (paramString.profileLevels[i].level < 1) {
          if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
          {
            gAVCDecoderCaps.width = 176;
            gAVCDecoderCaps.height = 144;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break;
      if (gAVCDecoderCaps.profile > 3) {
        break label140;
      }
      gAVCDecoderCaps.profile = 3;
      break label140;
      if (gAVCDecoderCaps.profile > 5) {
        break label140;
      }
      gAVCDecoderCaps.profile = 5;
      break label140;
      if (gAVCDecoderCaps.profile > 5) {
        break label140;
      }
      gAVCDecoderCaps.profile = 5;
      break label140;
      if (gAVCDecoderCaps.profile > 5) {
        break label140;
      }
      gAVCDecoderCaps.profile = 5;
      break label140;
      if (gAVCDecoderCaps.profile > 5) {
        break label140;
      }
      gAVCDecoderCaps.profile = 5;
      break label140;
      if (gAVCDecoderCaps.profile > 5) {
        break label140;
      }
      gAVCDecoderCaps.profile = 5;
      break label140;
      if (gAVCDecoderCaps.profile > 4) {
        break label140;
      }
      gAVCDecoderCaps.profile = 4;
      break label140;
      if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
      {
        gAVCDecoderCaps.width = 176;
        gAVCDecoderCaps.height = 144;
        continue;
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
          continue;
          if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
          {
            gAVCDecoderCaps.width = 352;
            gAVCDecoderCaps.height = 288;
            continue;
            if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
            {
              gAVCDecoderCaps.width = 352;
              gAVCDecoderCaps.height = 288;
              continue;
              if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
              {
                gAVCDecoderCaps.width = 352;
                gAVCDecoderCaps.height = 288;
                continue;
                if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
                {
                  gAVCDecoderCaps.width = 352;
                  gAVCDecoderCaps.height = 288;
                  continue;
                  if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 576))
                  {
                    gAVCDecoderCaps.width = 352;
                    gAVCDecoderCaps.height = 576;
                    continue;
                    if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
                    {
                      gAVCDecoderCaps.width = 720;
                      gAVCDecoderCaps.height = 576;
                      continue;
                      if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
                      {
                        gAVCDecoderCaps.width = 720;
                        gAVCDecoderCaps.height = 576;
                        continue;
                        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 720))
                        {
                          gAVCDecoderCaps.width = 1280;
                          gAVCDecoderCaps.height = 720;
                          continue;
                          if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 1024))
                          {
                            gAVCDecoderCaps.width = 1280;
                            gAVCDecoderCaps.height = 1024;
                            continue;
                            if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
                            {
                              gAVCDecoderCaps.width = 2048;
                              gAVCDecoderCaps.height = 1024;
                              continue;
                              if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
                              {
                                gAVCDecoderCaps.width = 2048;
                                gAVCDecoderCaps.height = 1024;
                                continue;
                                if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1088))
                                {
                                  gAVCDecoderCaps.width = 2048;
                                  gAVCDecoderCaps.height = 1088;
                                  continue;
                                  if ((gAVCDecoderCaps.width < 3680) || (gAVCDecoderCaps.height < 1536))
                                  {
                                    gAVCDecoderCaps.width = 3680;
                                    gAVCDecoderCaps.height = 1536;
                                    continue;
                                    if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2048))
                                    {
                                      gAVCDecoderCaps.width = 4096;
                                      gAVCDecoderCaps.height = 2048;
                                      continue;
                                      if ((paramString.profileLevels[i].level > 32768) && ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2160)))
                                      {
                                        gAVCDecoderCaps.width = 4096;
                                        gAVCDecoderCaps.height = 2160;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void initAVCEncoderCaps(String paramString)
  {
    paramString = AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME);
    if (paramString.size() == 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramString = AndroidCodec.getCodecCapabilities((MediaCodecInfo)paramString.get(0), AndroidCodec.AVC_CODEC_MIME);
        } while ((paramString == null) || (paramString.profileLevels == null));
        gAVCEncoderCaps = new AVCCaps();
      } while (paramString.profileLevels.length <= 0);
      i = 0;
    } while (i >= paramString.profileLevels.length);
    switch (paramString.profileLevels[i].profile)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      gAVCEncoderCaps.profile = 3;
      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = paramString.profileLevels[i];
      localCodecProfileLevel.level = 512;
      setLevel(localCodecProfileLevel, gAVCEncoderCaps);
    }
  }
  
  private static void initHevcDecoderCaps(String paramString)
  {
    paramString = AndroidCodec.getDecoderInfos(AndroidCodec.HEVC_CODEC_MIME);
    if (paramString.size() == 0) {}
    do
    {
      return;
      paramString = AndroidCodec.getCodecCapabilities((MediaCodecInfo)paramString.get(0), AndroidCodec.HEVC_CODEC_MIME);
    } while ((paramString == null) || (paramString.profileLevels == null));
    gHEVCDecoderCaps = new AVCCaps();
    int i = 0;
    label57:
    if (i < paramString.profileLevels.length)
    {
      if (paramString.profileLevels[i].profile > 1) {
        break label171;
      }
      if (gHEVCDecoderCaps.profile <= 1) {
        gHEVCDecoderCaps.profile = 1;
      }
      label96:
      if ((paramString.profileLevels[i].level > 1) && (paramString.profileLevels[i].level > 2)) {
        break label237;
      }
      if ((gHEVCDecoderCaps.width < 176) || (gHEVCDecoderCaps.height < 144))
      {
        gHEVCDecoderCaps.width = 176;
        gHEVCDecoderCaps.height = 144;
      }
    }
    for (;;)
    {
      i += 1;
      break label57;
      break;
      label171:
      if (paramString.profileLevels[i].profile == 2)
      {
        if (gHEVCDecoderCaps.profile > 2) {
          break label96;
        }
        gHEVCDecoderCaps.profile = 2;
        break label96;
      }
      if ((paramString.profileLevels[i].profile < 2) || (gHEVCDecoderCaps.profile > 2)) {
        break label96;
      }
      gHEVCDecoderCaps.profile = 2;
      break label96;
      label237:
      if ((paramString.profileLevels[i].level == 4) || (paramString.profileLevels[i].level == 8))
      {
        if ((gHEVCDecoderCaps.width < 352) || (gHEVCDecoderCaps.height < 288))
        {
          gHEVCDecoderCaps.width = 352;
          gHEVCDecoderCaps.height = 288;
        }
      }
      else if ((paramString.profileLevels[i].level == 16) || (paramString.profileLevels[i].level == 32))
      {
        if ((gHEVCDecoderCaps.width < 640) || (gHEVCDecoderCaps.height < 360))
        {
          gHEVCDecoderCaps.width = 640;
          gHEVCDecoderCaps.height = 360;
        }
      }
      else if ((paramString.profileLevels[i].level == 64) || (paramString.profileLevels[i].level == 128))
      {
        if ((gHEVCDecoderCaps.width < 960) || (gHEVCDecoderCaps.height < 540))
        {
          gHEVCDecoderCaps.width = 960;
          gHEVCDecoderCaps.height = 540;
        }
      }
      else if ((paramString.profileLevels[i].level == 256) || (paramString.profileLevels[i].level == 512))
      {
        if ((gHEVCDecoderCaps.width < 1280) || (gHEVCDecoderCaps.height < 720))
        {
          gHEVCDecoderCaps.width = 1280;
          gHEVCDecoderCaps.height = 720;
        }
      }
      else if ((paramString.profileLevels[i].level == 1024) || (paramString.profileLevels[i].level == 2048))
      {
        if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
        {
          gHEVCDecoderCaps.width = 2048;
          gHEVCDecoderCaps.height = 1080;
        }
      }
      else if ((paramString.profileLevels[i].level == 4096) || (paramString.profileLevels[i].level == 8192))
      {
        if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
        {
          gHEVCDecoderCaps.width = 2048;
          gHEVCDecoderCaps.height = 1080;
        }
      }
      else if ((paramString.profileLevels[i].level == 16384) || (paramString.profileLevels[i].level == 32768))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((paramString.profileLevels[i].level == 65536) || (paramString.profileLevels[i].level == 131072))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((paramString.profileLevels[i].level == 262144) || (paramString.profileLevels[i].level == 524288))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((paramString.profileLevels[i].level == 1048576) || (paramString.profileLevels[i].level == 2097152))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else if ((paramString.profileLevels[i].level == 4194304) || (paramString.profileLevels[i].level == 8388608))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else if (((paramString.profileLevels[i].level >= 16777216) || (paramString.profileLevels[i].level >= 33554432)) && ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320)))
      {
        gHEVCDecoderCaps.width = 8192;
        gHEVCDecoderCaps.height = 4320;
      }
    }
  }
  
  private static void initHevcEncoderCaps()
  {
    Object localObject = AndroidCodec.getDecoderInfos(AndroidCodec.HEVC_CODEC_MIME);
    if (((List)localObject).size() == 0) {}
    int i;
    do
    {
      do
      {
        return;
        localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), AndroidCodec.HEVC_CODEC_MIME);
      } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
      gHEVCEncoderCaps = new AVCCaps();
      i = 0;
    } while (i >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length);
    switch (localObject.profileLevels[i].profile)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      gHEVCEncoderCaps.profile = 1;
      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = localObject.profileLevels[i];
      localCodecProfileLevel.level = 16384;
      setHevcLevel(localCodecProfileLevel, gHEVCEncoderCaps);
    }
  }
  
  private static boolean onAttach(String paramString, int paramInt, boolean paramBoolean, Map<String, Object> paramMap)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return false;
    }
    AVLog.d("NativeCodec", String.format("onAttach mime=%s instance=%s isDecoder=%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    paramString = new NativeCodec(paramString, paramInt, paramMap, paramBoolean);
    if (paramString.mCodec == null)
    {
      AVLog.w("NativeCodec", "onAttach fail.");
      return false;
    }
    paramString.attachCodec(paramString);
    paramString.mTimeStamp = 0L;
    paramString.mTryAgainLaterCount = 0;
    paramString.mLastEncFrameTime = 0L;
    paramString.mTotalDecOutFrameNum = 0;
    paramString.mTotalDecInFrameNum = 0;
    return paramString.mCodec.start();
  }
  
  private boolean onCalcDelay(int paramInt)
  {
    if (this.mDebugDelay) {
      this.mDebugDelayMap2.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    }
    return true;
  }
  
  private static void onDetach(Object paramObject)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    NativeCodec localNativeCodec;
    do
    {
      return;
      localNativeCodec = (NativeCodec)paramObject;
    } while (localNativeCodec == null);
    localNativeCodec.detachCodec();
    localNativeCodec.mTryAgainLaterCount = 0;
    localNativeCodec.mTimeStamp = 0L;
    localNativeCodec.mFormat = null;
    localNativeCodec.mLastEncFrameTime = 0L;
    localNativeCodec.mTotalDecOutFrameNum = 0;
    localNativeCodec.mTotalDecInFrameNum = 0;
    synchronized (localNativeCodec.mPendingInputBuffers)
    {
      localNativeCodec.mCodersExit.set(true);
      localNativeCodec.mPendingInputBuffers.clear();
      if (localNativeCodec.mDebugDelay)
      {
        localNativeCodec.mDebugDelayMap.clear();
        localNativeCodec.mDebugDelayMap2.clear();
        localNativeCodec.mDebugIndexMap.clear();
      }
      AndroidCodec localAndroidCodec = localNativeCodec.mCodec;
      if (localAndroidCodec == null) {}
    }
    try
    {
      localNativeCodec.mCodec.stop();
      localNativeCodec.mCodec.release();
      localNativeCodec.mCodec = null;
      AVLog.w("NativeCodec", String.format("onDetach jNativeCodec=%s", new Object[] { paramObject }));
      return;
      paramObject = finally;
      throw paramObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.e("NativeCodec", "onDetach fail.", localException);
      }
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    if (this.mCodec == null)
    {
      AVLog.e("NativeCodec", "onDoCodec err!! mCodec is null");
      return false;
    }
    if ((this.mTryAgainLaterCount >= 10) && (paramInt1 == 0))
    {
      AVLog.e("NativeCodec", String.format("onDoCodec error! reset codec mTryAgainLaterCount=%s flag=%s", new Object[] { Integer.valueOf(this.mTryAgainLaterCount), Integer.valueOf(paramInt1) }));
      resetCodec();
      if (this.mCodec == null) {
        return false;
      }
    }
    Object localObject4;
    label247:
    for (;;)
    {
      try
      {
        Object localObject1 = this.mCodec.getInputBuffer();
        paramInt1 = 0;
        localObject4 = localObject1;
        int j;
        if (localObject1 == null)
        {
          localObject4 = localObject1;
          j = paramInt1;
        }
        try
        {
          Thread.sleep(50L);
          localObject4 = localObject1;
          j = paramInt1;
          localObject1 = this.mCodec.getInputBuffer();
          localObject4 = localObject1;
          int i = paramInt1 + 1;
          if (localObject4 != null)
          {
            if (!this.mDecoder) {
              break label247;
            }
            paramInt1 = writeInputData(localObject4.buffer, false);
            if (paramInt1 >= 0) {
              break;
            }
            AVLog.e("NativeCodec", "writeInputData, SampleSize < 0");
            return false;
          }
          localObject1 = localObject4;
          paramInt1 = i;
          if (i <= 8) {
            continue;
          }
          j = i;
          AVLog.e("NativeCodec", "onDoCodec not available, try count=" + i);
          return false;
        }
        catch (Throwable localThrowable)
        {
          AVLog.e("NativeCodec", "onDoCodec fail.", localThrowable);
          Object localObject2 = localObject4;
          paramInt1 = j;
        }
        continue;
        paramInt1 = writeInputData2(localObject4.buffer, this.mColorFormat, false);
      }
      catch (Exception localException)
      {
        AVLog.e("NativeCodec", "onDoCodec fail.", localException);
        return false;
      }
    }
    this.mLastEncFrameTime += this.mFrameInverval;
    if (this.mDebugDelay)
    {
      this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
      this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
    }
    this.mCodec.queueInputBuffer(localObject4.index, paramInt1, this.mLastEncFrameTime, 0);
    this.mTotalDecInFrameNum += 1;
    long l2 = System.nanoTime();
    long l1 = 33000000L;
    Object localObject3;
    if (this.mDecoder)
    {
      if (paramInt2 < 4) {
        l1 = 45000000L;
      }
      localObject3 = this.mCodec.dequeueDecoderOutputBuffer(l1);
    }
    while (localObject3 != null)
    {
      if (((AndroidCodec.BufferData)localObject3).index == -1)
      {
        this.mTryAgainLaterCount += 1;
        AVLog.w("NativeCodec", "onDoCodec try again count[" + this.mTryAgainLaterCount + "]");
        if ((this.mDecoder) && (dequeueOutFrameMore(l1 - (System.nanoTime() - l2))))
        {
          this.mTryAgainLaterCount = 0;
          return true;
          localObject3 = this.mCodec.dequeueOutputBuffer();
          continue;
        }
        if (this.mTryAgainLaterCount >= 16) {
          return false;
        }
      }
      else
      {
        this.mTryAgainLaterCount = 0;
        if (!((AndroidCodec.BufferData)localObject3).success)
        {
          AVLog.e("NativeCodec", "onDoCodec error!", new Throwable());
          return false;
        }
        if ((((AndroidCodec.BufferData)localObject3).format == null) || (((AndroidCodec.BufferData)localObject3).buffer == null))
        {
          this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject3).index);
          AVLog.e("NativeCodec", "onDoCodec error!", new Throwable());
          return false;
        }
        if (this.mDecoder)
        {
          calcDelay(true, ((AndroidCodec.BufferData)localObject3).info);
          setFrame(((AndroidCodec.BufferData)localObject3).buffer, ((AndroidCodec.BufferData)localObject3).info.size, ((AndroidCodec.BufferData)localObject3).format);
        }
        for (;;)
        {
          this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject3).index);
          if ((!this.mDecoder) || (this.mTotalDecInFrameNum - this.mTotalDecOutFrameNum <= 0)) {
            break;
          }
          dequeueOutFrameMore(l1 - (System.nanoTime() - l2));
          break;
          if (((AndroidCodec.BufferData)localObject3).info.flags == 1) {
            AVLog.e("NativeCodec", "onDoCodec error!", new Throwable());
          }
          localObject4 = localObject3;
          if (((AndroidCodec.BufferData)localObject3).info.flags == 2)
          {
            this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject3).index);
            readOutputStream(((AndroidCodec.BufferData)localObject3).buffer, ((AndroidCodec.BufferData)localObject3).info.presentationTimeUs, ((AndroidCodec.BufferData)localObject3).info.offset, ((AndroidCodec.BufferData)localObject3).info.size, ((AndroidCodec.BufferData)localObject3).info.flags);
            localObject3 = this.mCodec.dequeueOutputBuffer();
            localObject4 = localObject3;
            if (localObject3 != null)
            {
              if (((AndroidCodec.BufferData)localObject3).index == -1)
              {
                this.mTryAgainLaterCount2 += 1;
                if (this.mTryAgainLaterCount2 < 16) {
                  break label957;
                }
                return false;
              }
              this.mTryAgainLaterCount2 = 0;
              if (!((AndroidCodec.BufferData)localObject3).success)
              {
                AVLog.e("NativeCodec", "onDoCodec error!", new Throwable());
                return false;
              }
              if (((AndroidCodec.BufferData)localObject3).format != null)
              {
                localObject4 = localObject3;
                if (((AndroidCodec.BufferData)localObject3).buffer != null) {}
              }
              else
              {
                this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject3).index);
                AVLog.e("NativeCodec", "onDoCodec error!", new Throwable());
                return false;
              }
            }
          }
          calcDelay(true, localObject4.info);
          readOutputStream(localObject4.buffer, localObject4.info.presentationTimeUs, localObject4.info.offset, localObject4.info.size, localObject4.info.flags);
          localObject3 = localObject4;
        }
      }
      return true;
    }
    return true;
    label957:
    return true;
  }
  
  private int onDoCodecAsync(int paramInt1, int paramInt2)
  {
    if (!mUseAsyncAPI)
    {
      AVLog.e("NativeCodec", "not in async mode.");
      return -1;
    }
    synchronized (this.mPendingInputBuffers)
    {
      if (this.mCodersExit.get())
      {
        AVLog.e("NativeCodec", "hardware coders exit.");
        return 2;
      }
      if (this.mPendingInputBuffers.size() <= 0) {
        break label274;
      }
      AndroidCodec.InputBufferData localInputBufferData = (AndroidCodec.InputBufferData)this.mPendingInputBuffers.get(0);
      if (localInputBufferData == null) {
        return 2;
      }
      if (localInputBufferData.buffer == null)
      {
        AVLog.e("NativeCodec", "input buffer is null.");
        return -1;
      }
    }
    if (localObject.processing)
    {
      AVLog.e("NativeCodec", "current buffer is being processed by other thread.");
      return 2;
    }
    if (this.mDecoder) {}
    for (paramInt1 = writeInputData(localObject.buffer, false); paramInt1 > 0; paramInt1 = writeInputData2(localObject.buffer, this.mColorFormat, false))
    {
      this.mLastEncFrameTime += this.mFrameInverval;
      this.mPendingInputBuffers.remove(0);
      if (this.mDebugDelay)
      {
        this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
        this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
      }
      this.mCodec.queueInputBuffer(localObject.index, paramInt1, this.mLastEncFrameTime, 0);
      return 1;
    }
    for (;;)
    {
      return 0;
      label274:
      do
      {
        return -1;
        return 2;
        if (paramInt1 == 0) {
          break;
        }
      } while (paramInt1 != -1);
    }
  }
  
  public static native boolean putByteArray2ByteBuffer(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  /* Error */
  private void resetCodec()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   4: ifnull +82 -> 86
    //   7: aload_0
    //   8: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 129	com/tencent/av/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_1
    //   19: invokevirtual 499	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   22: aload_0
    //   23: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   26: invokeinterface 502 1 0
    //   31: aload_0
    //   32: getfield 135	com/tencent/av/mediacodec/NativeCodec:mDebugDelay	Z
    //   35: ifeq +30 -> 65
    //   38: aload_0
    //   39: getfield 205	com/tencent/av/mediacodec/NativeCodec:mDebugDelayMap	Ljava/util/Map;
    //   42: invokeinterface 503 1 0
    //   47: aload_0
    //   48: getfield 207	com/tencent/av/mediacodec/NativeCodec:mDebugDelayMap2	Ljava/util/Map;
    //   51: invokeinterface 503 1 0
    //   56: aload_0
    //   57: getfield 209	com/tencent/av/mediacodec/NativeCodec:mDebugIndexMap	Ljava/util/Map;
    //   60: invokeinterface 503 1 0
    //   65: aload_0
    //   66: getfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   69: invokevirtual 506	com/tencent/av/mediacodec/AndroidCodec:stop	()V
    //   72: aload_0
    //   73: getfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   76: invokevirtual 509	com/tencent/av/mediacodec/AndroidCodec:release	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 143	com/tencent/av/mediacodec/NativeCodec:mDecoder	Z
    //   90: ifeq +57 -> 147
    //   93: aload_0
    //   94: invokespecial 200	com/tencent/av/mediacodec/NativeCodec:createDecCodec	()V
    //   97: aload_0
    //   98: lconst_0
    //   99: putfield 98	com/tencent/av/mediacodec/NativeCodec:mTimeStamp	J
    //   102: aload_0
    //   103: lconst_0
    //   104: putfield 100	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   107: aload_0
    //   108: getfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   111: invokevirtual 485	com/tencent/av/mediacodec/AndroidCodec:start	()Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 129	com/tencent/av/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: iconst_0
    //   120: invokevirtual 499	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   123: return
    //   124: astore_2
    //   125: aload_1
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   135: ldc 35
    //   137: ldc_w 604
    //   140: aload_1
    //   141: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: goto -58 -> 86
    //   147: aload_0
    //   148: invokespecial 226	com/tencent/av/mediacodec/NativeCodec:createEncCodec	()V
    //   151: goto -54 -> 97
    //   154: astore_1
    //   155: ldc 35
    //   157: ldc_w 604
    //   160: aload_1
    //   161: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	NativeCodec
    //   129	12	1	localException1	Exception
    //   154	7	1	localException2	Exception
    //   124	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	65	124	finally
    //   65	86	124	finally
    //   125	127	124	finally
    //   7	14	129	java/lang/Exception
    //   127	129	129	java/lang/Exception
    //   86	97	154	java/lang/Exception
    //   97	123	154	java/lang/Exception
    //   147	151	154	java/lang/Exception
  }
  
  private boolean setFrame(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i6 = paramMediaFormat.getInteger("width");
    int i4 = paramMediaFormat.getInteger("height");
    int j = paramMediaFormat.getInteger("crop-left");
    int i3 = paramMediaFormat.getInteger("crop-right");
    int i = paramMediaFormat.getInteger("crop-top");
    int i2 = paramMediaFormat.getInteger("crop-bottom");
    int k = paramMediaFormat.getInteger("stride");
    int m = paramMediaFormat.getInteger("slice-height");
    int i5 = paramMediaFormat.getInteger("color-format");
    int n = Math.max(m, i4);
    int i1 = Math.max(k, i6);
    k = i;
    m = n;
    if (i5 == 2130706688)
    {
      m = n - i / 2;
      k = 0;
      j = 0;
    }
    n = Math.max(i1, i6);
    i1 = i4;
    if ((2141391876 != i5) && (2130706433 != i5))
    {
      i = i1;
      if (2130706944 != i5) {}
    }
    else
    {
      i = i1;
      if (i1 < m) {
        i = m;
      }
    }
    if (j + i3 + k + i2 == 0)
    {
      i1 = 0;
      k = 0;
      i3 = i6 - 1;
      i2 = i4 - 1;
      j = i;
      m = n;
    }
    while ((m <= 0) || (j <= 0) || (i3 <= 0) || (i2 <= 0))
    {
      AVLog.e("NativeCodec", String.format("setFrame error size=%s colorFormat=0x%s", new Object[] { Integer.valueOf(paramInt), Integer.toHexString(i5).toUpperCase() }));
      return false;
      i4 = i3 - j + 1;
      i1 = i2 - k + 1;
      m = n;
      if (n < i4) {
        m = i4;
      }
      n = i;
      if (i < i1) {
        n = i1;
      }
      i1 = j;
      i = i3;
      j = n;
      i3 = i;
    }
    paramInt = readOutputDataEx(paramByteBuffer, paramInt, m, j, i1, k, i3 - i1 + 1, i2 - k + 1, i5);
    this.mTotalDecOutFrameNum += 1;
    return paramInt > 0;
  }
  
  private static void setHevcLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, AVCCaps paramAVCCaps)
  {
    if (paramCodecProfileLevel.level == 1) {
      if ((paramAVCCaps.width < 192) || (paramAVCCaps.height < 144))
      {
        paramAVCCaps.width = 192;
        paramAVCCaps.height = 144;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (paramCodecProfileLevel.level != 4) {
                              break;
                            }
                          } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                          paramAVCCaps.width = 352;
                          paramAVCCaps.height = 288;
                          return;
                          if (paramCodecProfileLevel.level != 16) {
                            break;
                          }
                        } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 576));
                        paramAVCCaps.width = 352;
                        paramAVCCaps.height = 576;
                        return;
                        if (paramCodecProfileLevel.level != 64) {
                          break;
                        }
                      } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                      paramAVCCaps.width = 720;
                      paramAVCCaps.height = 576;
                      return;
                      if (paramCodecProfileLevel.level != 256) {
                        break;
                      }
                    } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 720));
                    paramAVCCaps.width = 1280;
                    paramAVCCaps.height = 720;
                    return;
                    if (paramCodecProfileLevel.level != 1024) {
                      break;
                    }
                  } while ((paramAVCCaps.width >= 1920) && (paramAVCCaps.height >= 1080));
                  paramAVCCaps.width = 1920;
                  paramAVCCaps.height = 1080;
                  return;
                  if (paramCodecProfileLevel.level != 4096) {
                    break;
                  }
                } while ((paramAVCCaps.width >= 1920) && (paramAVCCaps.height >= 1080));
                paramAVCCaps.width = 1920;
                paramAVCCaps.height = 1080;
                return;
                if (paramCodecProfileLevel.level != 16384) {
                  break;
                }
              } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2048));
              paramAVCCaps.width = 4096;
              paramAVCCaps.height = 2048;
              return;
              if (paramCodecProfileLevel.level != 65536) {
                break;
              }
            } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2048));
            paramAVCCaps.width = 4096;
            paramAVCCaps.height = 2048;
            return;
            if (paramCodecProfileLevel.level != 262144) {
              break;
            }
          } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2048));
          paramAVCCaps.width = 4096;
          paramAVCCaps.height = 2048;
          return;
          if (paramCodecProfileLevel.level != 1048576) {
            break;
          }
        } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 4096));
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 4096;
        return;
        if (paramCodecProfileLevel.level != 4194304) {
          break;
        }
      } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 4096));
      paramAVCCaps.width = 4096;
      paramAVCCaps.height = 4096;
      return;
    } while ((paramCodecProfileLevel.level != 16777216) || ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 4096)));
    paramAVCCaps.width = 4096;
    paramAVCCaps.height = 4096;
  }
  
  private static void setLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, AVCCaps paramAVCCaps)
  {
    switch (paramCodecProfileLevel.level)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                  } while ((paramAVCCaps.width >= 176) && (paramAVCCaps.height >= 144));
                                  paramAVCCaps.width = 176;
                                  paramAVCCaps.height = 144;
                                  return;
                                } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                                paramAVCCaps.width = 352;
                                paramAVCCaps.height = 288;
                                return;
                              } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                              paramAVCCaps.width = 352;
                              paramAVCCaps.height = 288;
                              return;
                            } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                            paramAVCCaps.width = 352;
                            paramAVCCaps.height = 288;
                            return;
                          } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                          paramAVCCaps.width = 352;
                          paramAVCCaps.height = 288;
                          return;
                        } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                        paramAVCCaps.width = 352;
                        paramAVCCaps.height = 288;
                        return;
                      } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 576));
                      paramAVCCaps.width = 352;
                      paramAVCCaps.height = 576;
                      return;
                    } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                    paramAVCCaps.width = 720;
                    paramAVCCaps.height = 576;
                    return;
                  } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                  paramAVCCaps.width = 720;
                  paramAVCCaps.height = 576;
                  return;
                } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 720));
                paramAVCCaps.width = 1280;
                paramAVCCaps.height = 720;
                return;
              } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 1024));
              paramAVCCaps.width = 1280;
              paramAVCCaps.height = 1024;
              return;
            } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024));
            paramAVCCaps.width = 2048;
            paramAVCCaps.height = 1024;
            return;
          } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024));
          paramAVCCaps.width = 2048;
          paramAVCCaps.height = 1024;
          return;
        } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1088));
        paramAVCCaps.width = 2048;
        paramAVCCaps.height = 1088;
        return;
      } while ((paramAVCCaps.width >= 3680) && (paramAVCCaps.height >= 1536));
      paramAVCCaps.width = 3680;
      paramAVCCaps.height = 1536;
      return;
    } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2304));
    paramAVCCaps.width = 4096;
    paramAVCCaps.height = 2304;
  }
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.mCodec == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString == null);
        if (!paramString.equalsIgnoreCase("frame-rate")) {
          break;
        }
      } while (paramInt <= 0);
      this.mFrameRate = paramInt;
      this.mFrameInverval = (1000000 / this.mFrameRate);
      resetCodec();
    } while (Build.VERSION.SDK_INT < 19);
    Bundle localBundle = new Bundle();
    localBundle.putInt(paramString, paramInt);
    this.mCodec.setParameters(localBundle);
  }
  
  public static native void set_device_infos(String paramString);
  
  public native boolean attachCodec(Object paramObject);
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (this.mCodersExit.get()) {
      return;
    }
    AVLog.e("NativeCodec", "onError", paramException);
  }
  
  /* Error */
  public void onInputBufferAvailable(MediaCodec arg1, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   4: iload_2
    //   5: invokevirtual 649	com/tencent/av/mediacodec/AndroidCodec:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: iconst_0
    //   17: istore 5
    //   19: iconst_0
    //   20: istore 4
    //   22: iload 5
    //   24: istore_3
    //   25: aload_0
    //   26: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   29: astore_1
    //   30: iload 5
    //   32: istore_3
    //   33: aload_1
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 129	com/tencent/av/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   39: invokevirtual 585	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   42: ifeq +69 -> 111
    //   45: aload_1
    //   46: monitorexit
    //   47: aload_0
    //   48: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   51: astore_1
    //   52: aload_1
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   58: iconst_0
    //   59: invokeinterface 280 2 0
    //   64: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   67: iconst_0
    //   68: putfield 595	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   71: iconst_0
    //   72: ifle +14 -> 86
    //   75: aload_0
    //   76: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   79: iconst_0
    //   80: invokeinterface 599 2 0
    //   85: pop
    //   86: aload_1
    //   87: monitorexit
    //   88: return
    //   89: astore 6
    //   91: aload_1
    //   92: monitorexit
    //   93: aload 6
    //   95: athrow
    //   96: astore 6
    //   98: ldc 35
    //   100: ldc_w 651
    //   103: aload 6
    //   105: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: goto -22 -> 86
    //   111: aload_0
    //   112: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   115: new 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   118: dup
    //   119: aload 6
    //   121: iload_2
    //   122: invokespecial 654	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:<init>	(Ljava/nio/ByteBuffer;I)V
    //   125: invokeinterface 657 2 0
    //   130: pop
    //   131: aload_0
    //   132: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   135: iconst_0
    //   136: invokeinterface 280 2 0
    //   141: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   144: iconst_1
    //   145: putfield 595	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   148: aload_1
    //   149: monitorexit
    //   150: iload 5
    //   152: istore_3
    //   153: aload_0
    //   154: getfield 143	com/tencent/av/mediacodec/NativeCodec:mDecoder	Z
    //   157: ifeq +218 -> 375
    //   160: iload 5
    //   162: istore_3
    //   163: aload_0
    //   164: aload_0
    //   165: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   168: iconst_0
    //   169: invokeinterface 280 2 0
    //   174: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   177: getfield 590	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   180: iconst_1
    //   181: invokevirtual 536	com/tencent/av/mediacodec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   184: istore_2
    //   185: iload_2
    //   186: ifle +84 -> 270
    //   189: iload_2
    //   190: istore_3
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 100	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   196: aload_0
    //   197: getfield 113	com/tencent/av/mediacodec/NativeCodec:mFrameInverval	I
    //   200: i2l
    //   201: ladd
    //   202: putfield 100	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   205: iload_2
    //   206: istore_3
    //   207: aload_0
    //   208: getfield 135	com/tencent/av/mediacodec/NativeCodec:mDebugDelay	Z
    //   211: ifeq +28 -> 239
    //   214: iload_2
    //   215: istore_3
    //   216: aload_0
    //   217: getfield 205	com/tencent/av/mediacodec/NativeCodec:mDebugDelayMap	Ljava/util/Map;
    //   220: aload_0
    //   221: getfield 100	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   224: invokestatic 243	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   227: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   230: invokestatic 243	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: invokeinterface 491 3 0
    //   238: pop
    //   239: iload_2
    //   240: istore_3
    //   241: aload_0
    //   242: getfield 211	com/tencent/av/mediacodec/NativeCodec:mCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   245: aload_0
    //   246: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   249: iconst_0
    //   250: invokeinterface 280 2 0
    //   255: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   258: getfield 600	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:index	I
    //   261: iload_2
    //   262: aload_0
    //   263: getfield 100	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   266: iconst_0
    //   267: invokevirtual 358	com/tencent/av/mediacodec/AndroidCodec:queueInputBuffer	(IIJI)V
    //   270: aload_0
    //   271: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   274: astore_1
    //   275: aload_1
    //   276: monitorenter
    //   277: aload_0
    //   278: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   281: iconst_0
    //   282: invokeinterface 280 2 0
    //   287: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   290: iconst_0
    //   291: putfield 595	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   294: iload_2
    //   295: ifle +14 -> 309
    //   298: aload_0
    //   299: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   302: iconst_0
    //   303: invokeinterface 599 2 0
    //   308: pop
    //   309: aload_1
    //   310: monitorexit
    //   311: return
    //   312: astore 6
    //   314: aload_1
    //   315: monitorexit
    //   316: aload 6
    //   318: athrow
    //   319: astore 6
    //   321: aload_1
    //   322: monitorexit
    //   323: iload 5
    //   325: istore_3
    //   326: aload 6
    //   328: athrow
    //   329: astore 6
    //   331: aload_0
    //   332: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   335: astore_1
    //   336: aload_1
    //   337: monitorenter
    //   338: aload_0
    //   339: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   342: iconst_0
    //   343: invokeinterface 280 2 0
    //   348: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   351: iconst_0
    //   352: putfield 595	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   355: iload_3
    //   356: ifle +14 -> 370
    //   359: aload_0
    //   360: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   363: iconst_0
    //   364: invokeinterface 599 2 0
    //   369: pop
    //   370: aload_1
    //   371: monitorexit
    //   372: aload 6
    //   374: athrow
    //   375: iload 5
    //   377: istore_3
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 122	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   383: iconst_0
    //   384: invokeinterface 280 2 0
    //   389: checkcast 589	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   392: getfield 590	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   395: aload_0
    //   396: getfield 310	com/tencent/av/mediacodec/NativeCodec:mColorFormat	I
    //   399: iconst_1
    //   400: invokevirtual 559	com/tencent/av/mediacodec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   403: istore_2
    //   404: goto -219 -> 185
    //   407: astore_1
    //   408: iload 5
    //   410: istore_3
    //   411: ldc 35
    //   413: ldc_w 651
    //   416: aload_1
    //   417: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   420: iload 4
    //   422: istore_2
    //   423: goto -238 -> 185
    //   426: astore_1
    //   427: iload_2
    //   428: istore_3
    //   429: ldc 35
    //   431: ldc_w 651
    //   434: aload_1
    //   435: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   438: goto -168 -> 270
    //   441: astore 6
    //   443: ldc 35
    //   445: ldc_w 651
    //   448: aload 6
    //   450: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   453: goto -144 -> 309
    //   456: astore 7
    //   458: ldc 35
    //   460: ldc_w 651
    //   463: aload 7
    //   465: invokestatic 219	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: goto -98 -> 370
    //   471: astore 6
    //   473: aload_1
    //   474: monitorexit
    //   475: aload 6
    //   477: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	NativeCodec
    //   0	478	2	paramInt	int
    //   24	405	3	i	int
    //   20	401	4	j	int
    //   17	392	5	k	int
    //   8	3	6	localByteBuffer	ByteBuffer
    //   89	5	6	localObject1	Object
    //   96	24	6	localException1	Exception
    //   312	5	6	localObject2	Object
    //   319	8	6	localObject3	Object
    //   329	44	6	localObject4	Object
    //   441	8	6	localException2	Exception
    //   471	5	6	localObject5	Object
    //   456	8	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   54	71	89	finally
    //   75	86	89	finally
    //   86	88	89	finally
    //   91	93	89	finally
    //   98	108	89	finally
    //   54	71	96	java/lang/Exception
    //   75	86	96	java/lang/Exception
    //   277	294	312	finally
    //   298	309	312	finally
    //   309	311	312	finally
    //   314	316	312	finally
    //   443	453	312	finally
    //   35	47	319	finally
    //   111	150	319	finally
    //   321	323	319	finally
    //   25	30	329	finally
    //   33	35	329	finally
    //   153	160	329	finally
    //   163	185	329	finally
    //   191	205	329	finally
    //   207	214	329	finally
    //   216	239	329	finally
    //   241	270	329	finally
    //   326	329	329	finally
    //   378	404	329	finally
    //   411	420	329	finally
    //   429	438	329	finally
    //   153	160	407	java/lang/Exception
    //   163	185	407	java/lang/Exception
    //   378	404	407	java/lang/Exception
    //   241	270	426	java/lang/Exception
    //   277	294	441	java/lang/Exception
    //   298	309	441	java/lang/Exception
    //   338	355	456	java/lang/Exception
    //   359	370	456	java/lang/Exception
    //   338	355	471	finally
    //   359	370	471	finally
    //   370	372	471	finally
    //   458	468	471	finally
    //   473	475	471	finally
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mCodersExit.get()) {}
    do
    {
      return;
      paramMediaCodec = this.mCodec.getOutputBuffer(paramInt);
    } while ((paramMediaCodec == null) || (paramBufferInfo == null));
    if (this.mDecoder)
    {
      MediaFormat localMediaFormat = this.mCodec.getOutputFormat(paramInt);
      if (localMediaFormat != null)
      {
        calcDelay(false, paramBufferInfo);
        setFrame(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
      }
    }
    for (;;)
    {
      this.mCodec.releaseOutputBuffer(paramInt);
      return;
      calcDelay(false, paramBufferInfo);
      readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (this.mCodersExit.get()) {
      return;
    }
    AVLog.d("NativeCodec", "onOutputFormatChanged");
  }
  
  public native int readOutputData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public native int readOutputDataEx(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public native int readOutputStream(ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAVCParams(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  void setParams_impl()
  {
    AVLog.d("NativeCodec", "setParams_impl");
    Bundle localBundle;
    if (this.setIFramePending)
    {
      localBundle = new Bundle();
      localBundle.putInt(AndroidCodec.ForceIFrame, 1);
      this.setIFramePending = false;
      if (this.setBitRatePending > 0) {
        localBundle.putInt("bitrate", this.setBitRatePending);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
    }
    if (this.setBitRatePending > 0)
    {
      localBundle = new Bundle();
      localBundle.putInt("bitrate", this.setBitRatePending);
      if (this.setIFramePending == true) {
        localBundle.putInt(AndroidCodec.ForceIFrame, 1);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
      this.setIFramePending = false;
    }
  }
  
  public native int writeInputData(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public native int writeInputData2(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
  
  static class AVCCaps
  {
    public int height = 0;
    public int profile = 3;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.mediacodec.NativeCodec
 * JD-Core Version:    0.7.0.1
 */