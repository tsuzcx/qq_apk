package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;

public final class d
  extends c<bdj>
{
  public d(String paramString)
  {
    AppMethodBeat.i(163540);
    bdi localbdi = new bdi();
    b.a locala = new b.a();
    locala.hvt = localbdi;
    locala.hvu = new bdj();
    locala.funcId = 3858;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketpreview";
    localbdi.url = paramString;
    this.rr = locala.aAz();
    AppMethodBeat.o(163540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */