package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.cnq;

final class aa
  extends a<cnq>
{
  private final String bCU;
  private final cnp hcE;
  private final b hcF;
  
  aa(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(129707);
    this.bCU = paramString2;
    b.a locala = new b.a();
    cnp localcnp = new cnp();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localcnp.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localcnp.xWA = paramInt1;
      localcnp.wAx = paramInt2;
      localcnp.xWB = 2;
      localcnp.xWC = paramInt3;
      localcnp.username = paramString1;
      localcnp.aXG = paramInt4;
      localcnp.session_id = paramString2;
      this.hcE = localcnp;
      locala.fsX = localcnp;
      locala.fsY = new cnq();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.funcId = 1149;
      paramString1 = locala.ado();
      this.hcF = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(129707);
      return;
    }
  }
  
  static aa aO(String paramString, int paramInt)
  {
    AppMethodBeat.i(129708);
    paramString = new aa(1001, false, paramInt, 2, paramString, 1, null);
    AppMethodBeat.o(129708);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */