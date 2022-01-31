package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public final class f
{
  private ByteBuffer[] axb;
  private boolean bCf = false;
  boolean bSr = false;
  private int bitrate = 0;
  int eIB;
  int eIC;
  int eID;
  int eIE;
  protected MediaCodec eIF;
  protected MediaFormat eIG;
  private int eIH = -1;
  private int eII = -1;
  private MediaCodec.BufferInfo eIJ;
  private boolean eIK = false;
  private int eIL;
  private int eIM;
  byte[] eIN;
  int eIO;
  protected int eIz = -1;
  int frameCount;
  private int fvY;
  private int fvZ;
  private ByteBuffer[] inputBuffers;
  a mle;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.fvY = paramInt1;
    this.fvZ = paramInt2;
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.eIB = paramInt3;
    this.eIC = paramInt4;
    this.eIM = paramInt6;
    this.eIL = 1;
    this.eIJ = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.fvY), Integer.valueOf(this.fvZ), Integer.valueOf(this.eIB), Integer.valueOf(this.eIC), Integer.valueOf(paramInt5) });
  }
  
  private int SR()
  {
    long l1 = bk.UZ();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    if (i < k)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        localObject1 = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        label39:
        if (j < localObject1.length) {
          if (!localObject1[j].equalsIgnoreCase("video/avc")) {}
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label95;
      }
      y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
      k.biY();
      return -1;
      j += 1;
      break label39;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label95:
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bk.cp(l1)) });
    l1 = bk.UZ();
    i = 0;
    long l2 = bk.UZ();
    Object localObject1 = localMediaCodecInfo.getCapabilitiesForType("video/avc");
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bk.cp(l2)) });
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats.length) });
    j = 0;
    int n;
    int m;
    if (j < ((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats.length)
    {
      k = localObject1.colorFormats[j];
      y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      switch (k)
      {
      }
      for (n = 0;; n = 1)
      {
        m = i;
        if (n != 0)
        {
          m = i;
          if (k > i)
          {
            i = k;
            if (k == 19) {
              break label310;
            }
            m = k;
          }
        }
        j += 1;
        i = m;
        break;
      }
    }
    label310:
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[] { localMediaCodecInfo.getName(), Integer.valueOf(i) });
    this.eID = i;
    l1 = bk.cp(l1);
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.eID), Long.valueOf(l1) });
    if (this.eID == 19)
    {
      this.eIO = 2;
      l1 = bk.UZ();
      this.eIG = MediaFormat.createVideoFormat("video/avc", this.eIB, this.eIC);
      y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bk.cp(l1)) });
      if ((localMediaCodecInfo != null) && (!d.gF(23))) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          localObject1 = localMediaCodecInfo.getCapabilitiesForType("video/avc");
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels;
          if (localObject1 == null) {
            continue;
          }
          localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
          localCodecProfileLevel.level = 0;
          localCodecProfileLevel.profile = 0;
          k = localObject1.length;
          i = 0;
          if (i >= k) {
            continue;
          }
          Object localObject2 = localObject1[i];
          m = localObject2.profile;
          n = localObject2.level;
          y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
          switch (m)
          {
          }
        }
        catch (Exception localException1)
        {
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
          y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
          continue;
          if (!localException1.isBitrateModeSupported(0)) {
            continue;
          }
          y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
          this.eIG.setInteger("bitrate-mode", 0);
          continue;
          j = 0;
          continue;
        }
        if ((j != 0) && (m >= localCodecProfileLevel.profile) && (n >= localCodecProfileLevel.level))
        {
          localCodecProfileLevel.profile = m;
          localCodecProfileLevel.level = n;
        }
        i += 1;
        continue;
        this.eIO = 1;
        break;
        j = 1;
      }
      y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
      if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
      {
        this.eIG.setInteger("profile", localCodecProfileLevel.profile);
        this.eIG.setInteger("level", 256);
      }
    }
    try
    {
      if (d.gF(21))
      {
        localObject1 = localMediaCodecInfo.getCapabilitiesForType("video/avc");
        if (localObject1 != null)
        {
          localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).getEncoderCapabilities();
          if (localObject1 != null)
          {
            if (!((MediaCodecInfo.EncoderCapabilities)localObject1).isBitrateModeSupported(2)) {
              break label914;
            }
            y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
            this.eIG.setInteger("bitrate-mode", 2);
          }
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
        continue;
        y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
      }
    }
    this.eIG.setInteger("bitrate", this.bitrate);
    this.eIG.setInteger("frame-rate", this.eIM);
    this.eIG.setInteger("color-format", this.eID);
    this.eIG.setInteger("i-frame-interval", this.eIL);
    y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[] { this.eIG });
    this.eIF = MediaCodec.createByCodecName(localMediaCodecInfo.getName());
    this.eIF.configure(this.eIG, null, null, 1);
    this.eIF.start();
    return 0;
  }
  
  private void SS()
  {
    this.eII = this.eIF.dequeueOutputBuffer(this.eIJ, 600L);
    y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.eII);
    if (this.eII == -1)
    {
      y.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.eIK) });
      if (!this.eIK) {}
    }
    label250:
    do
    {
      for (;;)
      {
        this.eII = this.eIF.dequeueOutputBuffer(this.eIJ, 600L);
        if (this.eII <= 0) {
          y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.eII) });
        }
        if ((this.eII >= 0) || (this.eIK)) {
          break;
        }
        return;
        if (this.eII == -3)
        {
          this.axb = this.eIF.getOutputBuffers();
          y.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
        }
        else if (this.eII == -2)
        {
          localObject = this.eIF.getOutputFormat();
          y.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: " + localObject);
        }
        else
        {
          if (this.eII >= 0) {
            break label250;
          }
          y.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.eII);
        }
      }
      y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
      Object localObject = this.axb[this.eII];
      if (localObject == null) {
        throw new RuntimeException("encoderOutputBuffer " + this.eII + " was null");
      }
      this.frameCount += 1;
      if ((this.eIJ.flags & 0x2) != 0) {
        y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.eIJ.size), Boolean.valueOf(false) });
      }
      if (this.eIJ.size != 0)
      {
        ((ByteBuffer)localObject).position(this.eIJ.offset);
        ((ByteBuffer)localObject).limit(this.eIJ.offset + this.eIJ.size);
        MediaCodec.BufferInfo localBufferInfo = this.eIJ;
        if ((localObject != null) && (localBufferInfo != null) && (this.mle != null)) {
          this.mle.a(this.eIz, (ByteBuffer)localObject, localBufferInfo.size);
        }
      }
      this.eIF.releaseOutputBuffer(this.eII, false);
    } while ((this.eIJ.flags & 0x4) == 0);
    if (!this.bCf)
    {
      y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
      return;
    }
    y.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.eIE) });
    try
    {
      this.eIF.stop();
      this.eIF.release();
      this.eIF = null;
      this.bSr = false;
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void b(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    try
    {
      if (!this.bSr)
      {
        y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
        return;
      }
      if (this.eIF == null)
      {
        y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      k.biZ();
      y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
      y.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", paramArrayOfByte, "", new Object[0]);
      return;
    }
    long l1 = bk.UZ();
    this.inputBuffers = this.eIF.getInputBuffers();
    this.axb = this.eIF.getOutputBuffers();
    int i = 0;
    while (this.eIF != null)
    {
      int j = this.eIF.dequeueInputBuffer(600L);
      this.eIH = j;
      if ((j >= 0) || (i >= 10)) {
        break;
      }
      y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
      SS();
      i += 1;
    }
    if (this.eIF == null)
    {
      y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
      return;
    }
    y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.eIH) });
    long l2 = bk.UZ();
    if (this.eIH >= 0) {
      if ((this.bSr) && (!paramBoolean) && (paramArrayOfByte != null))
      {
        y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: " + paramLong);
        ByteBuffer localByteBuffer = this.inputBuffers[this.eIH];
        localByteBuffer.clear();
        localByteBuffer.put(paramArrayOfByte);
        localByteBuffer.position(0);
        this.eIF.queueInputBuffer(this.eIH, 0, paramArrayOfByte.length, paramLong, 0);
      }
    }
    for (;;)
    {
      SS();
      y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bk.cp(l1)), Long.valueOf(bk.cp(l2)) });
      return;
      y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
      this.eIK = true;
      this.eIF.queueInputBuffer(this.eIH, 0, 0, paramLong, 4);
      this.bCf = true;
      continue;
      y.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
    }
  }
  
  public final int jv(int paramInt)
  {
    try
    {
      this.eIz = paramInt;
      paramInt = SR();
      return paramInt;
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = SR();
        return paramInt;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        k.biY();
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