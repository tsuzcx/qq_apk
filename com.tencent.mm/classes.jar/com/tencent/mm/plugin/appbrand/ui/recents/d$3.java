package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class d$3
  implements Runnable
{
  d$3(d paramd, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133327);
    if (!d.c(this.iSy))
    {
      AppMethodBeat.o(133327);
      return;
    }
    d.b(this.iSy, this.iSz);
    int j = Math.min(4, this.iSz.size());
    this.iSy.iSt.setIconLayerCount(j);
    Iterator localIterator = this.iSz.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
      if (j == i)
      {
        AppMethodBeat.o(133327);
        return;
      }
      b.acD().a(this.iSy.iSt.pU(i), localLocalUsageInfo.hcN, a.acC(), d.d(this.iSy));
      i += 1;
    }
    if (bo.es(this.iSz))
    {
      this.iSy.iSt.fa(true);
      AppMethodBeat.o(133327);
      return;
    }
    this.iSy.iSt.aOx();
    AppMethodBeat.o(133327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d.3
 * JD-Core Version:    0.7.0.1
 */