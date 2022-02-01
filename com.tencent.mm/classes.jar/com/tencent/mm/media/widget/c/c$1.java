package com.tencent.mm.media.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.a.k;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(205893);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
    this.gCX.gCs.tFa = d.c.tDQ;
    com.tencent.mm.media.h.a locala = c.a(this.gCX);
    c.1.1 local1 = new c.1.1(this);
    k.h(local1, "callback");
    locala.i((d.g.a.a)new a.k(local1));
    AppMethodBeat.o(205893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.1
 * JD-Core Version:    0.7.0.1
 */