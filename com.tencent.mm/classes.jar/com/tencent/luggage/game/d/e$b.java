package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$b
  implements Runnable
{
  private d bAB;
  private e.c bAF;
  
  public final void run()
  {
    AppMethodBeat.i(140400);
    if (this.bAB == null)
    {
      AppMethodBeat.o(140400);
      return;
    }
    if (this.bAF != null) {
      this.bAF.release(this);
    }
    AppMethodBeat.o(140400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.game.d.e.b
 * JD-Core Version:    0.7.0.1
 */