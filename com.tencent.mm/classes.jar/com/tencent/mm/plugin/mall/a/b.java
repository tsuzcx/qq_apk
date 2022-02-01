package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<cad>
{
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264572);
    cac localcac = new cac();
    localcac.RPp = paramInt1;
    localcac.RPq = 0;
    localcac.TiH = 1;
    localcac.TiI = paramInt2;
    d.a locala = new d.a();
    locala.lBU = localcac;
    locala.lBV = new cad();
    locala.funcId = 2680;
    locala.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    Log.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(264572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */