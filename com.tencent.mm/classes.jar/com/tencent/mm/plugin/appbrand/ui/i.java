package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class i
{
  public static final i nTZ;
  
  static
  {
    AppMethodBeat.i(180659);
    nTZ = new i();
    AppMethodBeat.o(180659);
  }
  
  static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(180656);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("AppBrandLauncherUIForceEntryConfig");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getSing…ncherUIForceEntryConfig\")");
    AppMethodBeat.o(180656);
    return localMultiProcessMMKV;
  }
  
  public static String bXd()
  {
    AppMethodBeat.i(180658);
    String str2 = VQ().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = "wxb6d22f922f37b35a";
    }
    AppMethodBeat.o(180658);
    return str1;
  }
  
  public static void em(Context paramContext)
  {
    AppMethodBeat.i(180657);
    p.h(paramContext, "context");
    paramContext = new e(paramContext, 1, false);
    paramContext.a((o.f)a.nUa);
    paramContext.a((o.g)b.nUb);
    paramContext.dGm();
    AppMethodBeat.o(180657);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements o.f
  {
    public static final a nUa;
    
    static
    {
      AppMethodBeat.i(180653);
      nUa = new a();
      AppMethodBeat.o(180653);
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(180652);
      paramm.kV(0, 2131755461);
      paramm.kV(1, 2131755459);
      paramm.kV(2, 2131755460);
      paramm.kV(10, 2131755458);
      paramm.kV(20, 2131755462);
      AppMethodBeat.o(180652);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements o.g
  {
    public static final b nUb;
    
    static
    {
      AppMethodBeat.i(180655);
      nUb = new b();
      AppMethodBeat.o(180655);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(180654);
      p.g(paramMenuItem, "menuItem");
      if (20 == paramMenuItem.getItemId())
      {
        paramMenuItem = j.kAc;
        paramMenuItem = new g();
        localObject = i.nTZ;
        paramMenuItem.appId = i.bXd();
        paramMenuItem.scene = 1112;
        paramMenuItem.kHx = ((d)new k());
        j.a(paramMenuItem, (f)new f()
        {
          public final void onError(int paramAnonymousInt, String paramAnonymousString) {}
          
          public final void onSuccess() {}
        });
        AppMethodBeat.o(180654);
        return;
      }
      Object localObject = i.nTZ;
      i.bXe().clearAll();
      paramInt = paramMenuItem.getItemId();
      if (paramInt == 0)
      {
        paramMenuItem = i.nTZ;
        i.bXe().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
        AppMethodBeat.o(180654);
        return;
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        paramMenuItem = i.nTZ;
        i.bXe().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
        paramMenuItem = i.nTZ;
        localObject = i.bXe();
        if (paramInt != 2) {
          break label181;
        }
      }
      label181:
      for (paramMenuItem = "wx6bd2fb149a93a9c5";; paramMenuItem = null)
      {
        ((MultiProcessMMKV)localObject).putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", paramMenuItem);
        AppMethodBeat.o(180654);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */