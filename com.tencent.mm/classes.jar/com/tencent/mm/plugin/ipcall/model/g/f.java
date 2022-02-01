package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.k;

public final class f
  extends a
{
  public final void Dg() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25523);
    if (paramc != null)
    {
      paramc = new k(paramc.roomId, paramc.uXg, paramc.uXh);
      bc.ajj().a(paramc, 0);
    }
    AppMethodBeat.o(25523);
  }
  
  public final int[] dgL()
  {
    return new int[] { 726 };
  }
  
  public final int getServiceType()
  {
    return 6;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.f
 * JD-Core Version:    0.7.0.1
 */