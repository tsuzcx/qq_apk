package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.u.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j$2
  implements u.i
{
  j$2(j paramj) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(56148);
    Iterator localIterator;
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (j.h(this.Kks) != null) {
        localIterator = j.h(this.Kks).entrySet().iterator();
      }
      break;
    case 2: 
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle()))
        {
          this.Kks.sak.a(this.Kks.sai, this.Kks.saj, (String)localEntry.getKey(), false);
          com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
          AppMethodBeat.o(56148);
          return;
          Log.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.h(this.Kks).containsKey("com.tencent.map")) });
          if (j.g(this.Kks))
          {
            this.Kks.sak.a(this.Kks.sai, this.Kks.saj, "com.tencent.map", false);
            com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
            AppMethodBeat.o(56148);
            return;
          }
          paramInt = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUD, 99);
          if (j.f(this.Kks) < paramInt)
          {
            j.i(this.Kks);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acRz, Integer.valueOf(j.f(this.Kks)));
          }
          if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGR, 0)) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            new j.a(this.Kks.activity, j.j(this.Kks)).execute(new String[] { j.fVR() });
            AppMethodBeat.o(56148);
            return;
          }
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("rawUrl", "http://" + WeChatHosts.domainString(a.i.host_mapdownload_map_qq_com) + "/?key=wx&referer=wx1&channel=00008");
          com.tencent.mm.br.c.b(this.Kks.activity, "webview", ".ui.tools.WebViewUI", paramMenuItem);
          com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(5) });
          AppMethodBeat.o(56148);
          return;
        }
      }
    }
    AppMethodBeat.o(56148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.2
 * JD-Core Version:    0.7.0.1
 */