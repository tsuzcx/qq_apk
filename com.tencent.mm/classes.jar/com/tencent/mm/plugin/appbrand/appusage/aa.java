package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;

class aa
  extends a<bmc>
{
  aa(int paramInt1, int paramInt2, int paramInt3)
  {
    this(4, 0, paramInt1, paramInt2, paramInt3);
  }
  
  aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    b.a locala = new b.a();
    bmb localbmb = new bmb();
    localbmb.reason = paramInt1;
    localbmb.GGB = paramInt2;
    localbmb.condition = paramInt3;
    localbmb.GGz = paramInt4;
    localbmb.GGA = paramInt5;
    locala.hNM = localbmb;
    locala.hNN = new bmc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    c(locala.aDC());
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */