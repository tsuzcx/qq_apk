package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bwv;

final class d$6
  implements Runnable
{
  d$6(d paramd, com.tencent.mm.plugin.appbrand.i parami, String paramString1, String paramString2, bwv parambwv, String paramString3, String paramString4, axt paramaxt, boolean paramBoolean, a.e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(102253);
    if (this.gWQ.atj() == null)
    {
      AppMethodBeat.o(102253);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.b.i locali = new com.tencent.mm.plugin.appbrand.widget.b.i(this.gWQ.atj().getContext(), new d.6.1(this));
    locali.FG(this.gWQ.wY().cqQ);
    locali.FJ(this.iBy);
    locali.FH(this.iBz.Desc);
    locali.FK(this.iBA);
    locali.FL(this.iBB);
    locali.ka(this.iBC.wnz);
    if (this.iBD) {
      locali.FI(this.iBE.desc);
    }
    this.gWQ.gPE.b(locali);
    AppMethodBeat.o(102253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.6
 * JD-Core Version:    0.7.0.1
 */