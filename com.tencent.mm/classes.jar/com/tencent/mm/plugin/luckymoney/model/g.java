package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.wallet_core.model.z;

public final class g
  extends z<cre>
{
  public g(String paramString)
  {
    AppMethodBeat.i(163540);
    crd localcrd = new crd();
    c.a locala = new c.a();
    locala.otE = localcrd;
    locala.otF = new cre();
    locala.funcId = 3858;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
    localcrd.url = paramString;
    c(locala.bEF());
    AppMethodBeat.o(163540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.g
 * JD-Core Version:    0.7.0.1
 */