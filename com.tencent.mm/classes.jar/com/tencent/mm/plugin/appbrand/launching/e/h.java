package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long kOJ = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(196037);
    String str2 = paramLaunchParcel.appId;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = u.Gh(paramLaunchParcel.username);
    }
    AppMethodBeat.o(196037);
    return str1;
  }
  
  static void c(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(47463);
    paramIntent.putExtra("key_from_activity_requested_orientation", paramActivity.getRequestedOrientation());
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramIntent.putExtra("extra_from_activity_status_bar_color", paramActivity.getWindow().getStatusBarColor());
        paramIntent.putExtra("extra_from_activity_navigation_bar_color", paramActivity.getWindow().getNavigationBarColor());
      }
      paramIntent.putExtra("extra_from_activity_window_attributes", paramActivity.getWindow().getAttributes());
      AppMethodBeat.o(47463);
      return;
    }
    catch (NullPointerException paramIntent)
    {
      AppMethodBeat.o(47463);
    }
  }
  
  public final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(47462);
    Object localObject1 = a(paramLaunchParcel);
    String str = com.tencent.mm.plugin.appbrand.utils.a.c(paramLaunchParcel, (String)localObject1);
    com.tencent.mm.plugin.appbrand.report.quality.f.a(paramLaunchParcel, str, (String)localObject1);
    Object localObject2 = t.lqn;
    t.b(paramLaunchParcel, str);
    if (n.bmY())
    {
      localObject2 = n.lut;
      n.dQ((String)localObject1, str);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { ay.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.gXn;
    if ((!bt.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.f.bS((String)localObject1, i)))
    {
      localObject2 = g.aTy().FO((String)localObject1);
      if ((localObject2 != null) && (((AppBrandInitConfigWC)localObject2).iOP == i))
      {
        paramLaunchParcel.d((AppBrandInitConfigLU)localObject2);
        ((AppBrandInitConfigWC)localObject2).jdp = paramLaunchParcel.jdp;
        ((AppBrandInitConfigWC)localObject2).jdo = paramLaunchParcel.jdo;
        ((AppBrandInitConfigWC)localObject2).launchMode = paramLaunchParcel.launchMode;
        ((AppBrandInitConfigWC)localObject2).iJm = paramLaunchParcel.iJm;
        ((AppBrandInitConfigWC)localObject2).iJl = paramLaunchParcel.iJl;
        ((AppBrandInitConfigWC)localObject2).jdu = new QualitySession(str, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.kOh);
        ((AppBrandInitConfigLU)localObject2).cfn = false;
        i.b(paramContext, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.kOh);
        paramContext = t.lqn;
        t.g((AppBrandInitConfigWC)localObject2);
        AppMethodBeat.o(47462);
        return true;
      }
    }
    if (Math.abs(System.currentTimeMillis() - kOJ) < 200L)
    {
      ad.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    kOJ = bt.eGO();
    ad.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.cfi != null) && (4 == paramLaunchParcel.cfi.jdC))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject2 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label607;
      }
      bool1 = true;
      label374:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject2, bool1).a(paramLaunchParcel, str);
      ad.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.kOh });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label613;
      }
      ((Intent)localObject1).addFlags(268435456);
      label459:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject2);
      if ((bool2) && (paramLaunchParcel.kOi != null) && (paramLaunchParcel.kOi.cfj != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.kOi.cfj.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.kOi.cfj.jea);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.iJh < 0)) {
        break label625;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramLaunchParcel.iJh);
    }
    for (;;)
    {
      if ((i != 0) && ((paramContext instanceof MMActivity))) {
        ((MMActivity)paramContext).hideAllManagedDialogs();
      }
      AppMethodBeat.o(47462);
      return true;
      i = 0;
      break;
      label607:
      bool1 = false;
      break label374;
      label613:
      c((Intent)localObject1, (Activity)paramContext);
      break label459;
      label625:
      paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.adn(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLaunchParcel.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.h
 * JD-Core Version:    0.7.0.1
 */