package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

public final class f
{
  private ByteBuffer[] bfT;
  private int bitrate;
  private ByteBuffer[] btA;
  protected int bufId;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean dgx;
  int frameCount;
  private int frameRate;
  int hhQ;
  private int hhR;
  protected z hjj;
  boolean isStart;
  int iuZ;
  private int iva;
  private int ivb;
  private boolean ivc;
  byte[] ivd;
  int ive;
  private int jus;
  private int jut;
  protected MediaFormat mediaFormat;
  int targetHeight;
  int targetWidth;
  a vRa;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89629);
    this.bufId = -1;
    this.iva = -1;
    this.ivb = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.dgx = false;
    this.ivc = false;
    this.jus = paramInt1;
    this.jut = paramInt2;
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.frameRate = paramInt6;
    this.hhR = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.jus), Integer.valueOf(this.jut), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(89629);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(89636);
    long l = bt.HI();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (qo(k))
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
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(89636);
    return i;
  }
  
  private int aNj()
  {
    AppMethodBeat.i(89631);
    long l = bt.HI();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
      l.auH();
      AppMethodBeat.o(89631);
      return -1;
    }
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bt.aO(l)) });
    l = bt.HI();
    this.hhQ = a(localMediaCodecInfo, "video/avc");
    l = bt.aO(l);
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.hhQ), Long.valueOf(l) });
    if (this.hhQ == 19) {}
    for (this.ive = 2;; this.ive = 1)
    {
      l = bt.HI();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.targetWidth, this.targetHeight);
      ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.hhQ);
      this.mediaFormat.setInteger("i-frame-interval", this.hhR);
      ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.hjj = z.vo(localMediaCodecInfo.getName());
      this.hjj.a(this.mediaFormat, null, 1);
      this.hjj.start();
      AppMethodBeat.o(89631);
      return 0;
    }
  }
  
  private void atx()
  {
    AppMethodBeat.i(89635);
    this.ivb = this.hjj.dequeueOutputBuffer(this.bufferInfo, 600L);
    ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.ivb);
    if (this.ivb == -1)
    {
      ad.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ivc) });
      if (!this.ivc) {}
    }
    label249:
    do
    {
      for (;;)
      {
        this.ivb = this.hjj.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.ivb <= 0) {
          ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ivb) });
        }
        if ((this.ivb >= 0) || (this.ivc)) {
          break;
        }
        AppMethodBeat.o(89635);
        return;
        if (this.ivb == -3)
        {
          this.bfT = this.hjj.getOutputBuffers();
          ad.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
        }
        else if (this.ivb == -2)
        {
          ad.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.hjj.getOutputFormat())));
        }
        else
        {
          if (this.ivb >= 0) {
            break label249;
          }
          ad.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ivb);
        }
      }
      ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
      Object localObject = this.bfT[this.ivb];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ivb + " was null");
        AppMethodBeat.o(89635);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.hjj.releaseOutputBuffer(this.ivb, false);
    } while ((this.bufferInfo.flags & 0x4) == 0);
    if (!this.dgx)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(89635);
      return;
    }
    ad.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.iuZ) });
    try
    {
      this.hjj.stop();
      this.hjj.release();
      this.hjj = null;
      this.isStart = false;
      AppMethodBeat.o(89635);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89635);
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89628);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.vRa != null)) {
      this.vRa.a(this.bufId, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(89628);
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
  
  private static boolean qo(int paramInt)
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
    AppMethodBeat.i(89637);
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
            AppMethodBeat.o(89637);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(89637);
    return null;
  }
  
  private void trySetBitRateMode(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(89633);
    try
    {
      if (!d.ly(21)) {
        break label137;
      }
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType("video/avc");
      if (paramMediaCodecInfo == null) {
        break label137;
      }
      paramMediaCodecInfo = paramMediaCodecInfo.getEncoderCapabilities();
      if (paramMediaCodecInfo == null) {
        break label137;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(2))
      {
        ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(89633);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(89633);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(89633);
      return;
    }
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(89633);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(89632);
    if (d.ly(23)) {}
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
              ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
            if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
            {
              this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
              this.mediaFormat.setInteger("level", 256);
            }
          }
        }
        AppMethodBeat.o(89632);
        return;
      }
      catch (Exception paramMediaCodecInfo)
      {
        ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      }
      AppMethodBeat.o(89632);
      return;
      label272:
      i += 1;
    }
  }
  
  public final void b(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89634);
    for (;;)
    {
      try
      {
        if (!this.isStart)
        {
          ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
          AppMethodBeat.o(89634);
          return;
        }
        if (this.hjj == null)
        {
          ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        long l1 = bt.HI();
        this.btA = this.hjj.getInputBuffers();
        this.bfT = this.hjj.getOutputBuffers();
        int i = 0;
        if (this.hjj != null)
        {
          int j = this.hjj.dequeueInputBuffer(600L);
          this.iva = j;
          if ((j < 0) && (i < 10))
          {
            ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
            atx();
            i += 1;
            continue;
          }
        }
        if (this.hjj == null)
        {
          ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.iva) });
        long l2 = bt.HI();
        if (this.iva >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.btA[this.iva];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.hjj.a(this.iva, paramArrayOfByte.length, paramLong, 0);
            atx();
            ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bt.aO(l1)), Long.valueOf(bt.aO(l2)) });
            AppMethodBeat.o(89634);
            return;
          }
          ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
          this.ivc = true;
          this.hjj.a(this.iva, 0, paramLong, 4);
          this.dgx = true;
          continue;
        }
        ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.auI();
        ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ad.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89634);
        return;
      }
    }
  }
  
  public final int qn(int paramInt)
  {
    AppMethodBeat.i(89630);
    try
    {
      this.bufId = paramInt;
      paramInt = aNj();
      AppMethodBeat.o(89630);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aNj();
        AppMethodBeat.o(89630);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.auH();
        AppMethodBeat.o(89630);
      }
    }
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.f
 * JD-Core Version:    0.7.0.1
 */