package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b uZV;
  private g uZW;
  
  public static b dha()
  {
    AppMethodBeat.i(25513);
    if (uZV == null) {
      uZV = new b();
    }
    b localb = uZV;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    bc.ajj().a(this.uZW);
    this.uZW = null;
    if (paramBoolean) {}
    for (this.uZW = new g(1);; this.uZW = new g(0))
    {
      bc.ajj().a(this.uZW, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */