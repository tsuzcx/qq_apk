package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.protocal.protobuf.abh;

public final class b
  extends a<abh>
{
  public b(String paramString)
  {
    AppMethodBeat.i(65162);
    abg localabg = new abg();
    localabg.Gta = paramString;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.hQF = localabg;
    paramString.hQG = new abh();
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNz, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 732;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/deleteshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource")
    {
      c(paramString.aDS());
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