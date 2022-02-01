package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.protocal.protobuf.bgs;

public final class b
  implements com.tencent.mm.ak.g, e
{
  private c nua;
  public com.tencent.mm.plugin.box.b.a nub;
  
  public b(c paramc)
  {
    AppMethodBeat.i(76341);
    this.nua = paramc;
    com.tencent.mm.kernel.g.agi().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.nub != null) {
      com.tencent.mm.kernel.g.agi().a(this.nub);
    }
    this.nub = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    com.tencent.mm.kernel.g.agi().a(this.nub, 0);
    com.tencent.mm.plugin.box.a.a.lA(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(76342);
    if (paramn.equals(this.nub))
    {
      this.nua.bIL().f(this.nub.dlj, paramInt2, paramString, this.nub.ntT.EVM);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.lA(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.lA(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */