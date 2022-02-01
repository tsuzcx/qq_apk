package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;

class aa
  extends a<bmu>
{
  aa(int paramInt1, int paramInt2, int paramInt3)
  {
    this(4, 0, paramInt1, paramInt2, paramInt3);
  }
  
  aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    b.a locala = new b.a();
    bmt localbmt = new bmt();
    localbmt.reason = paramInt1;
    localbmt.Had = paramInt2;
    localbmt.condition = paramInt3;
    localbmt.Hab = paramInt4;
    localbmt.Hac = paramInt5;
    locala.hQF = localbmt;
    locala.hQG = new bmu();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    c(locala.aDS());
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */