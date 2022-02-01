package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.e.g;

public final class b
{
  private static b uOi;
  private g uOj;
  
  public static b dei()
  {
    AppMethodBeat.i(25513);
    if (uOi == null) {
      uOi = new b();
    }
    b localb = uOi;
    AppMethodBeat.o(25513);
    return localb;
  }
  
  public final void nL(boolean paramBoolean)
  {
    AppMethodBeat.i(25514);
    ba.aiU().a(this.uOj);
    this.uOj = null;
    if (paramBoolean) {}
    for (this.uOj = new g(1);; this.uOj = new g(0))
    {
      ba.aiU().a(this.uOj, 0);
      AppMethodBeat.o(25514);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.b
 * JD-Core Version:    0.7.0.1
 */