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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r
  implements f
{
  private ByteBuffer[] aUK;
  private ByteBuffer[] biB;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  boolean cXL;
  private long fXw;
  int frameCount;
  private int frameRate;
  boolean gDs;
  int gnh;
  int gni;
  int gnk;
  private int gnl;
  protected z gqj;
  private final Object gqv;
  private int hBd;
  private int hBe;
  private boolean hBf;
  private int iBi;
  private int iBj;
  private boolean isStart;
  protected MediaFormat mediaFormat;
  private long startTime;
  int tES;
  int tET;
  int tEU;
  int tEV;
  a tEW;
  f.a tEX;
  private a.a tEY;
  private o tEh;
  private boolean tEj;
  private boolean tEk;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.fXw = 0L;
    this.hBd = -1;
    this.hBe = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.cXL = false;
    this.hBf = false;
    this.tES = -1;
    this.tET = -1;
    this.tEU = -1;
    this.tEV = -1;
    this.gDs = false;
    this.gqv = new Object();
    this.tEj = false;
    this.tEk = true;
    this.tEY = new a.a()
    {
      public final void output(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = bt.GC();
        boolean bool2 = r.this.tEW.cQd();
        r localr = r.this;
        if ((bool2) && (r.this.cXL)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localr.d(paramAnonymousArrayOfByte, bool1);
          com.tencent.mm.bl.b.hAZ.k(paramAnonymousArrayOfByte);
          ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(r.this.cXL), Boolean.valueOf(bool2), Long.valueOf(bt.aS(l)) });
          if ((bool2) && (r.this.cXL)) {
            r.this.cQq();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.tEW = new a(this.tEY);
    this.iBi = paramInt1;
    this.iBj = paramInt2;
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.gnh = paramInt3;
    this.gni = paramInt4;
    this.frameRate = paramInt7;
    this.gnl = paramInt6;
    this.tEh = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.gDs = paramBoolean;
    this.tEk = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqb, true);
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.iBi), Integer.valueOf(this.iBj), Integer.valueOf(this.gnh), Integer.valueOf(this.gni), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private int aDj()
  {
    AppMethodBeat.i(89591);
    long l1 = bt.GC();
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
      ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      l.ala();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label44;
      i += 1;
      break;
      ??? = null;
    }
    label105:
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(bt.aS(l1)) });
    l1 = bt.GC();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ae.a.FmJ, -1);
    }
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.gnk = i;
      l1 = bt.aS(l1);
      if ((this.gnk > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(ae.a.FmJ, Integer.valueOf(this.gnk));
      }
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.gnk), Long.valueOf(l1) });
      l1 = bt.GC();
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.tES) });
      if (!this.gDs) {
        break label805;
      }
      if ((this.tES != 180) && (this.tES != 0)) {
        break label789;
      }
      i = this.gnh;
      label319:
      if ((this.tES != 180) && (this.tES != 0)) {
        break label797;
      }
      j = this.gni;
      label341:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label352:
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bt.aS(l1)) });
      if ((??? != null) && (!d.lf(23))) {
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
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
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
          if (d.lf(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.gnk);
          this.mediaFormat.setInteger("i-frame-interval", this.gnl);
          ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.gqj = z.pn(((MediaCodecInfo)???).getName());
          this.gqj.a(this.mediaFormat, null, 1);
          this.gqj.start();
          if (this.tEk)
          {
            AppMethodBeat.o(89591);
            return 0;
            localException1 = localException1;
            ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
            continue;
          }
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
          synchronized (this.gqv)
          {
            this.tEj = false;
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
      l2 = bt.GC();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aS(l2)) });
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length) });
      j = 0;
      if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length)
      {
        n = localObject2.colorFormats[j];
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { ((MediaCodecInfo)???).getName(), Integer.valueOf(i) });
        break;
        i = this.gni;
        break label319;
        j = this.gnh;
        break label341;
        if ((this.tES == 180) || (this.tES == 0))
        {
          i = this.gni;
          if ((this.tES != 180) && (this.tES != 0)) {
            continue;
          }
          j = this.gnh;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label352;
        }
        i = this.gnh;
        continue;
        j = this.gni;
        continue;
        j = 1;
      }
    }
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void ajF()
  {
    AppMethodBeat.i(89599);
    if (this.tEk)
    {
      cQr();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.gqv)
    {
      if ((this.tEj) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.tEj = true;
      cQr();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private void ajK()
  {
    AppMethodBeat.i(89593);
    this.hBe = this.gqj.dequeueOutputBuffer(this.bufferInfo, 100L);
    ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.hBe);
    do
    {
      if (this.hBe != -1) {
        break label154;
      }
      ad.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.hBf) });
      if (!this.hBf) {
        break;
      }
      this.hBe = this.gqj.dequeueOutputBuffer(this.bufferInfo, 100L);
      if (this.hBe <= 0) {
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.hBe) });
      }
    } while ((this.hBe >= 0) || (this.hBf));
    label154:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.hBe == -3)
      {
        this.aUK = this.gqj.getOutputBuffers();
        ad.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.hBe == -2)
      {
        localObject = this.gqj.getOutputFormat();
        ad.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localObject)));
        if (this.tEh == null) {
          break;
        }
        this.tEh.k((MediaFormat)localObject);
        break;
      }
      if (this.hBe < 0)
      {
        ad.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.hBe);
        break;
      }
      ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.aUK[this.hBe];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.hBe + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        if ((this.tEh != null) && (!this.tEh.isStart))
        {
          MediaFormat localMediaFormat = this.gqj.getOutputFormat();
          this.tEh.k(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.gqj.releaseOutputBuffer(this.hBe, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.cXL)
      {
        ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      ad.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      ajF();
    } while (this.tEX == null);
    this.tEX.cQh();
    this.tEX = null;
    AppMethodBeat.o(89593);
  }
  
  private void cQr()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.tEW != null) {
        this.tEW.stop();
      }
      if (this.gqj != null)
      {
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.gqj.stop();
        this.gqj.release();
        this.isStart = false;
        this.gqj = null;
      }
      AppMethodBeat.o(89600);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89600);
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89595);
    this.tEX = parama;
    this.cXL = true;
    boolean bool = this.tEW.cQd();
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.tEX, Boolean.valueOf(bool) });
    if (bool) {
      cQq();
    }
    AppMethodBeat.o(89595);
  }
  
  public final long ajJ()
  {
    AppMethodBeat.i(89597);
    if (this.startTime <= 0L)
    {
      ad.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
      AppMethodBeat.o(89597);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    AppMethodBeat.o(89597);
    return l1 - l2;
  }
  
  final void cQq()
  {
    AppMethodBeat.i(89596);
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { bt.eGN().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89587);
            r.a(r.this);
            if (r.this.tEX != null)
            {
              r.this.tEX.cQh();
              r.this.tEX = null;
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
      ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89596);
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(89598);
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    ajF();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.tEk) {
      synchronized (this.gqv)
      {
        if (this.tEj)
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
          ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
          AppMethodBeat.o(89592);
          return;
          paramArrayOfByte = finally;
          AppMethodBeat.o(89592);
          throw paramArrayOfByte;
        }
        if (this.gqj == null)
        {
          ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        if ((this.tEh != null) && (this.tEh.tEQ <= 0L)) {
          this.tEh.tEQ = System.nanoTime();
        }
        long l2 = bt.GC();
        this.biB = this.gqj.getInputBuffers();
        this.aUK = this.gqj.getOutputBuffers();
        int i = this.gqj.dequeueInputBuffer(100L);
        this.hBd = i;
        if (i < 0)
        {
          ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
          ajK();
        }
        if (this.gqj == null)
        {
          ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.hBd) });
        long l3 = bt.GC();
        if (this.hBd >= 0)
        {
          long l4 = System.nanoTime();
          long l5 = paramArrayOfByte.length / 1600000 / 1000000000;
          long l1;
          if (this.tEh != null)
          {
            l1 = this.tEh.tEQ;
            l1 = (l4 - l5 - l1) / 1000L;
            ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l1)));
            ??? = this.biB[this.hBd];
            ((ByteBuffer)???).clear();
            ((ByteBuffer)???).put(paramArrayOfByte);
            ((ByteBuffer)???).position(0);
            if ((this.isStart) && (!paramBoolean))
            {
              this.gqj.a(this.hBd, paramArrayOfByte.length, l1, 0);
              ajK();
              ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(bt.aS(l2)), Long.valueOf(bt.aS(l3)) });
              AppMethodBeat.o(89592);
            }
          }
          else
          {
            l1 = this.startTime;
            continue;
          }
          ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
          this.hBf = true;
          this.gqj.a(this.hBd, paramArrayOfByte.length, l1, 4);
          continue;
        }
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.alb();
        ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ad.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89592);
        return;
      }
    }
  }
  
  public int gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.tES = paramInt2;
      paramInt1 = aDj();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(ae.a.FmJ, Integer.valueOf(-1));
        }
        paramInt1 = aDj();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.ala();
        AppMethodBeat.o(89590);
      }
    }
    return -1;
  }
  
  protected void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89594);
    o localo;
    if ((this.tEh != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      localo = this.tEh;
    }
    for (;;)
    {
      try
      {
        if ((localo.tEN != null) && (localo.tEO != -1) && (localo.isStart))
        {
          if (paramByteBuffer == null) {
            continue;
          }
          i = 1;
          break label215;
          if ((j & i) != 0)
          {
            long l1 = paramBufferInfo.presentationTimeUs;
            paramBufferInfo.presentationTimeUs = ((System.nanoTime() - localo.tEQ) / 1000L);
            paramBufferInfo.flags = 1;
            long l2 = bt.GC();
            localo.tEN.writeSampleData(localo.tEO, paramByteBuffer, paramBufferInfo);
            ad.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bt.aS(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
          }
        }
        AppMethodBeat.o(89594);
        return;
        int i = 0;
      }
      catch (Exception paramByteBuffer)
      {
        ad.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
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
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(89589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r
 * JD-Core Version:    0.7.0.1
 */