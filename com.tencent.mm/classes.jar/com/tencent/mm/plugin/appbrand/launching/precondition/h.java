package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends a
{
  private static long iod = 0L;
  
  static void c(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(143449);
    paramIntent.putExtra("key_from_activity_requested_orientation", paramActivity.getRequestedOrientation());
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramIntent.putExtra("extra_from_activity_status_bar_color", paramActivity.getWindow().getStatusBarColor());
        paramIntent.putExtra("extra_from_activity_navigation_bar_color", paramActivity.getWindow().getNavigationBarColor());
      }
      paramIntent.putExtra("extra_from_activity_window_attributes", paramActivity.getWindow().getAttributes());
      AppMethodBeat.o(143449);
      return;
    }
    catch (NullPointerException paramIntent)
    {
      AppMethodBeat.o(143449);
    }
  }
  
  public final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(132077);
    String str = com.tencent.mm.plugin.appbrand.report.quality.f.a(paramLaunchParcel);
    Object localObject2 = paramLaunchParcel.appId;
    int i = paramLaunchParcel.hcr;
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = com.tencent.mm.plugin.appbrand.config.f.ayv().bZ(paramLaunchParcel.username);
    }
    if ((!bo.isNullOrNil((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.h.bv((String)localObject1, i)))
    {
      localObject2 = com.tencent.mm.plugin.appbrand.config.f.ayv().Aa((String)localObject1);
      if ((localObject2 != null) && (((AppBrandInitConfigWC)localObject2).gXd == i))
      {
        paramLaunchParcel.c((AppBrandInitConfigLU)localObject2);
        ((AppBrandInitConfigWC)localObject2).hiI = new QualitySession(str, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.inG);
        ((AppBrandInitConfigLU)localObject2).bDg = false;
        j.b(paramContext, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.inG);
        AppMethodBeat.o(132077);
        return true;
      }
    }
    if (Math.abs(System.currentTimeMillis() - iod) < 200L)
    {
      ab.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      AppMethodBeat.o(132077);
      return false;
    }
    iod = bo.aoy();
    ab.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    boolean bool2 = "wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject1);
    localObject2 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      new d(paramContext, (String)localObject2, bool1).a(paramLaunchParcel, str);
      ab.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.inG });
      localObject1 = new Intent(paramContext, AppBrandLaunchProxyUI.class);
      if ((paramContext instanceof Activity)) {
        break label434;
      }
      ((Intent)localObject1).addFlags(268435456);
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("extra_from_mm", true);
      ((Intent)localObject1).putExtra("extra_entry_token", (String)localObject2);
      if ((bool2) && (paramLaunchParcel.inH != null) && (paramLaunchParcel.inH.bDa != null))
      {
        ((Intent)localObject1).putExtra("extra_launch_weishi_video", true);
        ((Intent)localObject1).putExtra("extra_launch_thumb_url", paramLaunchParcel.inH.bDa.thumbUrl);
        ((Intent)localObject1).putExtra("extra_launch_thumb_path", paramLaunchParcel.inH.bDa.inD);
      }
      paramContext.startActivity((Intent)localObject1);
      AppMethodBeat.o(132077);
      return true;
      bool1 = false;
      break;
      label434:
      c((Intent)localObject1, (Activity)paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.h
 * JD-Core Version:    0.7.0.1
 */