package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<bsh>
{
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213539);
    bsg localbsg = new bsg();
    localbsg.KOr = paramInt1;
    localbsg.KOs = 0;
    localbsg.LZn = 1;
    localbsg.LZo = paramInt2;
    d.a locala = new d.a();
    locala.iLN = localbsg;
    locala.iLO = new bsh();
    locala.funcId = 2680;
    locala.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(213539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */