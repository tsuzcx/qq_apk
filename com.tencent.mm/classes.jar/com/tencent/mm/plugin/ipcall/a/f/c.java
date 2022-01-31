package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.h;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends b
{
  private h lsz;
  
  public final int LW()
  {
    return 5;
  }
  
  public final void b(com.tencent.mm.plugin.ipcall.a.a.c paramc)
  {
    if (this.loW != null)
    {
      this.lsz = new h(this.loW.lpD, this.loW.lpE, this.loW.lpF);
      au.Dk().a(this.lsz, 0);
    }
  }
  
  public final int[] bcs()
  {
    return new int[] { 824 };
  }
  
  public final int bct()
  {
    return 50000;
  }
  
  public final void bcu()
  {
    y.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
  }
  
  public final void bcv()
  {
    y.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    if (this.lsz != null) {
      au.Dk().c(this.lsz);
    }
  }
  
  public final void pT() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.c
 * JD-Core Version:    0.7.0.1
 */