package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b DSx;
  private g DSy;
  
  public static b eJS()
  {
    AppMethodBeat.i(25513);
    if (DSx == null) {
      DSx = new b();
    }
    b localb = DSx;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    bh.aGY().a(this.DSy);
    this.DSy = null;
    if (paramBoolean) {}
    for (this.DSy = new g(1);; this.DSy = new g(0))
    {
      bh.aGY().a(this.DSy, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */