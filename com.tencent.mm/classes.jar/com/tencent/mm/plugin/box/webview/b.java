package com.tencent.mm.plugin.box.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.protocal.protobuf.bda;

public final class b
  implements com.tencent.mm.al.g, e
{
  private c mRK;
  public com.tencent.mm.plugin.box.b.a mRL;
  
  public b(c paramc)
  {
    AppMethodBeat.i(76341);
    this.mRK = paramc;
    com.tencent.mm.kernel.g.aeS().a(1869, this);
    AppMethodBeat.o(76341);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76343);
    if (this.mRL != null) {
      com.tencent.mm.kernel.g.aeS().a(this.mRL);
    }
    this.mRL = new com.tencent.mm.plugin.box.b.a(paramString1, paramString2);
    com.tencent.mm.kernel.g.aeS().a(this.mRL, 0);
    com.tencent.mm.plugin.box.a.a.lI(2);
    AppMethodBeat.o(76343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(76342);
    if (paramn.equals(this.mRL))
    {
      this.mRK.bBN().d(this.mRL.dnB, paramInt2, paramString, this.mRL.mRD.DAq);
      if ((paramInt2 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.box.a.a.lI(3);
        AppMethodBeat.o(76342);
        return;
      }
      com.tencent.mm.plugin.box.a.a.lI(4);
    }
    AppMethodBeat.o(76342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.b
 * JD-Core Version:    0.7.0.1
 */