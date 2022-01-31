package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(116496);
    if (!h.k(this.ckE))
    {
      ab.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
      h.l(this.ckE);
      AppMethodBeat.o(116496);
      return;
    }
    ab.e("MicroMsg.SceneVoice.Recorder", "mHasBeginRec is true");
    AppMethodBeat.o(116496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.h.2
 * JD-Core Version:    0.7.0.1
 */