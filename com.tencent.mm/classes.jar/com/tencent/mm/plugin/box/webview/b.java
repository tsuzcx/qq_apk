package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cfx;

public final class b
  implements i, e
{
  private com.tencent.mm.plugin.box.c.b som;
  public com.tencent.mm.plugin.box.b.a son;
  
  public b(com.tencent.mm.plugin.box.c.b paramb)
  {
    AppMethodBeat.i(76341);
    this.som = paramb;
    h.aGY().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.son != null) {
      h.aGY().a(this.son);
    }
    this.son = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    h.aGY().a(this.son, 0);
    com.tencent.mm.plugin.box.a.a.rE(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(76342);
    if (paramq.equals(this.son))
    {
      this.som.cyw().g(this.son.fIY, paramInt2, paramString, this.son.sof.RXT);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.rE(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.rE(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */