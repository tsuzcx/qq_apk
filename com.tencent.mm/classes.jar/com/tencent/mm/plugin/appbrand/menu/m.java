package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class m
  extends com.tencent.mm.plugin.appbrand.menu.a.a<z>
{
  public m()
  {
    super(r.iqS.ordinal());
    AppMethodBeat.i(132241);
    AppMethodBeat.o(132241);
  }
  
  static void a(z paramz, q paramq)
  {
    AppMethodBeat.i(132242);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramz.getRuntime().atR();
    m.a locala = new m.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", localAppBrandSysConfigWC.cqQ);
    localHashMap.put("desc", "");
    localHashMap.put("path", paramz.iuB);
    Object localObject = paramz.aJz();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject).getWebView().getUrl();
      localHashMap.put("webViewUrl", localObject);
      localHashMap.put("imgUrl", localAppBrandSysConfigWC.hiQ);
      if (!paramq.hCb.oR("enable_share_with_share_ticket")) {
        break label208;
      }
    }
    label208:
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(paramq.hCb.oR("enable_share_dynamic")));
      paramq.hCb.A("user_clicked_share_btn", true);
      locala.a(paramz.getRuntime().atU(), paramz.hashCode()).w(localHashMap).aBz();
      AppMethodBeat.o(132242);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.m
 * JD-Core Version:    0.7.0.1
 */