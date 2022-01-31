package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends b
{
  private h nPU;
  
  public final void b(com.tencent.mm.plugin.ipcall.a.a.c paramc)
  {
    AppMethodBeat.i(21901);
    if (this.nMs != null)
    {
      this.nPU = new h(this.nMs.nMZ, this.nMs.nNa, this.nMs.nNb);
      aw.Rc().a(this.nPU, 0);
    }
    AppMethodBeat.o(21901);
  }
  
  public final int bJA()
  {
    return 50000;
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(21902);
    ab.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    AppMethodBeat.o(21902);
  }
  
  public final void bJC()
  {
    AppMethodBeat.i(21903);
    ab.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    AppMethodBeat.o(21903);
  }
  
  public final int[] bJz()
  {
    return new int[] { 824 };
  }
  
  public final int getServiceType()
  {
    return 5;
  }
  
  public final void onDestroy() {}
  
  public final void onStop()
  {
    AppMethodBeat.i(21900);
    if (this.nPU != null) {
      aw.Rc().a(this.nPU);
    }
    AppMethodBeat.o(21900);
  }
  
  public final void tW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.c
 * JD-Core Version:    0.7.0.1
 */