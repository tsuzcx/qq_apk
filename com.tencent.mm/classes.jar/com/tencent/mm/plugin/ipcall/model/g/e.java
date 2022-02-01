package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.ipcall.model.h.a;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.sdk.event.EventCenter;

public final class e
  extends a
  implements h.a
{
  private h DSA = null;
  
  public final void Pu()
  {
    AppMethodBeat.i(25520);
    this.DSA = new h();
    this.DSA.DPd = this;
    EventCenter.instance.addListener(this.DSA);
    AppMethodBeat.o(25520);
  }
  
  public final void a(dph paramdph)
  {
    AppMethodBeat.i(25522);
    this.DPG.a(8, paramdph, 0, 0);
    AppMethodBeat.o(25522);
  }
  
  public final void b(c paramc) {}
  
  public final int[] eJD()
  {
    return new int[0];
  }
  
  public final int getServiceType()
  {
    return 8;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(25521);
    EventCenter.instance.removeListener(this.DSA);
    AppMethodBeat.o(25521);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.e
 * JD-Core Version:    0.7.0.1
 */