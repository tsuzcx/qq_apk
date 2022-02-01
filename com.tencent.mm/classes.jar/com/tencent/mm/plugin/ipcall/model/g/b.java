package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b JJH;
  private g JJI;
  
  public static b fRS()
  {
    AppMethodBeat.i(25513);
    if (JJH == null) {
      JJH = new b();
    }
    b localb = JJH;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void xL(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    bh.aZW().a(this.JJI);
    this.JJI = null;
    if (paramBoolean) {}
    for (this.JJI = new g(1);; this.JJI = new g(0))
    {
      bh.aZW().a(this.JJI, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */