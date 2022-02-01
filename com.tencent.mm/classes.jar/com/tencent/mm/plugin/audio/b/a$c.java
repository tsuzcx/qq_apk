package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$c
  implements Runnable
{
  a$c(a parama, int paramInt, d.g.a.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(189226);
    this.mpi.audioManager.setMode(this.mpj);
    d.g.a.a locala = this.mpk;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(189226);
      return;
    }
    AppMethodBeat.o(189226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a.c
 * JD-Core Version:    0.7.0.1
 */