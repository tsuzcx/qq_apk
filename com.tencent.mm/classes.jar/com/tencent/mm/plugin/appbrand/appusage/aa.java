package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.fst;
import com.tencent.mm.protocal.protobuf.fsu;

final class aa
  extends b<fsu>
{
  private final String eoP;
  private final fst qPU;
  private final c qPV;
  
  private aa(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.eoP = paramString2;
    c.a locala = new c.a();
    fst localfst = new fst();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localfst.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localfst.abRh = paramInt1;
      localfst.Tqb = paramInt2;
      localfst.abRi = 2;
      localfst.YAN = paramInt3;
      localfst.username = paramString1;
      localfst.reason = paramInt4;
      localfst.session_id = paramString2;
      this.qPU = localfst;
      locala.otE = localfst;
      locala.otF = new fsu();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.bEF();
      this.qPV = paramString1;
      c(paramString1);
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static aa a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(319347);
    paramString1 = new aa(paramInt2, paramBoolean, paramInt1, 1, paramString1, paramInt3, paramString2);
    AppMethodBeat.o(319347);
    return paramString1;
  }
  
  static aa cc(String paramString, int paramInt)
  {
    AppMethodBeat.i(44641);
    paramString = new aa(1001, false, paramInt, 2, paramString, 1, null);
    AppMethodBeat.o(44641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */