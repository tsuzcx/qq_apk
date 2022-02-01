package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.b;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;ILkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class i
  extends f
{
  public static final i.a hlT;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private volatile boolean hlM;
  
  static
  {
    AppMethodBeat.i(93548);
    hlT = new i.a((byte)0);
    AppMethodBeat.o(93548);
  }
  
  public i(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, b<? super f, d.z> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt);
    AppMethodBeat.i(93547);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.TAG = "MicroMsg.MediaCodecTransDecoder";
    try
    {
      this.mediaFormat = parama.hmO;
      this.hlf = com.tencent.mm.compatible.deviceinfo.z.vI(parama.atQ());
      parama = this.hlf;
      if (parama == null) {
        p.gkB();
      }
      parama.a(this.mediaFormat, paramSurface, 0);
      parama = this.hlf;
      if (parama == null) {
        p.gkB();
      }
      parama.start();
      if (paramb != null)
      {
        paramb.invoke(this);
        AppMethodBeat.o(93547);
        return;
      }
    }
    catch (Exception parama)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(93547);
      throw parama;
    }
    AppMethodBeat.o(93547);
  }
  
  private final boolean atE()
  {
    AppMethodBeat.i(93545);
    long l1;
    Object localObject2;
    try
    {
      synchronized (this.hly)
      {
        if (this.gJv) {
          ae.i(this.TAG, "inputDecoder already finished");
        }
        d.z localz = d.z.Nhr;
        ae.i(this.TAG, "inputDecoder");
        l1 = bu.HQ();
        ??? = this.hlf;
        if (??? == null) {
          p.gkB();
        }
        ??? = ((com.tencent.mm.compatible.deviceinfo.z)???).getInputBuffers();
        if (??? == null)
        {
          AppMethodBeat.o(93545);
          return false;
        }
      }
      localObject4 = this.hlf;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "inputDecoder error", new Object[0]);
      if (this.hlB)
      {
        localObject2 = d.hrI;
        d.avX();
      }
      AppMethodBeat.o(93545);
      return true;
    }
    Object localObject4;
    if (localObject4 == null) {
      p.gkB();
    }
    int i = ((com.tencent.mm.compatible.deviceinfo.z)localObject4).dequeueInputBuffer(60000L);
    int j = 0;
    while ((i < 0) && (j < 15))
    {
      if (atF())
      {
        AppMethodBeat.o(93545);
        return true;
      }
      localObject4 = this.hlf;
      if (localObject4 == null) {
        p.gkB();
      }
      i = ((com.tencent.mm.compatible.deviceinfo.z)localObject4).dequeueInputBuffer(60000L);
      j += 1;
    }
    this.hlM = false;
    long l2;
    int k;
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      localObject4 = this.hll;
      if (localObject4 == null) {
        p.gkB();
      }
      p.g(localObject2, "inputBuffer");
      if (!((com.tencent.mm.media.f.a)localObject4).j((ByteBuffer)localObject2))
      {
        ae.i(this.TAG, "read sample end");
        AppMethodBeat.o(93545);
        return true;
      }
      l2 = this.hll.getSampleTime();
      k = this.hll.sampleSize;
      ((ByteBuffer)localObject2).position(0);
      ae.i(this.TAG, "sampleTime : " + l2 + " us");
      if ((k < 0) || (l2 >= this.hlm * 1000L))
      {
        this.hlM = true;
        ae.i(this.TAG, "sawInputEOS");
      }
      localObject2 = this.hlf;
      if (localObject2 == null) {
        p.gkB();
      }
      if (!this.hlM) {
        break label490;
      }
    }
    label490:
    for (j = 4;; j = 0)
    {
      ((com.tencent.mm.compatible.deviceinfo.z)localObject2).a(i, k, l2, j);
      for (;;)
      {
        bool = atF();
        ae.i(this.TAG, "inputDecoder cost " + bu.aO(l1));
        if (!bool) {
          break;
        }
        ae.i(this.TAG, "drainDecoder eos");
        AppMethodBeat.o(93545);
        return true;
        ae.w(this.TAG, "input buffer not available");
      }
      boolean bool = this.hlM;
      AppMethodBeat.o(93545);
      return bool;
    }
  }
  
  private final boolean atF()
  {
    AppMethodBeat.i(93546);
    for (;;)
    {
      try
      {
        ae.i(this.TAG, "drainDecoder");
        synchronized (this.hly)
        {
          if (this.gJv) {
            ae.i(this.TAG, "drainDecoder already finished");
          }
          d.z localz = d.z.Nhr;
          ??? = this.hlf;
          if (??? == null) {
            p.gkB();
          }
          i = ((com.tencent.mm.compatible.deviceinfo.z)???).dequeueOutputBuffer(this.bufferInfo, 100L);
          if (i == -1)
          {
            ae.i(this.TAG, "no output from decoder available, break");
            AppMethodBeat.o(93546);
            return false;
          }
        }
        if (i != -3) {
          break label177;
        }
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)localException1, "drainDecoder error", new Object[0]);
        if (this.hlB)
        {
          localObject2 = d.hrI;
          d.avX();
        }
        AppMethodBeat.o(93546);
        return false;
      }
      ae.i(this.TAG, "decoder output buffers changed");
      continue;
      label177:
      if (i == -2)
      {
        localObject2 = this.hlf;
        if (localObject2 == null) {
          p.gkB();
        }
        this.mediaFormat = ((com.tencent.mm.compatible.deviceinfo.z)localObject2).getOutputFormat();
        ae.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
        localObject2 = this.mediaFormat;
        if (localObject2 != null)
        {
          b localb = this.hlu;
          if (localb != null) {
            localb.invoke(localObject2);
          }
        }
      }
      else if (i < 0)
      {
        ae.w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        long l = this.bufferInfo.presentationTimeUs;
        ae.i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          localObject2 = this.hlf;
          if (localObject2 == null) {
            p.gkB();
          }
          ((com.tencent.mm.compatible.deviceinfo.z)localObject2).releaseOutputBuffer(i, false);
          ae.i(this.TAG, "decoder pts: " + l + ", not reach start: " + this.startTimeMs * 1000L);
          AppMethodBeat.o(93546);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          a(i, this.bufferInfo);
          if ((this.hlm * 1000L != 1L) && (l >= this.hlm * 1000L))
          {
            ae.e(this.TAG, "exceed endTimeMs");
            AppMethodBeat.o(93546);
            return true;
          }
          i = this.bufferInfo.flags;
          if ((i & 0x4) == 0) {}
        }
      }
      try
      {
        localObject2 = this.hlf;
        if (localObject2 == null) {
          p.gkB();
        }
        ((com.tencent.mm.compatible.deviceinfo.z)localObject2).stop();
        localObject2 = this.hlf;
        if (localObject2 == null) {
          p.gkB();
        }
        ((com.tencent.mm.compatible.deviceinfo.z)localObject2).release();
      }
      catch (Exception localException2)
      {
        label527:
        int j;
        break label527;
      }
      AppMethodBeat.o(93546);
      return true;
      AppMethodBeat.o(93546);
      return false;
      Object localObject2 = this.hlf;
      if (localObject2 == null) {
        p.gkB();
      }
      ((com.tencent.mm.compatible.deviceinfo.z)localObject2).releaseOutputBuffer(i, false);
      localObject2 = this.hlf;
      if (localObject2 == null) {
        p.gkB();
      }
      j = ((com.tencent.mm.compatible.deviceinfo.z)localObject2).dequeueOutputBuffer(this.bufferInfo, 100L);
      int i = j;
      if (j >= 0) {}
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93544);
    while (!atE()) {}
    ae.i(this.TAG, "inputDecoder end");
    try
    {
      int i;
      synchronized (this.hly)
      {
        if (this.gJv) {
          ae.i(this.TAG, "drainDecoder already finished");
        }
        Object localObject3 = d.z.Nhr;
        ae.i(this.TAG, "sendDecoderEOS");
        ??? = this.hlf;
        if (??? == null) {
          p.gkB();
        }
        ??? = ((com.tencent.mm.compatible.deviceinfo.z)???).getInputBuffers();
        localObject3 = this.hlf;
        if (localObject3 == null) {
          p.gkB();
        }
        i = ((com.tencent.mm.compatible.deviceinfo.z)localObject3).dequeueInputBuffer(60000L);
        if (i < 0) {
          if (!atF())
          {
            localObject3 = this.hlf;
            if (localObject3 == null) {
              p.gkB();
            }
            i = ((com.tencent.mm.compatible.deviceinfo.z)localObject3).dequeueInputBuffer(60000L);
          }
        }
      }
      Object localObject2;
      com.tencent.mm.media.f.a locala;
      long l;
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "sendDecoderEOS error", new Object[0]);
      for (;;)
      {
        releaseDecoder();
        localObject2 = this.hlt;
        if (localObject2 == null) {
          break;
        }
        ((d.g.a.a)localObject2).invoke();
        AppMethodBeat.o(93544);
        return;
        if (i >= 0)
        {
          localObject2 = localObject2[i];
          ((ByteBuffer)localObject2).clear();
          locala = this.hll;
          if (locala == null) {
            p.gkB();
          }
          p.g(localObject2, "inputBuffer");
          locala.j((ByteBuffer)localObject2);
          l = this.hll.getSampleTime();
          ((ByteBuffer)localObject2).position(0);
          if (i >= 0)
          {
            localObject2 = this.hlf;
            if (localObject2 == null) {
              p.gkB();
            }
            ((com.tencent.mm.compatible.deviceinfo.z)localObject2).a(i, 0, l, 4);
          }
        }
        atF();
      }
      AppMethodBeat.o(93544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.i
 * JD-Core Version:    0.7.0.1
 */