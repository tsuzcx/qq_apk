package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<bfv>
{
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199027);
    bfu localbfu = new bfu();
    localbfu.FCo = paramInt1;
    localbfu.FCp = 0;
    localbfu.GBv = 1;
    localbfu.GBw = paramInt2;
    b.a locala = new b.a();
    locala.hNM = localbfu;
    locala.hNN = new bfv();
    locala.funcId = 2680;
    locala.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(199027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */