package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<bgl>
{
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189862);
    bgk localbgk = new bgk();
    localbgk.FUJ = paramInt1;
    localbgk.FUK = 0;
    localbgk.GUV = 1;
    localbgk.GUW = paramInt2;
    b.a locala = new b.a();
    locala.hQF = localbgk;
    locala.hQG = new bgl();
    locala.funcId = 2680;
    locala.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(189862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */