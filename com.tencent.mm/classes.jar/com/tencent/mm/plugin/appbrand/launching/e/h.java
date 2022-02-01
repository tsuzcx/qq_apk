package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class h
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  private static long lND = 0L;
  
  public static String a(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(188649);
    String str2 = paramLaunchParcel.appId;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = v.NE(paramLaunchParcel.username);
    }
    AppMethodBeat.o(188649);
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
    com.tencent.mm.plugin.appbrand.report.quality.f.b(paramLaunchParcel, str, (String)localObject1);
    Object localObject2 = t.mrY;
    t.b(paramLaunchParcel, str);
    if (n.bxY())
    {
      localObject2 = n.mwc;
      n.em((String)localObject1, str);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1);
      c.a(KSProcessWeAppLaunch.class, (String)localObject1, String.format("Network:%s", new Object[] { ay.getNetTypeString(paramContext) }));
    }
    int i = paramLaunchParcel.hQh;
    if ((!bt.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.f.ca((String)localObject1, i)))
    {
      localObject2 = g.bdW().Nl((String)localObject1);
      if ((localObject2 != null) && (((AppBrandInitConfigWC)localObject2).dPf == i))
      {
        paramLaunchParcel.d((AppBrandInitConfigLU)localObject2);
        ((AppBrandInitConfigWC)localObject2).jXy = paramLaunchParcel.jXy;
        ((AppBrandInitConfigWC)localObject2).jXx = paramLaunchParcel.jXx;
        ((AppBrandInitConfigWC)localObject2).launchMode = paramLaunchParcel.launchMode;
        ((AppBrandInitConfigWC)localObject2).jCX = paramLaunchParcel.jCX;
        ((AppBrandInitConfigWC)localObject2).jXD = new QualitySession(str, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.lMZ);
        ((AppBrandInitConfigWC)localObject2).jXD.mvk = false;
        ((AppBrandInitConfigWC)localObject2).jCZ = paramLaunchParcel.jCZ;
        if (paramLaunchParcel.lNf != null) {}
        for (((AppBrandInitConfigWC)localObject2).jXL = ((WeAppOpenDeclarePromptBundle)paramLaunchParcel.lNf);; ((AppBrandInitConfigWC)localObject2).jXL = null)
        {
          ((AppBrandInitConfigLU)localObject2).cmB = false;
          i.b(paramContext, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.lMZ);
          paramContext = t.mrY;
          t.f((AppBrandInitConfigWC)localObject2);
          AppMethodBeat.o(47462);
          return true;
        }
      }
    }
    if (Math.abs(System.currentTimeMillis() - lND) < 200L)
    {
      ad.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(47462);
      return false;
    }
    lND = bt.flT();
    ad.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool1;
    if ((paramLaunchParcel.cmv != null) && (4 == paramLaunchParcel.cmv.jXR))
    {
      i = 1;
      boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
      localObject2 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
      if (bool2) {
        break label655;
      }
      bool1 = true;
      label421:
      if (i != 0) {
        bool1 = false;
      }
      new d(paramContext, (String)localObject2, bool1).a(paramLaunchParcel, str);
      ad.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.lMZ });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label661;
      }
      ((Intent)localObject1).addFlags(268435456);
      label507:
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject2);
      if ((bool2) && (paramLaunchParcel.lNa != null) && (paramLaunchParcel.lNa.cmw != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.lNa.cmw.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.lNa.cmw.jYq);
      }
      if ((!(paramContext instanceof Activity)) || (paramLaunchParcel.jCT < 0)) {
        break label673;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramLaunchParcel.jCT);
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
      paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.ahp(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLaunchParcel.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.h
 * JD-Core Version:    0.7.0.1
 */