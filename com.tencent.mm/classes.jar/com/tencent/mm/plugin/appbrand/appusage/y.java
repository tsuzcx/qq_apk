package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxg;

class y
  extends b<cxg>
{
  y(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    c.a locala = new c.a();
    cxf localcxf = new cxf();
    localcxf.reason = paramInt1;
    localcxf.aaCM = paramInt2;
    localcxf.rXy = paramInt3;
    localcxf.aaCK = paramInt4;
    localcxf.aaCL = paramInt5;
    locala.otE = localcxf;
    locala.otF = new cxg();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    c(locala.bEF());
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */