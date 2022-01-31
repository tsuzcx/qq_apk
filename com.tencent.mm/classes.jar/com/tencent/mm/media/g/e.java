package com.tencent.mm.media.g;

import a.f.a.q;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckHasBFrame;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "CheckMaxThreshold", "", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasBFrame", "", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "initPts", "", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Landroid/media/MediaCodec$BufferInfo;", "onDecodeEnd", "Lkotlin/Function0;", "startCheckTick", "timeoutChecker", "Ljava/lang/Runnable;", "startCheck", "stopDecoder", "result", "plugin-mediaeditor_release"})
public final class e
{
  final String TAG;
  final a.f.a.a<y> eRU;
  Runnable eWA;
  final q<ByteBuffer, Long, MediaCodec.BufferInfo, y> eWB;
  final com.tencent.mm.media.e.a eWC;
  com.tencent.mm.media.c.b eWv;
  volatile boolean eWw;
  long eWx;
  final int eWy;
  long eWz;
  volatile a.f.a.b<? super Boolean, y> evv;
  final ak handler;
  final Object lock;
  
  public e(com.tencent.mm.media.e.a parama)
  {
    AppMethodBeat.i(154813);
    this.eWC = parama;
    this.lock = new Object();
    this.eWx = -1L;
    this.TAG = "MicroMsg.MediaCodecCheckHasBFrame";
    this.eWy = 1000000;
    this.eWz = -1L;
    this.eWA = ((Runnable)new e.f(this));
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new ak(parama);
    ab.i(this.TAG, "create MediaCodecCheckHasBFrame, looper:".concat(String.valueOf(parama)));
    this.eWC.UT();
    this.eWB = ((q)new e.a(this));
    this.eRU = ((a.f.a.a)new e.b(this));
    AppMethodBeat.o(154813);
  }
  
  final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(156657);
    ab.i(this.TAG, "stopDecoder");
    this.eWw = true;
    Object localObject = this.eWv;
    if (localObject != null) {
      ((com.tencent.mm.media.c.b)localObject).pJ();
    }
    this.handler.removeCallbacks(this.eWA);
    localObject = this.evv;
    if (localObject != null) {
      ((a.f.a.b)localObject).S(Boolean.valueOf(paramBoolean));
    }
    this.evv = null;
    AppMethodBeat.o(156657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.e
 * JD-Core Version:    0.7.0.1
 */