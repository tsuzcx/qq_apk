package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.protocal.protobuf.emt;

final class ab
  extends c<emt>
{
  private final String cym;
  private final ems kVP;
  private final d kVQ;
  
  ab(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(44640);
    this.cym = paramString2;
    d.a locala = new d.a();
    ems localems = new ems();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localems.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localems.NkO = paramInt1;
      localems.KXC = paramInt2;
      localems.NkP = 2;
      localems.NkQ = paramInt3;
      localems.username = paramString1;
      localems.bDZ = paramInt4;
      localems.session_id = paramString2;
      this.kVP = localems;
      locala.iLN = localems;
      locala.iLO = new emt();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.aXF();
      this.kVQ = paramString1;
      c(paramString1);
      AppMethodBeat.o(44640);
      return;
    }
  }
  
  static ab br(String paramString, int paramInt)
  {
    AppMethodBeat.i(44641);
    paramString = new ab(1001, false, paramInt, 2, paramString, 1, null);
    AppMethodBeat.o(44641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */