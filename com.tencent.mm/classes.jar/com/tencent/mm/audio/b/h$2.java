package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;

final class h$2
  implements au.a
{
  h$2(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(209457);
    s.a(h.c(this.cWT), this.cWT);
    o.aKr().run();
    ac.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.c(this.cWT));
    AppMethodBeat.o(209457);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.2
 * JD-Core Version:    0.7.0.1
 */