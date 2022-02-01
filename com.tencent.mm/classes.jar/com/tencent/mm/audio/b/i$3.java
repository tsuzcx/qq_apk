package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class i$3
  implements MTimerHandler.CallBack
{
  i$3(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(148356);
    Log.i("MicroMsg.SceneVoiceService", "onTimerExpired[%s]", new Object[] { this.dAL.toString() });
    i.h(this.dAL);
    AppMethodBeat.o(148356);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(148357);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(148357);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.i.3
 * JD-Core Version:    0.7.0.1
 */