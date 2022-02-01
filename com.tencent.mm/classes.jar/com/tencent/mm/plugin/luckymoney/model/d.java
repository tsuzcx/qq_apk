package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends c<bvi>
{
  public d(String paramString)
  {
    AppMethodBeat.i(65163);
    bvh localbvh = new bvh();
    d.a locala = new d.a();
    locala.iLN = localbvh;
    locala.iLO = new bvi();
    boolean bool;
    if (((b)g.af(b.class)).a(b.a.skv, 1) == 1)
    {
      bool = true;
      Log.d("CgiGetShowSource", "is new: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label129;
      }
      locala.funcId = 3857;
    }
    for (locala.uri = "/cgi-bin/micromsg-bin/getshowsourcenew";; locala.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource")
    {
      localbvh.Mbr = paramString;
      c(locala.aXF());
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
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */