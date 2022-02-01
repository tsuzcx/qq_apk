package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bif;

public final class d
  extends a<bif>
{
  public d(String paramString)
  {
    AppMethodBeat.i(163540);
    bie localbie = new bie();
    b.a locala = new b.a();
    locala.hQF = localbie;
    locala.hQG = new bif();
    locala.funcId = 3858;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
    localbie.url = paramString;
    c(locala.aDS());
    AppMethodBeat.o(163540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */