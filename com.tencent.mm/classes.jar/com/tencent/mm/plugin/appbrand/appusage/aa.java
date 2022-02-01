package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bhu;

class aa
  extends c<bhu>
{
  aa(int paramInt1, int paramInt2, int paramInt3)
  {
    this(4, 0, paramInt1, paramInt2, paramInt3);
  }
  
  aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(44639);
    b.a locala = new b.a();
    bht localbht = new bht();
    localbht.reason = paramInt1;
    localbht.EXe = paramInt2;
    localbht.condition = paramInt3;
    localbht.EXc = paramInt4;
    localbht.EXd = paramInt5;
    locala.hvt = localbht;
    locala.hvu = new bhu();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.funcId = 1148;
    this.rr = locala.aAz();
    AppMethodBeat.o(44639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */