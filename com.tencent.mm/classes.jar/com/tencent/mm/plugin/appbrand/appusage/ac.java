package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dmh;

final class ac
  extends c<dmh>
{
  private final String cbY;
  private final dmg jvV;
  private final b jvW;
  
  ac(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.cbY = paramString2;
    b.a locala = new b.a();
    dmg localdmg = new dmg();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localdmg.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localdmg.FUg = paramInt1;
      localdmg.Een = paramInt2;
      localdmg.FUh = 2;
      localdmg.FUi = paramInt3;
      localdmg.username = paramString1;
      localdmg.reason = paramInt4;
      localdmg.session_id = paramString2;
      this.jvV = localdmg;
      locala.hvt = localdmg;
      locala.hvu = new dmh();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.aAz();
      this.jvW = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static ac bh(String paramString, int paramInt)
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