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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

public final class f
{
  private ByteBuffer[] bfT;
  private int bitrate;
  private ByteBuffer[] btA;
  protected int bufId;
  private MediaCodec.BufferInfo bufferInfo;
  private boolean dhz;
  int frameCount;
  private int frameRate;
  int hkE;
  private int hkF;
  protected z hlX;
  boolean isStart;
  int ixT;
  private int ixU;
  private int ixV;
  private boolean ixW;
  byte[] ixX;
  int ixY;
  private int jxn;
  private int jxo;
  protected MediaFormat mediaFormat;
  int targetHeight;
  int targetWidth;
  a wde;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89629);
    this.bufId = -1;
    this.ixU = -1;
    this.ixV = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.dhz = false;
    this.ixW = false;
    this.jxn = paramInt1;
    this.jxo = paramInt2;
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.frameRate = paramInt6;
    this.hkF = 1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[] { Integer.valueOf(this.jxn), Integer.valueOf(this.jxo), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(89629);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(89636);
    long l = bu.HQ();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int j = 0;
    int m;
    for (int i = 0; j < paramString.colorFormats.length; i = m)
    {
      int k = paramString.colorFormats[j];
      ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(k) });
      m = i;
      if (qr(k))
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
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(i) });
    AppMethodBeat.o(89636);
    return i;
  }
  
  private int aNH()
  {
    AppMethodBeat.i(89631);
    long l = bu.HQ();
    MediaCodecInfo localMediaCodecInfo = selectCodec("video/avc");
    if (localMediaCodecInfo == null)
    {
      ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
      l.auW();
      AppMethodBeat.o(89631);
      return -1;
    }
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bu.aO(l)) });
    l = bu.HQ();
    this.hkE = a(localMediaCodecInfo, "video/avc");
    l = bu.aO(l);
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.hkE), Long.valueOf(l) });
    if (this.hkE == 19) {}
    for (this.ixY = 2;; this.ixY = 1)
    {
      l = bu.HQ();
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.targetWidth, this.targetHeight);
      ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      if (localMediaCodecInfo != null)
      {
        trySetProfile(localMediaCodecInfo);
        trySetBitRateMode(localMediaCodecInfo);
      }
      this.mediaFormat.setInteger("bitrate", this.bitrate);
      this.mediaFormat.setInteger("frame-rate", this.frameRate);
      this.mediaFormat.setInteger("color-format", this.hkE);
      this.mediaFormat.setInteger("i-frame-interval", this.hkF);
      ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[] { this.mediaFormat });
      this.hlX = z.vK(localMediaCodecInfo.getName());
      this.hlX.a(this.mediaFormat, null, 1);
      this.hlX.start();
      AppMethodBeat.o(89631);
      return 0;
    }
  }
  
  private void atM()
  {
    AppMethodBeat.i(89635);
    this.ixV = this.hlX.dequeueOutputBuffer(this.bufferInfo, 600L);
    ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.ixV);
    if (this.ixV == -1)
    {
      ae.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ixW) });
      if (!this.ixW) {}
    }
    label249:
    do
    {
      for (;;)
      {
        this.ixV = this.hlX.dequeueOutputBuffer(this.bufferInfo, 600L);
        if (this.ixV <= 0) {
          ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ixV) });
        }
        if ((this.ixV >= 0) || (this.ixW)) {
          break;
        }
        AppMethodBeat.o(89635);
        return;
        if (this.ixV == -3)
        {
          this.bfT = this.hlX.getOutputBuffers();
          ae.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
        }
        else if (this.ixV == -2)
        {
          ae.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.hlX.getOutputFormat())));
        }
        else
        {
          if (this.ixV >= 0) {
            break label249;
          }
          ae.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ixV);
        }
      }
      ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
      Object localObject = this.bfT[this.ixV];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ixV + " was null");
        AppMethodBeat.o(89635);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
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
      ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
      AppMethodBeat.o(89635);
      return;
    }
    ae.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[] { Integer.valueOf(this.frameCount), Integer.valueOf(this.ixT) });
    try
    {
      this.hlX.stop();
      this.hlX.release();
      this.hlX = null;
      this.isStart = false;
      AppMethodBeat.o(89635);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89635);
    }
  }
  
  private void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89628);
    if ((paramByteBuffer != null) && (paramBufferInfo != null) && (this.wde != null)) {
      this.wde.a(this.bufId, paramByteBuffer, paramBufferInfo.size);
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
        ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 2);
        AppMethodBeat.o(89633);
        return;
      }
      if (paramMediaCodecInfo.isBitrateModeSupported(0))
      {
        ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
        this.mediaFormat.setInteger("bitrate-mode", 0);
        AppMethodBeat.o(89633);
        return;
      }
    }
    catch (Exception paramMediaCodecInfo)
    {
      ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      AppMethodBeat.o(89633);
      return;
    }
    ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
    label137:
    AppMethodBeat.o(89633);
  }
  
  private void trySetProfile(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(89632);
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
              ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              if ((!isRecognizedProfile(k)) || (k < localCodecProfileLevel.profile) || (m < localCodecProfileLevel.level)) {
                break label272;
              }
              localCodecProfileLevel.profile = k;
              localCodecProfileLevel.level = m;
              break label272;
            }
            ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
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
        ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
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
          ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
          AppMethodBeat.o(89634);
          return;
        }
        if (this.hlX == null)
        {
          ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
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
            ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
            atM();
            i += 1;
            continue;
          }
        }
        if (this.hlX == null)
        {
          ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
          AppMethodBeat.o(89634);
          return;
        }
        ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.ixU) });
        long l2 = bu.HQ();
        if (this.ixU >= 0)
        {
          if ((this.isStart) && (!paramBoolean) && (paramArrayOfByte != null))
          {
            ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(paramLong)));
            ByteBuffer localByteBuffer = this.btA[this.ixU];
            localByteBuffer.clear();
            localByteBuffer.put(paramArrayOfByte);
            localByteBuffer.position(0);
            this.hlX.a(this.ixU, paramArrayOfByte.length, paramLong, 0);
            atM();
            ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[] { Long.valueOf(bu.aO(l1)), Long.valueOf(bu.aO(l2)) });
            AppMethodBeat.o(89634);
            return;
          }
          ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
          this.ixW = true;
          this.hlX.a(this.ixU, 0, paramLong, 4);
          this.dhz = true;
          continue;
        }
        ae.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.auX();
        ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ae.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89634);
        return;
      }
    }
  }
  
  public final int qq(int paramInt)
  {
    AppMethodBeat.i(89630);
    try
    {
      this.bufId = paramInt;
      paramInt = aNH();
      AppMethodBeat.o(89630);
      return paramInt;
    }
    catch (Exception localException1)
    {
      ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        paramInt = aNH();
        AppMethodBeat.o(89630);
        return paramInt;
      }
      catch (Exception localException2)
      {
        ae.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.auW();
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