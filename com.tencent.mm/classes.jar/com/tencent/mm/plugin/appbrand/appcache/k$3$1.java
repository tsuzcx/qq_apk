package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.clw;

final class k$3$1
  implements f
{
  k$3$1(k.3 param3) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm != null) && ((paramm.edi instanceof com.tencent.mm.ah.b)))
    {
      paramString = (clw)((com.tencent.mm.ah.b)paramm.edi).ecF.ecN;
      paramInt1 = k.a(this.fCj.fCg);
      paramInt2 = paramString.version;
      paramString = new k.3.1.1(this);
      at.b(af.r("@LibraryAppId", paramInt1, paramInt2), paramString);
    }
    g.DO().dJT.b(1168, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k.3.1
 * JD-Core Version:    0.7.0.1
 */