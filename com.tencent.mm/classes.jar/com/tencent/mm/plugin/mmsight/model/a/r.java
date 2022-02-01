package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r
  implements f
{
  private ByteBuffer[] aVy;
  private int bitrate;
  private ByteBuffer[] bjg;
  private MediaCodec.BufferInfo bufferInfo;
  boolean cVh;
  int frameCount;
  private int frameRate;
  int gNU;
  int gNV;
  int gNW;
  private int gNX;
  protected z gQR;
  private final Object gRd;
  private long gcd;
  boolean hdT;
  private int ibE;
  private int ibF;
  private boolean ibG;
  private boolean isStart;
  private int jbj;
  private int jbk;
  protected MediaFormat mediaFormat;
  private long startTime;
  private o uMC;
  private boolean uME;
  private boolean uMF;
  int uNn;
  int uNo;
  int uNp;
  int uNq;
  a uNr;
  f.a uNs;
  private a.a uNt;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.gcd = 0L;
    this.ibE = -1;
    this.ibF = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.cVh = false;
    this.ibG = false;
    this.uNn = -1;
    this.uNo = -1;
    this.uNp = -1;
    this.uNq = -1;
    this.hdT = false;
    this.gRd = new Object();
    this.uME = false;
    this.uMF = true;
    this.uNt = new a.a()
    {
      public final void output(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = bs.Gn();
        boolean bool2 = r.this.uNr.ddL();
        r localr = r.this;
        if ((bool2) && (r.this.cVh)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localr.d(paramAnonymousArrayOfByte, bool1);
          com.tencent.mm.bk.b.ibA.k(paramAnonymousArrayOfByte);
          ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(r.this.cVh), Boolean.valueOf(bool2), Long.valueOf(bs.aO(l)) });
          if ((bool2) && (r.this.cVh)) {
            r.this.ddY();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.uNr = new a(this.uNt);
    this.jbj = paramInt1;
    this.jbk = paramInt2;
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.gNU = paramInt3;
    this.gNV = paramInt4;
    this.frameRate = paramInt7;
    this.gNX = paramInt6;
    this.uMC = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.hdT = paramBoolean;
    this.uMF = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTM, true);
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.jbj), Integer.valueOf(this.jbk), Integer.valueOf(this.gNU), Integer.valueOf(this.gNV), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private int aKa()
  {
    AppMethodBeat.i(89591);
    long l1 = bs.Gn();
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
      ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      l.arU();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label44;
      i += 1;
      break;
      ??? = null;
    }
    label105:
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(bs.aO(l1)) });
    l1 = bs.Gn();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ah.a.GKy, -1);
    }
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.gNW = i;
      l1 = bs.aO(l1);
      if ((this.gNW > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(ah.a.GKy, Integer.valueOf(this.gNW));
      }
      ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.gNW), Long.valueOf(l1) });
      l1 = bs.Gn();
      ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.uNn) });
      if (!this.hdT) {
        break label805;
      }
      if ((this.uNn != 180) && (this.uNn != 0)) {
        break label789;
      }
      i = this.gNU;
      label319:
      if ((this.uNn != 180) && (this.uNn != 0)) {
        break label797;
      }
      j = this.gNV;
      label341:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label352:
      ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bs.aO(l1)) });
      if ((??? != null) && (!d.kZ(23))) {
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
        ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
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
          if (d.kZ(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.gNW);
          this.mediaFormat.setInteger("i-frame-interval", this.gNX);
          ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.gQR = z.sz(((MediaCodecInfo)???).getName());
          this.gQR.a(this.mediaFormat, null, 1);
          this.gQR.start();
          if (this.uMF)
          {
            AppMethodBeat.o(89591);
            return 0;
            localException1 = localException1;
            ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
            continue;
          }
        }
        catch (Exception localException2)
        {
          ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
          synchronized (this.gRd)
          {
            this.uME = false;
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
      l2 = bs.Gn();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bs.aO(l2)) });
      ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length) });
      j = 0;
      if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length)
      {
        n = localObject2.colorFormats[j];
        ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
        ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { ((MediaCodecInfo)???).getName(), Integer.valueOf(i) });
        break;
        i = this.gNV;
        break label319;
        j = this.gNU;
        break label341;
        if ((this.uNn == 180) || (this.uNn == 0))
        {
          i = this.gNV;
          if ((this.uNn != 180) && (this.uNn != 0)) {
            continue;
          }
          j = this.gNU;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label352;
        }
        i = this.gNU;
        continue;
        j = this.gNV;
        continue;
        j = 1;
      }
    }
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void aqE()
  {
    AppMethodBeat.i(89599);
    if (this.uMF)
    {
      ddZ();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.gRd)
    {
      if ((this.uME) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.uME = true;
      ddZ();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private void aqJ()
  {
    AppMethodBeat.i(89593);
    this.ibF = this.gQR.dequeueOutputBuffer(this.bufferInfo, 100L);
    ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.ibF);
    do
    {
      if (this.ibF != -1) {
        break label154;
      }
      ac.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ibG) });
      if (!this.ibG) {
        break;
      }
      this.ibF = this.gQR.dequeueOutputBuffer(this.bufferInfo, 100L);
      if (this.ibF <= 0) {
        ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ibF) });
      }
    } while ((this.ibF >= 0) || (this.ibG));
    label154:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.ibF == -3)
      {
        this.aVy = this.gQR.getOutputBuffers();
        ac.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.ibF == -2)
      {
        localObject = this.gQR.getOutputFormat();
        ac.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localObject)));
        if (this.uMC == null) {
          break;
        }
        this.uMC.f((MediaFormat)localObject);
        break;
      }
      if (this.ibF < 0)
      {
        ac.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ibF);
        break;
      }
      ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.aVy[this.ibF];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ibF + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        if ((this.uMC != null) && (!this.uMC.isStart))
        {
          MediaFormat localMediaFormat = this.gQR.getOutputFormat();
          this.uMC.f(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.gQR.releaseOutputBuffer(this.ibF, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.cVh)
      {
        ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      ac.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      aqE();
    } while (this.uNs == null);
    this.uNs.ddP();
    this.uNs = null;
    AppMethodBeat.o(89593);
  }
  
  private void ddZ()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.uNr != null) {
        this.uNr.stop();
      }
      if (this.gQR != null)
      {
        ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.gQR.stop();
        this.gQR.release();
        this.isStart = false;
        this.gQR = null;
      }
      AppMethodBeat.o(89600);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89600);
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89595);
    this.uNs = parama;
    this.cVh = true;
    boolean bool = this.uNr.ddL();
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.uNs, Boolean.valueOf(bool) });
    if (bool) {
      ddY();
    }
    AppMethodBeat.o(89595);
  }
  
  public final long aqI()
  {
    AppMethodBeat.i(89597);
    if (this.startTime <= 0L)
    {
      ac.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
      AppMethodBeat.o(89597);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    AppMethodBeat.o(89597);
    return l1 - l2;
  }
  
  public void clear()
  {
    AppMethodBeat.i(89598);
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    aqE();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.uMF) {
      synchronized (this.gRd)
      {
        if (this.uME)
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
          ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
          AppMethodBeat.o(89592);
          return;
          paramArrayOfByte = finally;
          AppMethodBeat.o(89592);
          throw paramArrayOfByte;
        }
        if (this.gQR == null)
        {
          ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        if ((this.uMC != null) && (this.uMC.uNl <= 0L)) {
          this.uMC.uNl = System.nanoTime();
        }
        long l2 = bs.Gn();
        this.bjg = this.gQR.getInputBuffers();
        this.aVy = this.gQR.getOutputBuffers();
        int i = this.gQR.dequeueInputBuffer(100L);
        this.ibE = i;
        if (i < 0)
        {
          ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
          aqJ();
        }
        if (this.gQR == null)
        {
          ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.ibE) });
        long l3 = bs.Gn();
        if (this.ibE >= 0)
        {
          long l4 = System.nanoTime();
          long l5 = paramArrayOfByte.length / 1600000 / 1000000000;
          long l1;
          if (this.uMC != null)
          {
            l1 = this.uMC.uNl;
            l1 = (l4 - l5 - l1) / 1000L;
            ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l1)));
            ??? = this.bjg[this.ibE];
            ((ByteBuffer)???).clear();
            ((ByteBuffer)???).put(paramArrayOfByte);
            ((ByteBuffer)???).position(0);
            if ((this.isStart) && (!paramBoolean))
            {
              this.gQR.a(this.ibE, paramArrayOfByte.length, l1, 0);
              aqJ();
              ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(bs.aO(l2)), Long.valueOf(bs.aO(l3)) });
              AppMethodBeat.o(89592);
            }
          }
          else
          {
            l1 = this.startTime;
            continue;
          }
          ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
          this.ibG = true;
          this.gQR.a(this.ibE, paramArrayOfByte.length, l1, 4);
          continue;
        }
        ac.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.arV();
        ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ac.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89592);
        return;
      }
    }
  }
  
  final void ddY()
  {
    AppMethodBeat.i(89596);
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { bs.eWi().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89587);
            r.a(r.this);
            if (r.this.uNs != null)
            {
              r.this.uNs.ddP();
              r.this.uNs = null;
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
      ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89596);
    }
  }
  
  public int gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.uNn = paramInt2;
      paramInt1 = aKa();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(ah.a.GKy, Integer.valueOf(-1));
        }
        paramInt1 = aKa();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        ac.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.arU();
        AppMethodBeat.o(89590);
      }
    }
    return -1;
  }
  
  protected void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89594);
    o localo;
    if ((this.uMC != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      localo = this.uMC;
    }
    for (;;)
    {
      try
      {
        if ((localo.uNi != null) && (localo.uNj != -1) && (localo.isStart))
        {
          if (paramByteBuffer == null) {
            continue;
          }
          i = 1;
          break label215;
          if ((j & i) != 0)
          {
            long l1 = paramBufferInfo.presentationTimeUs;
            paramBufferInfo.presentationTimeUs = ((System.nanoTime() - localo.uNl) / 1000L);
            paramBufferInfo.flags = 1;
            long l2 = bs.Gn();
            localo.uNi.writeSampleData(localo.uNj, paramByteBuffer, paramBufferInfo);
            ac.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bs.aO(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
          }
        }
        AppMethodBeat.o(89594);
        return;
        int i = 0;
      }
      catch (Exception paramByteBuffer)
      {
        ac.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
      }
      int j = 0;
      continue;
      AppMethodBeat.o(89594);
      return;
      label215:
      if (paramBufferInfo != null) {
        j = 1;
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(89589);
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(89589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r
 * JD-Core Version:    0.7.0.1
 */