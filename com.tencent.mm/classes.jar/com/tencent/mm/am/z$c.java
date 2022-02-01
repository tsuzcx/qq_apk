package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;

final class z$c
  implements z.a, a
{
  private z.a ovp;
  
  public z$c(z.a parama)
  {
    this.ovp = parama;
  }
  
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(132488);
    if (this.ovp != null)
    {
      paramInt1 = this.ovp.callback(paramInt1, paramInt2, paramString, paramc, paramp);
      AppMethodBeat.o(132488);
      return paramInt1;
    }
    AppMethodBeat.o(132488);
    return -100000;
  }
  
  public final void dead()
  {
    this.ovp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.z.c
 * JD-Core Version:    0.7.0.1
 */