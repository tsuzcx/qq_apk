package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class h$2
  implements av.a
{
  h$2(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(189915);
    s.a(h.c(this.cZx), this.cZx);
    o.aDA().run();
    ad.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.c(this.cZx));
    AppMethodBeat.o(189915);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.2
 * JD-Core Version:    0.7.0.1
 */