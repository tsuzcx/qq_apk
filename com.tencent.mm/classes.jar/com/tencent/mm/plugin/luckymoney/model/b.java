package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;

public final class b
  extends c<yy>
{
  public b(String paramString)
  {
    AppMethodBeat.i(65162);
    yx localyx = new yx();
    localyx.Etc = paramString;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.hvt = localyx;
    paramString.hvu = new yy();
    int i;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qax, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 732;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/deleteshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource")
    {
      this.rr = paramString.aAz();
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