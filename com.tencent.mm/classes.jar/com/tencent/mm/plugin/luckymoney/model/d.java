package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends c<cda>
{
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(275871);
    ccz localccz = new ccz();
    d.a locala = new d.a();
    locala.lBU = localccz;
    locala.lBV = new cda();
    boolean bool;
    if (((b)h.ae(b.class)).a(b.a.vUS, 1) == 1)
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
      localccz.TkO = paramString;
      localccz.TkP = paramInt;
      c(locala.bgN());
      AppMethodBeat.o(275871);
      return;
      bool = false;
      break;
      label138:
      locala.funcId = 2620;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */