package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.al.c<bap>
{
  public c(String paramString)
  {
    AppMethodBeat.i(65163);
    bao localbao = new bao();
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.gUU = localbao;
    locala.gUV = new bap();
    boolean bool;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwj, 1) == 1)
    {
      bool = true;
      ad.d("CgiGetShowSource", "is new: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label129;
      }
      locala.funcId = 3857;
    }
    for (locala.uri = "/cgi-bin/micromsg-bin/getshowsourcenew";; locala.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource")
    {
      localbao.Dyq = paramString;
      this.rr = locala.atI();
      AppMethodBeat.o(65163);
      return;
      bool = false;
      break;
      label129:
      locala.funcId = 2620;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.c
 * JD-Core Version:    0.7.0.1
 */