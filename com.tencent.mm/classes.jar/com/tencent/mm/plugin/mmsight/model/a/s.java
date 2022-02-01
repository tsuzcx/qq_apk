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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class s
  implements f
{
  private ByteBuffer[] bfT;
  private int bitrate;
  private ByteBuffer[] btA;
  private MediaCodec.BufferInfo bufferInfo;
  boolean dgx;
  int frameCount;
  private int frameRate;
  private long gvN;
  int hhQ;
  private int hhR;
  protected z hjj;
  private final Object hjv;
  boolean hwb;
  private boolean isStart;
  private int iva;
  private int ivb;
  private boolean ivc;
  private int jus;
  private int jut;
  protected MediaFormat mediaFormat;
  private long startTime;
  int targetHeight;
  int targetWidth;
  private p vPI;
  private boolean vPK;
  private boolean vPM;
  a vQA;
  f.a vQB;
  private a.a vQC;
  int vQw;
  int vQx;
  int vQy;
  int vQz;
  
  public s(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.gvN = 0L;
    this.iva = -1;
    this.ivb = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.dgx = false;
    this.ivc = false;
    this.vQw = -1;
    this.vQx = -1;
    this.vQy = -1;
    this.vQz = -1;
    this.hwb = false;
    this.hjv = new Object();
    this.vPK = false;
    this.vPM = true;
    this.vQC = new a.a()
    {
      public final void output(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = bt.HI();
        boolean bool2 = s.this.vQA.dnh();
        s locals = s.this;
        if ((bool2) && (s.this.dgx)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          locals.d(paramAnonymousArrayOfByte, bool1);
          com.tencent.mm.bl.b.iuW.k(paramAnonymousArrayOfByte);
          ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(s.this.dgx), Boolean.valueOf(bool2), Long.valueOf(bt.aO(l)) });
          if ((bool2) && (s.this.dgx)) {
            s.this.dnw();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.vQA = new a(this.vQC);
    this.jus = paramInt1;
    this.jut = paramInt2;
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.frameRate = paramInt7;
    this.hhR = paramInt6;
    this.vPI = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.hwb = paramBoolean;
    this.vPM = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qys, true);
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.jus), Integer.valueOf(this.jut), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private int aNj()
  {
    AppMethodBeat.i(89591);
    long l1 = bt.HI();
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
      l.auH();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label44;
      i += 1;
      break;
      ??? = null;
    }
    label105:
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(bt.aO(l1)) });
    l1 = bt.HI();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(al.a.IwQ, -1);
    }
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.hhQ = i;
      l1 = bt.aO(l1);
      if ((this.hhQ > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(al.a.IwQ, Integer.valueOf(this.hhQ));
      }
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.hhQ), Long.valueOf(l1) });
      l1 = bt.HI();
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.vQw) });
      if (!this.hwb) {
        break label805;
      }
      if ((this.vQw != 180) && (this.vQw != 0)) {
        break label789;
      }
      i = this.targetWidth;
      label319:
      if ((this.vQw != 180) && (this.vQw != 0)) {
        break label797;
      }
      j = this.targetHeight;
      label341:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label352:
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bt.aO(l1)) });
      if ((??? != null) && (!d.ly(23))) {
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
          if (d.ly(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.hhQ);
          this.mediaFormat.setInteger("i-frame-interval", this.hhR);
          ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.hjj = z.vo(((MediaCodecInfo)???).getName());
          this.hjj.a(this.mediaFormat, null, 1);
          this.hjj.start();
          if (this.vPM)
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
          synchronized (this.hjv)
          {
            this.vPK = false;
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
      l2 = bt.HI();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aO(l2)) });
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
        i = this.targetHeight;
        break label319;
        j = this.targetWidth;
        break label341;
        if ((this.vQw == 180) || (this.vQw == 0))
        {
          i = this.targetHeight;
          if ((this.vQw != 180) && (this.vQw != 0)) {
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
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void ats()
  {
    AppMethodBeat.i(89599);
    if (this.vPM)
    {
      dnx();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.hjv)
    {
      if ((this.vPK) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.vPK = true;
      dnx();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private void atx()
  {
    AppMethodBeat.i(89593);
    this.ivb = this.hjj.dequeueOutputBuffer(this.bufferInfo, 100L);
    ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.ivb);
    do
    {
      if (this.ivb != -1) {
        break label154;
      }
      ad.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.ivc) });
      if (!this.ivc) {
        break;
      }
      this.ivb = this.hjj.dequeueOutputBuffer(this.bufferInfo, 100L);
      if (this.ivb <= 0) {
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.ivb) });
      }
    } while ((this.ivb >= 0) || (this.ivc));
    label154:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.ivb == -3)
      {
        this.bfT = this.hjj.getOutputBuffers();
        ad.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.ivb == -2)
      {
        localObject = this.hjj.getOutputFormat();
        ad.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localObject)));
        if (this.vPI == null) {
          break;
        }
        this.vPI.g((MediaFormat)localObject);
        break;
      }
      if (this.ivb < 0)
      {
        ad.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ivb);
        break;
      }
      ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.bfT[this.ivb];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.ivb + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        if ((this.vPI != null) && (!this.vPI.dnv()))
        {
          MediaFormat localMediaFormat = this.hjj.getOutputFormat();
          this.vPI.g(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.hjj.releaseOutputBuffer(this.ivb, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.dgx)
      {
        ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      ad.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      ats();
    } while (this.vQB == null);
    this.vQB.dnl();
    this.vQB = null;
    AppMethodBeat.o(89593);
  }
  
  private void dnx()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.vQA != null) {
        this.vQA.stop();
      }
      if (this.hjj != null)
      {
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.hjj.stop();
        this.hjj.release();
        this.isStart = false;
        this.hjj = null;
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
    this.vQB = parama;
    this.dgx = true;
    boolean bool = this.vQA.dnh();
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.vQB, Boolean.valueOf(bool) });
    if (bool) {
      dnw();
    }
    AppMethodBeat.o(89595);
  }
  
  public final long atw()
  {
    AppMethodBeat.i(89597);
    if (this.startTime <= 0L)
    {
      ad.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
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
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    ats();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.vPM) {
      synchronized (this.hjv)
      {
        if (this.vPK)
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
        if (this.hjj == null)
        {
          ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        if ((this.vPI != null) && (this.vPI.dnt() <= 0L)) {
          this.vPI.dnu();
        }
        long l2 = bt.HI();
        this.btA = this.hjj.getInputBuffers();
        this.bfT = this.hjj.getOutputBuffers();
        int i = this.hjj.dequeueInputBuffer(100L);
        this.iva = i;
        if (i < 0)
        {
          ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
          atx();
        }
        if (this.hjj == null)
        {
          ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(89592);
          return;
        }
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.iva) });
        long l3 = bt.HI();
        if (this.iva >= 0)
        {
          long l4 = System.nanoTime();
          long l5 = paramArrayOfByte.length / 1600000 * 1000000000;
          long l1;
          if (this.vPI != null)
          {
            l1 = this.vPI.dnt();
            l1 = (l4 - l5 - l1) / 1000L;
            ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l1)));
            ??? = this.btA[this.iva];
            ((ByteBuffer)???).clear();
            ((ByteBuffer)???).put(paramArrayOfByte);
            ((ByteBuffer)???).position(0);
            if ((this.isStart) && (!paramBoolean))
            {
              this.hjj.a(this.iva, paramArrayOfByte.length, l1, 0);
              atx();
              ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(bt.aO(l2)), Long.valueOf(bt.aO(l3)) });
              AppMethodBeat.o(89592);
            }
          }
          else
          {
            l1 = this.startTime;
            continue;
          }
          ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
          this.ivc = true;
          this.hjj.a(this.iva, paramArrayOfByte.length, l1, 4);
          continue;
        }
        ad.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        l.auI();
        ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ad.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(89592);
        return;
      }
    }
  }
  
  final void dnw()
  {
    AppMethodBeat.i(89596);
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { bt.flS().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89587);
            s.a(s.this);
            if (s.this.vQB != null)
            {
              s.this.vQB.dnl();
              s.this.vQB = null;
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
  
  public int gz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.vQw = paramInt2;
      paramInt1 = aNj();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(al.a.IwQ, Integer.valueOf(-1));
        }
        paramInt1 = aNj();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        l.auH();
        AppMethodBeat.o(89590);
      }
    }
    return -1;
  }
  
  protected void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89594);
    if ((this.vPI != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.vPI.k(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89594);
  }
  
  public final void start()
  {
    AppMethodBeat.i(89589);
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.nanoTime();
    AppMethodBeat.o(89589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */