package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g qVy;
  
  static
  {
    AppMethodBeat.i(180659);
    qVy = new g();
    AppMethodBeat.o(180659);
  }
  
  static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(180656);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("AppBrandLauncherUIForceEntryConfig");
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getSing…ncherUIForceEntryConfig\")");
    AppMethodBeat.o(180656);
    return localMultiProcessMMKV;
  }
  
  public static String cjH()
  {
    AppMethodBeat.i(180658);
    String str2 = aal().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = "wxb6d22f922f37b35a";
    }
    AppMethodBeat.o(180658);
    return str1;
  }
  
  public static void el(Context paramContext)
  {
    AppMethodBeat.i(180657);
    p.k(paramContext, "context");
    e locale = new e(paramContext, 1, false);
    locale.a((q.f)b.qVz);
    locale.a((q.g)new a(paramContext));
    locale.eik();
    AppMethodBeat.o(180657);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig$showChooseSheet$1$2"})
  static final class a
    implements q.g
  {
    a(Context paramContext) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(272075);
      p.j(paramMenuItem, "menuItem");
      if (40 == paramMenuItem.getItemId())
      {
        localObject1 = this.$context$inlined;
        Object localObject2 = new Intent(this.$context$inlined, CarLicensePlateListUI.class);
        ((Intent)localObject2).addFlags(268435456);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig$showChooseSheet$$inlined$apply$lambda$1", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig$showChooseSheet$$inlined$apply$lambda$1", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if (30 == paramMenuItem.getItemId())
      {
        paramMenuItem = this.$context$inlined;
        localObject1 = new Intent(this.$context$inlined, AppBrandDebugUI.class);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig$showChooseSheet$$inlined$apply$lambda$1", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig$showChooseSheet$$inlined$apply$lambda$1", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(272075);
        return;
      }
      if (20 == paramMenuItem.getItemId())
      {
        paramMenuItem = m.ntn;
        paramMenuItem = new com.tencent.mm.plugin.appbrand.api.g();
        localObject1 = g.qVy;
        paramMenuItem.appId = g.cjH();
        paramMenuItem.scene = 1112;
        paramMenuItem.nBr = ((d)new k());
        m.a(paramMenuItem, (f)new f()
        {
          public final void onError(int paramAnonymousInt, String paramAnonymousString) {}
          
          public final void onSuccess() {}
        });
        AppMethodBeat.o(272075);
        return;
      }
      Object localObject1 = g.qVy;
      g.cjI().clearAll();
      paramInt = paramMenuItem.getItemId();
      if (paramInt == 0)
      {
        paramMenuItem = g.qVy;
        g.cjI().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
        AppMethodBeat.o(272075);
        return;
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        paramMenuItem = g.qVy;
        g.cjI().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
        paramMenuItem = g.qVy;
        localObject1 = g.cjI();
        if (paramInt != 2) {
          break label380;
        }
      }
      label380:
      for (paramMenuItem = "wx6bd2fb149a93a9c5";; paramMenuItem = null)
      {
        ((MultiProcessMMKV)localObject1).putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", paramMenuItem);
        AppMethodBeat.o(272075);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    public static final b qVz;
    
    static
    {
      AppMethodBeat.i(180653);
      qVz = new b();
      AppMethodBeat.o(180653);
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(180652);
      paramo.mn(0, au.i.app_brand_find_more_ui_choose_force_entry_native_launcher);
      paramo.mn(1, au.i.app_brand_find_more_ui_choose_force_entry_fake_native_we_use);
      paramo.mn(2, au.i.app_brand_find_more_ui_choose_force_entry_fake_native_we_use_internal);
      paramo.mn(10, au.i.app_brand_find_more_ui_choose_force_entry_clear_config);
      paramo.mn(20, au.i.app_brand_find_more_ui_choose_silent_launch_fake_native);
      paramo.mn(30, au.i.app_brand_find_more_ui_choose_open_debug_ui);
      paramo.mn(40, au.i.car_license_plate_entrance);
      AppMethodBeat.o(180652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */