package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class h$9
  implements n.d
{
  h$9(h paramh) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (this.lKp.lKn != null)
      {
        Iterator localIterator = this.lKp.lKn.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle()))
          {
            this.lKp.lHY.a(this.lKp.lHZ, this.lKp.lIa, (String)localEntry.getKey(), false);
            com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
          }
        }
      }
      return;
    case 1: 
      this.lKp.bfd();
      com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(4) });
      return;
    }
    y.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(this.lKp.lKn.containsKey("com.tencent.map")) });
    if (h.a(this.lKp))
    {
      this.lKp.lHY.a(this.lKp.lHZ, this.lKp.lIa, "com.tencent.map", false);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
      return;
    }
    if (this.lKp.lKo < 4)
    {
      paramMenuItem = this.lKp;
      paramMenuItem.lKo += 1;
      g.DP().Dz().c(ac.a.uwk, Integer.valueOf(this.lKp.lKo));
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", " http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
    com.tencent.mm.br.d.b(this.lKp.activity, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(5) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.9
 * JD-Core Version:    0.7.0.1
 */