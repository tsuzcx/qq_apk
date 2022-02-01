package com.tencent.mm.bl;

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
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

public final class c
{
  private ByteBuffer[] aUK;
  private ByteBuffer[] biB;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean cXL;
  private int frameCount;
  private int frameRate;
  protected int gmW;
  private int gnh;
  private int gni;
  private int gnk;
  private int gnl;
  protected z gqj;
  a hBb;
  private int hBc;
  private int hBd;
  private int hBe;
  private boolean hBf;
  private byte[] hBg;
  private int hBh;
  boolean isStart;
  protected MediaFormat mediaFormat;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127067);
    this.gmW = -1;
    this.hBd = -1;
    this.hBe = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.cXL = false;
    this.hBf = false;
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gnh = paramInt1;
    this.gni = paramInt2;
    this.frameRate = paramInt4;
    this.gnl = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt3;
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.gnh), Integer.valueOf(this.gni), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(127067);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(127075);
    long l = bt.GC();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ad.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (oX(k))
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
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(127075);
    return i;
  }
  
  private int aDj()
  {
    AppMethodBeat.i(127069);
    long l = bt.GC();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ad.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
      AppMethodBeat.o(127069);
      return -1;
    }
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bt.aS(l)) });
    l = bt.GC();
    this.gnk = a(localMediaCodecInfo, "video/avc");
    l = bt.aS(l);
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.gnk), Long.valueOf(l) });
    if (this.gnk == 19) {}
    for (this.hBh = 2;; this.hBh = 1)
    {
      l = bt.GC();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.gnh, this.gni);
      ad.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.gnk);
      this.mediaFormat.setInteger("i-frame-interval", this.gnl);
      ad.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.gqj = z.pn(localMediaCodecInfo.getName());
      this.gqj.a(this.mediaFormat, null, 1);
      this.gqj.start();
      AppMethodBeat.o(127069);
      return 0;
    }
  }
  
  private void ajK()
  {
    AppMethodBeat.i(127074);
    this.hBe = this.gqj.dequeueOutputBuffer(this.bufferInfo, 600L);
    ad.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.hBe);
    if (this.hBe == -1)
    {
      ad.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.hBf) });
      if (!this.hBf) {}
    }
    label248:
    do
    {
      for (;;)
      {
        this.hBe = this.gqj.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.hBe <= 0) {
          ad.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.hBe) });
        }
        if ((this.hBe >= 0) || (this.hBf)) {
          break;
        }
        AppMethodBeat.o(127074);
        return;
        if (this.hBe == -3)
        {
          this.aUK = this.gqj.getOutputBuffers();
          ad.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
        }
        else if (this.hBe == -2)
        {
          ad.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.gqj.getOutputFormat())));
        }
        else
        {
          if (this.hBe >= 0) {
            break label248;
          }
          ad.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.hBe);
        }
      }
      ad.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
      Object localObject = this.aUK[this.hBe];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.hBe + " was null");
        AppMethodBeat.o(127074);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ad.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
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
      ad.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(127074);
      return;
    }
    ad.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.hBc) });
    try
    {
      this.gqj.stop();
      this.gqj.release();
      this.gqj = null;
      this.isStart = false;
      AppMethodBeat.o(127074);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(127074);
    }
  }
  
  private void b(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(127073);
    for (;;)
    {
      try
      {
        if (!this.isStart)
        {
          ad.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
          AppMethodBeat.o(127073);
          return;
        }
        if (this.gqj == null)
        {
          ad.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
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
            ad.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
            ajK();
            i += 1;
            continue;
          }
        }
        if (this.gqj == null)
        {
          ad.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
          return;
        }
        ad.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.hBd) });
        long l2 = bt.GC();
        if (this.hBd >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ad.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.biB[this.hBd];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.gqj.a(this.hBd, paramArrayOfByte.length, paramLong, 0);
            ajK();
            ad.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bt.aS(l1)), Long.valueOf(bt.aS(l2)) });
            AppMethodBeat.o(127073);
            return;
          }
          ad.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
          this.hBf = true;
          this.gqj.a(this.hBd, 0, paramLong, 4);
          this.cXL = true;
          continue;
        }
        ad.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ad.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(127073);
        return;
      }
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(127066);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.hBb != null)) {
      this.hBb.a(this.gmW, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(127066);
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
    AppMethodBeat.i(127076);
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
            AppMethodBeat.o(127076);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(127076);
    return null;
  }
  
  private void trySetBitRateMode(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(127071);
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
        ad.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(127071);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ad.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(127071);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ad.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(127071);
      return;
    }
    ad.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(127071);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(127070);
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
              ad.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            ad.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
            if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
            {
              this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
              this.mediaFormat.setInteger("level", 256);
            }
          }
        }
        AppMethodBeat.o(127070);
        return;
      }
      catch (Exception paramMediaCodecInfo)
      {
        ad.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      }
      AppMethodBeat.o(127070);
      return;
      label272:
      i += 1;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, int paramInt5)
  {
    AppMethodBeat.i(127072);
    if ((!paramBoolean) && (paramArrayOfByte != null))
    {
      if ((paramInt3 == this.gnh) && (paramInt4 == this.gni))
      {
        paramBoolean = false;
        ad.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.gnh), Integer.valueOf(this.gni), Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(this.hBh), Integer.valueOf(paramArrayOfByte.length) });
        if (this.hBg == null) {
          this.hBg = new byte[this.gnh * this.gni * 3 >> 1];
        }
        if (this.hBg.length != paramArrayOfByte.length) {
          this.hBg = new byte[paramArrayOfByte.length];
        }
        if ((this.gnk != 19) || (paramBoolean)) {
          break label250;
        }
        System.arraycopy(paramArrayOfByte, 0, this.hBg, 0, paramArrayOfByte.length);
      }
      for (;;)
      {
        this.hBc += 1;
        b(this.hBg, false, paramLong);
        AppMethodBeat.o(127072);
        return;
        paramBoolean = true;
        break;
        label250:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(paramArrayOfByte, paramInt5, this.hBg, this.hBh, paramInt1, paramInt2, paramInt3, paramInt4, this.gnh, this.gni);
      }
    }
    b(this.hBg, true, paramLong);
    AppMethodBeat.o(127072);
  }
  
  public final int oW(int paramInt)
  {
    AppMethodBeat.i(127068);
    try
    {
      this.gmW = paramInt;
      paramInt = aDj();
      AppMethodBeat.o(127068);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aDj();
        AppMethodBeat.o(127068);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(127068);
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
 * Qualified Name:     com.tencent.mm.bl.c
 * JD-Core Version:    0.7.0.1
 */