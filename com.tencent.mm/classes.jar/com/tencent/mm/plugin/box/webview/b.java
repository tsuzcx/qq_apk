package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.protocal.protobuf.cwa;

public final class b
  implements com.tencent.mm.am.h, e
{
  private com.tencent.mm.plugin.box.c.b vAk;
  public com.tencent.mm.plugin.box.b.a vAl;
  
  public b(com.tencent.mm.plugin.box.c.b paramb)
  {
    AppMethodBeat.i(76341);
    this.vAk = paramb;
    com.tencent.mm.kernel.h.aZW().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void fH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.vAl != null) {
      com.tencent.mm.kernel.h.aZW().a(this.vAl);
    }
    this.vAl = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    com.tencent.mm.kernel.h.aZW().a(this.vAl, 0);
    com.tencent.mm.plugin.box.a.a.rG(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(76342);
    if (paramp.equals(this.vAl))
    {
      this.vAk.dbn().c(this.vAl.hOG, paramInt2, paramString, this.vAl.vAd.YVP);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.rG(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.rG(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */