package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f ube;
  
  static
  {
    AppMethodBeat.i(180659);
    ube = new f();
    AppMethodBeat.o(180659);
  }
  
  private static final void a(Context paramContext, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(322086);
    kotlin.g.b.s.u(paramContext, "$context");
    if (40 == paramMenuItem.getItemId())
    {
      Object localObject = new Intent(paramContext, CarLicensePlateListUI.class);
      ((Intent)localObject).addFlags(268435456);
      ah localah = ah.aiuX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig", "showChooseSheet$lambda-4$lambda-3", "(Landroid/content/Context;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig", "showChooseSheet$lambda-4$lambda-3", "(Landroid/content/Context;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    if (30 == paramMenuItem.getItemId())
    {
      paramMenuItem = new Intent(paramContext, AppBrandDebugUI.class);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramMenuItem.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig", "showChooseSheet$lambda-4$lambda-3", "(Landroid/content/Context;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig", "showChooseSheet$lambda-4$lambda-3", "(Landroid/content/Context;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(322086);
      return;
    }
    if (20 == paramMenuItem.getItemId())
    {
      paramContext = m.qrR;
      paramContext = new g();
      paramContext.appId = cKU();
      paramContext.scene = 1112;
      paramContext.qAG = ((d)new k());
      paramMenuItem = ah.aiuX;
      m.a(paramContext, (com.tencent.mm.plugin.appbrand.api.f)new a());
      AppMethodBeat.o(322086);
      return;
    }
    aBP().clearAll();
    paramInt = paramMenuItem.getItemId();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(322086);
      return;
    case 0: 
      aBP().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
      AppMethodBeat.o(322086);
      return;
    }
    aBP().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
    paramMenuItem = aBP();
    if (paramInt == 2) {}
    for (paramContext = "wx6bd2fb149a93a9c5";; paramContext = null)
    {
      paramMenuItem.putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", paramContext);
      break;
    }
  }
  
  static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(180656);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("AppBrandLauncherUIForceEntryConfig");
    kotlin.g.b.s.s(localMultiProcessMMKV, "getSingleMMKV(\"AppBrandL…ncherUIForceEntryConfig\")");
    AppMethodBeat.o(180656);
    return localMultiProcessMMKV;
  }
  
  private static final void b(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(322080);
    params.oh(0, ba.i.app_brand_find_more_ui_choose_force_entry_native_launcher);
    params.oh(1, ba.i.app_brand_find_more_ui_choose_force_entry_fake_native_we_use);
    params.oh(2, ba.i.app_brand_find_more_ui_choose_force_entry_fake_native_we_use_internal);
    params.oh(10, ba.i.app_brand_find_more_ui_choose_force_entry_clear_config);
    params.oh(20, ba.i.app_brand_find_more_ui_choose_silent_launch_fake_native);
    params.oh(30, ba.i.app_brand_find_more_ui_choose_open_debug_ui);
    params.oh(40, ba.i.car_license_plate_entrance);
    AppMethodBeat.o(322080);
  }
  
  public static String cKU()
  {
    AppMethodBeat.i(180658);
    String str = aBP().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
    if (str == null)
    {
      AppMethodBeat.o(180658);
      return "wxb6d22f922f37b35a";
    }
    AppMethodBeat.o(180658);
    return str;
  }
  
  public static void fh(Context paramContext)
  {
    AppMethodBeat.i(180657);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
    localf.Vtg = f..ExternalSyntheticLambda0.INSTANCE;
    localf.GAC = new f..ExternalSyntheticLambda1(paramContext);
    localf.dDn();
    AppMethodBeat.o(180657);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig$showChooseSheet$1$2$3", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.appbrand.api.f
  {
    public final void onError(int paramInt, String paramString) {}
    
    public final void onSuccess() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */