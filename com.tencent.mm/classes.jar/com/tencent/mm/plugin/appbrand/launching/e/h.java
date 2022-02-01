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
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long lqi = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(186861);
    String str2 = paramLaunchParcel.appId;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = u.Kl(paramLaunchParcel.username);
    }
    AppMethodBeat.o(186861);
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
    Object localObject2 = s.lSi;
    s.b(paramLaunchParcel, str);
    if (n.btU())
    {
      localObject2 = n.lWn;
      n.ec((String)localObject1, str);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { ax.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.hxM;
    if ((!bs.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.f.bX((String)localObject1, i)))
    {
      localObject2 = g.baw().JS((String)localObject1);
      if ((localObject2 != null) && (((AppBrandInitConfigWC)localObject2).joY == i))
      {
        paramLaunchParcel.d((AppBrandInitConfigLU)localObject2);
        ((AppBrandInitConfigWC)localObject2).jDC = paramLaunchParcel.jDC;
        ((AppBrandInitConfigWC)localObject2).jDB = paramLaunchParcel.jDB;
        ((AppBrandInitConfigWC)localObject2).launchMode = paramLaunchParcel.launchMode;
        ((AppBrandInitConfigWC)localObject2).jjq = paramLaunchParcel.jjq;
        ((AppBrandInitConfigWC)localObject2).jjp = paramLaunchParcel.jjp;
        ((AppBrandInitConfigWC)localObject2).jDH = new QualitySession(str, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.lpG);
        ((AppBrandInitConfigWC)localObject2).jjr = paramLaunchParcel.jjr;
        ((AppBrandInitConfigLU)localObject2).cck = false;
        i.b(paramContext, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.lpG);
        paramContext = s.lSi;
        s.g((AppBrandInitConfigWC)localObject2);
        AppMethodBeat.o(47462);
        return true;
      }
    }
    if (Math.abs(System.currentTimeMillis() - lqi) < 200L)
    {
      ac.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    lqi = bs.eWj();
    ac.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.cce != null) && (4 == paramLaunchParcel.cce.jDQ))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject2 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label619;
      }
      bool1 = true;
      label385:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject2, bool1).a(paramLaunchParcel, str);
      ac.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.lpG });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label625;
      }
      ((Intent)localObject1).addFlags(268435456);
      label471:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject2);
      if ((bool2) && (paramLaunchParcel.lpH != null) && (paramLaunchParcel.lpH.ccf != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.lpH.ccf.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.lpH.ccf.jEo);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.jjl < 0)) {
        break label637;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramLaunchParcel.jjl);
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
      label619:
      bool1 = false;
      break label385;
      label625:
      c((Intent)localObject1, (Activity)paramContext);
      break label471;
      label637:
      paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.aeD(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLaunchParcel.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.h
 * JD-Core Version:    0.7.0.1
 */