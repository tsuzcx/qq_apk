package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.aqa;

public final class c
  extends a<aqa>
{
  public c(String paramString)
  {
    AppMethodBeat.i(42272);
    apz localapz = new apz();
    b.a locala = new b.a();
    locala.fsX = localapz;
    locala.fsY = new aqa();
    locala.funcId = 2620;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource";
    localapz.xfw = paramString;
    this.rr = locala.ado();
    AppMethodBeat.o(42272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.c
 * JD-Core Version:    0.7.0.1
 */