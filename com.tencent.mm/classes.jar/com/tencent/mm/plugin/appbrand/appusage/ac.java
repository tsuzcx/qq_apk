package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.dsv;

final class ac
  extends a<dsv>
{
  private final String cmr;
  private final dsu jTh;
  private final b jTi;
  
  ac(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.cmr = paramString2;
    b.a locala = new b.a();
    dsu localdsu = new dsu();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localdsu.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localdsu.HYH = paramInt1;
      localdsu.Gdl = paramInt2;
      localdsu.HYI = 2;
      localdsu.HYJ = paramInt3;
      localdsu.username = paramString1;
      localdsu.reason = paramInt4;
      localdsu.session_id = paramString2;
      this.jTh = localdsu;
      locala.hQF = localdsu;
      locala.hQG = new dsv();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.aDS();
      this.jTi = paramString1;
      c(paramString1);
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static ac bm(String paramString, int paramInt)
  {
    AppMethodBeat.i(44641);
    paramString = new ac(1001, false, paramInt, 2, paramString, 1, null);
    AppMethodBeat.o(44641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ac
 * JD-Core Version:    0.7.0.1
 */