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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

public final class f
{
  private ByteBuffer[] aVy;
  private int bitrate;
  private ByteBuffer[] bjg;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean cVh;
  int frameCount;
  private int frameRate;
  protected int gNJ;
  int gNU;
  int gNV;
  int gNW;
  private int gNX;
  protected z gQR;
  int ibD;
  private int ibE;
  private int ibF;
  private boolean ibG;
  byte[] ibH;
  int ibI;
  boolean isStart;
  private int jbj;
  private int jbk;
  protected MediaFormat mediaFormat;
  a uNR;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89629);
    this.gNJ = -1;
    this.ibE = -1;
    this.ibF = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.cVh = false;
    this.ibG = false;
    this.jbj = paramInt1;
    this.jbk = paramInt2;
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.gNU = paramInt3;
    this.gNV = paramInt4;
    this.frameRate = paramInt6;
    this.gNX = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.jbj), Integer.valueOf(this.jbk), Integer.valueOf(this.gNU), Integer.valueOf(this.gNV), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(89629);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(89636);
    long l = bs.Gn();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (pM(k))
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
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(89636);
    return i;
  }
  
  private int aKa()
  {
    AppMethodBeat.i(89631);
    long l = bs.Gn();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
      l.arU();
      AppMethodBeat.o(89631);
      return -1;
    }
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bs.aO(l)) });
    l = bs.Gn();
    this.gNW = a(localMediaCodecInfo, "video/avc");
    l = bs.aO(l);
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.gNW), Long.valueOf(l) });
    if (this.gNW == 19) {}
    for (this.ibI = 2;; this.ibI = 1)
    {
      l = bs.Gn();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.gNU, this.gNV);
      ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.gNW);
      this.mediaFormat.setInteger("i-frame-interval", this.gNX);
      ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.gQR = z.sz(localMediaCodecInfo.getName());
      this.gQR.a(this.mediaFormat, null, 1);
      this.gQR.start();
      AppMethodBeat.o(89631);
      return 0;
    }
  }
  
  private void aqJ()
  {
    AppMethodBeat.i(89635);
    this.ibF = this.gQR.dequeueOutputBuffer(this.bufferInfo, 600L);
    ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.ibF);
    if (this.ibF == -1)
    {
      ac.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ibG) });
      if (!this.ibG) {}
    }
    label249:
    do
    {
      for (;;)
      {
        this.ibF = this.gQR.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.ibF <= 0) {
          ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ibF) });
        }
        if ((this.ibF >= 0) || (this.ibG)) {
          break;
        }
        AppMethodBeat.o(89635);
        return;
        if (this.ibF == -3)
        {
          this.aVy = this.gQR.getOutputBuffers();
          ac.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
        }
        else if (this.ibF == -2)
        {
          ac.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.gQR.getOutputFormat())));
        }
        else
        {
          if (this.ibF >= 0) {
            break label249;
          }
          ac.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ibF);
        }
      }
      ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
      Object localObject = this.aVy[this.ibF];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ibF + " was null");
        AppMethodBeat.o(89635);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.gQR.releaseOutputBuffer(this.ibF, false);
    } while ((this.bufferInfo.flags & 0x4) == 0);
    if (!this.cVh)
    {
      ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(89635);
      return;
    }
    ac.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.ibD) });
    try
    {
      this.gQR.stop();
      this.gQR.release();
      this.gQR = null;
      this.isStart = false;
      AppMethodBeat.o(89635);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89635);
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89628);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.uNR != null)) {
      this.uNR.a(this.gNJ, paramByteBuffer, paramBufferInfo.size);
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
  
  private static boolean pM(int paramInt)
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
      if (!d.kZ(21)) {
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
        ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(89633);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(89633);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(89633);
      return;
    }
    ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(89633);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(89632);
    if (d.kZ(23)) {}
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
              ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
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
        ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
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
          ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
          AppMethodBeat.o(89634);
          return;
        }
        if (this.gQR == null)
        {
          ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        long l1 = bs.Gn();
        this.bjg = this.gQR.getInputBuffers();
        this.aVy = this.gQR.getOutputBuffers();
        int i = 0;
        if (this.gQR != null)
        {
          int j = this.gQR.dequeueInputBuffer(600L);
          this.ibE = j;
          if ((j < 0) && (i < 10))
          {
            ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
            aqJ();
            i += 1;
            continue;
          }
        }
        if (this.gQR == null)
        {
          ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.ibE) });
        long l2 = bs.Gn();
        if (this.ibE >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.bjg[this.ibE];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.gQR.a(this.ibE, paramArrayOfByte.length, paramLong, 0);
            aqJ();
            ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bs.aO(l1)), Long.valueOf(bs.aO(l2)) });
            AppMethodBeat.o(89634);
            return;
          }
          ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
          this.ibG = true;
          this.gQR.a(this.ibE, 0, paramLong, 4);
          this.cVh = true;
          continue;
        }
        ac.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.arV();
        ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ac.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89634);
        return;
      }
    }
  }
  
  public final int pL(int paramInt)
  {
    AppMethodBeat.i(89630);
    try
    {
      this.gNJ = paramInt;
      paramInt = aKa();
      AppMethodBeat.o(89630);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aKa();
        AppMethodBeat.o(89630);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ac.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.arU();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.f
 * JD-Core Version:    0.7.0.1
 */