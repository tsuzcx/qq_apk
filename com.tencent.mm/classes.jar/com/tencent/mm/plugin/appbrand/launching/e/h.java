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
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long lSe = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(222811);
    String str2 = paramLaunchParcel.appId;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = v.Om(paramLaunchParcel.username);
    }
    AppMethodBeat.o(222811);
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
    Object localObject2 = b.c(paramLaunchParcel, (String)localObject1);
    com.tencent.mm.plugin.appbrand.report.quality.f.a(paramLaunchParcel, (String)localObject2, (String)localObject1);
    com.tencent.mm.plugin.appbrand.report.quality.f.b(paramLaunchParcel, (String)localObject2, (String)localObject1);
    Object localObject3 = t.mwW;
    t.b(paramLaunchParcel, (String)localObject2);
    if (n.byR())
    {
      localObject3 = n.mAZ;
      n.ep((String)localObject1, (String)localObject2);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { az.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.hSZ;
    if ((!bu.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.f.ce((String)localObject1, i)))
    {
      localObject3 = g.beC().NS((String)localObject1);
      if ((localObject3 != null) && (((AppBrandInitConfigWC)localObject3).dQv == i))
      {
        paramLaunchParcel.f((AppBrandInitConfigLU)localObject3);
        ((AppBrandInitConfigWC)localObject3).kaN = paramLaunchParcel.kaN;
        ((AppBrandInitConfigWC)localObject3).kaM = paramLaunchParcel.kaM;
        ((AppBrandInitConfigWC)localObject3).launchMode = paramLaunchParcel.launchMode;
        ((AppBrandInitConfigWC)localObject3).jFV = paramLaunchParcel.jFV;
        ((AppBrandInitConfigWC)localObject3).kaS = new QualitySession((String)localObject2, (AppBrandInitConfigWC)localObject3, paramLaunchParcel.lRA);
        ((AppBrandInitConfigWC)localObject3).kaS.mAh = false;
        ((AppBrandInitConfigWC)localObject3).jFX = paramLaunchParcel.jFX;
        if (paramLaunchParcel.lRG != null) {}
        for (((AppBrandInitConfigWC)localObject3).kba = ((WeAppOpenDeclarePromptBundle)paramLaunchParcel.lRG);; ((AppBrandInitConfigWC)localObject3).kba = null)
        {
          ((AppBrandInitConfigLU)localObject3).cmD = false;
          i.b(paramContext, (AppBrandInitConfigWC)localObject3, paramLaunchParcel.lRA);
          paramContext = t.mwW;
          t.f((AppBrandInitConfigWC)localObject3);
          AppMethodBeat.o(47462);
          return true;
        }
      }
    }
    if (Math.abs(System.currentTimeMillis() - lSe) < 200L)
    {
      ae.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    lSe = bu.fpO();
    ae.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.cmx != null) && (4 == paramLaunchParcel.cmx.kbg))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject3 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label655;
      }
      bool1 = true;
      label421:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject3, bool1).a(paramLaunchParcel, (String)localObject2);
      ae.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.lRA });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label661;
      }
      ((Intent)localObject1).addFlags(268435456);
      label507:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject3);
      if ((bool2) && (paramLaunchParcel.lRB != null) && (paramLaunchParcel.lRB.cmy != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.lRB.cmy.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.lRB.cmy.kbF);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.jFR < 0)) {
        break label673;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramLaunchParcel.jFR);
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
      label655:
      bool1 = false;
      break label421;
      label661:
      c((Intent)localObject1, (Activity)paramContext);
      break label507;
      label673:
      if (paramLaunchParcel.lIP != null)
      {
        int j = ((Intent)localObject1).getFlags();
        try
        {
          ((Intent)localObject1).setFlags(0xEFFFFFFF & j);
          paramLaunchParcel = paramLaunchParcel.lIP;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramLaunchParcel, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramLaunchParcel.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramLaunchParcel, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        catch (Exception paramLaunchParcel)
        {
          ((Intent)localObject1).setFlags(j);
          paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.ahE(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramLaunchParcel.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      else
      {
        paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.ahE(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramLaunchParcel.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.h
 * JD-Core Version:    0.7.0.1
 */