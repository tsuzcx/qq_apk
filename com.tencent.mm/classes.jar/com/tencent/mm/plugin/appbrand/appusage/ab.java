package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.exa;
import com.tencent.mm.protocal.protobuf.exb;

final class ab
  extends c<exb>
{
  private final String cwP;
  private final exa nQc;
  private final d nQd;
  
  private ab(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.cwP = paramString2;
    d.a locala = new d.a();
    exa localexa = new exa();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localexa.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localexa.UxA = paramInt1;
      localexa.RYL = paramInt2;
      localexa.UxB = 2;
      localexa.SLl = paramInt3;
      localexa.username = paramString1;
      localexa.bnA = paramInt4;
      localexa.session_id = paramString2;
      this.nQc = localexa;
      locala.lBU = localexa;
      locala.lBV = new exb();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.bgN();
      this.nQd = paramString1;
      c(paramString1);
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static ab a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(272434);
    paramString1 = new ab(paramInt2, paramBoolean, paramInt1, 1, paramString1, paramInt3, paramString2);
    AppMethodBeat.o(272434);
    return paramString1;
  }
  
  static ab bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(44641);
    paramString = new ab(1001, false, paramInt, 2, paramString, 1, null);
    AppMethodBeat.o(44641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */