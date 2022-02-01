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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

public final class c
{
  private ByteBuffer[] bfT;
  private int bitrate;
  private ByteBuffer[] btA;
  protected int bufId;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean dhz;
  private int frameCount;
  private int frameRate;
  private int hkE;
  private int hkF;
  protected z hlX;
  boolean isStart;
  a ixS;
  private int ixT;
  private int ixU;
  private int ixV;
  private boolean ixW;
  private byte[] ixX;
  private int ixY;
  protected MediaFormat mediaFormat;
  private int targetHeight;
  private int targetWidth;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127067);
    this.bufId = -1;
    this.ixU = -1;
    this.ixV = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.dhz = false;
    this.ixW = false;
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    this.frameRate = paramInt4;
    this.hkF = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt3;
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(127067);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(127075);
    long l = bu.HQ();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ae.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (qr(k))
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
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(127075);
    return i;
  }
  
  private int aNH()
  {
    AppMethodBeat.i(127069);
    long l = bu.HQ();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ae.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
      AppMethodBeat.o(127069);
      return -1;
    }
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bu.aO(l)) });
    l = bu.HQ();
    this.hkE = a(localMediaCodecInfo, "video/avc");
    l = bu.aO(l);
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.hkE), Long.valueOf(l) });
    if (this.hkE == 19) {}
    for (this.ixY = 2;; this.ixY = 1)
    {
      l = bu.HQ();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.targetWidth, this.targetHeight);
      ae.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.hkE);
      this.mediaFormat.setInteger("i-frame-interval", this.hkF);
      ae.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.hlX = z.vK(localMediaCodecInfo.getName());
      this.hlX.a(this.mediaFormat, null, 1);
      this.hlX.start();
      AppMethodBeat.o(127069);
      return 0;
    }
  }
  
  private void atM()
  {
    AppMethodBeat.i(127074);
    this.ixV = this.hlX.dequeueOutputBuffer(this.bufferInfo, 600L);
    ae.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.ixV);
    if (this.ixV == -1)
    {
      ae.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ixW) });
      if (!this.ixW) {}
    }
    label248:
    do
    {
      for (;;)
      {
        this.ixV = this.hlX.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.ixV <= 0) {
          ae.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ixV) });
        }
        if ((this.ixV >= 0) || (this.ixW)) {
          break;
        }
        AppMethodBeat.o(127074);
        return;
        if (this.ixV == -3)
        {
          this.bfT = this.hlX.getOutputBuffers();
          ae.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
        }
        else if (this.ixV == -2)
        {
          ae.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.hlX.getOutputFormat())));
        }
        else
        {
          if (this.ixV >= 0) {
            break label248;
          }
          ae.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ixV);
        }
      }
      ae.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
      Object localObject = this.bfT[this.ixV];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ixV + " was null");
        AppMethodBeat.o(127074);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ae.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.hlX.releaseOutputBuffer(this.ixV, false);
    } while ((this.bufferInfo.flags & 0x4) == 0);
    if (!this.dhz)
    {
      ae.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(127074);
      return;
    }
    ae.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.ixT) });
    try
    {
      this.hlX.stop();
      this.hlX.release();
      this.hlX = null;
      this.isStart = false;
      AppMethodBeat.o(127074);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
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
          ae.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
          AppMethodBeat.o(127073);
          return;
        }
        if (this.hlX == null)
        {
          ae.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
          return;
        }
        long l1 = bu.HQ();
        this.btA = this.hlX.getInputBuffers();
        this.bfT = this.hlX.getOutputBuffers();
        int i = 0;
        if (this.hlX != null)
        {
          int j = this.hlX.dequeueInputBuffer(600L);
          this.ixU = j;
          if ((j < 0) && (i < 10))
          {
            ae.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
            atM();
            i += 1;
            continue;
          }
        }
        if (this.hlX == null)
        {
          ae.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
          return;
        }
        ae.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.ixU) });
        long l2 = bu.HQ();
        if (this.ixU >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ae.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.btA[this.ixU];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.hlX.a(this.ixU, paramArrayOfByte.length, paramLong, 0);
            atM();
            ae.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bu.aO(l1)), Long.valueOf(bu.aO(l2)) });
            AppMethodBeat.o(127073);
            return;
          }
          ae.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
          this.ixW = true;
          this.hlX.a(this.ixU, 0, paramLong, 4);
          this.dhz = true;
          continue;
        }
        ae.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        ae.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ae.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(127073);
        return;
      }
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(127066);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.ixS != null)) {
      this.ixS.a(this.bufId, paramByteBuffer, paramBufferInfo.size);
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
  
  private static boolean qr(int paramInt)
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
      if (!d.lA(21)) {
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
        ae.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(127071);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ae.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(127071);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ae.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(127071);
      return;
    }
    ae.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(127071);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(127070);
    if (d.lA(23)) {}
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
              ae.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            ae.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
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
        ae.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
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
      if ((paramInt3 == this.targetWidth) && (paramInt4 == this.targetHeight))
      {
        paramBoolean = false;
        ae.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(this.ixY), Integer.valueOf(paramArrayOfByte.length) });
        if (this.ixX == null) {
          this.ixX = new byte[this.targetWidth * this.targetHeight * 3 >> 1];
        }
        if (this.ixX.length != paramArrayOfByte.length) {
          this.ixX = new byte[paramArrayOfByte.length];
        }
        if ((this.hkE != 19) || (paramBoolean)) {
          break label250;
        }
        System.arraycopy(paramArrayOfByte, 0, this.ixX, 0, paramArrayOfByte.length);
      }
      for (;;)
      {
        this.ixT += 1;
        b(this.ixX, false, paramLong);
        AppMethodBeat.o(127072);
        return;
        paramBoolean = true;
        break;
        label250:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(paramArrayOfByte, paramInt5, this.ixX, this.ixY, paramInt1, paramInt2, paramInt3, paramInt4, this.targetWidth, this.targetHeight);
      }
    }
    b(this.ixX, true, paramLong);
    AppMethodBeat.o(127072);
  }
  
  public final int qq(int paramInt)
  {
    AppMethodBeat.i(127068);
    try
    {
      this.bufId = paramInt;
      paramInt = aNH();
      AppMethodBeat.o(127068);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ae.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aNH();
        AppMethodBeat.o(127068);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ae.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bk.c
 * JD-Core Version:    0.7.0.1
 */