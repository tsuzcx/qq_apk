package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends b
{
  private h JJJ;
  
  public final void apC() {}
  
  public final void b(com.tencent.mm.plugin.ipcall.model.b.c paramc)
  {
    AppMethodBeat.i(25516);
    if (this.JGn != null)
    {
      this.JJJ = new h(this.JGn.roomId, this.JGn.Hnt, this.JGn.JGV);
      bh.aZW().a(this.JJJ, 0);
    }
    AppMethodBeat.o(25516);
  }
  
  public final int[] fRD()
  {
    return new int[] { 824 };
  }
  
  public final boolean fRE()
  {
    return false;
  }
  
  public final void fRF()
  {
    AppMethodBeat.i(25517);
    Log.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    AppMethodBeat.o(25517);
  }
  
  public final void fRG()
  {
    AppMethodBeat.i(25518);
    Log.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    AppMethodBeat.o(25518);
  }
  
  public final int getServiceType()
  {
    return 5;
  }
  
  public final int getTimerInterval()
  {
    return 50000;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(25515);
    if (this.JJJ != null) {
      bh.aZW().a(this.JJJ);
    }
    AppMethodBeat.o(25515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.c
 * JD-Core Version:    0.7.0.1
 */