package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b tLv;
  private g tLw;
  
  public static b cUX()
  {
    AppMethodBeat.i(25513);
    if (tLv == null) {
      tLv = new b();
    }
    b localb = tLv;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void nr(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    az.agi().a(this.tLw);
    this.tLw = null;
    if (paramBoolean) {}
    for (this.tLw = new g(1);; this.tLw = new g(0))
    {
      az.agi().a(this.tLw, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */