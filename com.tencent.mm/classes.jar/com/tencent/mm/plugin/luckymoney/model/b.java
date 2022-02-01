package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.wallet_core.model.z;

public final class b
  extends z<afv>
{
  public b(String paramString)
  {
    AppMethodBeat.i(65161);
    afu localafu = new afu();
    localafu.ZoK = paramString;
    paramString = new com.tencent.mm.am.c.a();
    paramString.otE = localafu;
    paramString.otF = new afv();
    int i;
    if (((c)h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znw, 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      paramString.funcId = 479;
    }
    for (paramString.uri = "/cgi-bin/micromsg-bin/confirmshowsourcenew";; paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource")
    {
      c(paramString.bEF());
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