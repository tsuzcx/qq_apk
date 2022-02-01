package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends b
{
  private h uOk;
  
  public final void Dd() {}
  
  public final void b(com.tencent.mm.plugin.ipcall.model.b.c paramc)
  {
    AppMethodBeat.i(25516);
    if (this.uKI != null)
    {
      this.uOk = new h(this.uKI.roomId, this.uKI.uLt, this.uKI.uLu);
      ba.aiU().a(this.uOk, 0);
    }
    AppMethodBeat.o(25516);
  }
  
  public final int[] ddT()
  {
    return new int[] { 824 };
  }
  
  public final void ddU()
  {
    AppMethodBeat.i(25517);
    ad.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    AppMethodBeat.o(25517);
  }
  
  public final void ddV()
  {
    AppMethodBeat.i(25518);
    ad.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
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
    if (this.uOk != null) {
      ba.aiU().a(this.uOk);
    }
    AppMethodBeat.o(25515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.c
 * JD-Core Version:    0.7.0.1
 */