package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<bbr>
{
  public b(int paramInt)
  {
    AppMethodBeat.i(65988);
    bbq localbbq = new bbq();
    localbbq.DWS = paramInt;
    localbbq.DWT = 0;
    localbbq.ESd = 1;
    b.a locala = new b.a();
    locala.hvt = localbbq;
    locala.hvu = new bbr();
    locala.funcId = 2680;
    locala.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */