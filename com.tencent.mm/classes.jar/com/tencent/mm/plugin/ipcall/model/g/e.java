package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.ipcall.model.h.a;
import com.tencent.mm.protocal.protobuf.chz;

public final class e
  extends com.tencent.mm.plugin.ipcall.model.b.a
  implements h.a
{
  private h tLy = null;
  
  public final void BE()
  {
    AppMethodBeat.i(25520);
    this.tLy = new h();
    this.tLy.tIa = this;
    com.tencent.mm.sdk.b.a.GpY.c(this.tLy);
    AppMethodBeat.o(25520);
  }
  
  public final void a(chz paramchz)
  {
    AppMethodBeat.i(25522);
    this.tID.a(8, paramchz, 0, 0);
    AppMethodBeat.o(25522);
  }
  
  public final void b(c paramc) {}
  
  public final int[] cUI()
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
    com.tencent.mm.sdk.b.a.GpY.d(this.tLy);
    AppMethodBeat.o(25521);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g.e
 * JD-Core Version:    0.7.0.1
 */