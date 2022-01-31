package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.atb;

class y
  extends a<atb>
{
  y(int paramInt1, int paramInt2, int paramInt3)
  {
    this(4, 0, paramInt1, paramInt2, paramInt3);
  }
  
  y(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(129706);
    b.a locala = new b.a();
    ata localata = new ata();
    localata.aXG = paramInt1;
    localata.xiq = paramInt2;
    localata.condition = paramInt3;
    localata.xio = paramInt4;
    localata.xip = paramInt5;
    locala.fsX = localata;
    locala.fsY = new atb();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    this.rr = locala.ado();
    AppMethodBeat.o(129706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */