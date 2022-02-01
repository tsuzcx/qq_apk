package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class s
  implements f
{
  private ByteBuffer[] bfT;
  private int bitrate;
  private ByteBuffer[] btA;
  private MediaCodec.BufferInfo bufferInfo;
  boolean dhz;
  int frameCount;
  private int frameRate;
  private long gyu;
  int hkE;
  private int hkF;
  protected z hlX;
  private final Object hmj;
  boolean hyP;
  private boolean isStart;
  private int ixU;
  private int ixV;
  private boolean ixW;
  private int jxn;
  private int jxo;
  protected MediaFormat mediaFormat;
  private long startTime;
  int targetHeight;
  int targetWidth;
  private p wbL;
  private boolean wbN;
  private boolean wbP;
  int wcA;
  int wcB;
  int wcC;
  int wcD;
  a wcE;
  f.a wcF;
  private a.a wcG;
  private long wca;
  
  public s(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.gyu = 0L;
    this.ixU = -1;
    this.ixV = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.dhz = false;
    this.ixW = false;
    this.wcA = -1;
    this.wcB = -1;
    this.wcC = -1;
    this.wcD = -1;
    this.hyP = false;
    this.hmj = new Object();
    this.wbN = false;
    this.wbP = true;
    this.wca = 0L;
    this.wcG = new a.a()
    {
      public final void output(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = bu.HQ();
        boolean bool2 = s.this.wcE.dqf();
        s locals = s.this;
        if ((bool2) && (s.this.dhz)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          locals.d(paramAnonymousArrayOfByte, bool1);
          com.tencent.mm.bk.b.ixQ.k(paramAnonymousArrayOfByte);
          ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(s.this.dhz), Boolean.valueOf(bool2), Long.valueOf(bu.aO(l)) });
          if ((bool2) && (s.this.dhz)) {
            s.this.dqu();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.wcE = new a(this.wcG);
    this.jxn = paramInt1;
    this.jxo = paramInt2;
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.frameRate = paramInt7;
    this.hkF = paramInt6;
    this.wbL = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.hyP = paramBoolean;
    this.wbP = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFy, true);
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.jxn), Integer.valueOf(this.jxo), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private int aNH()
  {
    AppMethodBeat.i(89591);
    long l1 = bu.HQ();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      ??? = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)???).isEncoder())
      {
        localObject2 = ((MediaCodecInfo)???).getSupportedTypes();
        j = 0;
        label44:
        if (j < localObject2.length) {
          if (!localObject2[j].equalsIgnoreCase("video/avc")) {}
        }
      }
    }
    for (;;)
    {
      if (??? != null) {
        break label105;
      }
      ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      l.auW();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label44;
      i += 1;
      break;
      ??? = null;
    }
    label105:
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(bu.aO(l1)) });
    l1 = bu.HQ();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(am.a.IRo, -1);
    }
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.hkE = i;
      l1 = bu.aO(l1);
      if ((this.hkE > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(am.a.IRo, Integer.valueOf(this.hkE));
      }
      ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.hkE), Long.valueOf(l1) });
      l1 = bu.HQ();
      ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.wcA) });
      if (!this.hyP) {
        break label805;
      }
      if ((this.wcA != 180) && (this.wcA != 0)) {
        break label789;
      }
      i = this.targetWidth;
      label319:
      if ((this.wcA != 180) && (this.wcA != 0)) {
        break label797;
      }
      j = this.targetHeight;
      label341:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label352:
      ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bu.aO(l1)) });
      if ((??? != null) && (!d.lA(23))) {
        break label965;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels;
        if (localObject2 == null) {
          continue;
        }
        localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        localCodecProfileLevel.level = 0;
        localCodecProfileLevel.profile = 0;
        k = localObject2.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        Object localObject4 = localObject2[i];
        m = localObject4.profile;
        n = localObject4.level;
        ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
        switch (m)
        {
        }
      }
      catch (Exception localException1)
      {
        try
        {
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
          int m;
          int n;
          long l2;
          label789:
          label797:
          label805:
          if (d.lA(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.hkE);
          this.mediaFormat.setInteger("i-frame-interval", this.hkF);
          ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.hlX = z.vK(((MediaCodecInfo)???).getName());
          this.hlX.a(this.mediaFormat, null, 1);
          this.hlX.start();
          if (this.wbP)
          {
            AppMethodBeat.o(89591);
            return 0;
            localException1 = localException1;
            ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
            continue;
          }
        }
        catch (Exception localException2)
        {
          ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
          synchronized (this.hmj)
          {
            this.wbN = false;
            AppMethodBeat.o(89591);
            return 0;
          }
        }
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
      i = 0;
      l2 = bu.HQ();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bu.aO(l2)) });
      ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length) });
      j = 0;
      if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length)
      {
        n = localObject2.colorFormats[j];
        ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
      else
      {
        ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { ((MediaCodecInfo)???).getName(), Integer.valueOf(i) });
        break;
        i = this.targetHeight;
        break label319;
        j = this.targetWidth;
        break label341;
        if ((this.wcA == 180) || (this.wcA == 0))
        {
          i = this.targetHeight;
          if ((this.wcA != 180) && (this.wcA != 0)) {
            continue;
          }
          j = this.targetWidth;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label352;
        }
        i = this.targetWidth;
        continue;
        j = this.targetHeight;
        continue;
        j = 1;
      }
    }
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void atH()
  {
    AppMethodBeat.i(89599);
    if (this.wbP)
    {
      dqv();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.hmj)
    {
      if ((this.wbN) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.wbN = true;
      dqv();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private void atM()
  {
    AppMethodBeat.i(89593);
    this.ixV = this.hlX.dequeueOutputBuffer(this.bufferInfo, 100L);
    ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.ixV);
    do
    {
      if (this.ixV != -1) {
        break label154;
      }
      ae.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ixW) });
      if (!this.ixW) {
        break;
      }
      this.ixV = this.hlX.dequeueOutputBuffer(this.bufferInfo, 100L);
      if (this.ixV <= 0) {
        ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ixV) });
      }
    } while ((this.ixV >= 0) || (this.ixW));
    label154:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.ixV == -3)
      {
        this.bfT = this.hlX.getOutputBuffers();
        ae.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.ixV == -2)
      {
        localObject = this.hlX.getOutputFormat();
        ae.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localObject)));
        if (this.wbL == null) {
          break;
        }
        this.wbL.g((MediaFormat)localObject);
        break;
      }
      if (this.ixV < 0)
      {
        ae.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ixV);
        break;
      }
      ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.bfT[this.ixV];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ixV + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        if ((this.wbL != null) && (!this.wbL.dqt()))
        {
          MediaFormat localMediaFormat = this.hlX.getOutputFormat();
          this.wbL.g(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.hlX.releaseOutputBuffer(this.ixV, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.dhz)
      {
        ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      ae.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      atH();
    } while (this.wcF == null);
    this.wcF.dqj();
    this.wcF = null;
    AppMethodBeat.o(89593);
  }
  
  private void dqv()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.wcE != null) {
        this.wcE.stop();
      }
      if (this.hlX != null)
      {
        ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.hlX.stop();
        this.hlX.release();
        this.isStart = false;
        this.hlX = null;
      }
      AppMethodBeat.o(89600);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89600);
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89595);
    this.wcF = parama;
    this.dhz = true;
    boolean bool = this.wcE.dqf();
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.wcF, Boolean.valueOf(bool) });
    if (bool) {
      dqu();
    }
    AppMethodBeat.o(89595);
  }
  
  public final long atL()
  {
    AppMethodBeat.i(89597);
    if (this.startTime <= 0L)
    {
      ae.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
      AppMethodBeat.o(89597);
      return 0L;
    }
    long l = (System.nanoTime() - this.startTime) / 1000000L;
    AppMethodBeat.o(89597);
    return l;
  }
  
  public void clear()
  {
    AppMethodBeat.i(89598);
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    atH();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.wbP) {
      synchronized (this.hmj)
      {
        if (this.wbN)
        {
          AppMethodBeat.o(89592);
          return;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!this.isStart)
        {
          ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
          AppMethodBeat.o(89592);
          return;
          paramArrayOfByte = finally;
          AppMethodBeat.o(89592);
          throw paramArrayOfByte;
        }
        if (this.hlX == null)
        {
          ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        if ((this.wbL != null) && (this.wbL.dqr() <= 0L)) {
          this.wbL.dqs();
        }
        long l2 = bu.HQ();
        this.btA = this.hlX.getInputBuffers();
        this.bfT = this.hlX.getOutputBuffers();
        int i = this.hlX.dequeueInputBuffer(100L);
        this.ixU = i;
        if (i < 0)
        {
          ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
          atM();
        }
        if (this.hlX == null)
        {
          ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.ixU) });
        long l3 = bu.HQ();
        if (this.ixU >= 0)
        {
          long l4 = System.nanoTime();
          long l5 = paramArrayOfByte.length * 1000000000L / 1600000L;
          long l1;
          if (this.wbL != null)
          {
            l1 = this.wbL.dqr();
            l1 = (l4 - l5 - l1) / 1000L;
            if ((l1 < 0L) && (this.wca <= 0L)) {
              this.wca = (-l1);
            }
            l1 += this.wca;
            ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l1)));
            ??? = this.btA[this.ixU];
            ((ByteBuffer)???).clear();
            ((ByteBuffer)???).put(paramArrayOfByte);
            ((ByteBuffer)???).position(0);
            if ((this.isStart) && (!paramBoolean))
            {
              this.hlX.a(this.ixU, paramArrayOfByte.length, l1, 0);
              atM();
              ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(bu.aO(l2)), Long.valueOf(bu.aO(l3)) });
              AppMethodBeat.o(89592);
            }
          }
          else
          {
            l1 = this.startTime;
            continue;
          }
          ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
          this.ixW = true;
          this.hlX.a(this.ixU, paramArrayOfByte.length, l1, 4);
          continue;
        }
        ae.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.auX();
        ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ae.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89592);
        return;
      }
    }
  }
  
  final void dqu()
  {
    AppMethodBeat.i(89596);
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { bu.fpN().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89587);
            s.a(s.this);
            if (s.this.wcF != null)
            {
              s.this.wcF.dqj();
              s.this.wcF = null;
            }
            AppMethodBeat.o(89587);
          }
        }, 500L);
      }
      AppMethodBeat.o(89596);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89596);
    }
  }
  
  public int gz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.wcA = paramInt2;
      paramInt1 = aNH();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(am.a.IRo, Integer.valueOf(-1));
        }
        paramInt1 = aNH();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        ae.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.auW();
        AppMethodBeat.o(89590);
      }
    }
    return -1;
  }
  
  protected void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89594);
    if ((this.wbL != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.wbL.k(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89594);
  }
  
  public final void start()
  {
    AppMethodBeat.i(89589);
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.nanoTime();
    AppMethodBeat.o(89589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */