package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.g;

public final class b
{
  private static b nPS;
  private g nPT;
  
  public static b bJQ()
  {
    AppMethodBeat.i(21898);
    if (nPS == null) {
      nPS = new b();
    }
    b localb = nPS;
    AppMethodBeat.o(21898);
    return localb;
  }
  
  public final void iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(21899);
    aw.Rc().a(this.nPT);
    this.nPT = null;
    if (paramBoolean) {}
    for (this.nPT = new g(1);; this.nPT = new g(0))
    {
      aw.Rc().a(this.nPT, 0);
      AppMethodBeat.o(21899);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.b
 * JD-Core Version:    0.7.0.1
 */