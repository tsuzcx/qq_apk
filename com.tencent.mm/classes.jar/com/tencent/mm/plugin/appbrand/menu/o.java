package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class o
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ag>
{
  public o()
  {
    super(u.neY.ordinal());
    AppMethodBeat.i(47652);
    AppMethodBeat.o(47652);
  }
  
  static void a(ag paramag, t paramt)
  {
    AppMethodBeat.i(47655);
    Object localObject = paramag.getRuntime().bsB();
    a locala = new a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", ((l)localObject).brandName);
    localHashMap.put("desc", "");
    localHashMap.put("path", paramag.nna);
    localHashMap.put("webViewUrl", h(paramag));
    localHashMap.put("imgUrl", ((l)localObject).jyi);
    if (paramt.lEi.JY("enable_share_with_share_ticket")) {}
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(paramt.lEi.JY("enable_share_dynamic")));
      localHashMap.put("origin", "weixin");
      paramt.lEi.H("user_clicked_share_btn", true);
      locala.a(paramag.getRuntime().bsE(), paramag.getComponentId()).K(localHashMap).bEo();
      AppMethodBeat.o(47655);
      return;
    }
  }
  
  public static boolean g(ag paramag)
  {
    AppMethodBeat.i(47653);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramag.getRuntime().bsB();
    if ((localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.leE.kNW == 0) && (com.tencent.mm.plugin.appbrand.config.a.lbE.a(localAppBrandSysConfigWC) == 2))
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (!paramag.yK(u.neY.ordinal()).neT)
    {
      AppMethodBeat.o(47653);
      return true;
    }
    AppMethodBeat.o(47653);
    return false;
  }
  
  private static String h(ag paramag)
  {
    AppMethodBeat.i(47656);
    paramag = paramag.bRM();
    if (paramag != null)
    {
      paramag = paramag.getWebView().getUrl();
      AppMethodBeat.o(47656);
      return paramag;
    }
    AppMethodBeat.o(47656);
    return null;
  }
  
  public final void a(Context paramContext, final ag paramag, final String paramString, final t paramt)
  {
    AppMethodBeat.i(47654);
    i.a(paramString, paramag.lBI, 39, "", Util.nowSecond(), 1, 0);
    if (g.an(paramag.getRuntime()))
    {
      a(paramag, paramt);
      AppMethodBeat.o(47654);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramag.getRuntime().bsB();
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(paramContext, "pref_appbrand_" + paramag.getRuntime().bsC().uin, 4);
    if ((localAppBrandSysConfigWC.leE.kNW == 1) && (!localSharedPreferences.contains("has_share_dev_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
      h.a(paramContext, 2131755465, 2131755998, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47650);
          o.a(paramag, paramt);
          AppMethodBeat.o(47650);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    if ((localAppBrandSysConfigWC.leE.kNW == 2) && (!localSharedPreferences.contains("has_share_beta_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
      h.a(paramContext, 2131755464, 2131755998, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47651);
          o.a(paramag, paramt);
          AppMethodBeat.o(47651);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    a(paramag, paramt);
    AppMethodBeat.o(47654);
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = 75;
    public static final String NAME = "onShareAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o
 * JD-Core Version:    0.7.0.1
 */