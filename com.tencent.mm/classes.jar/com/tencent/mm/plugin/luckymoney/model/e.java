package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bwe;

public final class e
  extends c<bwe>
{
  public e(String paramString)
  {
    AppMethodBeat.i(213302);
    bwd localbwd = new bwd();
    d.a locala = new d.a();
    locala.iLN = localbwd;
    locala.iLO = new bwe();
    locala.funcId = 5952;
    locala.uri = "/cgi-bin/micromsg-bin/gettimelimitpromo";
    localbwd.iwu = paramString;
    c(locala.aXF());
    AppMethodBeat.o(213302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */