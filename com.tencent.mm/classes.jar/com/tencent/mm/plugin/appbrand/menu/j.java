package com.tencent.mm.plugin.appbrand.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends com.tencent.mm.plugin.appbrand.menu.a.a<s>
{
  public j()
  {
    super(o.gPk.ordinal());
  }
  
  static void a(s params, n paramn)
  {
    AppBrandSysConfigWC localAppBrandSysConfigWC = params.getRuntime().aaa();
    j.a locala = new j.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", localAppBrandSysConfigWC.bJw);
    localHashMap.put("desc", "");
    localHashMap.put("path", params.ahc());
    Object localObject = params.ans();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.t.a)localObject).getWebView().getUrl();
      localHashMap.put("webViewUrl", localObject);
      localHashMap.put("imgUrl", localAppBrandSysConfigWC.fPM);
      if (!paramn.fVQ.ik("enable_share_with_share_ticket")) {
        break label198;
      }
    }
    label198:
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(paramn.fVQ.ik("enable_share_dynamic")));
      paramn.fVQ.w("user_clicked_share_btn", true);
      locala.a(params.getRuntime().aae(), params.hashCode()).o(localHashMap).dispatch();
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.j
 * JD-Core Version:    0.7.0.1
 */