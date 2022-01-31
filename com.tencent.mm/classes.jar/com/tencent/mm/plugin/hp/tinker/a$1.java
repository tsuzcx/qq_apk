package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements Runnable
{
  a$1(a parama, a.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(90624);
    if (this.nKC != null)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
      this.nKC.bIk();
    }
    AppMethodBeat.o(90624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.a.1
 * JD-Core Version:    0.7.0.1
 */