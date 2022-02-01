package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ag.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class q
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ah>
{
  public q()
  {
    super(w.qfG.ordinal());
    AppMethodBeat.i(47652);
    AppMethodBeat.o(47652);
  }
  
  static void a(ah paramah, v paramv)
  {
    AppMethodBeat.i(47655);
    Object localObject = paramah.getRuntime().bDx();
    a locala = new a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", ((l)localObject).fzM);
    localHashMap.put("desc", "");
    localHashMap.put("path", paramah.qoI);
    localHashMap.put("webViewUrl", i(paramah));
    localHashMap.put("imgUrl", ((l)localObject).mnM);
    if (paramv.ozJ.Rq("enable_share_with_share_ticket")) {}
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(paramv.ozJ.Rq("enable_share_dynamic")));
      localHashMap.put("origin", "weixin");
      paramv.ozJ.J("user_clicked_share_btn", true);
      locala.a(paramah.getRuntime().bDA(), paramah.getComponentId()).D(localHashMap).bPO();
      AppMethodBeat.o(47655);
      return;
    }
  }
  
  public static boolean h(ah paramah)
  {
    AppMethodBeat.i(47653);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().bDx();
    if ((localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.nYR.nHY == 0) && (com.tencent.mm.plugin.appbrand.config.a.nVM.a(localAppBrandSysConfigWC) == 2))
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (paramah.Cp(w.qfG.ordinal()) == null)
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (!paramah.Cp(w.qfG.ordinal()).qfB)
    {
      AppMethodBeat.o(47653);
      return true;
    }
    AppMethodBeat.o(47653);
    return false;
  }
  
  private static String i(ah paramah)
  {
    AppMethodBeat.i(47656);
    paramah = paramah.ceE();
    if (paramah != null)
    {
      paramah = paramah.getWebView().getUrl();
      AppMethodBeat.o(47656);
      return paramah;
    }
    AppMethodBeat.o(47656);
    return null;
  }
  
  public final void a(Context paramContext, final ah paramah, final String paramString, final v paramv)
  {
    AppMethodBeat.i(47654);
    j.a(paramString, paramah.oxe, 39, "", Util.nowSecond(), 1, 0);
    if (g.ap(paramah.getRuntime()))
    {
      a(paramah, paramv);
      AppMethodBeat.o(47654);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().bDx();
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(paramContext, "pref_appbrand_" + paramah.getRuntime().bDy().uin, 4);
    if ((localAppBrandSysConfigWC.nYR.nHY == 1) && (!localSharedPreferences.contains("has_share_dev_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
      h.a(paramContext, au.i.app_brand_first_time_share_dev_page_tips, au.i.app_tip, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47650);
          q.a(paramah, paramv);
          AppMethodBeat.o(47650);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    if ((localAppBrandSysConfigWC.nYR.nHY == 2) && (!localSharedPreferences.contains("has_share_beta_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
      h.a(paramContext, au.i.app_brand_first_time_share_beta_page_tips, au.i.app_tip, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47651);
          q.a(paramah, paramv);
          AppMethodBeat.o(47651);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    a(paramah, paramv);
    AppMethodBeat.o(47654);
  }
  
  public static final class a
    extends r
  {
    private static final int CTRL_INDEX = 75;
    public static final String NAME = "onShareAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.q
 * JD-Core Version:    0.7.0.1
 */