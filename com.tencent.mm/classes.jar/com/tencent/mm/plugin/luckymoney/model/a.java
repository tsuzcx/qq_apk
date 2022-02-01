package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.protocal.protobuf.abh;

public final class a
  extends com.tencent.mm.ak.a<abh>
{
  public a(String paramString)
  {
    AppMethodBeat.i(65161);
    abg localabg = new abg();
    localabg.Gta = paramString;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.hQF = localabg;
    paramString.hQG = new abh();
    int i;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNz, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 479;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/confirmshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource")
    {
      c(paramString.aDS());
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