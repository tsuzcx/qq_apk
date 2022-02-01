package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j$2
  implements q.g
{
  j$2(j paramj) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(56148);
    Iterator localIterator;
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (j.h(this.ErM) != null) {
        localIterator = j.h(this.ErM).entrySet().iterator();
      }
      break;
    case 2: 
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle()))
        {
          this.ErM.oUX.a(this.ErM.oUV, this.ErM.oUW, (String)localEntry.getKey(), false);
          com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
          AppMethodBeat.o(56148);
          return;
          Log.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.h(this.ErM).containsKey("com.tencent.map")) });
          if (j.g(this.ErM))
          {
            this.ErM.oUX.a(this.ErM.oUV, this.ErM.oUW, "com.tencent.map", false);
            com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
            AppMethodBeat.o(56148);
            return;
          }
          paramInt = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vFf, 99);
          if (j.f(this.ErM) < paramInt)
          {
            j.i(this.ErM);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VpX, Integer.valueOf(j.f(this.ErM)));
          }
          if (1 == ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vum, 0)) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            new j.a(this.ErM.activity, j.j(this.ErM)).execute(new String[] { j.eNy() });
            AppMethodBeat.o(56148);
            return;
          }
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("rawUrl", "http://" + WeChatHosts.domainString(a.i.host_mapdownload_map_qq_com) + "/?key=wx&referer=wx1&channel=00008");
          c.b(this.ErM.activity, "webview", ".ui.tools.WebViewUI", paramMenuItem);
          com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(5) });
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