package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends b
{
  private o lsD = null;
  private int lsE = 0;
  
  public final int LW()
  {
    return 2;
  }
  
  public final void b(c paramc)
  {
    boolean bool = true;
    if (paramc == null) {}
    for (;;)
    {
      y.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.loW != null)
      {
        this.lsE = this.loW.lpN;
        this.lsD = new o(this.loW.lpD, this.loW.lpE, this.loW.bcw(), this.loW.lpF, false);
        au.Dk().a(this.lsD, 0);
      }
      return;
      bool = false;
    }
  }
  
  public final int[] bcs()
  {
    return new int[] { 819 };
  }
  
  public final int bct()
  {
    return this.lsE;
  }
  
  public final void bcu()
  {
    y.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
  }
  
  public final void bcv()
  {
    y.d("MicroMsg.IPCallSyncService", "onLoopFailed");
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    if (this.lsD != null) {
      au.Dk().c(this.lsD);
    }
  }
  
  public final void pT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.i
 * JD-Core Version:    0.7.0.1
 */