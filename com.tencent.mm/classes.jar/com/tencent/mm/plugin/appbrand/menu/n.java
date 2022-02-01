package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class n
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ad>
{
  public n()
  {
    super(s.lXl.ordinal());
    AppMethodBeat.i(47652);
    AppMethodBeat.o(47652);
  }
  
  static void a(ad paramad, r paramr)
  {
    AppMethodBeat.i(47655);
    Object localObject = paramad.getRuntime().aXw();
    a locala = new a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", ((k)localObject).dpI);
    localHashMap.put("desc", "");
    localHashMap.put("path", paramad.mcM);
    localHashMap.put("webViewUrl", g(paramad));
    localHashMap.put("imgUrl", ((k)localObject).iCT);
    if (paramr.kzP.Bs("enable_share_with_share_ticket")) {}
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(paramr.kzP.Bs("enable_share_dynamic")));
      localHashMap.put("origin", "weixin");
      paramr.kzP.G("user_clicked_share_btn", true);
      locala.a(paramad.getRuntime().aXz(), paramad.aXX()).H(localHashMap).bja();
      AppMethodBeat.o(47655);
      return;
    }
  }
  
  public static boolean f(ad paramad)
  {
    AppMethodBeat.i(47653);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramad.getRuntime().aXw();
    if ((localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.kbw.jLV == 0) && ((localAppBrandSysConfigWC.cnj & 0x20) > 0L))
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (!paramad.uS(s.lXl.ordinal()).lXh)
    {
      AppMethodBeat.o(47653);
      return true;
    }
    AppMethodBeat.o(47653);
    return false;
  }
  
  private static String g(ad paramad)
  {
    AppMethodBeat.i(47656);
    paramad = paramad.bvG();
    if (paramad != null)
    {
      paramad = paramad.getWebView().getUrl();
      AppMethodBeat.o(47656);
      return paramad;
    }
    AppMethodBeat.o(47656);
    return null;
  }
  
  public final void a(Context paramContext, final ad paramad, final String paramString, final r paramr)
  {
    AppMethodBeat.i(47654);
    com.tencent.mm.plugin.appbrand.report.h.a(paramString, paramad.kxv, 39, "", bu.aRi(), 1, 0);
    if (g.am(paramad.getRuntime()))
    {
      a(paramad, paramr);
      AppMethodBeat.o(47654);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramad.getRuntime().aXw();
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(paramContext, "pref_appbrand_" + paramad.getRuntime().aXx().uin, 4);
    if ((localAppBrandSysConfigWC.kbw.jLV == 1) && (!localSharedPreferences.contains("has_share_dev_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
      com.tencent.mm.ui.base.h.a(paramContext, 2131755427, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47650);
          n.a(paramad, paramr);
          AppMethodBeat.o(47650);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    if ((localAppBrandSysConfigWC.kbw.jLV == 2) && (!localSharedPreferences.contains("has_share_beta_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
      com.tencent.mm.ui.base.h.a(paramContext, 2131755426, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47651);
          n.a(paramad, paramr);
          AppMethodBeat.o(47651);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    a(paramad, paramr);
    AppMethodBeat.o(47654);
  }
  
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    private static final int CTRL_INDEX = 75;
    public static final String NAME = "onShareAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.n
 * JD-Core Version:    0.7.0.1
 */