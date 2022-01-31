package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.w;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.asv;

final class q$2
  implements com.tencent.mm.modelgeo.b.a
{
  private int hbI = 0;
  
  q$2(PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(129600);
    e.ai(this);
    d.agQ().c(this);
    paramInt = this.hbI + 1;
    this.hbI = paramInt;
    if ((paramInt > 1) || (this.hbH.value))
    {
      AppMethodBeat.o(129600);
      return false;
    }
    this.hbG.value = true;
    if (!paramBoolean)
    {
      q.a(null);
      AppMethodBeat.o(129600);
      return false;
    }
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    locala.funcId = 1056;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
    asu localasu = new asu();
    localasu.xhM = paramFloat1;
    localasu.xhN = paramFloat2;
    if (!q.axh()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localasu.xhP = paramBoolean;
      locala.fsX = localasu;
      locala.fsY = new asv();
      w.a(locala.ado(), new q.2.1(this), true);
      AppMethodBeat.o(129600);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q.2
 * JD-Core Version:    0.7.0.1
 */