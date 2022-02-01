package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class r$3
  implements q.g
{
  r$3(r paramr, v paramv, e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(279333);
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (this.oUY.oUU != null)
      {
        Iterator localIterator = this.oUY.oUU.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((String)localEntry.getValue()).equals(paramMenuItem.getTitle())) {
            this.oUY.oUX.a(this.oUY.oUV, this.oUY.oUW, (String)localEntry.getKey(), false);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.jaP.bYF();
      AppMethodBeat.o(279333);
      return;
      Log.i("MicroMsg.JsApiOpenMapApp", "click tencent map: %s", new Object[] { Boolean.valueOf(this.oUY.oUU.containsKey("com.tencent.map")) });
      if (r.a(this.oUY))
      {
        this.oUY.oUX.a(this.oUY.oUV, this.oUY.oUW, "com.tencent.map", false);
      }
      else
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
        c.b(this.onN.ax(Activity.class), "webview", ".ui.tools.WebViewUI", paramMenuItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.r.3
 * JD-Core Version:    0.7.0.1
 */