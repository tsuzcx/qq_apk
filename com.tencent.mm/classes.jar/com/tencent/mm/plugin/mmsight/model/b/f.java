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
  private ByteBuffer[] aUK;
  private ByteBuffer[] biB;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean cXL;
  int frameCount;
  private int frameRate;
  protected int gmW;
  int gnh;
  int gni;
  int gnk;
  private int gnl;
  protected z gqj;
  int hBc;
  private int hBd;
  private int hBe;
  private boolean hBf;
  byte[] hBg;
  int hBh;
  private int iBi;
  private int iBj;
  boolean isStart;
  protected MediaFormat mediaFormat;
  a tFw;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89629);
    this.gmW = -1;
    this.hBd = -1;
    this.hBe = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.cXL = false;
    this.hBf = false;
    this.iBi = paramInt1;
    this.iBj = paramInt2;
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.gnh = paramInt3;
    this.gni = paramInt4;
    this.frameRate = paramInt6;
    this.gnl = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.iBi), Integer.valueOf(this.iBj), Integer.valueOf(this.gnh), Integer.valueOf(this.gni), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(89629);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(89636);
    long l = bt.GC();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (oX(k))
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
  
  private int aDj()
  {
    AppMethodBeat.i(89631);
    long l = bt.GC();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
      l.ala();
      AppMethodBeat.o(89631);
      return -1;
    }
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bt.aS(l)) });
    l = bt.GC();
    this.gnk = a(localMediaCodecInfo, "video/avc");
    l = bt.aS(l);
    ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.gnk), Long.valueOf(l) });
    if (this.gnk == 19) {}
    for (this.hBh = 2;; this.hBh = 1)
    {
      l = bt.GC();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.gnh, this.gni);
      ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.gnk);
      this.mediaFormat.setInteger("i-frame-interval", this.gnl);
      ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.gqj = z.pn(localMediaCodecInfo.getName());
      this.gqj.a(this.mediaFormat, null, 1);
      this.gqj.start();
      AppMethodBeat.o(89631);
      return 0;
    }
  }
  
  private void ajK()
  {
    AppMethodBeat.i(89635);
    this.hBe = this.gqj.dequeueOutputBuffer(this.bufferInfo, 600L);
    ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.hBe);
    if (this.hBe == -1)
    {
      ad.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.hBf) });
      if (!this.hBf) {}
    }
    label249:
    do
    {
      for (;;)
      {
        this.hBe = this.gqj.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.hBe <= 0) {
          ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.hBe) });
        }
        if ((this.hBe >= 0) || (this.hBf)) {
          break;
        }
        AppMethodBeat.o(89635);
        return;
        if (this.hBe == -3)
        {
          this.aUK = this.gqj.getOutputBuffers();
          ad.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
        }
        else if (this.hBe == -2)
        {
          ad.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.gqj.getOutputFormat())));
        }
        else
        {
          if (this.hBe >= 0) {
            break label249;
          }
          ad.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.hBe);
        }
      }
      ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
      Object localObject = this.aUK[this.hBe];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.hBe + " was null");
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
      this.gqj.releaseOutputBuffer(this.hBe, false);
    } while ((this.bufferInfo.flags & 0x4) == 0);
    if (!this.cXL)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(89635);
      return;
    }
    ad.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.hBc) });
    try
    {
      this.gqj.stop();
      this.gqj.release();
      this.gqj = null;
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
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.tFw != null)) {
      this.tFw.a(this.gmW, paramByteBuffer, paramBufferInfo.size);
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
  
  private static boolean oX(int paramInt)
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
      if (!d.lf(21)) {
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
    if (d.lf(23)) {}
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
        if (this.gqj == null)
        {
          ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        long l1 = bt.GC();
        this.biB = this.gqj.getInputBuffers();
        this.aUK = this.gqj.getOutputBuffers();
        int i = 0;
        if (this.gqj != null)
        {
          int j = this.gqj.dequeueInputBuffer(600L);
          this.hBd = j;
          if ((j < 0) && (i < 10))
          {
            ad.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
            ajK();
            i += 1;
            continue;
          }
        }
        if (this.gqj == null)
        {
          ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.hBd) });
        long l2 = bt.GC();
        if (this.hBd >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.biB[this.hBd];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.gqj.a(this.hBd, paramArrayOfByte.length, paramLong, 0);
            ajK();
            ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bt.aS(l1)), Long.valueOf(bt.aS(l2)) });
            AppMethodBeat.o(89634);
            return;
          }
          ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
          this.hBf = true;
          this.gqj.a(this.hBd, 0, paramLong, 4);
          this.cXL = true;
          continue;
        }
        ad.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.alb();
        ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ad.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89634);
        return;
      }
    }
  }
  
  public final int oW(int paramInt)
  {
    AppMethodBeat.i(89630);
    try
    {
      this.gmW = paramInt;
      paramInt = aDj();
      AppMethodBeat.o(89630);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aDj();
        AppMethodBeat.o(89630);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.ala();
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