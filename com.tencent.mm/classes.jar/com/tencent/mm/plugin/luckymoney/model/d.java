package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.azr;

public final class d
  extends c<azr>
{
  public d(String paramString)
  {
    AppMethodBeat.i(163540);
    azq localazq = new azq();
    b.a locala = new b.a();
    locala.gUU = localazq;
    locala.gUV = new azr();
    locala.funcId = 3858;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
    localazq.url = paramString;
    this.rr = locala.atI();
    AppMethodBeat.o(163540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */