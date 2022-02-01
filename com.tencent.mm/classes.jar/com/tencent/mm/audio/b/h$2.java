package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;

final class h$2
  implements aw.a
{
  h$2(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(200152);
    s.a(h.c(this.djm), this.djm);
    o.aNY().run();
    ae.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.c(this.djm));
    AppMethodBeat.o(200152);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.2
 * JD-Core Version:    0.7.0.1
 */