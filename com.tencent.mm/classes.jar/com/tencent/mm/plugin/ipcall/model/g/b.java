package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b sDN;
  private g sDO;
  
  public static b cHM()
  {
    AppMethodBeat.i(25513);
    if (sDN == null) {
      sDN = new b();
    }
    b localb = sDN;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void my(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    az.aeS().a(this.sDO);
    this.sDO = null;
    if (paramBoolean) {}
    for (this.sDO = new g(1);; this.sDO = new g(0))
    {
      az.aeS().a(this.sDO, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */