package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aay;

public final class b
  extends a<aay>
{
  public b(String paramString)
  {
    AppMethodBeat.i(65162);
    aax localaax = new aax();
    localaax.Gat = paramString;
    paramString = new com.tencent.mm.al.b.a();
    paramString.hNM = localaax;
    paramString.hNN = new aay();
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFT, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 732;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/deleteshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource")
    {
      c(paramString.aDC());
      AppMethodBeat.o(65162);
      return;
      i = 0;
      break;
      label105:
      paramString.funcId = 2665;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.b
 * JD-Core Version:    0.7.0.1
 */