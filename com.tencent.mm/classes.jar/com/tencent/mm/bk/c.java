package com.tencent.mm.bk;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

public final class c
{
  private ByteBuffer[] aVy;
  private int bitrate;
  private ByteBuffer[] bjg;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean cVh;
  private int frameCount;
  private int frameRate;
  protected int gNJ;
  private int gNU;
  private int gNV;
  private int gNW;
  private int gNX;
  protected z gQR;
  a ibC;
  private int ibD;
  private int ibE;
  private int ibF;
  private boolean ibG;
  private byte[] ibH;
  private int ibI;
  boolean isStart;
  protected MediaFormat mediaFormat;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127067);
    this.gNJ = -1;
    this.ibE = -1;
    this.ibF = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.cVh = false;
    this.ibG = false;
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gNU = paramInt1;
    this.gNV = paramInt2;
    this.frameRate = paramInt4;
    this.gNX = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt3;
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.gNU), Integer.valueOf(this.gNV), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(127067);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(127075);
    long l = bs.Gn();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ac.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (pM(k))
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
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(127075);
    return i;
  }
  
  private int aKa()
  {
    AppMethodBeat.i(127069);
    long l = bs.Gn();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ac.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
      AppMethodBeat.o(127069);
      return -1;
    }
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bs.aO(l)) });
    l = bs.Gn();
    this.gNW = a(localMediaCodecInfo, "video/avc");
    l = bs.aO(l);
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.gNW), Long.valueOf(l) });
    if (this.gNW == 19) {}
    for (this.ibI = 2;; this.ibI = 1)
    {
      l = bs.Gn();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.gNU, this.gNV);
      ac.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.gNW);
      this.mediaFormat.setInteger("i-frame-interval", this.gNX);
      ac.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.gQR = z.sz(localMediaCodecInfo.getName());
      this.gQR.a(this.mediaFormat, null, 1);
      this.gQR.start();
      AppMethodBeat.o(127069);
      return 0;
    }
  }
  
  private void aqJ()
  {
    AppMethodBeat.i(127074);
    this.ibF = this.gQR.dequeueOutputBuffer(this.bufferInfo, 600L);
    ac.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.ibF);
    if (this.ibF == -1)
    {
      ac.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ibG) });
      if (!this.ibG) {}
    }
    label248:
    do
    {
      for (;;)
      {
        this.ibF = this.gQR.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.ibF <= 0) {
          ac.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ibF) });
        }
        if ((this.ibF >= 0) || (this.ibG)) {
          break;
        }
        AppMethodBeat.o(127074);
        return;
        if (this.ibF == -3)
        {
          this.aVy = this.gQR.getOutputBuffers();
          ac.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
        }
        else if (this.ibF == -2)
        {
          ac.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.gQR.getOutputFormat())));
        }
        else
        {
          if (this.ibF >= 0) {
            break label248;
          }
          ac.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ibF);
        }
      }
      ac.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
      Object localObject = this.aVy[this.ibF];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ibF + " was null");
        AppMethodBeat.o(127074);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ac.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
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
      ac.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(127074);
      return;
    }
    ac.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.ibD) });
    try
    {
      this.gQR.stop();
      this.gQR.release();
      this.gQR = null;
      this.isStart = false;
      AppMethodBeat.o(127074);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
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
          ac.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
          AppMethodBeat.o(127073);
          return;
        }
        if (this.gQR == null)
        {
          ac.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
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
            ac.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
            aqJ();
            i += 1;
            continue;
          }
        }
        if (this.gQR == null)
        {
          ac.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
          return;
        }
        ac.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.ibE) });
        long l2 = bs.Gn();
        if (this.ibE >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ac.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.bjg[this.ibE];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.gQR.a(this.ibE, paramArrayOfByte.length, paramLong, 0);
            aqJ();
            ac.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bs.aO(l1)), Long.valueOf(bs.aO(l2)) });
            AppMethodBeat.o(127073);
            return;
          }
          ac.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
          this.ibG = true;
          this.gQR.a(this.ibE, 0, paramLong, 4);
          this.cVh = true;
          continue;
        }
        ac.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        ac.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ac.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(127073);
        return;
      }
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(127066);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.ibC != null)) {
      this.ibC.a(this.gNJ, paramByteBuffer, paramBufferInfo.size);
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
        ac.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(127071);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ac.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(127071);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ac.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(127071);
      return;
    }
    ac.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(127071);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(127070);
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
              ac.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            ac.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
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
        ac.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
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
      if ((paramInt3 == this.gNU) && (paramInt4 == this.gNV))
      {
        paramBoolean = false;
        ac.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.gNU), Integer.valueOf(this.gNV), Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(this.ibI), Integer.valueOf(paramArrayOfByte.length) });
        if (this.ibH == null) {
          this.ibH = new byte[this.gNU * this.gNV * 3 >> 1];
        }
        if (this.ibH.length != paramArrayOfByte.length) {
          this.ibH = new byte[paramArrayOfByte.length];
        }
        if ((this.gNW != 19) || (paramBoolean)) {
          break label250;
        }
        System.arraycopy(paramArrayOfByte, 0, this.ibH, 0, paramArrayOfByte.length);
      }
      for (;;)
      {
        this.ibD += 1;
        b(this.ibH, false, paramLong);
        AppMethodBeat.o(127072);
        return;
        paramBoolean = true;
        break;
        label250:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(paramArrayOfByte, paramInt5, this.ibH, this.ibI, paramInt1, paramInt2, paramInt3, paramInt4, this.gNU, this.gNV);
      }
    }
    b(this.ibH, true, paramLong);
    AppMethodBeat.o(127072);
  }
  
  public final int pL(int paramInt)
  {
    AppMethodBeat.i(127068);
    try
    {
      this.gNJ = paramInt;
      paramInt = aKa();
      AppMethodBeat.o(127068);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ac.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aKa();
        AppMethodBeat.o(127068);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ac.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
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
 * Qualified Name:     com.tencent.mm.bk.c
 * JD-Core Version:    0.7.0.1
 */