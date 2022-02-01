package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class z
{
  public static void a(Context paramContext, final ah paramah, final w paramw, Runnable paramRunnable)
  {
    AppMethodBeat.i(323860);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().ccM();
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(paramContext, "pref_appbrand_" + paramah.getRuntime().getInitConfig().uin, 4);
    if ((localAppBrandSysConfigWC.qYY.qHO == 1) && (!localSharedPreferences.contains("has_share_dev_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
      k.a(paramContext, ba.i.app_brand_first_time_share_dev_page_tips, ba.i.app_tip, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(323871);
          if (z.this != null) {
            z.this.run();
          }
          z.a(paramah, paramw);
          AppMethodBeat.o(323871);
        }
      });
      AppMethodBeat.o(323860);
      return;
    }
    if ((localAppBrandSysConfigWC.qYY.qHO == 2) && (!localSharedPreferences.contains("has_share_beta_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
      k.a(paramContext, ba.i.app_brand_first_time_share_beta_page_tips, ba.i.app_tip, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(323875);
          if (z.this != null) {
            z.this.run();
          }
          z.a(paramah, paramw);
          AppMethodBeat.o(323875);
        }
      });
      AppMethodBeat.o(323860);
      return;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    a(paramah, paramw);
    AppMethodBeat.o(323860);
  }
  
  public static void a(ah paramah, w paramw)
  {
    AppMethodBeat.i(323869);
    Object localObject = paramah.getRuntime().ccM();
    a locala = new a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", ((n)localObject).hEy);
    localHashMap.put("desc", "");
    localHashMap.put("path", paramah.cEE());
    localHashMap.put("webViewUrl", j(paramah));
    localHashMap.put("imgUrl", ((n)localObject).phA);
    if (WxaMenuHelper.a(paramw, "enable_share_with_share_ticket")) {}
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(WxaMenuHelper.a(paramw, "enable_share_dynamic")));
      localHashMap.put("origin", "weixin");
      WxaMenuHelper.b(paramw, "user_clicked_share_btn");
      locala.a(paramah.getRuntime().ccO(), paramah.getComponentId()).K(localHashMap).cpV();
      AppMethodBeat.o(323869);
      return;
    }
  }
  
  private static String j(ah paramah)
  {
    AppMethodBeat.i(323874);
    paramah = paramah.cFg();
    if (paramah != null)
    {
      paramah = paramah.getWebView().getUrl();
      AppMethodBeat.o(323874);
      return paramah;
    }
    AppMethodBeat.o(323874);
    return null;
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = 75;
    public static final String NAME = "onShareAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.z
 * JD-Core Version:    0.7.0.1
 */