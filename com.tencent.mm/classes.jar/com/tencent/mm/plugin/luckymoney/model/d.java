package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.protocal.protobuf.bhp;

public final class d
  extends a<bhp>
{
  public d(String paramString)
  {
    AppMethodBeat.i(163540);
    bho localbho = new bho();
    b.a locala = new b.a();
    locala.hNM = localbho;
    locala.hNN = new bhp();
    locala.funcId = 3858;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
    localbho.url = paramString;
    c(locala.aDC());
    AppMethodBeat.o(163540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */