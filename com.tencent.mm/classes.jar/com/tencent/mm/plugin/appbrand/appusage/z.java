package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;

class z
  extends c<bzl>
{
  z(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    d.a locala = new d.a();
    bzk localbzk = new bzk();
    localbzk.bDZ = paramInt1;
    localbzk.Mfd = paramInt2;
    localbzk.condition = paramInt3;
    localbzk.Mfb = paramInt4;
    localbzk.Mfc = paramInt5;
    locala.iLN = localbzk;
    locala.iLO = new bzl();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    c(locala.aXF());
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */