package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.byd;

public final class b
  implements i, e
{
  private com.tencent.mm.plugin.box.c.b plU;
  public com.tencent.mm.plugin.box.b.a plV;
  
  public b(com.tencent.mm.plugin.box.c.b paramb)
  {
    AppMethodBeat.i(76341);
    this.plU = paramb;
    g.azz().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void fc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.plV != null) {
      g.azz().a(this.plV);
    }
    this.plV = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    g.azz().a(this.plV, 0);
    com.tencent.mm.plugin.box.a.a.pl(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(76342);
    if (paramq.equals(this.plV))
    {
      this.plU.cla().f(this.plV.dPI, paramInt2, paramString, this.plV.plN.KWF);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.pl(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.pl(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */