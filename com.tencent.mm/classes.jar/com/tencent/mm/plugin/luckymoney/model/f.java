package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.wallet_core.model.z;

public final class f
  extends z<ctq>
{
  public f(String paramString)
  {
    AppMethodBeat.i(283957);
    ctp localctp = new ctp();
    c.a locala = new c.a();
    locala.otE = localctp;
    locala.otF = new ctq();
    locala.funcId = 5952;
    locala.uri = "/cgi-bin/micromsg-bin/gettimelimitpromo";
    localctp.nQE = paramString;
    c(locala.bEF());
    AppMethodBeat.o(283957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.f
 * JD-Core Version:    0.7.0.1
 */