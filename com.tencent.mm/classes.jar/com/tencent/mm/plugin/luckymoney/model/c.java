package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends com.tencent.mm.ak.c<beh>
{
  public c(String paramString)
  {
    AppMethodBeat.i(65163);
    beg localbeg = new beg();
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.hvt = localbeg;
    locala.hvu = new beh();
    boolean bool;
    if (((b)g.ab(b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qax, 1) == 1)
    {
      bool = true;
      ac.d("CgiGetShowSource", "is new: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label129;
      }
      locala.funcId = 3857;
    }
    for (locala.uri = "/cgi-bin/micromsg-bin/getshowsourcenew";; locala.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource")
    {
      localbeg.ETM = paramString;
      this.rr = locala.aAz();
      AppMethodBeat.o(65163);
      return;
      bool = false;
      break;
      label129:
      locala.funcId = 2620;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.c
 * JD-Core Version:    0.7.0.1
 */