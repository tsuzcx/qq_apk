package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a<bip>
{
  public c(String paramString)
  {
    AppMethodBeat.i(65163);
    bio localbio = new bio();
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.hNM = localbio;
    locala.hNN = new bip();
    boolean bool;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFT, 1) == 1)
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
      localbio.GDj = paramString;
      c(locala.aDC());
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