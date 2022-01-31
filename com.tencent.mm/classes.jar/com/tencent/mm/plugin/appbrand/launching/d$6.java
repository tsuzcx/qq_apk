package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.b;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.platformtools.bk;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    Object localObject = r.su(this.gKh);
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.JD();
        if (!bk.bl(str)) {
          localb.a(new b.b(), str, null);
        }
        i += 1;
      }
    }
    if (g.DP().isSDCardAvailable())
    {
      localObject = new k(12);
      g.DO().dJT.a((m)localObject, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.6
 * JD-Core Version:    0.7.0.1
 */