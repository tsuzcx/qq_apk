package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;

public final class a
  extends c<yy>
{
  public a(String paramString)
  {
    AppMethodBeat.i(65161);
    yx localyx = new yx();
    localyx.Etc = paramString;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.hvt = localyx;
    paramString.hvu = new yy();
    int i;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qax, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 479;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/confirmshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource")
    {
      this.rr = paramString.aAz();
      AppMethodBeat.o(65161);
      return;
      i = 0;
      break;
      label105:
      paramString.funcId = 2968;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a
 * JD-Core Version:    0.7.0.1
 */