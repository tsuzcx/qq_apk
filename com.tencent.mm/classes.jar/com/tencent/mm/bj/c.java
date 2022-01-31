package com.tencent.mm.bj;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class c
{
  private ByteBuffer[] azr;
  private int bitrate;
  private boolean ciU;
  private MediaCodec.BufferInfo eRL;
  protected int eRm;
  private int eRu;
  private int eRv;
  private int eRw;
  private int eRx;
  private int eRy;
  protected MediaCodec eUg;
  c.a fYo;
  private int fYp;
  private int fYq;
  private int fYr;
  private boolean fYs;
  private byte[] fYt;
  private int fYu;
  private int frameCount;
  private ByteBuffer[] inputBuffers;
  boolean isStart;
  protected MediaFormat mediaFormat;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(50897);
    this.eRm = -1;
    this.fYq = -1;
    this.fYr = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.ciU = false;
    this.fYs = false;
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.eRu = paramInt1;
    this.eRv = paramInt2;
    this.eRw = paramInt4;
    this.eRy = 1;
    this.eRL = new MediaCodec.BufferInfo();
    this.bitrate = paramInt3;
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.eRu), Integer.valueOf(this.eRv), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(50897);
  }
  
  private void UR()
  {
    AppMethodBeat.i(50904);
    this.fYr = this.eUg.dequeueOutputBuffer(this.eRL, 600L);
    ab.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.fYr);
    if (this.fYr == -1)
    {
      ab.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.fYs) });
      if (!this.fYs) {}
    }
    label245:
    do
    {
      for (;;)
      {
        this.fYr = this.eUg.dequeueOutputBuffer(this.eRL, 600L);
        if (this.fYr <= 0) {
          ab.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.fYr) });
        }
        if ((this.fYr >= 0) || (this.fYs)) {
          break;
        }
        AppMethodBeat.o(50904);
        return;
        if (this.fYr == -3)
        {
          this.azr = this.eUg.getOutputBuffers();
          ab.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
        }
        else if (this.fYr == -2)
        {
          ab.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.eUg.getOutputFormat())));
        }
        else
        {
          if (this.fYr >= 0) {
            break label245;
          }
          ab.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fYr);
        }
      }
      ab.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
      Object localObject = this.azr[this.fYr];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.fYr + " was null");
        AppMethodBeat.o(50904);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.eRL.flags & 0x2) != 0) {
        ab.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.eRL.size), Boolean.FALSE });
      }
      if (this.eRL.size != 0)
      {
        ((ByteBuffer)localObject).position(this.eRL.offset);
        ((ByteBuffer)localObject).limit(this.eRL.offset + this.eRL.size);
        g((ByteBuffer)localObject, this.eRL);
      }
      this.eUg.releaseOutputBuffer(this.fYr, false);
    } while ((this.eRL.flags & 0x4) == 0);
    if (!this.ciU)
    {
      ab.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(50904);
      return;
    }
    ab.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.fYp) });
    try
    {
      this.eUg.stop();
      this.eUg.release();
      this.eUg = null;
      this.isStart = false;
      AppMethodBeat.o(50904);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(50904);
    }
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(50905);
    long l = bo.yB();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ab.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (mo(k))
      {
        m = i;
        if (k > i)
        {
          i = k;
          if (k == 21) {
            break;
          }
          m = k;
        }
      }
      j += 1;
    }
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(50905);
    return i;
  }
  
  private int ame()
  {
    AppMethodBeat.i(50899);
    long l = bo.yB();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ab.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
      AppMethodBeat.o(50899);
      return -1;
    }
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bo.av(l)) });
    l = bo.yB();
    this.eRx = a(localMediaCodecInfo, "video/avc");
    l = bo.av(l);
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.eRx), Long.valueOf(l) });
    if (this.eRx == 19) {}
    for (this.fYu = 2;; this.fYu = 1)
    {
      l = bo.yB();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.eRu, this.eRv);
      ab.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.eRw);
      this.mediaFormat.setInteger("color-format", this.eRx);
      this.mediaFormat.setInteger("i-frame-interval", this.eRy);
      ab.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.eUg = MediaCodec.createByCodecName(localMediaCodecInfo.getName());
      this.eUg.configure(this.mediaFormat, null, null, 1);
      this.eUg.start();
      AppMethodBeat.o(50899);
      return 0;
    }
  }
  
  private void b(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(50903);
    for (;;)
    {
      try
      {
        if (!this.isStart)
        {
          ab.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
          AppMethodBeat.o(50903);
          return;
        }
        if (this.eUg == null)
        {
          ab.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(50903);
          return;
        }
        long l1 = bo.yB();
        this.inputBuffers = this.eUg.getInputBuffers();
        this.azr = this.eUg.getOutputBuffers();
        int i = 0;
        if (this.eUg != null)
        {
          int j = this.eUg.dequeueInputBuffer(600L);
          this.fYq = j;
          if ((j < 0) && (i < 10))
          {
            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
            UR();
            i += 1;
            continue;
          }
        }
        if (this.eUg == null)
        {
          ab.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(50903);
          return;
        }
        ab.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.fYq) });
        long l2 = bo.yB();
        if (this.fYq >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ab.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.inputBuffers[this.fYq];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.eUg.queueInputBuffer(this.fYq, 0, paramArrayOfByte.length, paramLong, 0);
            UR();
            ab.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bo.av(l1)), Long.valueOf(bo.av(l2)) });
            AppMethodBeat.o(50903);
            return;
          }
          ab.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
          this.fYs = true;
          this.eUg.queueInputBuffer(this.fYq, 0, 0, paramLong, 4);
          this.ciU = true;
          continue;
        }
        ab.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        ab.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ab.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(50903);
        return;
      }
    }
  }
  
  private void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(50896);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.fYo != null)) {
      this.fYo.a(this.eRm, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(50896);
  }
  
  private static boolean isRecognizedProfile(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean mo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(50906);
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(50906);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(50906);
    return null;
  }
  
  private void trySetBitRateMode(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(50901);
    try
    {
      if (!d.fv(21)) {
        break label138;
      }
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType("video/avc");
      if (paramMediaCodecInfo == null) {
        break label138;
      }
      paramMediaCodecInfo = paramMediaCodecInfo.getEncoderCapabilities();
      if (paramMediaCodecInfo == null) {
        break label138;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(2))
      {
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(50901);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(50901);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ab.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(50901);
      return;
    }
    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
    label138:
    AppMethodBeat.o(50901);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(50900);
    if (d.fv(23)) {}
    for (;;)
    {
      int i;
      try
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType("video/avc");
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          if (paramMediaCodecInfo != null)
          {
            MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            localCodecProfileLevel.level = 0;
            localCodecProfileLevel.profile = 0;
            int j = paramMediaCodecInfo.length;
            i = 0;
            if (i < j)
            {
              Object localObject = paramMediaCodecInfo[i];
              int k = localObject.profile;
              int m = localObject.level;
              ab.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label273;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label273;
            }
            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
            if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
            {
              this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
              this.mediaFormat.setInteger("level", 256);
            }
          }
        }
        AppMethodBeat.o(50900);
        return;
      }
      catch (Exception paramMediaCodecInfo)
      {
        ab.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      }
      AppMethodBeat.o(50900);
      return;
      label273:
      i += 1;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, int paramInt5)
  {
    AppMethodBeat.i(50902);
    if ((!paramBoolean) && (paramArrayOfByte != null))
    {
      if ((paramInt3 == this.eRu) && (paramInt4 == this.eRv))
      {
        paramBoolean = false;
        ab.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.eRu), Integer.valueOf(this.eRv), Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(this.fYu), Integer.valueOf(paramArrayOfByte.length) });
        if (this.fYt == null) {
          this.fYt = new byte[this.eRu * this.eRv * 3 >> 1];
        }
        if (this.fYt.length != paramArrayOfByte.length) {
          this.fYt = new byte[paramArrayOfByte.length];
        }
        if ((this.eRx != 19) || (paramBoolean)) {
          break label250;
        }
        System.arraycopy(paramArrayOfByte, 0, this.fYt, 0, paramArrayOfByte.length);
      }
      for (;;)
      {
        this.fYp += 1;
        b(this.fYt, false, paramLong);
        AppMethodBeat.o(50902);
        return;
        paramBoolean = true;
        break;
        label250:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(paramArrayOfByte, paramInt5, this.fYt, this.fYu, paramInt1, paramInt2, paramInt3, paramInt4, this.eRu, this.eRv);
      }
    }
    b(this.fYt, true, paramLong);
    AppMethodBeat.o(50902);
  }
  
  public final int mn(int paramInt)
  {
    AppMethodBeat.i(50898);
    try
    {
      this.eRm = paramInt;
      paramInt = ame();
      AppMethodBeat.o(50898);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ab.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = ame();
        AppMethodBeat.o(50898);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(50898);
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bj.c
 * JD-Core Version:    0.7.0.1
 */