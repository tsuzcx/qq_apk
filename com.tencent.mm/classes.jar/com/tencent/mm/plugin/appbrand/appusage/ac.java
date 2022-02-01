package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;

final class ac
  extends a<dry>
{
  private final String cmp;
  private final drx jPP;
  private final b jPQ;
  
  ac(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.cmp = paramString2;
    b.a locala = new b.a();
    drx localdrx = new drx();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localdrx.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localdrx.HEU = paramInt1;
      localdrx.FKM = paramInt2;
      localdrx.HEV = 2;
      localdrx.HEW = paramInt3;
      localdrx.username = paramString1;
      localdrx.reason = paramInt4;
      localdrx.session_id = paramString2;
      this.jPP = localdrx;
      locala.hNM = localdrx;
      locala.hNN = new dry();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.aDC();
      this.jPQ = paramString1;
      c(paramString1);
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static ac bj(String paramString, int paramInt)
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