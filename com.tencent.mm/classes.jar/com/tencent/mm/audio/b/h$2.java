package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class h$2
  implements MTimerHandler.CallBack
{
  h$2(h paramh) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(236220);
    s.a(h.c(this.hxB), this.hxB);
    o.bPh().run();
    Log.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.c(this.hxB));
    AppMethodBeat.o(236220);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.2
 * JD-Core Version:    0.7.0.1
 */