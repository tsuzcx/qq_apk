package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.k;

public final class f
  extends a
{
  public final void Ca() {}
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(25523);
    if (paramc != null)
    {
      paramc = new k(paramc.roomId, paramc.sAY, paramc.sAZ);
      az.aeS().a(paramc, 0);
    }
    AppMethodBeat.o(25523);
  }
  
  public final int[] cHx()
  {
    return new int[] { 726 };
  }
  
  public final int getServiceType()
  {
    return 6;
  }
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.f
 * JD-Core Version:    0.7.0.1
 */