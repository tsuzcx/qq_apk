package com.tencent.mm.media.c;

import android.media.MediaCodec.BufferInfo;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.media.j.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;ILkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class i
  extends f
{
  public static final i.a gPf;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private volatile boolean gOY;
  
  static
  {
    AppMethodBeat.i(93548);
    gPf = new i.a((byte)0);
    AppMethodBeat.o(93548);
  }
  
  public i(long paramLong1, long paramLong2, com.tencent.mm.media.e.a parama, Surface paramSurface, int paramInt, b<? super f, y> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt);
    AppMethodBeat.i(93547);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.TAG = "MicroMsg.MediaCodecTransDecoder";
    try
    {
      this.mediaFormat = parama.gRI;
      this.gOr = z.sx(parama.aqN());
      parama = this.gOr;
      if (parama == null) {
        k.fOy();
      }
      parama.a(this.mediaFormat, paramSurface, 0);
      parama = this.gOr;
      if (parama == null) {
        k.fOy();
      }
      parama.start();
      if (paramb != null)
      {
        paramb.ay(this);
        AppMethodBeat.o(93547);
        return;
      }
    }
    catch (Exception parama)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(93547);
      throw parama;
    }
    AppMethodBeat.o(93547);
  }
  
  private final boolean aqu()
  {
    AppMethodBeat.i(93545);
    long l1;
    Object localObject2;
    try
    {
      synchronized (this.gOK)
      {
        if (this.gnd) {
          ac.i(this.TAG, "inputDecoder already finished");
        }
        y localy = y.KTp;
        ac.i(this.TAG, "inputDecoder");
        l1 = bs.Gn();
        ??? = this.gOr;
        if (??? == null) {
          k.fOy();
        }
        ??? = ((z)???).getInputBuffers();
        if (??? == null)
        {
          AppMethodBeat.o(93545);
          return false;
        }
      }
      localObject4 = this.gOr;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "inputDecoder error", new Object[0]);
      if (this.gON)
      {
        localObject2 = d.gWO;
        d.asV();
      }
      AppMethodBeat.o(93545);
      return true;
    }
    Object localObject4;
    if (localObject4 == null) {
      k.fOy();
    }
    int i = ((z)localObject4).dequeueInputBuffer(60000L);
    int j = 0;
    while ((i < 0) && (j < 15))
    {
      if (aqv())
      {
        AppMethodBeat.o(93545);
        return true;
      }
      localObject4 = this.gOr;
      if (localObject4 == null) {
        k.fOy();
      }
      i = ((z)localObject4).dequeueInputBuffer(60000L);
      j += 1;
    }
    this.gOY = false;
    long l2;
    int k;
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      localObject4 = this.gOy;
      if (localObject4 == null) {
        k.fOy();
      }
      k.g(localObject2, "inputBuffer");
      if (!((com.tencent.mm.media.e.a)localObject4).k((ByteBuffer)localObject2))
      {
        ac.i(this.TAG, "read sample end");
        AppMethodBeat.o(93545);
        return true;
      }
      l2 = this.gOy.getSampleTime();
      k = this.gOy.sampleSize;
      ((ByteBuffer)localObject2).position(0);
      ac.i(this.TAG, "sampleTime : " + l2 + " us");
      if ((k < 0) || (l2 >= this.gOz * 1000L))
      {
        this.gOY = true;
        ac.i(this.TAG, "sawInputEOS");
      }
      localObject2 = this.gOr;
      if (localObject2 == null) {
        k.fOy();
      }
      if (!this.gOY) {
        break label490;
      }
    }
    label490:
    for (j = 4;; j = 0)
    {
      ((z)localObject2).a(i, k, l2, j);
      for (;;)
      {
        bool = aqv();
        ac.i(this.TAG, "inputDecoder cost " + bs.aO(l1));
        if (!bool) {
          break;
        }
        ac.i(this.TAG, "drainDecoder eos");
        AppMethodBeat.o(93545);
        return true;
        ac.w(this.TAG, "input buffer not available");
      }
      boolean bool = this.gOY;
      AppMethodBeat.o(93545);
      return bool;
    }
  }
  
  private final boolean aqv()
  {
    AppMethodBeat.i(93546);
    for (;;)
    {
      try
      {
        ac.i(this.TAG, "drainDecoder");
        synchronized (this.gOK)
        {
          if (this.gnd) {
            ac.i(this.TAG, "drainDecoder already finished");
          }
          y localy = y.KTp;
          ??? = this.gOr;
          if (??? == null) {
            k.fOy();
          }
          i = ((z)???).dequeueOutputBuffer(this.bufferInfo, 100L);
          if (i == -1)
          {
            ac.i(this.TAG, "no output from decoder available, break");
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
        ac.printErrStackTrace(this.TAG, (Throwable)localException1, "drainDecoder error", new Object[0]);
        if (this.gON)
        {
          localObject2 = d.gWO;
          d.asV();
        }
        AppMethodBeat.o(93546);
        return false;
      }
      ac.i(this.TAG, "decoder output buffers changed");
      continue;
      label177:
      if (i == -2)
      {
        localObject2 = this.gOr;
        if (localObject2 == null) {
          k.fOy();
        }
        this.mediaFormat = ((z)localObject2).getOutputFormat();
        ac.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
        localObject2 = this.mediaFormat;
        if (localObject2 != null)
        {
          b localb = this.gOH;
          if (localb != null) {
            localb.ay(localObject2);
          }
        }
      }
      else if (i < 0)
      {
        ac.w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        long l = this.bufferInfo.presentationTimeUs;
        ac.i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < this.bvf * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          localObject2 = this.gOr;
          if (localObject2 == null) {
            k.fOy();
          }
          ((z)localObject2).releaseOutputBuffer(i, false);
          ac.i(this.TAG, "decoder pts: " + l + ", not reach start: " + this.bvf * 1000L);
          AppMethodBeat.o(93546);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          a(i, this.bufferInfo);
          if ((this.gOz * 1000L != 1L) && (l >= this.gOz * 1000L))
          {
            ac.e(this.TAG, "exceed endTimeMs");
            AppMethodBeat.o(93546);
            return true;
          }
          i = this.bufferInfo.flags;
          if ((i & 0x4) == 0) {}
        }
      }
      try
      {
        localObject2 = this.gOr;
        if (localObject2 == null) {
          k.fOy();
        }
        ((z)localObject2).stop();
        localObject2 = this.gOr;
        if (localObject2 == null) {
          k.fOy();
        }
        ((z)localObject2).release();
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
      Object localObject2 = this.gOr;
      if (localObject2 == null) {
        k.fOy();
      }
      ((z)localObject2).releaseOutputBuffer(i, false);
      localObject2 = this.gOr;
      if (localObject2 == null) {
        k.fOy();
      }
      j = ((z)localObject2).dequeueOutputBuffer(this.bufferInfo, 100L);
      int i = j;
      if (j >= 0) {}
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93544);
    while (!aqu()) {}
    ac.i(this.TAG, "inputDecoder end");
    try
    {
      int i;
      synchronized (this.gOK)
      {
        if (this.gnd) {
          ac.i(this.TAG, "drainDecoder already finished");
        }
        Object localObject3 = y.KTp;
        ac.i(this.TAG, "sendDecoderEOS");
        ??? = this.gOr;
        if (??? == null) {
          k.fOy();
        }
        ??? = ((z)???).getInputBuffers();
        localObject3 = this.gOr;
        if (localObject3 == null) {
          k.fOy();
        }
        i = ((z)localObject3).dequeueInputBuffer(60000L);
        if (i < 0) {
          if (!aqv())
          {
            localObject3 = this.gOr;
            if (localObject3 == null) {
              k.fOy();
            }
            i = ((z)localObject3).dequeueInputBuffer(60000L);
          }
        }
      }
      Object localObject2;
      com.tencent.mm.media.e.a locala;
      long l;
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "sendDecoderEOS error", new Object[0]);
      for (;;)
      {
        releaseDecoder();
        localObject2 = this.gOG;
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
          locala = this.gOy;
          if (locala == null) {
            k.fOy();
          }
          k.g(localObject2, "inputBuffer");
          locala.k((ByteBuffer)localObject2);
          l = this.gOy.getSampleTime();
          ((ByteBuffer)localObject2).position(0);
          if (i >= 0)
          {
            localObject2 = this.gOr;
            if (localObject2 == null) {
              k.fOy();
            }
            ((z)localObject2).a(i, 0, l, 4);
          }
        }
        aqv();
      }
      AppMethodBeat.o(93544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.c.i
 * JD-Core Version:    0.7.0.1
 */