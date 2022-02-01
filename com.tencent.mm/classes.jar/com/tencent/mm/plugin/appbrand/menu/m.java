package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class m
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ae>
{
  public m()
  {
    super(q.kSb.ordinal());
    AppMethodBeat.i(47652);
    AppMethodBeat.o(47652);
  }
  
  static void a(ae paramae, p paramp)
  {
    AppMethodBeat.i(47655);
    Object localObject = paramae.getRuntime().aNb();
    a locala = new a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", ((k)localObject).dfM);
    localHashMap.put("desc", "");
    localHashMap.put("path", paramae.kWX);
    localHashMap.put("webViewUrl", g(paramae));
    localHashMap.put("imgUrl", ((k)localObject).hGe);
    if (paramp.jBF.tE("enable_share_with_share_ticket")) {}
    for (localObject = "withShareTicket";; localObject = "common")
    {
      localHashMap.put("mode", localObject);
      localHashMap.put("dynamic", Boolean.valueOf(paramp.jBF.tE("enable_share_dynamic")));
      paramp.jBF.F("user_clicked_share_btn", true);
      locala.a(paramae.getRuntime().aNe(), paramae.aOd()).B(localHashMap).aXQ();
      AppMethodBeat.o(47655);
      return;
    }
  }
  
  public static boolean f(ae paramae)
  {
    AppMethodBeat.i(47653);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramae.getRuntime().aNb();
    if ((localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.jdS.iOQ == 0) && ((localAppBrandSysConfigWC.cfT & 0x20) > 0L))
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (!paramae.ts(q.kSb.ordinal()).kRX)
    {
      AppMethodBeat.o(47653);
      return true;
    }
    AppMethodBeat.o(47653);
    return false;
  }
  
  private static String g(ae paramae)
  {
    AppMethodBeat.i(47656);
    paramae = paramae.bkd();
    if (paramae != null)
    {
      paramae = paramae.getWebView().getUrl();
      AppMethodBeat.o(47656);
      return paramae;
    }
    AppMethodBeat.o(47656);
    return null;
  }
  
  public final void a(Context paramContext, final ae paramae, final String paramString, final p paramp)
  {
    AppMethodBeat.i(47654);
    com.tencent.mm.plugin.appbrand.report.h.a(paramString, paramae.jzm, 39, "", bt.aGK(), 1, 0);
    if (g.as(paramae.getRuntime()))
    {
      a(paramae, paramp);
      AppMethodBeat.o(47654);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramae.getRuntime().aNb();
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(paramContext, "pref_appbrand_" + paramae.getRuntime().aNc().uin, 4);
    if ((localAppBrandSysConfigWC.jdS.iOQ == 1) && (!localSharedPreferences.contains("has_share_dev_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
      com.tencent.mm.ui.base.h.a(paramContext, 2131755427, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47650);
          m.a(paramae, paramp);
          AppMethodBeat.o(47650);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    if ((localAppBrandSysConfigWC.jdS.iOQ == 2) && (!localSharedPreferences.contains("has_share_beta_tips")))
    {
      localSharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
      com.tencent.mm.ui.base.h.a(paramContext, 2131755426, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(47651);
          m.a(paramae, paramp);
          AppMethodBeat.o(47651);
        }
      });
      AppMethodBeat.o(47654);
      return;
    }
    a(paramae, paramp);
    AppMethodBeat.o(47654);
  }
  
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    private static final int CTRL_INDEX = 75;
    public static final String NAME = "onShareAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.m
 * JD-Core Version:    0.7.0.1
 */