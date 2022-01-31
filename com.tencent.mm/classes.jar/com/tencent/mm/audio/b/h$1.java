package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class h$1
  implements ap.a
{
  h$1(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116495);
    s.a(h.a(this.ckE), this.ckE);
    o.amu().run();
    ab.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.a(this.ckE));
    AppMethodBeat.o(116495);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.1
 * JD-Core Version:    0.7.0.1
 */