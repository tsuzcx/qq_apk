package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class e
  extends z<csm>
{
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(283971);
    csl localcsl = new csl();
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = localcsl;
    locala.otF = new csm();
    boolean bool;
    if (((c)h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znw, 1) == 1)
    {
      bool = true;
      Log.d("CgiGetShowSource", "is new: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label138;
      }
      locala.funcId = 3857;
    }
    for (locala.uri = "/cgi-bin/micromsg-bin/getshowsourcenew";; locala.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource")
    {
      localcsl.aayv = paramString;
      localcsl.aayw = paramInt;
      c(locala.bEF());
      AppMethodBeat.o(283971);
      return;
      bool = false;
      break;
      label138:
      locala.funcId = 2620;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */