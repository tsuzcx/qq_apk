package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(113702);
    Iterator localIterator;
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (this.ohE.ohB != null) {
        localIterator = this.ohE.ohB.entrySet().iterator();
      }
      break;
    case 1: 
    case 2: 
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle()))
        {
          this.ohE.ofl.a(this.ohE.ofm, this.ohE.ofn, (String)localEntry.getKey(), false);
          com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
          AppMethodBeat.o(113702);
          return;
          this.ohE.bMB();
          com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(4) });
          AppMethodBeat.o(113702);
          return;
          ab.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(this.ohE.ohB.containsKey("com.tencent.map")) });
          if (h.a(this.ohE))
          {
            this.ohE.ofl.a(this.ohE.ofm, this.ohE.ofn, "com.tencent.map", false);
            com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
            AppMethodBeat.o(113702);
            return;
          }
          if (this.ohE.ohC < 4)
          {
            paramMenuItem = this.ohE;
            paramMenuItem.ohC += 1;
            g.RL().Ru().set(ac.a.yGs, Integer.valueOf(this.ohE.ohC));
          }
          if (1 == ((a)g.E(a.class)).a(a.a.lRK, 0)) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            new h.a(this.ohE.activity, this.ohE.ohD).execute(new String[] { "https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json" });
            AppMethodBeat.o(113702);
            return;
          }
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
          com.tencent.mm.bq.d.b(this.ohE.activity, "webview", ".ui.tools.WebViewUI", paramMenuItem);
          com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(113702);
          return;
        }
      }
    }
    AppMethodBeat.o(113702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.9
 * JD-Core Version:    0.7.0.1
 */