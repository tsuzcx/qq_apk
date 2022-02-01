package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j$2
  implements o.g
{
  j$2(j paramj) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(56148);
    Iterator localIterator;
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (j.h(this.yNO) != null) {
        localIterator = j.h(this.yNO).entrySet().iterator();
      }
      break;
    case 2: 
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle()))
        {
          this.yNO.lXm.a(this.yNO.lXk, this.yNO.lXl, (String)localEntry.getKey(), false);
          h.CyF.a(12809, new Object[] { Integer.valueOf(4), localEntry.getKey() });
          AppMethodBeat.o(56148);
          return;
          Log.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[] { Boolean.valueOf(j.h(this.yNO).containsKey("com.tencent.map")) });
          if (j.g(this.yNO))
          {
            this.yNO.lXm.a(this.yNO.lXk, this.yNO.lXl, "com.tencent.map", false);
            h.CyF.a(12809, new Object[] { Integer.valueOf(4), "com.tencent.map" });
            AppMethodBeat.o(56148);
            return;
          }
          paramInt = ((b)g.af(b.class)).a(b.a.rYm, 99);
          if (j.f(this.yNO) < paramInt)
          {
            j.i(this.yNO);
            g.aAh().azQ().set(ar.a.ObU, Integer.valueOf(j.f(this.yNO)));
          }
          if (1 == ((b)g.af(b.class)).a(b.a.rOr, 0)) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            new j.a(this.yNO.activity, j.j(this.yNO)).execute(new String[] { j.eed() });
            AppMethodBeat.o(56148);
            return;
          }
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("rawUrl", "http://" + WeChatHosts.domainString(2131761719) + "/?key=wx&referer=wx1&channel=00008");
          c.b(this.yNO.activity, "webview", ".ui.tools.WebViewUI", paramMenuItem);
          h.CyF.a(12809, new Object[] { Integer.valueOf(5) });
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