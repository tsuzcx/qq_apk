package com.tencent.luggage.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$d
  implements Runnable
{
  private d ctu;
  private e.e cty;
  
  public final void run()
  {
    AppMethodBeat.i(130522);
    if (this.ctu == null)
    {
      AppMethodBeat.o(130522);
      return;
    }
    if (this.cty != null) {
      this.cty.release(this);
    }
    AppMethodBeat.o(130522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.c.e.d
 * JD-Core Version:    0.7.0.1
 */