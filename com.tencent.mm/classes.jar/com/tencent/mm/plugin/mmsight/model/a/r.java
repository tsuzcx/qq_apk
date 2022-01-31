package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r
  implements f
{
  private ByteBuffer[] azr;
  private int bitrate;
  boolean ciU;
  private long eBT;
  private MediaCodec.BufferInfo eRL;
  int eRu;
  int eRv;
  private int eRw;
  int eRx;
  private int eRy;
  private boolean eUA;
  private final Object eUB;
  protected MediaCodec eUg;
  private int fYq;
  private int fYr;
  private boolean fYs;
  boolean fdl;
  int frameCount;
  private int gNA;
  private int gNB;
  private ByteBuffer[] inputBuffers;
  private boolean isStart;
  protected MediaFormat mediaFormat;
  private o oIZ;
  int oJH;
  int oJI;
  int oJJ;
  int oJK;
  a oJL;
  f.a oJM;
  private a.a oJN;
  private boolean oJb;
  private long startTime;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(76672);
    this.startTime = 0L;
    this.eBT = 0L;
    this.fYq = -1;
    this.fYr = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.ciU = false;
    this.fYs = false;
    this.oJH = -1;
    this.oJI = -1;
    this.oJJ = -1;
    this.oJK = -1;
    this.fdl = false;
    this.eUB = new Object();
    this.eUA = false;
    this.oJb = true;
    this.oJN = new r.1(this);
    this.oJL = new a(this.oJN);
    this.gNA = paramInt1;
    this.gNB = paramInt2;
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.eRu = paramInt3;
    this.eRv = paramInt4;
    this.eRw = paramInt7;
    this.eRy = paramInt6;
    this.oIZ = null;
    this.eRL = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.fdl = paramBoolean;
    this.oJb = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVO, true);
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.gNA), Integer.valueOf(this.gNB), Integer.valueOf(this.eRu), Integer.valueOf(this.eRv), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(76672);
  }
  
  private void UN()
  {
    AppMethodBeat.i(138320);
    if (this.oJb)
    {
      bRw();
      AppMethodBeat.o(138320);
      return;
    }
    synchronized (this.eUB)
    {
      if ((this.eUA) || (0L == this.startTime))
      {
        AppMethodBeat.o(138320);
        return;
      }
      this.eUA = true;
      bRw();
      AppMethodBeat.o(138320);
      return;
    }
  }
  
  private void UR()
  {
    AppMethodBeat.i(76679);
    this.fYr = this.eUg.dequeueOutputBuffer(this.eRL, 100L);
    ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.fYr);
    do
    {
      if (this.fYr != -1) {
        break label149;
      }
      ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.fYs) });
      if (!this.fYs) {
        break;
      }
      this.fYr = this.eUg.dequeueOutputBuffer(this.eRL, 100L);
      if (this.fYr <= 0) {
        ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.fYr) });
      }
    } while ((this.fYr >= 0) || (this.fYs));
    label149:
    do
    {
      AppMethodBeat.o(76679);
      return;
      if (this.fYr == -3)
      {
        this.azr = this.eUg.getOutputBuffers();
        ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.fYr == -2)
      {
        localObject = this.eUg.getOutputFormat();
        ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localObject)));
        if (this.oIZ == null) {
          break;
        }
        this.oIZ.e((MediaFormat)localObject);
        break;
      }
      if (this.fYr < 0)
      {
        ab.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fYr);
        break;
      }
      ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.azr[this.fYr];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.fYr + " was null");
        AppMethodBeat.o(76679);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.eRL.flags & 0x2) != 0) {
        ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.eRL.size), Boolean.FALSE });
      }
      if (this.eRL.size != 0)
      {
        if ((this.oIZ != null) && (!this.oIZ.isStart))
        {
          MediaFormat localMediaFormat = this.eUg.getOutputFormat();
          this.oIZ.e(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.eRL.offset);
        ((ByteBuffer)localObject).limit(this.eRL.offset + this.eRL.size);
        g((ByteBuffer)localObject, this.eRL);
      }
      this.eUg.releaseOutputBuffer(this.fYr, false);
      if ((this.eRL.flags & 0x4) == 0) {
        break;
      }
      if (!this.ciU)
      {
        ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(76679);
        return;
      }
      ab.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      UN();
    } while (this.oJM == null);
    this.oJM.bRn();
    this.oJM = null;
    AppMethodBeat.o(76679);
  }
  
  private int ame()
  {
    AppMethodBeat.i(76675);
    long l1 = bo.yB();
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
        label45:
        if (j < localObject2.length) {
          if (!localObject2[j].equalsIgnoreCase("video/avc")) {}
        }
      }
    }
    for (;;)
    {
      if (??? != null) {
        break label109;
      }
      ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      k.VN();
      AppMethodBeat.o(76675);
      return -1;
      j += 1;
      break label45;
      i += 1;
      break;
      ??? = null;
    }
    label109:
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(bo.av(l1)) });
    l1 = bo.yB();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ac.a.yEd, -1);
    }
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.eRx = i;
      l1 = bo.av(l1);
      if ((this.eRx > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(ac.a.yEd, Integer.valueOf(this.eRx));
      }
      ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.eRx), Long.valueOf(l1) });
      l1 = bo.yB();
      ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.oJH) });
      if (!this.fdl) {
        break label813;
      }
      if ((this.oJH != 180) && (this.oJH != 0)) {
        break label797;
      }
      i = this.eRu;
      label324:
      if ((this.oJH != 180) && (this.oJH != 0)) {
        break label805;
      }
      j = this.eRv;
      label346:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label358:
      ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(bo.av(l1)) });
      if ((??? != null) && (!d.fv(23))) {
        break label974;
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
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
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
          label797:
          label805:
          label813:
          if (d.fv(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.eRw);
          this.mediaFormat.setInteger("color-format", this.eRx);
          this.mediaFormat.setInteger("i-frame-interval", this.eRy);
          ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.eUg = MediaCodec.createByCodecName(((MediaCodecInfo)???).getName());
          this.eUg.configure(this.mediaFormat, null, null, 1);
          this.eUg.start();
          if (this.oJb)
          {
            AppMethodBeat.o(76675);
            return 0;
            localException1 = localException1;
            ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
            continue;
          }
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
          synchronized (this.eUB)
          {
            this.eUA = false;
            AppMethodBeat.o(76675);
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
      l2 = bo.yB();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bo.av(l2)) });
      ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length) });
      j = 0;
      if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length)
      {
        n = localObject2.colorFormats[j];
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { ((MediaCodecInfo)???).getName(), Integer.valueOf(i) });
        break;
        i = this.eRv;
        break label324;
        j = this.eRu;
        break label346;
        if ((this.oJH == 180) || (this.oJH == 0))
        {
          i = this.eRv;
          if ((this.oJH != 180) && (this.oJH != 0)) {
            continue;
          }
          j = this.eRu;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label358;
        }
        i = this.eRu;
        continue;
        j = this.eRv;
        continue;
        j = 1;
      }
    }
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void bRw()
  {
    AppMethodBeat.i(138321);
    try
    {
      if (this.oJL != null) {
        this.oJL.stop();
      }
      if (this.eUg != null)
      {
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.eUg.stop();
        this.eUg.release();
        this.isStart = false;
        this.eUg = null;
      }
      AppMethodBeat.o(138321);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(138321);
    }
  }
  
  public final long UQ()
  {
    AppMethodBeat.i(76683);
    if (this.startTime <= 0L)
    {
      ab.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
      AppMethodBeat.o(76683);
      return 0L;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    AppMethodBeat.o(76683);
    return l1 - l2;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(76681);
    this.oJM = parama;
    this.ciU = true;
    boolean bool = this.oJL.bRj();
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.oJM, Boolean.valueOf(bool) });
    if (bool) {
      bRv();
    }
    AppMethodBeat.o(76681);
  }
  
  final void bRv()
  {
    AppMethodBeat.i(76682);
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { bo.dtY().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        al.p(new r.2(this), 500L);
      }
      AppMethodBeat.o(76682);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76682);
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(76684);
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    UN();
    AppMethodBeat.o(76684);
  }
  
  public final void e(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(76678);
    if (!this.oJb) {
      synchronized (this.eUB)
      {
        if (this.eUA)
        {
          AppMethodBeat.o(76678);
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
          ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
          AppMethodBeat.o(76678);
          return;
          paramArrayOfByte = finally;
          AppMethodBeat.o(76678);
          throw paramArrayOfByte;
        }
        if (this.eUg == null)
        {
          ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(76678);
          return;
        }
        if ((this.oIZ != null) && (this.oIZ.oJF <= 0L)) {
          this.oIZ.oJF = System.nanoTime();
        }
        long l2 = bo.yB();
        this.inputBuffers = this.eUg.getInputBuffers();
        this.azr = this.eUg.getOutputBuffers();
        int i = this.eUg.dequeueInputBuffer(100L);
        this.fYq = i;
        if (i < 0)
        {
          ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
          UR();
        }
        if (this.eUg == null)
        {
          ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
          AppMethodBeat.o(76678);
          return;
        }
        ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.fYq) });
        long l3 = bo.yB();
        if (this.fYq >= 0)
        {
          long l4 = System.nanoTime();
          long l5 = paramArrayOfByte.length / 1600000 / 1000000000;
          long l1;
          if (this.oIZ != null)
          {
            l1 = this.oIZ.oJF;
            l1 = (l4 - l5 - l1) / 1000L;
            ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l1)));
            ??? = this.inputBuffers[this.fYq];
            ((ByteBuffer)???).clear();
            ((ByteBuffer)???).put(paramArrayOfByte);
            ((ByteBuffer)???).position(0);
            if ((this.isStart) && (!paramBoolean))
            {
              this.eUg.queueInputBuffer(this.fYq, 0, paramArrayOfByte.length, l1, 0);
              UR();
              ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(bo.av(l2)), Long.valueOf(bo.av(l3)) });
              AppMethodBeat.o(76678);
            }
          }
          else
          {
            l1 = this.startTime;
            continue;
          }
          ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
          this.fYs = true;
          this.eUg.queueInputBuffer(this.fYq, 0, paramArrayOfByte.length, l1, 4);
          continue;
        }
        ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
      }
      catch (Exception paramArrayOfByte)
      {
        k.VO();
        ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
        ab.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(76678);
        return;
      }
    }
  }
  
  public int eF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76674);
    try
    {
      this.oJH = paramInt2;
      paramInt1 = ame();
      AppMethodBeat.o(76674);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(ac.a.yEd, Integer.valueOf(-1));
        }
        paramInt1 = ame();
        AppMethodBeat.o(76674);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        k.VN();
        AppMethodBeat.o(76674);
      }
    }
    return -1;
  }
  
  protected void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(76680);
    o localo;
    if ((this.oIZ != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      localo = this.oIZ;
    }
    for (;;)
    {
      try
      {
        if ((localo.oJC != null) && (localo.oJD != -1) && (localo.isStart))
        {
          if (paramByteBuffer == null) {
            continue;
          }
          i = 1;
          break label215;
          if ((j & i) != 0)
          {
            long l1 = paramBufferInfo.presentationTimeUs;
            paramBufferInfo.presentationTimeUs = ((System.nanoTime() - localo.oJF) / 1000L);
            paramBufferInfo.flags = 1;
            long l2 = bo.yB();
            localo.oJC.writeSampleData(localo.oJD, paramByteBuffer, paramBufferInfo);
            ab.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bo.av(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
          }
        }
        AppMethodBeat.o(76680);
        return;
        int i = 0;
      }
      catch (Exception paramByteBuffer)
      {
        ab.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
      }
      int j = 0;
      continue;
      AppMethodBeat.o(76680);
      return;
      label215:
      if (paramBufferInfo != null) {
        j = 1;
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(76673);
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r
 * JD-Core Version:    0.7.0.1
 */