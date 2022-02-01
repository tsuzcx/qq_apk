package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.buf;

public final class f
  extends c<buf>
{
  public f(String paramString)
  {
    AppMethodBeat.i(163540);
    bue localbue = new bue();
    d.a locala = new d.a();
    locala.iLN = localbue;
    locala.iLO = new buf();
    locala.funcId = 3858;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
    localbue.url = paramString;
    c(locala.aXF());
    AppMethodBeat.o(163540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.f
 * JD-Core Version:    0.7.0.1
 */