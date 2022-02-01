package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adg;

public final class b
  extends c<adg>
{
  public b(String paramString)
  {
    AppMethodBeat.i(65161);
    adf localadf = new adf();
    localadf.Lot = paramString;
    paramString = new d.a();
    paramString.iLN = localadf;
    paramString.iLO = new adg();
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skv, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 479;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/confirmshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource")
    {
      c(paramString.aXF());
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
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.b
 * JD-Core Version:    0.7.0.1
 */