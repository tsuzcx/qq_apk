package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aay;

public final class a
  extends com.tencent.mm.al.a<aay>
{
  public a(String paramString)
  {
    AppMethodBeat.i(65161);
    aax localaax = new aax();
    localaax.Gat = paramString;
    paramString = new com.tencent.mm.al.b.a();
    paramString.hNM = localaax;
    paramString.hNN = new aay();
    int i;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFT, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 479;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/confirmshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource")
    {
      c(paramString.aDC());
      AppMethodBeat.o(65161);
      return;
      i = 0;
      break;
      label105:
      paramString.funcId = 2968;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a
 * JD-Core Version:    0.7.0.1
 */