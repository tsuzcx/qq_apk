package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;

public final class e
  extends c<cdu>
{
  public e(String paramString)
  {
    AppMethodBeat.i(226501);
    cdt localcdt = new cdt();
    d.a locala = new d.a();
    locala.lBU = localcdt;
    locala.lBV = new cdu();
    locala.funcId = 5952;
    locala.uri = "/cgi-bin/micromsg-bin/gettimelimitpromo";
    localcdt.llH = paramString;
    c(locala.bgN());
    AppMethodBeat.o(226501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */