package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.protocal.protobuf.bla;

public final class b
  implements f, e
{
  private c nVq;
  public com.tencent.mm.plugin.box.b.a nVr;
  
  public b(c paramc)
  {
    AppMethodBeat.i(76341);
    this.nVq = paramc;
    g.aiU().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.nVr != null) {
      g.aiU().a(this.nVr);
    }
    this.nVr = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    g.aiU().a(this.nVr, 0);
    com.tencent.mm.plugin.box.a.a.ma(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(76342);
    if (paramn.equals(this.nVr))
    {
      this.nVq.bNb().f(this.nVr.dwW, paramInt2, paramString, this.nVr.nVj.FKb);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.ma(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.ma(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */