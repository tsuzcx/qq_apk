package com.tencent.mm.plugin.mmsight.model.b;

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
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class f
{
  private ByteBuffer[] azr;
  private int bitrate;
  private boolean ciU;
  private MediaCodec.BufferInfo eRL;
  protected int eRm;
  int eRu;
  int eRv;
  private int eRw;
  int eRx;
  private int eRy;
  protected MediaCodec eUg;
  int fYp;
  private int fYq;
  private int fYr;
  private boolean fYs;
  byte[] fYt;
  int fYu;
  int frameCount;
  private int gNA;
  private int gNB;
  private ByteBuffer[] inputBuffers;
  boolean isStart;
  protected MediaFormat mediaFormat;
  f.a oKl;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(76715);
    this.eRm = -1;
    this.fYq = -1;
    this.fYr = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.ciU = false;
    this.fYs = false;
    this.gNA = paramInt1;
    this.gNB = paramInt2;
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.eRu = paramInt3;
    this.eRv = paramInt4;
    this.eRw = paramInt6;
    this.eRy = 1;
    this.eRL = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.gNA), Integer.valueOf(this.gNB), Integer.valueOf(this.eRu), Integer.valueOf(this.eRv), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(76715);
  }
  
  private void UR()
  {
    AppMethodBeat.i(76721);
    this.fYr = this.eUg.dequeueOutputBuffer(this.eRL, 600L);
    ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.fYr);
    if (this.fYr == -1)
    {
      ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.fYs) });
      if (!this.fYs) {}
    }
    label245:
    do
    {
      for (;;)
      {
        this.fYr = this.eUg.dequeueOutputBuffer(this.eRL, 600L);
        if (this.fYr <= 0) {
          ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.fYr) });
        }
        if ((this.fYr >= 0) || (this.fYs)) {
          break;
        }
        AppMethodBeat.o(76721);
        return;
        if (this.fYr == -3)
        {
          this.azr = this.eUg.getOutputBuffers();
          ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
        }
        else if (this.fYr == -2)
        {
          ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.eUg.getOutputFormat())));
        }
        else
        {
          if (this.fYr >= 0) {
            break label245;
          }
          ab.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fYr);
        }
      }
      ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
      Object localObject = this.azr[this.fYr];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.fYr + " was null");
        AppMethodBeat.o(76721);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.eRL.flags & 0x2) != 0) {
        ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.eRL.size), Boolean.FALSE });
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
      ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(76721);
      return;
    }
    ab.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.fYp) });
    try
    {
      this.eUg.stop();
      this.eUg.release();
      this.eUg = null;
      this.isStart = false;
      AppMethodBeat.o(76721);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76721);
    }
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(76722);
    long l = bo.yB();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (mo(k))
      {
        m = i;
        if (k > i)
        {
          i = k;
          if (k == 19) {
            break;
          }
          m = k;
        }
      }
      j += 1;
    }
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(76722);
    return i;
  }
  
  private int ame()
  {
    AppMethodBeat.i(76717);
    long l = bo.yB();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
      k.VN();
      AppMethodBeat.o(76717);
      return -1;
    }
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bo.av(l)) });
    l = bo.yB();
    this.eRx = a(localMediaCodecInfo, "video/avc");
    l = bo.av(l);
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.eRx), Long.valueOf(l) });
    if (this.eRx == 19) {}
    for (this.fYu = 2;; this.fYu = 1)
    {
      l = bo.yB();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.eRu, this.eRv);
      ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.eRw);
      this.mediaFormat.setInteger("color-format", this.eRx);
      this.mediaFormat.setInteger("i-frame-interval", this.eRy);
      ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.eUg = MediaCodec.createByCodecName(localMediaCodecInfo.getName());
      this.eUg.configure(this.mediaFormat, null, null, 1);
      this.eUg.start();
      AppMethodBeat.o(76717);
      return 0;
    }
  }
  
  private void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(76714);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.oKl != null)) {
      this.oKl.a(this.eRm, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(76714);
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
    AppMethodBeat.i(76723);
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
            AppMethodBeat.o(76723);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(76723);
    return null;
  }
  
  private void trySetBitRateMode(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(76719);
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
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(76719);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(76719);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(76719);
      return;
    }
    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
    label138:
    AppMethodBeat.o(76719);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(76718);
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
              ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label273;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label273;
            }
            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
            if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
            {
              this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
              this.mediaFormat.setInteger("level", 256);
            }
          }
        }
        AppMethodBeat.o(76718);
        return;
      }
      catch (Exception paramMediaCodecInfo)
      {
        ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      }
      AppMethodBeat.o(76718);
      return;
      label273:
      i += 1;
    }
  }
  
  public final void b(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(76720);
    for (;;)
    {
      try
      {
        if (!this.isStart)
        {
          ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
          AppMethodBeat.o(76720);
          return;
        }
        if (this.eUg == null)
        {
          ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(76720);
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
            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
            UR();
            i += 1;
            continue;
          }
        }
        if (this.eUg == null)
        {
          ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(76720);
          return;
        }
        ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.fYq) });
        long l2 = bo.yB();
        if (this.fYq >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.inputBuffers[this.fYq];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.eUg.queueInputBuffer(this.fYq, 0, paramArrayOfByte.length, paramLong, 0);
            UR();
            ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bo.av(l1)), Long.valueOf(bo.av(l2)) });
            AppMethodBeat.o(76720);
            return;
          }
          ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
          this.fYs = true;
          this.eUg.queueInputBuffer(this.fYq, 0, 0, paramLong, 4);
          this.ciU = true;
          continue;
        }
        ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        k.VO();
        ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(76720);
        return;
      }
    }
  }
  
  public final int mn(int paramInt)
  {
    AppMethodBeat.i(76716);
    try
    {
      this.eRm = paramInt;
      paramInt = ame();
      AppMethodBeat.o(76716);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = ame();
        AppMethodBeat.o(76716);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        k.VN();
        AppMethodBeat.o(76716);
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.f
 * JD-Core Version:    0.7.0.1
 */