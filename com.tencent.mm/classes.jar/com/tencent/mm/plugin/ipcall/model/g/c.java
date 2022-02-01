package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends b
{
  private h ysx;
  
  public final void MC() {}
  
  public final void b(com.tencent.mm.plugin.ipcall.model.b.c paramc)
  {
    AppMethodBeat.i(25516);
    if (this.yoW != null)
    {
      this.ysx = new h(this.yoW.roomId, this.yoW.ypH, this.yoW.ypI);
      bg.azz().a(this.ysx, 0);
    }
    AppMethodBeat.o(25516);
  }
  
  public final int[] eaF()
  {
    return new int[] { 824 };
  }
  
  public final void eaG()
  {
    AppMethodBeat.i(25517);
    Log.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    AppMethodBeat.o(25517);
  }
  
  public final void eaH()
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
    if (this.ysx != null) {
      bg.azz().a(this.ysx);
    }
    AppMethodBeat.o(25515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.c
 * JD-Core Version:    0.7.0.1
 */