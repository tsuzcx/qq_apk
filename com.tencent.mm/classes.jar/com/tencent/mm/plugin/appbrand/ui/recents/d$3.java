package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

final class d$3
  implements Runnable
{
  d$3(d paramd, List paramList) {}
  
  public final void run()
  {
    if (!d.c(this.hgW)) {
      return;
    }
    d.b(this.hgW, this.hgX);
    int j = Math.min(4, this.hgX.size());
    d.d(this.hgW).setIconLayerCount(j);
    Iterator localIterator = this.hgX.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label125;
      }
      LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
      if (j == i) {
        break;
      }
      b.JD().a(d.d(this.hgW).mB(i), localLocalUsageInfo.fJY, a.JC(), d.e(this.hgW));
      i += 1;
    }
    label125:
    if (bk.dk(this.hgX))
    {
      d.d(this.hgW).dK(true);
      return;
    }
    d.d(this.hgW).aqT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d.3
 * JD-Core Version:    0.7.0.1
 */