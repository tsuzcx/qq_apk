package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class i$3
  implements ap.a
{
  i$3(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116521);
    ab.d("MicroMsg.SceneVoiceService", "onTimerExpired");
    i.h(this.ckT);
    AppMethodBeat.o(116521);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(116522);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(116522);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.b.i.3
 * JD-Core Version:    0.7.0.1
 */