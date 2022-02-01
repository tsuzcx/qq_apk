package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class j
  extends f
{
  public static final a kTD;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private volatile boolean kTv;
  
  static
  {
    AppMethodBeat.i(93548);
    kTD = new a((byte)0);
    AppMethodBeat.o(93548);
  }
  
  public j(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean, b<? super f, x> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt, paramBoolean);
    AppMethodBeat.i(258990);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.TAG = "MicroMsg.MediaCodecTransDecoder";
    try
    {
      this.mediaFormat = parama.kUV;
      this.kSN = aa.KR(parama.aUI());
      parama = this.kSN;
      if (parama == null) {
        p.iCn();
      }
      parama.a(this.mediaFormat, paramSurface, 0);
      parama = this.kSN;
      if (parama == null) {
        p.iCn();
      }
      parama.start();
      if (paramb != null)
      {
        paramb.invoke(this);
        AppMethodBeat.o(258990);
        return;
      }
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(258990);
      throw parama;
    }
    AppMethodBeat.o(258990);
  }
  
  private final boolean aUu()
  {
    AppMethodBeat.i(93545);
    long l1;
    Object localObject2;
    try
    {
      synchronized (aUq())
      {
        if (this.isFinished) {
          Log.i(this.TAG, "inputDecoder already finished");
        }
        x localx = x.aazN;
        Log.i(this.TAG, "inputDecoder");
        l1 = Util.currentTicks();
        ??? = this.kSN;
        if (??? == null) {
          p.iCn();
        }
        ??? = ((aa)???).avj();
        if (??? == null)
        {
          AppMethodBeat.o(93545);
          return false;
        }
      }
      localObject4 = this.kSN;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "inputDecoder error", new Object[0]);
      if (this.kTl)
      {
        localObject2 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXo();
      }
      AppMethodBeat.o(93545);
      return true;
    }
    Object localObject4;
    if (localObject4 == null) {
      p.iCn();
    }
    int i = ((aa)localObject4).EX(60000L);
    int j = 0;
    while ((i < 0) && (j < 15))
    {
      if (aUv())
      {
        AppMethodBeat.o(93545);
        return true;
      }
      localObject4 = this.kSN;
      if (localObject4 == null) {
        p.iCn();
      }
      i = ((aa)localObject4).EX(60000L);
      j += 1;
    }
    this.kTv = false;
    long l2;
    int k;
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      localObject4 = aUp();
      if (localObject4 == null) {
        p.iCn();
      }
      p.j(localObject2, "inputBuffer");
      if (!com.tencent.mm.media.f.a.a((com.tencent.mm.media.f.a)localObject4, (ByteBuffer)localObject2))
      {
        Log.i(this.TAG, "read sample end");
        AppMethodBeat.o(93545);
        return true;
      }
      l2 = aUp().getSampleTime();
      k = aUp().sampleSize;
      ((ByteBuffer)localObject2).position(0);
      Log.i(this.TAG, "sampleTime : " + l2 + " us");
      if ((k < 0) || (l2 >= this.endTimeMs * 1000L))
      {
        this.kTv = true;
        Log.i(this.TAG, "sawInputEOS");
      }
      localObject2 = this.kSN;
      if (localObject2 == null) {
        p.iCn();
      }
      if (!this.kTv) {
        break label490;
      }
    }
    label490:
    for (j = 4;; j = 0)
    {
      ((aa)localObject2).a(i, k, l2, j);
      for (;;)
      {
        bool = aUv();
        Log.i(this.TAG, "inputDecoder cost " + Util.ticksToNow(l1));
        if (!bool) {
          break;
        }
        Log.i(this.TAG, "drainDecoder eos");
        AppMethodBeat.o(93545);
        return true;
        Log.w(this.TAG, "input buffer not available");
      }
      boolean bool = this.kTv;
      AppMethodBeat.o(93545);
      return bool;
    }
  }
  
  private final boolean aUv()
  {
    AppMethodBeat.i(93546);
    for (;;)
    {
      try
      {
        Log.i(this.TAG, "drainDecoder");
        synchronized (aUq())
        {
          if (this.isFinished) {
            Log.i(this.TAG, "drainDecoder already finished");
          }
          x localx = x.aazN;
          ??? = this.kSN;
          if (??? == null) {
            p.iCn();
          }
          i = ((aa)???).a(this.bufferInfo, 100L);
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
        if (this.kTl)
        {
          localObject2 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aXo();
        }
        AppMethodBeat.o(93546);
        return false;
      }
      Log.i(this.TAG, "decoder output buffers changed");
      continue;
      label177:
      if (i == -2)
      {
        localObject2 = this.kSN;
        if (localObject2 == null) {
          p.iCn();
        }
        this.mediaFormat = ((aa)localObject2).avi();
        Log.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
        localObject2 = this.mediaFormat;
        if (localObject2 != null)
        {
          b localb = this.kTe;
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
          localObject2 = this.kSN;
          if (localObject2 == null) {
            p.iCn();
          }
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
      }
      try
      {
        localObject2 = this.kSN;
        if (localObject2 == null) {
          p.iCn();
        }
        ((aa)localObject2).stop();
        localObject2 = this.kSN;
        if (localObject2 == null) {
          p.iCn();
        }
        ((aa)localObject2).release();
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
      Object localObject2 = this.kSN;
      if (localObject2 == null) {
        p.iCn();
      }
      ((aa)localObject2).releaseOutputBuffer(i, false);
      localObject2 = this.kSN;
      if (localObject2 == null) {
        p.iCn();
      }
      j = ((aa)localObject2).a(this.bufferInfo, 100L);
      int i = j;
      if (j >= 0) {}
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93544);
    while (!aUu()) {}
    Log.i(this.TAG, "inputDecoder end");
    try
    {
      int i;
      synchronized (aUq())
      {
        if (this.isFinished) {
          Log.i(this.TAG, "drainDecoder already finished");
        }
        Object localObject3 = x.aazN;
        Log.i(this.TAG, "sendDecoderEOS");
        ??? = this.kSN;
        if (??? == null) {
          p.iCn();
        }
        ??? = ((aa)???).avj();
        localObject3 = this.kSN;
        if (localObject3 == null) {
          p.iCn();
        }
        i = ((aa)localObject3).EX(60000L);
        if (i < 0) {
          if (!aUv())
          {
            localObject3 = this.kSN;
            if (localObject3 == null) {
              p.iCn();
            }
            i = ((aa)localObject3).EX(60000L);
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
        localObject2 = this.kTd;
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
          locala = aUp();
          if (locala == null) {
            p.iCn();
          }
          p.j(localObject2, "inputBuffer");
          com.tencent.mm.media.f.a.a(locala, (ByteBuffer)localObject2);
          l = aUp().getSampleTime();
          ((ByteBuffer)localObject2).position(0);
          if (i >= 0)
          {
            localObject2 = this.kSN;
            if (localObject2 == null) {
              p.iCn();
            }
            ((aa)localObject2).a(i, 0, l, 4);
          }
        }
        aUv();
      }
      AppMethodBeat.o(93544);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder$Companion;", "", "()V", "DECODE_TIMEOUT", "", "TIMEOUT", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.j
 * JD-Core Version:    0.7.0.1
 */