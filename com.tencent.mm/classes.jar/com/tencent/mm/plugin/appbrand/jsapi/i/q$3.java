package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class q$3
  implements o.g
{
  q$3(q paramq, s params, e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(226851);
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (this.lXn.lXj != null)
      {
        Iterator localIterator = this.lXn.lXj.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle())) {
            this.lXn.lXm.a(this.lXn.lXk, this.lXn.lXl, (String)localEntry.getKey(), false);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.gwC.bMo();
      AppMethodBeat.o(226851);
      return;
      Log.i("MicroMsg.JsApiOpenMapApp", "click tencent map: %s", new Object[] { Boolean.valueOf(this.lXn.lXj.containsKey("com.tencent.map")) });
      if (q.a(this.lXn))
      {
        this.lXn.lXm.a(this.lXn.lXk, this.lXn.lXl, "com.tencent.map", false);
      }
      else
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
        c.b(this.lsQ.ay(Activity.class), "webview", ".ui.tools.WebViewUI", paramMenuItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.q.3
 * JD-Core Version:    0.7.0.1
 */