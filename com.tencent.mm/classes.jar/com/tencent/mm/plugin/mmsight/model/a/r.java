package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r
  implements f
{
  private ByteBuffer[] axb;
  boolean bCf = false;
  boolean bSr = false;
  private int bitrate = 0;
  private long dEq = 0L;
  int eIB;
  int eIC;
  int eID;
  protected MediaCodec eIF;
  protected MediaFormat eIG;
  private int eIH = -1;
  private int eII = -1;
  private MediaCodec.BufferInfo eIJ;
  private boolean eIK = false;
  private int eIL;
  private int eIM;
  int frameCount;
  private int fvY;
  private int fvZ;
  private ByteBuffer[] inputBuffers;
  boolean mhL = false;
  private o miU;
  int mkr = -1;
  int mks = -1;
  int mkt = -1;
  int mku = -1;
  a mkv = new a(this.mkx);
  f.a mkw;
  private a.a mkx = new r.1(this);
  private long startTime = 0L;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    this.fvY = paramInt1;
    this.fvZ = paramInt2;
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.eIB = paramInt3;
    this.eIC = paramInt4;
    this.eIM = paramInt7;
    this.eIL = paramInt6;
    this.miU = null;
    this.eIJ = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.mhL = paramBoolean;
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.fvY), Integer.valueOf(this.fvZ), Integer.valueOf(this.eIB), Integer.valueOf(this.eIC), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
  }
  
  private int SR()
  {
    long l1 = bk.UZ();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    Object localObject1;
    int j;
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
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      k.biY();
      return -1;
      j += 1;
      break label39;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label95:
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { localMediaCodecInfo.getName(), Long.valueOf(bk.cp(l1)) });
    l1 = bk.UZ();
    if (CaptureMMProxy.getInstance() != null)
    {
      i = CaptureMMProxy.getInstance().getInt(ac.a.uua, -1);
      y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        this.eID = i;
        l1 = bk.cp(l1);
        if ((this.eID > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
          CaptureMMProxy.getInstance().set(ac.a.uua, Integer.valueOf(this.eID));
        }
        y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.eID), Long.valueOf(l1) });
        l1 = bk.UZ();
        y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.mkr) });
        if (!this.mhL) {
          break label789;
        }
        if ((this.mkr != 180) && (this.mkr != 0)) {
          break label773;
        }
        i = this.eIB;
        label304:
        if ((this.mkr != 180) && (this.mkr != 0)) {
          break label781;
        }
        j = this.eIC;
        label326:
        this.eIG = MediaFormat.createVideoFormat("video/avc", i, j);
        label337:
        y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bk.cp(l1)) });
        if ((localMediaCodecInfo != null) && (!d.gF(23))) {
          break label949;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localMediaCodecInfo.getCapabilitiesForType("video/avc");
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
        int m;
        int n;
        if (localObject1 != null)
        {
          localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels;
          if (localObject1 != null)
          {
            localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            localCodecProfileLevel.level = 0;
            localCodecProfileLevel.profile = 0;
            k = localObject1.length;
            i = 0;
            if (i < k)
            {
              Object localObject2 = localObject1[i];
              m = localObject2.profile;
              n = localObject2.level;
              y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
            }
          }
        }
        switch (m)
        {
        case 1: 
          if ((j != 0) && (m >= localCodecProfileLevel.profile) && (n >= localCodecProfileLevel.level))
          {
            localCodecProfileLevel.profile = m;
            localCodecProfileLevel.level = n;
          }
          i += 1;
          continue;
          long l2 = bk.UZ();
          localObject1 = localMediaCodecInfo.getCapabilitiesForType("video/avc");
          y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bk.cp(l2)) });
          y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats.length) });
          i = 0;
          j = 0;
          if (j < ((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats.length)
          {
            n = localObject1.colorFormats[j];
            y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
            switch (n)
            {
            default: 
              m = 0;
              k = i;
              if (m != 0) {
                if (n <= i)
                {
                  k = i;
                  if (n != 21) {}
                }
                else
                {
                  k = n;
                }
              }
              j += 1;
              i = k;
              break;
            case 19: 
            case 21: 
            case 2130706688: 
              m = 1;
              break;
            }
          }
          y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { localMediaCodecInfo.getName(), Integer.valueOf(i) });
          break;
          i = this.eIC;
          break label304;
          j = this.eIB;
          break label326;
          if ((this.mkr == 180) || (this.mkr == 0))
          {
            i = this.eIC;
            if ((this.mkr != 180) && (this.mkr != 0)) {
              continue;
            }
            j = this.eIB;
            this.eIG = MediaFormat.createVideoFormat("video/avc", i, j);
            break label337;
          }
          i = this.eIB;
          continue;
          j = this.eIC;
          break;
        case 2: 
        case 8: 
          label773:
          label781:
          label789:
          j = 1;
          continue;
          y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
          if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
          {
            this.eIG.setInteger("profile", localCodecProfileLevel.profile);
            this.eIG.setInteger("level", 256);
          }
          label949:
          i = -1;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (d.gF(21)) {
            this.eIG.setInteger("bitrate-mode", 1);
          }
          this.eIG.setInteger("bitrate", this.bitrate);
          this.eIG.setInteger("frame-rate", this.eIM);
          this.eIG.setInteger("color-format", this.eID);
          this.eIG.setInteger("i-frame-interval", this.eIL);
          y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.eIG });
          this.eIF = MediaCodec.createByCodecName(localMediaCodecInfo.getName());
          this.eIF.configure(this.eIG, null, null, 1);
          this.eIF.start();
          return 0;
          localException1 = localException1;
          y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
          continue;
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
        }
      }
      break;
      j = 0;
    }
  }
  
  private void SS()
  {
    this.eII = this.eIF.dequeueOutputBuffer(this.eIJ, 100L);
    y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.eII);
    do
    {
      if (this.eII != -1) {
        break label142;
      }
      y.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.eIK) });
      if (!this.eIK) {
        break;
      }
      this.eII = this.eIF.dequeueOutputBuffer(this.eIJ, 100L);
      if (this.eII <= 0) {
        y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.eII) });
      }
    } while ((this.eII >= 0) || (this.eIK));
    for (;;)
    {
      return;
      label142:
      if (this.eII == -3)
      {
        this.axb = this.eIF.getOutputBuffers();
        y.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.eII == -2)
      {
        localObject = this.eIF.getOutputFormat();
        y.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: " + localObject);
        if (this.miU == null) {
          break;
        }
        this.miU.c((MediaFormat)localObject);
        break;
      }
      if (this.eII < 0)
      {
        y.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.eII);
        break;
      }
      y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.axb[this.eII];
      if (localObject == null) {
        throw new RuntimeException("encoderOutputBuffer " + this.eII + " was null");
      }
      this.frameCount += 1;
      if ((this.eIJ.flags & 0x2) != 0) {
        y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.eIJ.size), Boolean.valueOf(false) });
      }
      if (this.eIJ.size != 0)
      {
        if ((this.miU != null) && (!this.miU.bSr))
        {
          MediaFormat localMediaFormat = this.eIF.getOutputFormat();
          this.miU.c(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.eIJ.offset);
        ((ByteBuffer)localObject).limit(this.eIJ.offset + this.eIJ.size);
        e((ByteBuffer)localObject, this.eIJ);
      }
      this.eIF.releaseOutputBuffer(this.eII, false);
      if ((this.eIJ.flags & 0x4) == 0) {
        break;
      }
      if (!this.bCf)
      {
        y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        return;
      }
      y.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      try
      {
        this.eIF.stop();
        this.eIF.release();
        this.mkv.stop();
        this.eIF = null;
        this.bSr = false;
        if (this.mkw != null)
        {
          this.mkw.bjy();
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void a(f.a parama)
  {
    this.mkw = parama;
    this.bCf = true;
    boolean bool = this.mkv.bjg();
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.bSr), this.mkw, Boolean.valueOf(bool) });
    if (bool) {
      bjI();
    }
  }
  
  public final long bjH()
  {
    return System.currentTimeMillis() - this.startTime;
  }
  
  final void bjI()
  {
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s", new Object[] { bk.csb().toString() });
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "isStart：" + this.bSr);
    try
    {
      if (this.bSr) {
        ai.l(new r.2(this), 500L);
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public void clear()
  {
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    try
    {
      if (this.eIF != null)
      {
        y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.eIF.stop();
        this.eIF.release();
        this.eIF = null;
        this.bSr = false;
      }
      if (this.mkv != null) {
        this.mkv.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      if (!this.bSr)
      {
        y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
        return;
      }
      if (this.eIF == null)
      {
        y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      k.biZ();
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
      y.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
      return;
    }
    if ((this.miU != null) && (this.miU.mkp <= 0L)) {
      this.miU.mkp = System.nanoTime();
    }
    long l2 = bk.UZ();
    this.inputBuffers = this.eIF.getInputBuffers();
    this.axb = this.eIF.getOutputBuffers();
    int i = this.eIF.dequeueInputBuffer(100L);
    this.eIH = i;
    if (i < 0)
    {
      y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
      SS();
    }
    if (this.eIF == null)
    {
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
      return;
    }
    y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.eIH) });
    long l3 = bk.UZ();
    long l1;
    if (this.eIH >= 0)
    {
      long l4 = System.nanoTime();
      long l5 = paramArrayOfByte.length / 1600000 / 1000000000;
      if (this.miU != null)
      {
        l1 = this.miU.mkp;
        l1 = (l4 - l5 - l1) / 1000L;
        y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: " + l1);
        ByteBuffer localByteBuffer = this.inputBuffers[this.eIH];
        localByteBuffer.clear();
        localByteBuffer.put(paramArrayOfByte);
        localByteBuffer.position(0);
        if ((!this.bSr) || (paramBoolean)) {
          break label385;
        }
        this.eIF.queueInputBuffer(this.eIH, 0, paramArrayOfByte.length, l1, 0);
      }
    }
    for (;;)
    {
      SS();
      y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(bk.cp(l2)), Long.valueOf(bk.cp(l3)) });
      return;
      l1 = this.startTime;
      break;
      label385:
      y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
      this.eIK = true;
      this.eIF.queueInputBuffer(this.eIH, 0, paramArrayOfByte.length, l1, 4);
      continue;
      y.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
    }
  }
  
  public int dg(int paramInt1, int paramInt2)
  {
    try
    {
      this.mkr = paramInt2;
      paramInt1 = SR();
      return paramInt1;
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(ac.a.uua, Integer.valueOf(-1));
        }
        paramInt1 = SR();
        return paramInt1;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        k.biY();
      }
    }
    return -1;
  }
  
  protected void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if ((this.miU != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.miU.g(paramByteBuffer, paramBufferInfo);
    }
  }
  
  public final void start()
  {
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.bSr = true;
    y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.bSr);
    this.startTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r
 * JD-Core Version:    0.7.0.1
 */