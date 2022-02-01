package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a<bjf>
{
  public c(String paramString)
  {
    AppMethodBeat.i(65163);
    bje localbje = new bje();
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.hQF = localbje;
    locala.hQG = new bjf();
    boolean bool;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNz, 1) == 1)
    {
      bool = true;
      ae.d("CgiGetShowSource", "is new: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label129;
      }
      locala.funcId = 3857;
    }
    for (locala.uri = "/cgi-bin/micromsg-bin/getshowsourcenew";; locala.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource")
    {
      localbje.GWJ = paramString;
      c(locala.aDS());
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