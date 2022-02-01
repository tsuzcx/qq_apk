package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.protocal.protobuf.bls;

public final class b
  implements f, e
{
  private c oaX;
  public com.tencent.mm.plugin.box.b.a oaY;
  
  public b(c paramc)
  {
    AppMethodBeat.i(76341);
    this.oaX = paramc;
    g.ajj().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.oaY != null) {
      g.ajj().a(this.oaY);
    }
    this.oaY = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    g.ajj().a(this.oaY, 0);
    com.tencent.mm.plugin.box.a.a.md(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(76342);
    if (paramn.equals(this.oaY))
    {
      this.oaX.bNZ().f(this.oaY.dyb, paramInt2, paramString, this.oaY.oaQ.GcA);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.md(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.md(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */