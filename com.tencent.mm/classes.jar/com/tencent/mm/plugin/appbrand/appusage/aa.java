package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bec;

class aa
  extends c<bec>
{
  aa(int paramInt1, int paramInt2, int paramInt3)
  {
    this(4, 0, paramInt1, paramInt2, paramInt3);
  }
  
  aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    b.a locala = new b.a();
    beb localbeb = new beb();
    localbeb.bvJ = paramInt1;
    localbeb.DBI = paramInt2;
    localbeb.condition = paramInt3;
    localbeb.DBG = paramInt4;
    localbeb.DBH = paramInt5;
    locala.gUU = localbeb;
    locala.gUV = new bec();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    this.rr = locala.atI();
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */