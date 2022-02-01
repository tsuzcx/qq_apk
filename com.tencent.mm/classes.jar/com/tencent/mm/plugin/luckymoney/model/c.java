package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adg;

public final class c
  extends com.tencent.mm.ak.c<adg>
{
  public c(String paramString)
  {
    AppMethodBeat.i(65162);
    adf localadf = new adf();
    localadf.Lot = paramString;
    paramString = new d.a();
    paramString.iLN = localadf;
    paramString.iLO = new adg();
    int i;
    if (((b)g.af(b.class)).a(b.a.skv, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 732;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/deleteshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource")
    {
      c(paramString.aXF());
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
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.c
 * JD-Core Version:    0.7.0.1
 */