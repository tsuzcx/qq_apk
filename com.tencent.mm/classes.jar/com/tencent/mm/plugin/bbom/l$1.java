package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.u;

final class l$1
  implements ao.b.a
{
  l$1(l paraml, u paramu, String paramString) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(18266);
    if ((this.eub != null) && (this.eub.dwp()))
    {
      paramString = new kq();
      paramString.cAD.chatroomName = this.fkI;
      paramString.cAD.cAE = this.eub.dwo();
      a.ymk.l(paramString);
    }
    AppMethodBeat.o(18266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.l.1
 * JD-Core Version:    0.7.0.1
 */