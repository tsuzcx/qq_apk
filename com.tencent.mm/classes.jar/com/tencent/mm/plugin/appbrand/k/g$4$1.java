package com.tencent.mm.plugin.appbrand.k;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;

final class g$4$1
  implements Runnable
{
  g$4$1(g.4 param4, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(140854);
    if (this.isf.isb.irY.mFinished)
    {
      ab.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", new Object[] { this.isf.bEK, this.isf.isb.irY.toString() });
      AppMethodBeat.o(140854);
      return;
    }
    int i;
    if ((!bo.isNullOrNil(this.ise)) && ((!this.isf.isc) || (this.isf.isb.aIf())))
    {
      i = 1;
      if (i != 0)
      {
        if (!"__APP__".equals(this.isf.bEK)) {
          break label288;
        }
        this.isf.isb.irY.wR().hiX.gUy = this.ise;
        label172:
        break label311;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        this.isf.isb.irY.wR().hiX.cqq = com.tencent.mm.a.g.b(e.openRead(this.ise), 4096);
        ax.p(this.isf.isb.irY);
        this.isf.isb.DJ(this.isf.bEK);
        al.d(new g.4.1.1(this));
        localObject2 = this.isf.isb;
        String str = this.isf.bEK;
        if (i == 0) {
          break label358;
        }
        a.d locald = a.d.irN;
        g.a((g)localObject2, str, locald);
        AppMethodBeat.o(140854);
        return;
        i = 0;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ab.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { this.isf.isb.irY.mAppId });
        continue;
      }
      label288:
      Object localObject1 = this.isf.isb.irY.wR().hiX.gXi.iterator();
      label311:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
        if (!this.isf.bEK.equals(((ModulePkgInfo)localObject2).name)) {
          break label172;
        }
        ((ModulePkgInfo)localObject2).gUy = this.ise;
        continue;
        label358:
        localObject1 = a.d.irO;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.g.4.1
 * JD-Core Version:    0.7.0.1
 */