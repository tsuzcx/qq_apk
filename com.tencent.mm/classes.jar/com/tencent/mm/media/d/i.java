package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.media.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class i
  extends f
{
  public static final i.a ieP;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private volatile boolean ieI;
  
  static
  {
    AppMethodBeat.i(93548);
    ieP = new i.a((byte)0);
    AppMethodBeat.o(93548);
  }
  
  public i(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean, b<? super f, x> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt, paramBoolean);
    AppMethodBeat.i(258661);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.TAG = "MicroMsg.MediaCodecTransDecoder";
    try
    {
      this.mediaFormat = parama.igh;
      this.iec = z.DZ(parama.aMs());
      parama = this.iec;
      if (parama == null) {
        p.hyc();
      }
      parama.a(this.mediaFormat, paramSurface, 0);
      parama = this.iec;
      if (parama == null) {
        p.hyc();
      }
      parama.start();
      if (paramb != null)
      {
        paramb.invoke(this);
        AppMethodBeat.o(258661);
        return;
      }
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(258661);
      throw parama;
    }
    AppMethodBeat.o(258661);
  }
  
  private final boolean aMf()
  {
    AppMethodBeat.i(93545);
    long l1;
    Object localObject2;
    try
    {
      synchronized (this.ieu)
      {
        if (this.isFinished) {
          Log.i(this.TAG, "inputDecoder already finished");
        }
        x localx = x.SXb;
        Log.i(this.TAG, "inputDecoder");
        l1 = Util.currentTicks();
        ??? = this.iec;
        if (??? == null) {
          p.hyc();
        }
        ??? = ((z)???).getInputBuffers();
        if (??? == null)
        {
          AppMethodBeat.o(93545);
          return false;
        }
      }
      localObject4 = this.iec;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "inputDecoder error", new Object[0]);
      if (this.iex)
      {
        localObject2 = e.ilC;
        e.aOK();
      }
      AppMethodBeat.o(93545);
      return true;
    }
    Object localObject4;
    if (localObject4 == null) {
      p.hyc();
    }
    int i = ((z)localObject4).dequeueInputBuffer(60000L);
    int j = 0;
    while ((i < 0) && (j < 15))
    {
      if (aMg())
      {
        AppMethodBeat.o(93545);
        return true;
      }
      localObject4 = this.iec;
      if (localObject4 == null) {
        p.hyc();
      }
      i = ((z)localObject4).dequeueInputBuffer(60000L);
      j += 1;
    }
    this.ieI = false;
    long l2;
    int k;
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      localObject4 = this.iei;
      if (localObject4 == null) {
        p.hyc();
      }
      p.g(localObject2, "inputBuffer");
      if (!com.tencent.mm.media.f.a.a((com.tencent.mm.media.f.a)localObject4, (ByteBuffer)localObject2))
      {
        Log.i(this.TAG, "read sample end");
        AppMethodBeat.o(93545);
        return true;
      }
      l2 = this.iei.getSampleTime();
      k = this.iei.sampleSize;
      ((ByteBuffer)localObject2).position(0);
      Log.i(this.TAG, "sampleTime : " + l2 + " us");
      if ((k < 0) || (l2 >= this.endTimeMs * 1000L))
      {
        this.ieI = true;
        Log.i(this.TAG, "sawInputEOS");
      }
      localObject2 = this.iec;
      if (localObject2 == null) {
        p.hyc();
      }
      if (!this.ieI) {
        break label490;
      }
    }
    label490:
    for (j = 4;; j = 0)
    {
      ((z)localObject2).a(i, k, l2, j);
      for (;;)
      {
        bool = aMg();
        Log.i(this.TAG, "inputDecoder cost " + Util.ticksToNow(l1));
        if (!bool) {
          break;
        }
        Log.i(this.TAG, "drainDecoder eos");
        AppMethodBeat.o(93545);
        return true;
        Log.w(this.TAG, "input buffer not available");
      }
      boolean bool = this.ieI;
      AppMethodBeat.o(93545);
      return bool;
    }
  }
  
  private final boolean aMg()
  {
    AppMethodBeat.i(93546);
    for (;;)
    {
      try
      {
        Log.i(this.TAG, "drainDecoder");
        synchronized (this.ieu)
        {
          if (this.isFinished) {
            Log.i(this.TAG, "drainDecoder already finished");
          }
          x localx = x.SXb;
          ??? = this.iec;
          if (??? == null) {
            p.hyc();
          }
          i = ((z)???).dequeueOutputBuffer(this.bufferInfo, 100L);
          if (i == -1)
          {
            Log.i(this.TAG, "no output from decoder available, break");
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
        Log.printErrStackTrace(this.TAG, (Throwable)localException1, "drainDecoder error", new Object[0]);
        if (this.iex)
        {
          localObject2 = e.ilC;
          e.aOK();
        }
        AppMethodBeat.o(93546);
        return false;
      }
      Log.i(this.TAG, "decoder output buffers changed");
      continue;
      label177:
      if (i == -2)
      {
        localObject2 = this.iec;
        if (localObject2 == null) {
          p.hyc();
        }
        this.mediaFormat = ((z)localObject2).getOutputFormat();
        Log.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
        localObject2 = this.mediaFormat;
        if (localObject2 != null)
        {
          b localb = this.ieq;
          if (localb != null) {
            localb.invoke(localObject2);
          }
        }
      }
      else if (i < 0)
      {
        Log.w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        long l = this.bufferInfo.presentationTimeUs;
        Log.i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          localObject2 = this.iec;
          if (localObject2 == null) {
            p.hyc();
          }
          ((z)localObject2).releaseOutputBuffer(i, false);
          Log.i(this.TAG, "decoder pts: " + l + ", not reach start: " + this.startTimeMs * 1000L);
          AppMethodBeat.o(93546);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          a(i, this.bufferInfo);
          if ((this.endTimeMs * 1000L != 1L) && (l >= this.endTimeMs * 1000L))
          {
            Log.e(this.TAG, "exceed endTimeMs");
            AppMethodBeat.o(93546);
            return true;
          }
          i = this.bufferInfo.flags;
          if ((i & 0x4) == 0) {}
        }
      }
      try
      {
        localObject2 = this.iec;
        if (localObject2 == null) {
          p.hyc();
        }
        ((z)localObject2).stop();
        localObject2 = this.iec;
        if (localObject2 == null) {
          p.hyc();
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
      Object localObject2 = this.iec;
      if (localObject2 == null) {
        p.hyc();
      }
      ((z)localObject2).releaseOutputBuffer(i, false);
      localObject2 = this.iec;
      if (localObject2 == null) {
        p.hyc();
      }
      j = ((z)localObject2).dequeueOutputBuffer(this.bufferInfo, 100L);
      int i = j;
      if (j >= 0) {}
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93544);
    while (!aMf()) {}
    Log.i(this.TAG, "inputDecoder end");
    try
    {
      int i;
      synchronized (this.ieu)
      {
        if (this.isFinished) {
          Log.i(this.TAG, "drainDecoder already finished");
        }
        Object localObject3 = x.SXb;
        Log.i(this.TAG, "sendDecoderEOS");
        ??? = this.iec;
        if (??? == null) {
          p.hyc();
        }
        ??? = ((z)???).getInputBuffers();
        localObject3 = this.iec;
        if (localObject3 == null) {
          p.hyc();
        }
        i = ((z)localObject3).dequeueInputBuffer(60000L);
        if (i < 0) {
          if (!aMg())
          {
            localObject3 = this.iec;
            if (localObject3 == null) {
              p.hyc();
            }
            i = ((z)localObject3).dequeueInputBuffer(60000L);
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
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "sendDecoderEOS error", new Object[0]);
      for (;;)
      {
        releaseDecoder();
        localObject2 = this.iep;
        if (localObject2 == null) {
          break;
        }
        ((kotlin.g.a.a)localObject2).invoke();
        AppMethodBeat.o(93544);
        return;
        if (i >= 0)
        {
          localObject2 = localObject2[i];
          ((ByteBuffer)localObject2).clear();
          locala = this.iei;
          if (locala == null) {
            p.hyc();
          }
          p.g(localObject2, "inputBuffer");
          com.tencent.mm.media.f.a.a(locala, (ByteBuffer)localObject2);
          l = this.iei.getSampleTime();
          ((ByteBuffer)localObject2).position(0);
          if (i >= 0)
          {
            localObject2 = this.iec;
            if (localObject2 == null) {
              p.hyc();
            }
            ((z)localObject2).a(i, 0, l, 4);
          }
        }
        aMg();
      }
      AppMethodBeat.o(93544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.d.i
 * JD-Core Version:    0.7.0.1
 */