package com.tencent.mm.media.c;

import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final a eSs;
  private final String TAG;
  private MediaCodec.BufferInfo eRL;
  private volatile boolean eSr;
  
  static
  {
    AppMethodBeat.i(12866);
    eSs = new a((byte)0);
    AppMethodBeat.o(12866);
  }
  
  public e(long paramLong1, long paramLong2, com.tencent.mm.media.e.a parama, Surface paramSurface, a.f.a.b<? super b, y> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface);
    AppMethodBeat.i(12865);
    this.eRL = new MediaCodec.BufferInfo();
    this.TAG = "MicroMsg.MediaCodecTransDecoder";
    try
    {
      this.mediaFormat = parama.eUT;
      this.eRD = MediaCodec.createDecoderByType(parama.UV());
      parama = this.eRD;
      if (parama == null) {
        j.ebi();
      }
      parama.configure(this.mediaFormat, paramSurface, null, 0);
      parama = this.eRD;
      if (parama == null) {
        j.ebi();
      }
      parama.start();
      paramb.S(this);
      AppMethodBeat.o(12865);
      return;
    }
    catch (Exception parama)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(12865);
      throw parama;
    }
  }
  
  private final boolean UD()
  {
    AppMethodBeat.i(12863);
    long l1;
    Object localObject2;
    try
    {
      synchronized (this.eRY)
      {
        if (this.eRZ) {
          ab.i(this.TAG, "inputDecoder already finished");
        }
        y localy = y.BMg;
        ab.i(this.TAG, "inputDecoder");
        l1 = bo.yB();
        ??? = this.eRD;
        if (??? == null) {
          j.ebi();
        }
        ??? = ((MediaCodec)???).getInputBuffers();
        if (??? == null)
        {
          AppMethodBeat.o(12863);
          return false;
        }
      }
      j = 0;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "inputDecoder error", new Object[0]);
      if (this.eSb)
      {
        localObject2 = c.eZC;
        c.Wv();
      }
      AppMethodBeat.o(12863);
      return true;
    }
    Object localObject4 = this.eRD;
    if (localObject4 == null) {
      j.ebi();
    }
    int i = ((MediaCodec)localObject4).dequeueInputBuffer(60000L);
    while ((i < 0) && (j < 15))
    {
      if (UE())
      {
        AppMethodBeat.o(12863);
        return true;
      }
      localObject4 = this.eRD;
      if (localObject4 == null) {
        j.ebi();
      }
      i = ((MediaCodec)localObject4).dequeueInputBuffer(60000L);
      j += 1;
    }
    this.eSr = false;
    int k;
    long l2;
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      localObject4 = this.eRM;
      if (localObject4 == null) {
        j.ebi();
      }
      j.p(localObject2, "inputBuffer");
      if (!((com.tencent.mm.media.e.a)localObject4).g((ByteBuffer)localObject2))
      {
        ab.i(this.TAG, "read sample end");
        AppMethodBeat.o(12863);
        return true;
      }
      k = this.eRM.sampleSize;
      ((ByteBuffer)localObject2).position(0);
      l2 = this.eRM.getSampleTime();
      ab.i(this.TAG, "sampleTime : " + l2 + " us");
      if ((k < 0) || (l2 >= this.eRN * 1000L))
      {
        this.eSr = true;
        ab.i(this.TAG, "sawInputEOS");
      }
      localObject2 = this.eRD;
      if (localObject2 == null) {
        j.ebi();
      }
      if (!this.eSr) {
        break label498;
      }
    }
    label498:
    for (int j = 4;; j = 0)
    {
      ((MediaCodec)localObject2).queueInputBuffer(i, 0, k, l2, j);
      for (;;)
      {
        bool = UE();
        ab.i(this.TAG, "inputDecoder cost " + bo.av(l1));
        if (!bool) {
          break;
        }
        ab.i(this.TAG, "drainDecoder eos");
        AppMethodBeat.o(12863);
        return true;
        ab.w(this.TAG, "input buffer not available");
      }
      boolean bool = this.eSr;
      AppMethodBeat.o(12863);
      return bool;
    }
  }
  
  private final boolean UE()
  {
    AppMethodBeat.i(12864);
    int i;
    label92:
    Object localObject2;
    for (;;)
    {
      try
      {
        ab.i(this.TAG, "drainDecoder");
        synchronized (this.eRY)
        {
          if (this.eRZ) {
            ab.i(this.TAG, "drainDecoder already finished");
          }
          y localy = y.BMg;
          ??? = this.eRD;
          if (??? == null) {
            j.ebi();
          }
          i = ((MediaCodec)???).dequeueOutputBuffer(this.eRL, 100L);
          if (i == -1)
          {
            ab.i(this.TAG, "no output from decoder available, break");
            AppMethodBeat.o(12864);
            return false;
          }
        }
        if (i != -3) {
          break label177;
        }
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)localException1, "drainDecoder error", new Object[0]);
        if (this.eSb)
        {
          localObject2 = c.eZC;
          c.Wv();
        }
        AppMethodBeat.o(12864);
        return false;
      }
      ab.i(this.TAG, "decoder output buffers changed");
      continue;
      label177:
      if (i == -2)
      {
        localObject2 = this.eRD;
        if (localObject2 == null) {
          j.ebi();
        }
        this.mediaFormat = ((MediaCodec)localObject2).getOutputFormat();
        ab.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
        localObject2 = this.mediaFormat;
        if (localObject2 != null)
        {
          a.f.a.b localb = this.eRV;
          if (localb != null) {
            localb.S(localObject2);
          }
        }
      }
      else
      {
        if (i >= 0) {
          break;
        }
        ab.w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
    }
    long l = this.eRL.presentationTimeUs;
    ab.i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
    if ((l < this.aZw * 1000L) && ((this.eRL.flags & 0x4) == 0))
    {
      localObject2 = this.eRD;
      if (localObject2 == null) {
        j.ebi();
      }
      ((MediaCodec)localObject2).releaseOutputBuffer(i, false);
      ab.i(this.TAG, "decoder pts: " + l + ", not reach start: " + this.aZw * 1000L);
      AppMethodBeat.o(12864);
      return false;
    }
    if (this.eRL.size != 0)
    {
      a(this.eRL);
      localObject2 = this.eRD;
      if (localObject2 == null) {
        j.ebi();
      }
      if (this.eSg == null) {
        break label634;
      }
    }
    label558:
    label634:
    for (boolean bool = true;; bool = false)
    {
      ((MediaCodec)localObject2).releaseOutputBuffer(i, bool);
      if ((this.eRN * 1000L != 1L) && (l >= this.eRN * 1000L))
      {
        ab.e(this.TAG, "exceed endTimeMs");
        AppMethodBeat.o(12864);
        return true;
      }
      i = this.eRL.flags;
      if ((i & 0x4) != 0) {}
      try
      {
        localObject2 = this.eRD;
        if (localObject2 == null) {
          j.ebi();
        }
        ((MediaCodec)localObject2).stop();
        localObject2 = this.eRD;
        if (localObject2 == null) {
          j.ebi();
        }
        ((MediaCodec)localObject2).release();
      }
      catch (Exception localException2)
      {
        break label558;
      }
      AppMethodBeat.o(12864);
      return true;
      AppMethodBeat.o(12864);
      return false;
      localObject2 = this.eRD;
      if (localObject2 == null) {
        j.ebi();
      }
      ((MediaCodec)localObject2).releaseOutputBuffer(i, false);
      localObject2 = this.eRD;
      if (localObject2 == null) {
        j.ebi();
      }
      i = ((MediaCodec)localObject2).dequeueOutputBuffer(this.eRL, 100L);
      if (i < 0) {
        break label92;
      }
      break;
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(12862);
    while (!UD()) {}
    ab.i(this.TAG, "inputDecoder end");
    try
    {
      int i;
      synchronized (this.eRY)
      {
        if (this.eRZ) {
          ab.i(this.TAG, "drainDecoder already finished");
        }
        Object localObject3 = y.BMg;
        ab.i(this.TAG, "sendDecoderEOS");
        ??? = this.eRD;
        if (??? == null) {
          j.ebi();
        }
        ??? = ((MediaCodec)???).getInputBuffers();
        localObject3 = this.eRD;
        if (localObject3 == null) {
          j.ebi();
        }
        i = ((MediaCodec)localObject3).dequeueInputBuffer(60000L);
        if (i < 0) {
          if (!UE())
          {
            localObject3 = this.eRD;
            if (localObject3 == null) {
              j.ebi();
            }
            i = ((MediaCodec)localObject3).dequeueInputBuffer(60000L);
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
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "sendDecoderEOS error", new Object[0]);
      for (;;)
      {
        pJ();
        localObject2 = this.eRU;
        if (localObject2 == null) {
          break;
        }
        ((a.f.a.a)localObject2).invoke();
        AppMethodBeat.o(12862);
        return;
        if (i >= 0)
        {
          localObject2 = localObject2[i];
          ((ByteBuffer)localObject2).clear();
          locala = this.eRM;
          if (locala == null) {
            j.ebi();
          }
          j.p(localObject2, "inputBuffer");
          locala.g((ByteBuffer)localObject2);
          ((ByteBuffer)localObject2).position(0);
          localObject2 = this.eRM;
          if (localObject2 == null) {
            j.ebi();
          }
          l = ((com.tencent.mm.media.e.a)localObject2).getSampleTime();
          if (i >= 0)
          {
            localObject2 = this.eRD;
            if (localObject2 == null) {
              j.ebi();
            }
            ((MediaCodec)localObject2).queueInputBuffer(i, 0, 0, l, 4);
          }
        }
        UE();
      }
      AppMethodBeat.o(12862);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder$Companion;", "", "()V", "DECODE_TIMEOUT", "", "TIMEOUT", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.c.e
 * JD-Core Version:    0.7.0.1
 */