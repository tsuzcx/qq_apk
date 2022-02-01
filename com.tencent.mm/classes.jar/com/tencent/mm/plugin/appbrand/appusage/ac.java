package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.protocal.protobuf.dgs;

final class ac
  extends c<dgs>
{
  private final String cfb;
  private final dgr iVF;
  private final b iVG;
  
  ac(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.cfb = paramString2;
    b.a locala = new b.a();
    dgr localdgr = new dgr();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localdgr.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localdgr.Exe = paramInt1;
      localdgr.CLK = paramInt2;
      localdgr.Exf = 2;
      localdgr.Exg = paramInt3;
      localdgr.username = paramString1;
      localdgr.bvJ = paramInt4;
      localdgr.session_id = paramString2;
      this.iVF = localdgr;
      locala.gUU = localdgr;
      locala.gUV = new dgs();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.atI();
      this.iVG = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static ac bd(String paramString, int paramInt)
  {
    AppMethodBeat.i(44641);
    paramString = new ac(1001, false, paramInt, 2, paramString, 1, null);
    AppMethodBeat.o(44641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ac
 * JD-Core Version:    0.7.0.1
 */