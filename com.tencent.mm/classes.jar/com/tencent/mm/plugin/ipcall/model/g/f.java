package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.k;

public final class f
  extends a
{
  public final void MC() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25523);
    if (paramc != null)
    {
      paramc = new k(paramc.roomId, paramc.ypH, paramc.ypI);
      bg.azz().a(paramc, 0);
    }
    AppMethodBeat.o(25523);
  }
  
  public final int[] eaF()
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