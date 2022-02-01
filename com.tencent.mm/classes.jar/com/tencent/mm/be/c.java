package com.tencent.mm.be;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class c
{
  private int bitrate;
  protected int bufId;
  private MediaCodec.BufferInfo bufferInfo;
  private ByteBuffer[] cJm;
  private ByteBuffer[] cWS;
  private int colorFormat;
  private int frameCount;
  private int frameRate;
  private boolean hvE;
  boolean isStart;
  protected MediaFormat mediaFormat;
  private int nxO;
  private int nxP;
  private int nxQ;
  protected aa nzs;
  a pci;
  private int pcj;
  private int pck;
  private int pcl;
  private boolean pcm;
  private byte[] pcn;
  private int pco;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127067);
    this.bufId = -1;
    this.pck = -1;
    this.pcl = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.hvE = false;
    this.pcm = false;
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.nxO = paramInt1;
    this.nxP = paramInt2;
    this.frameRate = paramInt4;
    this.nxQ = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt3;
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.nxO), Integer.valueOf(this.nxP), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(127067);
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
          Log.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
          AppMethodBeat.o(127073);
          return;
        }
        if (this.nzs == null)
        {
          Log.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
          return;
        }
        long l1 = Util.currentTicks();
        this.cWS = this.nzs.aPD();
        this.cJm = this.nzs.aPE();
        int i = 0;
        if (this.nzs != null)
        {
          int j = this.nzs.dequeueInputBuffer(600L);
          this.pck = j;
          if ((j < 0) && (i < 10))
          {
            Log.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
            bpk();
            i += 1;
            continue;
          }
        }
        if (this.nzs == null)
        {
          Log.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
          AppMethodBeat.o(127073);
          return;
        }
        Log.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.pck) });
        long l2 = Util.currentTicks();
        if (this.pck >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            Log.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.cWS[this.pck];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.nzs.a(this.pck, paramArrayOfByte.length, paramLong, 0);
            bpk();
            Log.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Long.valueOf(Util.ticksToNow(l2)) });
            AppMethodBeat.o(127073);
            return;
          }
          Log.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
          this.pcm = true;
          this.nzs.a(this.pck, 0, paramLong, 4);
          this.hvE = true;
          continue;
        }
        Log.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        Log.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(127073);
        return;
      }
    }
  }
  
  private int bOO()
  {
    AppMethodBeat.i(127069);
    long l = Util.currentTicks();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      Log.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
      AppMethodBeat.o(127069);
      return -1;
    }
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(Util.ticksToNow(l)) });
    l = Util.currentTicks();
    this.colorFormat = selectColorFormat(localMediaCodecInfo, "video/avc");
    l = Util.ticksToNow(l);
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.colorFormat), Long.valueOf(l) });
    if (this.colorFormat == 19) {}
    for (this.pco = 2;; this.pco = 1)
    {
      l = Util.currentTicks();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.nxO, this.nxP);
      Log.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.colorFormat);
      this.mediaFormat.setInteger("i-frame-interval", this.nxQ);
      Log.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.nzs = aa.Dx(localMediaCodecInfo.getName());
      this.nzs.a(this.mediaFormat, null, 1);
      this.nzs.start();
      AppMethodBeat.o(127069);
      return 0;
    }
  }
  
  private void bpk()
  {
    AppMethodBeat.i(127074);
    this.pcl = this.nzs.dequeueOutputBuffer(this.bufferInfo, 600L);
    Log.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.pcl);
    if (this.pcl == -1)
    {
      Log.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.pcm) });
      if (!this.pcm) {}
    }
    label253:
    do
    {
      for (;;)
      {
        this.pcl = this.nzs.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.pcl <= 0) {
          Log.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.pcl) });
        }
        if ((this.pcl >= 0) || (this.pcm)) {
          break;
        }
        AppMethodBeat.o(127074);
        return;
        if (this.pcl == -3)
        {
          this.cJm = this.nzs.aPE();
          Log.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
        }
        else if (this.pcl == -2)
        {
          Log.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.nzs.getOutputFormat())));
        }
        else
        {
          if (this.pcl >= 0) {
            break label253;
          }
          Log.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.pcl);
        }
      }
      Log.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
      Object localObject = this.cJm[this.pcl];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.pcl + " was null");
        AppMethodBeat.o(127074);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        Log.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.nzs.releaseOutputBuffer(this.pcl, false);
    } while ((this.bufferInfo.flags & 0x4) == 0);
    if (!this.hvE)
    {
      Log.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(127074);
      return;
    }
    Log.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.pcj) });
    try
    {
      this.nzs.stop();
      this.nzs.release();
      this.nzs = null;
      this.isStart = false;
      AppMethodBeat.o(127074);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(127074);
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(127066);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.pci != null)) {
      this.pci.a(this.bufId, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(127066);
  }
  
  private static boolean isRecognizedFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
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
  
  private static int selectColorFormat(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(127075);
    long l = Util.currentTicks();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      Log.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (isRecognizedFormat(k))
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
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(127075);
    return i;
  }
  
  private void trySetBitRateMode(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(127071);
    try
    {
      if (!d.rb(21)) {
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
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(127071);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(127071);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      Log.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(127071);
      return;
    }
    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(127071);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(127070);
    if (d.rb(23)) {}
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
              Log.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            Log.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
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
        Log.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
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
      if ((paramInt3 == this.nxO) && (paramInt4 == this.nxP))
      {
        paramBoolean = false;
        Log.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.nxO), Integer.valueOf(this.nxP), Long.valueOf(paramLong), Integer.valueOf(paramInt5), Integer.valueOf(this.pco), Integer.valueOf(paramArrayOfByte.length) });
        if (this.pcn == null) {
          this.pcn = new byte[this.nxO * this.nxP * 3 >> 1];
        }
        if (this.pcn.length != paramArrayOfByte.length) {
          this.pcn = new byte[paramArrayOfByte.length];
        }
        if ((this.colorFormat != 19) || (paramBoolean)) {
          break label250;
        }
        System.arraycopy(paramArrayOfByte, 0, this.pcn, 0, paramArrayOfByte.length);
      }
      for (;;)
      {
        this.pcj += 1;
        b(this.pcn, false, paramLong);
        AppMethodBeat.o(127072);
        return;
        paramBoolean = true;
        break;
        label250:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(paramArrayOfByte, paramInt5, this.pcn, this.pco, paramInt1, paramInt2, paramInt3, paramInt4, this.nxO, this.nxP);
      }
    }
    b(this.pcn, true, paramLong);
    AppMethodBeat.o(127072);
  }
  
  public final int xf(int paramInt)
  {
    AppMethodBeat.i(127068);
    try
    {
      this.bufId = paramInt;
      paramInt = bOO();
      AppMethodBeat.o(127068);
      return paramInt;
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = bOO();
        AppMethodBeat.o(127068);
        return paramInt;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.c
 * JD-Core Version:    0.7.0.1
 */