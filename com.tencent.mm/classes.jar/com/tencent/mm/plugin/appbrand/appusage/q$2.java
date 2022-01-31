package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.ang;

final class q$2
  implements a.a
{
  private int fIQ = 0;
  
  q$2(PBool paramPBool1, PBool paramPBool2) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    com.tencent.mm.plugin.appbrand.v.c.aa(this);
    com.tencent.mm.modelgeo.c.Ob().c(this);
    paramInt = this.fIQ + 1;
    this.fIQ = paramInt;
    if ((paramInt > 1) || (this.fIP.value)) {
      return false;
    }
    this.fIO.value = true;
    if (!paramBoolean)
    {
      q.a(null);
      return false;
    }
    b.a locala = new b.a();
    locala.ecG = 1056;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
    anf localanf = new anf();
    localanf.tiZ = paramFloat1;
    localanf.tja = paramFloat2;
    if (!q.adb()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localanf.tjc = paramBoolean;
      locala.ecH = localanf;
      locala.ecI = new ang();
      w.a(locala.Kt(), new q.2.1(this), true);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q.2
 * JD-Core Version:    0.7.0.1
 */