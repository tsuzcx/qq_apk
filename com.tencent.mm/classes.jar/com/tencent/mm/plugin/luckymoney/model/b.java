package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.protocal.protobuf.yd;

public final class b
  extends c<yd>
{
  public b(String paramString)
  {
    AppMethodBeat.i(65162);
    yc localyc = new yc();
    localyc.Daf = paramString;
    paramString = new com.tencent.mm.al.b.a();
    paramString.gUU = localyc;
    paramString.gUV = new yd();
    int i;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwj, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 732;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/deleteshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource")
    {
      this.rr = paramString.atI();
      AppMethodBeat.o(65162);
      return;
      i = 0;
      break;
      label105:
      paramString.funcId = 2665;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.b
 * JD-Core Version:    0.7.0.1
 */