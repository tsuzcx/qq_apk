package com.tencent.mm.bi;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

public final class c
{
  private ByteBuffer[] axb;
  private boolean bCf = false;
  boolean bSr = false;
  private int bitrate = 0;
  c.a eIA;
  private int eIB;
  private int eIC;
  private int eID;
  private int eIE;
  protected MediaCodec eIF;
  protected MediaFormat eIG;
  private int eIH = -1;
  private int eII = -1;
  private MediaCodec.BufferInfo eIJ;
  private boolean eIK = false;
  private int eIL;
  private int eIM;
  private byte[] eIN;
  private int eIO;
  protected int eIz = -1;
  private int frameCount;
  private ByteBuffer[] inputBuffers;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.eIB = paramInt1;
    this.eIC = paramInt2;
    this.eIM = paramInt4;
    this.eIL = 1;
    this.eIJ = new MediaCodec.BufferInfo();
    this.bitrate = paramInt3;
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.eIB), Integer.valueOf(this.eIC), Integer.valueOf(paramInt3) });
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
        break label92;
      }
      y.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
      return -1;
      j += 1;
      break label39;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label92:
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bk.cp(l1)) });
    l1 = bk.UZ();
    i = 0;
    long l2 = bk.UZ();
    Object localObject1 = localMediaCodecInfo.getCapabilitiesForType("video/avc");
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bk.cp(l2)) });
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats.length) });
    j = 0;
    int n;
    int m;
    if (j < ((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats.length)
    {
      k = localObject1.colorFormats[j];
      y.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
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
              break label306;
            }
            m = k;
          }
        }
        j += 1;
        i = m;
        break;
      }
    }
    label306:
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", new Object[] { localMediaCodecInfo.getName(), Integer.valueOf(i) });
    this.eID = i;
    l1 = bk.cp(l1);
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.eID), Long.valueOf(l1) });
    if (this.eID == 19)
    {
      this.eIO = 2;
      l1 = bk.UZ();
      this.eIG = MediaFormat.createVideoFormat("video/avc", this.eIB, this.eIC);
      y.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bk.cp(l1)) });
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
          y.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
          switch (m)
          {
          }
        }
        catch (Exception localException1)
        {
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
          y.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
          continue;
          if (!localException1.isBitrateModeSupported(0)) {
            continue;
          }
          y.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
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
      y.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
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
              break label909;
            }
            y.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
            this.eIG.setInteger("bitrate-mode", 2);
          }
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
        continue;
        y.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
      }
    }
    this.eIG.setInteger("bitrate", this.bitrate);
    this.eIG.setInteger("frame-rate", this.eIM);
    this.eIG.setInteger("color-format", this.eID);
    this.eIG.setInteger("i-frame-interval", this.eIL);
    y.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", new Object[] { this.eIG });
    this.eIF = MediaCodec.createByCodecName(localMediaCodecInfo.getName());
    this.eIF.configure(this.eIG, null, null, 1);
    this.eIF.start();
    return 0;
  }
  
  private void SS()
  {
    this.eII = this.eIF.dequeueOutputBuffer(this.eIJ, 600L);
    y.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.eII);
    if (this.eII == -1)
    {
      y.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.eIK) });
      if (!this.eIK) {}
    }
    label250:
    do
    {
      for (;;)
      {
        this.eII = this.eIF.dequeueOutputBuffer(this.eIJ, 600L);
        if (this.eII <= 0) {
          y.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.eII) });
        }
        if ((this.eII >= 0) || (this.eIK)) {
          break;
        }
        return;
        if (this.eII == -3)
        {
          this.axb = this.eIF.getOutputBuffers();
          y.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
        }
        else if (this.eII == -2)
        {
          localObject = this.eIF.getOutputFormat();
          y.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: " + localObject);
        }
        else
        {
          if (this.eII >= 0) {
            break label250;
          }
          y.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.eII);
        }
      }
      y.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
      Object localObject = this.axb[this.eII];
      if (localObject == null) {
        throw new RuntimeException("encoderOutputBuffer " + this.eII + " was null");
      }
      this.frameCount += 1;
      if ((this.eIJ.flags & 0x2) != 0) {
        y.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.eIJ.size), Boolean.valueOf(false) });
      }
      if (this.eIJ.size != 0)
      {
        ((ByteBuffer)localObject).position(this.eIJ.offset);
        ((ByteBuffer)localObject).limit(this.eIJ.offset + this.eIJ.size);
        MediaCodec.BufferInfo localBufferInfo = this.eIJ;
        if ((localObject != null) && (localBufferInfo != null) && (this.eIA != null)) {
          this.eIA.a(this.eIz, (ByteBuffer)localObject, localBufferInfo.size);
        }
      }
      this.eIF.releaseOutputBuffer(this.eII, false);
    } while ((this.eIJ.flags & 0x4) == 0);
    if (!this.bCf)
    {
      y.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
      return;
    }
    y.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.eIE) });
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
      y.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  private void b(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    try
    {
      if (!this.bSr)
      {
        y.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
        return;
      }
      if (this.eIF == null)
      {
        y.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
      y.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", paramArrayOfByte, "", new Object[0]);
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
      y.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
      SS();
      i += 1;
    }
    if (this.eIF == null)
    {
      y.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
      return;
    }
    y.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.eIH) });
    long l2 = bk.UZ();
    if (this.eIH >= 0) {
      if ((this.bSr) && (!paramBoolean) && (paramArrayOfByte != null))
      {
        y.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: " + paramLong);
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
      y.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bk.cp(l1)), Long.valueOf(bk.cp(l2)) });
      return;
      y.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
      this.eIK = true;
      this.eIF.queueInputBuffer(this.eIH, 0, 0, paramLong, 4);
      this.bCf = true;
      continue;
      y.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, int paramInt5)
  {
    if ((!paramBoolean) && (paramArrayOfByte != null))
    {
      if ((paramInt3 == this.eIB) && (paramInt4 == this.eIC))
      {
        paramBoolean = false;
        y.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.eIB), Integer.valueOf(this.eIC), Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(this.eIO) });
        if (this.eIN == null) {
          this.eIN = new byte[this.eIB * this.eIC * 3 >> 1];
        }
        if ((this.eID != 19) || (paramBoolean)) {
          break label211;
        }
        System.arraycopy(paramArrayOfByte, 0, this.eIN, 0, paramArrayOfByte.length);
      }
      for (;;)
      {
        this.eIE += 1;
        b(this.eIN, false, paramLong);
        return;
        paramBoolean = true;
        break;
        label211:
        MP4MuxerJNI.yuv420pTo420XXAndScale(paramArrayOfByte, paramInt5, this.eIN, this.eIO, paramInt1, paramInt2, paramInt3, paramInt4, this.eIB, this.eIC);
      }
    }
    b(this.eIN, true, paramLong);
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
      y.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = SR();
        return paramInt;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bi.c
 * JD-Core Version:    0.7.0.1
 */