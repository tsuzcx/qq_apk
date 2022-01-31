package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;

final class f$3$1
  implements Runnable
{
  f$3$1(f.3 param3, String paramString) {}
  
  public final void run()
  {
    int i;
    if ((!bk.bl(this.gQp)) && ((!this.gQq.gQn) || (this.gQq.gQm.amB())))
    {
      i = 1;
      if (i != 0)
      {
        if (!"__APP__".equals(this.gQq.fAh)) {
          break label219;
        }
        this.gQq.gQm.gaS.aaa().fPS.fCl = this.gQp;
        label108:
        break label242;
      }
    }
    label289:
    for (;;)
    {
      Object localObject2;
      try
      {
        this.gQq.gQm.gaS.aaa().fPS.bIW = g.b(e.openRead(this.gQp), 4096);
        aq.k(this.gQq.gQm.gaS);
        this.gQq.gQm.vl(this.gQq.fAh);
        ai.d(new f.3.1.1(this));
        localObject2 = this.gQq.gQm;
        String str = this.gQq.fAh;
        if (i == 0) {
          break label289;
        }
        a.d locald = a.d.gQb;
        f.a((f)localObject2, str, locald);
        return;
        i = 0;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        y.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { this.gQq.gQm.gaS.mAppId });
        continue;
      }
      label219:
      Object localObject1 = this.gQq.gQm.gaS.aaa().fPS.fEQ.iterator();
      label242:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
        if (!this.gQq.fAh.equals(((ModulePkgInfo)localObject2).name)) {
          break label108;
        }
        ((ModulePkgInfo)localObject2).fCl = this.gQp;
        continue;
        localObject1 = a.d.gQc;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.f.3.1
 * JD-Core Version:    0.7.0.1
 */