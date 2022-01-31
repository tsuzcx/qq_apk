package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends b
{
  private o nPY = null;
  private int nPZ = 0;
  
  public final void b(c paramc)
  {
    boolean bool = true;
    AppMethodBeat.i(21912);
    if (paramc == null) {}
    for (;;)
    {
      ab.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.nMs != null)
      {
        this.nPZ = this.nMs.nNj;
        this.nPY = new o(this.nMs.nMZ, this.nMs.nNa, this.nMs.bJD(), this.nMs.nNb, false);
        aw.Rc().a(this.nPY, 0);
      }
      AppMethodBeat.o(21912);
      return;
      bool = false;
    }
  }
  
  public final int bJA()
  {
    return this.nPZ;
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(21913);
    ab.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    AppMethodBeat.o(21913);
  }
  
  public final void bJC()
  {
    AppMethodBeat.i(21914);
    ab.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    AppMethodBeat.o(21914);
  }
  
  public final int[] bJz()
  {
    return new int[] { 819 };
  }
  
  public final int getServiceType()
  {
    return 2;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(21911);
    if (this.nPY != null) {
      aw.Rc().a(this.nPY);
    }
    AppMethodBeat.o(21911);
  }
  
  public final void tW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.i
 * JD-Core Version:    0.7.0.1
 */