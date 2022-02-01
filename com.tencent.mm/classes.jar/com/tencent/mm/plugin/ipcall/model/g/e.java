package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.ipcall.model.h.a;
import com.tencent.mm.protocal.protobuf.cnt;

public final class e
  extends com.tencent.mm.plugin.ipcall.model.b.a
  implements h.a
{
  private h uZY = null;
  
  public final void Dg()
  {
    AppMethodBeat.i(25520);
    this.uZY = new h();
    this.uZY.uWA = this;
    com.tencent.mm.sdk.b.a.IvT.c(this.uZY);
    AppMethodBeat.o(25520);
  }
  
  public final void a(cnt paramcnt)
  {
    AppMethodBeat.i(25522);
    this.uXd.a(8, paramcnt, 0, 0);
    AppMethodBeat.o(25522);
  }
  
  public final void b(c paramc) {}
  
  public final int[] dgL()
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
    com.tencent.mm.sdk.b.a.IvT.d(this.uZY);
    AppMethodBeat.o(25521);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.e
 * JD-Core Version:    0.7.0.1
 */