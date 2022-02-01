package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.ipcall.model.h.a;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.event.EventCenter;

public final class e
  extends a
  implements h.a
{
  private h ysy = null;
  
  public final void MC()
  {
    AppMethodBeat.i(25520);
    this.ysy = new h();
    this.ysy.ypb = this;
    EventCenter.instance.addListener(this.ysy);
    AppMethodBeat.o(25520);
  }
  
  public final void a(dfn paramdfn)
  {
    AppMethodBeat.i(25522);
    this.ypE.a(8, paramdfn, 0, 0);
    AppMethodBeat.o(25522);
  }
  
  public final void b(c paramc) {}
  
  public final int[] eaF()
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
    EventCenter.instance.removeListener(this.ysy);
    AppMethodBeat.o(25521);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.e
 * JD-Core Version:    0.7.0.1
 */