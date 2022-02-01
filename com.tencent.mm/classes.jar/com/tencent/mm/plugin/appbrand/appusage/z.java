package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chf;

class z
  extends c<chf>
{
  z(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    d.a locala = new d.a();
    che localche = new che();
    localche.bnA = paramInt1;
    localche.ToF = paramInt2;
    localche.oRY = paramInt3;
    localche.ToD = paramInt4;
    localche.ToE = paramInt5;
    locala.lBU = localche;
    locala.lBV = new chf();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    c(locala.bgN());
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */