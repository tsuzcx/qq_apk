package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends f
{
  public static final i.a nzl;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private volatile boolean nze;
  
  static
  {
    AppMethodBeat.i(93548);
    nzl = new i.a((byte)0);
    AppMethodBeat.o(93548);
  }
  
  public i(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean, b<? super f, ah> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt, paramBoolean);
    AppMethodBeat.i(236901);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.TAG = "MicroMsg.MediaCodecTransDecoder";
    try
    {
      this.mediaFormat = parama.nAs;
      this.nyz = aa.Dw(parama.bpp());
      parama = this.nyz;
      s.checkNotNull(parama);
      parama.a(this.mediaFormat, paramSurface, 0);
      parama = this.nyz;
      s.checkNotNull(parama);
      parama.start();
      if (paramb != null) {
        paramb.invoke(this);
      }
      AppMethodBeat.o(236901);
      return;
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)parama, s.X("create decoder error:", parama.getMessage()), new Object[0]);
      parama = new IllegalStateException("init decoder error");
      AppMethodBeat.o(236901);
      throw parama;
    }
  }
  
  private final boolean boV()
  {
    AppMethodBeat.i(93545);
    long l1;
    Object localObject2;
    try
    {
      synchronized (boS())
      {
        if (this.isFinished) {
          Log.i(this.TAG, "inputDecoder already finished");
        }
        ah localah = ah.aiuX;
        Log.i(this.TAG, "inputDecoder");
        l1 = Util.currentTicks();
        ??? = this.nyz;
        s.checkNotNull(???);
        ??? = ((aa)???).aPD();
        if (??? == null)
        {
          AppMethodBeat.o(93545);
          return false;
        }
      }
      localObject4 = this.nyz;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "inputDecoder error", new Object[0]);
      if (this.nyT)
      {
        localObject2 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brW();
      }
      AppMethodBeat.o(93545);
      return true;
    }
    Object localObject4;
    s.checkNotNull(localObject4);
    int i = ((aa)localObject4).dequeueInputBuffer(60000L);
    int j = 0;
    while ((i < 0) && (j < 15))
    {
      if (boW())
      {
        AppMethodBeat.o(93545);
        return true;
      }
      localObject4 = this.nyz;
      s.checkNotNull(localObject4);
      i = ((aa)localObject4).dequeueInputBuffer(60000L);
      j += 1;
    }
    this.nze = false;
    long l2;
    int k;
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      localObject4 = boN();
      s.checkNotNull(localObject4);
      s.s(localObject2, "inputBuffer");
      if (!com.tencent.mm.media.f.a.a((com.tencent.mm.media.f.a)localObject4, (ByteBuffer)localObject2))
      {
        Log.i(this.TAG, "read sample end");
        AppMethodBeat.o(93545);
        return true;
      }
      l2 = boN().getSampleTime();
      k = boN().sampleSize;
      ((ByteBuffer)localObject2).position(0);
      Log.i(this.TAG, "sampleTime : " + l2 + " us");
      if ((k < 0) || (l2 >= this.endTimeMs * 1000L))
      {
        this.nze = true;
        Log.i(this.TAG, "sawInputEOS");
      }
      localObject2 = this.nyz;
      s.checkNotNull(localObject2);
      if (!this.nze) {
        break label468;
      }
    }
    label468:
    for (j = 4;; j = 0)
    {
      ((aa)localObject2).a(i, k, l2, j);
      for (;;)
      {
        bool = boW();
        Log.i(this.TAG, s.X("inputDecoder cost ", Long.valueOf(Util.ticksToNow(l1))));
        if (!bool) {
          break;
        }
        Log.i(this.TAG, "drainDecoder eos");
        AppMethodBeat.o(93545);
        return true;
        Log.w(this.TAG, "input buffer not available");
      }
      boolean bool = this.nze;
      AppMethodBeat.o(93545);
      return bool;
    }
  }
  
  private final boolean boW()
  {
    AppMethodBeat.i(93546);
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        Log.i(this.TAG, "drainDecoder");
        synchronized (boS())
        {
          if (this.isFinished) {
            Log.i(this.TAG, "drainDecoder already finished");
          }
          ah localah = ah.aiuX;
          ??? = this.nyz;
          s.checkNotNull(???);
          i = ((aa)???).dequeueOutputBuffer(this.bufferInfo, 100L);
          if (i == -1)
          {
            Log.i(this.TAG, "no output from decoder available, break");
            AppMethodBeat.o(93546);
            return false;
          }
        }
        if (i != -3) {
          break label174;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException1, "drainDecoder error", new Object[0]);
        if (this.nyT)
        {
          localObject2 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brW();
        }
        AppMethodBeat.o(93546);
        return false;
      }
      Log.i(this.TAG, "decoder output buffers changed");
      continue;
      label174:
      if (i == -2)
      {
        localObject2 = this.nyz;
        s.checkNotNull(localObject2);
        this.mediaFormat = ((aa)localObject2).getOutputFormat();
        Log.i(this.TAG, s.X("decoder output format changed: ", this.mediaFormat));
        localObject2 = this.mediaFormat;
        if (localObject2 == null) {
          continue;
        }
        b localb = this.nyM;
        if (localb == null) {
          continue;
        }
        localb.invoke(localObject2);
        continue;
      }
      if (i < 0)
      {
        Log.w(this.TAG, s.X("unexpected result from decoder.dequeueOutputBuffer: ", Integer.valueOf(i)));
        continue;
      }
      long l = this.bufferInfo.presentationTimeUs;
      Log.i(this.TAG, s.X("presentationTimeUs : ", Long.valueOf(l)));
      if ((l < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
      {
        localObject2 = this.nyz;
        s.checkNotNull(localObject2);
        ((aa)localObject2).releaseOutputBuffer(i, false);
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
      try
      {
        localObject2 = this.nyz;
        s.checkNotNull(localObject2);
        ((aa)localObject2).stop();
        localObject2 = this.nyz;
        s.checkNotNull(localObject2);
        ((aa)localObject2).release();
        label502:
        AppMethodBeat.o(93546);
        return true;
        AppMethodBeat.o(93546);
        return false;
        localObject2 = this.nyz;
        s.checkNotNull(localObject2);
        ((aa)localObject2).releaseOutputBuffer(i, false);
        localObject2 = this.nyz;
        s.checkNotNull(localObject2);
        int j = ((aa)localObject2).dequeueOutputBuffer(this.bufferInfo, 100L);
        i = j;
        if (j >= 0) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        break label502;
      }
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93544);
    while (!boV()) {}
    Log.i(this.TAG, "inputDecoder end");
    int i;
    try
    {
      synchronized (boS())
      {
        if (this.isFinished) {
          Log.i(this.TAG, "drainDecoder already finished");
        }
        Object localObject3 = ah.aiuX;
        Log.i(this.TAG, "sendDecoderEOS");
        ??? = this.nyz;
        s.checkNotNull(???);
        ??? = ((aa)???).aPD();
        localObject3 = this.nyz;
        s.checkNotNull(localObject3);
        i = ((aa)localObject3).dequeueInputBuffer(60000L);
        if (i >= 0) {
          break label204;
        }
        if (!boW())
        {
          localObject3 = this.nyz;
          s.checkNotNull(localObject3);
          i = ((aa)localObject3).dequeueInputBuffer(60000L);
        }
      }
      releaseDecoder();
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "sendDecoderEOS error", new Object[0]);
    }
    for (;;)
    {
      Object localObject2 = this.nyL;
      if (localObject2 != null) {
        ((kotlin.g.a.a)localObject2).invoke();
      }
      AppMethodBeat.o(93544);
      return;
      label204:
      if (i >= 0)
      {
        localObject2 = localObject2[i];
        ((ByteBuffer)localObject2).clear();
        com.tencent.mm.media.f.a locala = boN();
        s.checkNotNull(locala);
        s.s(localObject2, "inputBuffer");
        com.tencent.mm.media.f.a.a(locala, (ByteBuffer)localObject2);
        long l = boN().getSampleTime();
        ((ByteBuffer)localObject2).position(0);
        if (i >= 0)
        {
          localObject2 = this.nyz;
          s.checkNotNull(localObject2);
          ((aa)localObject2).a(i, 0, l, 4);
        }
      }
      boW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.i
 * JD-Core Version:    0.7.0.1
 */