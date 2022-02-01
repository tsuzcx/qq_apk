package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Locale;

public final class h
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long pZO = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(281159);
    paramLaunchParcel = (String)com.tencent.luggage.sdk.h.d.a(String.format(Locale.ENGLISH, "tryGetAppId(%s, %s)", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId }), new kotlin.g.a.a() {});
    AppMethodBeat.o(281159);
    return paramLaunchParcel;
  }
  
  static void c(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(47463);
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
    Object localObject2 = g.c(paramLaunchParcel, (String)localObject1);
    g.a(paramLaunchParcel, (String)localObject2, (String)localObject1);
    Object localObject3 = x.qKl;
    x.b(paramLaunchParcel, (String)localObject2);
    if (o.civ())
    {
      localObject3 = o.qOt;
      o.eW((String)localObject1, (String)localObject2);
      c.d(KSProcessWeAppLaunch.class, (String)localObject1);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.cBU;
    if ((!Util.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.i.cjb().w((String)localObject1, i)))
    {
      localObject3 = com.tencent.mm.plugin.appbrand.config.h.bLi().aeM((String)localObject1);
      if ((localObject3 != null) && (((AppBrandInitConfigWC)localObject3).cBI == i))
      {
        paramLaunchParcel.f((AppBrandInitConfigLU)localObject3);
        WeAppOpenUICallbackIPCProxy.c.a((AppBrandInitConfigWC)localObject3, paramLaunchParcel);
        ((AppBrandInitConfigWC)localObject3).nYf = paramLaunchParcel.nYf;
        ((AppBrandInitConfigWC)localObject3).nYe = paramLaunchParcel.nYe;
        ((AppBrandInitConfigWC)localObject3).launchMode = paramLaunchParcel.launchMode;
        if (paramLaunchParcel.pZj == null)
        {
          i = 0;
          ((AppBrandInitConfigWC)localObject3).lyw = i;
          ((AppBrandInitConfigWC)localObject3).fWY = paramLaunchParcel.fWY;
          ((AppBrandInitConfigWC)localObject3).nYk = new QualitySession((String)localObject2, (AppBrandInitConfigWC)localObject3, paramLaunchParcel.pdk);
          ((AppBrandInitConfigWC)localObject3).dW((String)localObject2);
          ((AppBrandInitConfigWC)localObject3).nYk.qNz = false;
          ((AppBrandInitConfigWC)localObject3).nBB = paramLaunchParcel.nBB;
          if (paramLaunchParcel.pZo == null) {
            break label336;
          }
        }
        label336:
        for (((AppBrandInitConfigWC)localObject3).nYs = ((WeAppOpenDeclarePromptBundle)paramLaunchParcel.pZo);; ((AppBrandInitConfigWC)localObject3).nYs = null)
        {
          ((AppBrandInitConfigLU)localObject3).cxd = false;
          ((AppBrandInitConfigWC)localObject3).nBE = paramLaunchParcel.nBE;
          ((AppBrandInitConfigWC)localObject3).nBF = paramLaunchParcel.nBF;
          ((AppBrandInitConfigWC)localObject3).nBJ = paramLaunchParcel.nBJ;
          i.b(paramContext, (AppBrandInitConfigWC)localObject3, paramLaunchParcel.pdk);
          paramContext = x.qKl;
          x.f((AppBrandInitConfigWC)localObject3);
          AppMethodBeat.o(47462);
          return true;
          i = paramLaunchParcel.pZj.lyw;
          break;
        }
      }
    }
    if (Math.abs(System.currentTimeMillis() - pZO) < 200L)
    {
      Log.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    pZO = Util.nowMilliSecond();
    Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.cwV != null) && (4 == paramLaunchParcel.cwV.nYB))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject3 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label716;
      }
      bool1 = true;
      label482:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject3, bool1).a(paramLaunchParcel, (String)localObject2);
      Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.pdk });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label722;
      }
      ((Intent)localObject1).addFlags(268435456);
      label568:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject3);
      if ((bool2) && (paramLaunchParcel.pZj != null) && (paramLaunchParcel.pZj.cwW != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.pZj.cwW.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.pZj.cwW.nZa);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.nBw < 0)) {
        break label734;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramLaunchParcel.nBw);
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
      label716:
      bool1 = false;
      break label482;
      label722:
      c((Intent)localObject1, (Activity)paramContext);
      break label568;
      label734:
      if (paramLaunchParcel.pRy != null)
      {
        int j = ((Intent)localObject1).getFlags();
        try
        {
          ((Intent)localObject1).setFlags(0xEFFFFFFF & j);
          paramLaunchParcel = paramLaunchParcel.pRy;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramLaunchParcel, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramLaunchParcel.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramLaunchParcel, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        catch (Exception paramLaunchParcel)
        {
          ((Intent)localObject1).setFlags(j);
          paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLaunchParcel.aFh(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramLaunchParcel.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      else
      {
        paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLaunchParcel.aFh(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramLaunchParcel.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.h
 * JD-Core Version:    0.7.0.1
 */