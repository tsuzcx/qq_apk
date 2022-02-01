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
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long mZq = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(227139);
    String str2 = paramLaunchParcel.appId;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = y.Xw(paramLaunchParcel.username);
    }
    AppMethodBeat.o(227139);
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
    Object localObject2 = g.c(paramLaunchParcel, (String)localObject1);
    g.a(paramLaunchParcel, (String)localObject2, (String)localObject1);
    Object localObject3 = w.nHZ;
    w.b(paramLaunchParcel, (String)localObject2);
    if (o.bVk())
    {
      localObject3 = o.nMe;
      o.eI((String)localObject1, (String)localObject2);
      c.e(KSProcessWeAppLaunch.class, (String)localObject1);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.iOo;
    if ((!Util.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.h.bWb().cn((String)localObject1, i)))
    {
      localObject3 = com.tencent.mm.plugin.appbrand.config.h.bzT().Xa((String)localObject1);
      if ((localObject3 != null) && (((AppBrandInitConfigWC)localObject3).eix == i))
      {
        paramLaunchParcel.f((AppBrandInitConfigLU)localObject3);
        WeAppOpenUICallbackIPCProxy.c.a((AppBrandInitConfigWC)localObject3, paramLaunchParcel);
        ((AppBrandInitConfigWC)localObject3).ldR = paramLaunchParcel.ldR;
        ((AppBrandInitConfigWC)localObject3).ldQ = paramLaunchParcel.ldQ;
        ((AppBrandInitConfigWC)localObject3).launchMode = paramLaunchParcel.launchMode;
        ((AppBrandInitConfigWC)localObject3).kHG = paramLaunchParcel.kHG;
        ((AppBrandInitConfigWC)localObject3).ldW = new QualitySession((String)localObject2, (AppBrandInitConfigWC)localObject3, paramLaunchParcel.mYK);
        ((AppBrandInitConfigWC)localObject3).dC((String)localObject2);
        ((AppBrandInitConfigWC)localObject3).ldW.nLm = false;
        ((AppBrandInitConfigWC)localObject3).kHI = paramLaunchParcel.kHI;
        if (paramLaunchParcel.mYQ != null) {}
        for (((AppBrandInitConfigWC)localObject3).lee = ((WeAppOpenDeclarePromptBundle)paramLaunchParcel.mYQ);; ((AppBrandInitConfigWC)localObject3).lee = null)
        {
          ((AppBrandInitConfigLU)localObject3).cyy = false;
          ((AppBrandInitConfigWC)localObject3).kHL = paramLaunchParcel.kHL;
          ((AppBrandInitConfigWC)localObject3).kHM = paramLaunchParcel.kHM;
          ((AppBrandInitConfigWC)localObject3).kHQ = paramLaunchParcel.kHQ;
          i.b(paramContext, (AppBrandInitConfigWC)localObject3, paramLaunchParcel.mYK);
          paramContext = w.nHZ;
          w.h((AppBrandInitConfigWC)localObject3);
          AppMethodBeat.o(47462);
          return true;
        }
      }
    }
    if (Math.abs(System.currentTimeMillis() - mZq) < 200L)
    {
      Log.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    mZq = Util.nowMilliSecond();
    Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.cys != null) && (4 == paramLaunchParcel.cys.leo))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject3 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label692;
      }
      bool1 = true;
      label458:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject3, bool1).a(paramLaunchParcel, (String)localObject2);
      Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.mYK });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label698;
      }
      ((Intent)localObject1).addFlags(268435456);
      label544:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject3);
      if ((bool2) && (paramLaunchParcel.mYL != null) && (paramLaunchParcel.mYL.cyt != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.mYL.cyt.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.mYL.cyt.leN);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.kHC < 0)) {
        break label710;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramLaunchParcel.kHC);
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
      label692:
      bool1 = false;
      break label458;
      label698:
      c((Intent)localObject1, (Activity)paramContext);
      break label544;
      label710:
      if (paramLaunchParcel.mQC != null)
      {
        int j = ((Intent)localObject1).getFlags();
        try
        {
          ((Intent)localObject1).setFlags(0xEFFFFFFF & j);
          paramLaunchParcel = paramLaunchParcel.mQC;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramLaunchParcel, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramLaunchParcel.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramLaunchParcel, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        catch (Exception paramLaunchParcel)
        {
          ((Intent)localObject1).setFlags(j);
          paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramLaunchParcel.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      else
      {
        paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramLaunchParcel.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.h
 * JD-Core Version:    0.7.0.1
 */