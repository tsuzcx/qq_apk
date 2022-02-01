package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g mHb;
  
  static
  {
    AppMethodBeat.i(180659);
    mHb = new g();
    AppMethodBeat.o(180659);
  }
  
  static ay LD()
  {
    AppMethodBeat.i(180656);
    ay localay = ay.aRX("AppBrandLauncherUIForceEntryConfig");
    p.g(localay, "MultiProcessMMKV.getSing…ncherUIForceEntryConfig\")");
    AppMethodBeat.o(180656);
    return localay;
  }
  
  public static String bAf()
  {
    AppMethodBeat.i(180658);
    String str2 = LD().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = "wxb6d22f922f37b35a";
    }
    AppMethodBeat.o(180658);
    return str1;
  }
  
  public static void dP(Context paramContext)
  {
    AppMethodBeat.i(180657);
    p.h(paramContext, "context");
    paramContext = new e(paramContext, 1, false);
    paramContext.a((n.d)a.mHc);
    paramContext.a((n.e)b.mHd);
    paramContext.cPF();
    AppMethodBeat.o(180657);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements n.d
  {
    public static final a mHc;
    
    static
    {
      AppMethodBeat.i(180653);
      mHc = new a();
      AppMethodBeat.o(180653);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(180652);
      paraml.jM(0, 2131755424);
      paraml.jM(1, 2131755422);
      paraml.jM(2, 2131755423);
      paraml.jM(10, 2131755419);
      AppMethodBeat.o(180652);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.e
  {
    public static final b mHd;
    
    static
    {
      AppMethodBeat.i(180655);
      mHd = new b();
      AppMethodBeat.o(180655);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(180654);
      if (3 > paramInt) {}
      Object localObject;
      while (4 < paramInt)
      {
        localObject = g.mHb;
        g.bAg().clearAll();
        p.g(paramMenuItem, "menuItem");
        paramInt = paramMenuItem.getItemId();
        if (paramInt != 0) {
          break;
        }
        paramMenuItem = g.mHb;
        g.bAg().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
        AppMethodBeat.o(180654);
        return;
      }
      paramMenuItem = v.mLB;
      if (4 != paramInt) {}
      for (;;)
      {
        v.a.setCanShowAlphaCover(bool);
        AppMethodBeat.o(180654);
        return;
        bool = false;
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        paramMenuItem = g.mHb;
        g.bAg().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
        paramMenuItem = g.mHb;
        localObject = g.bAg();
        if (paramInt != 2) {
          break label145;
        }
      }
      label145:
      for (paramMenuItem = "wx6bd2fb149a93a9c5";; paramMenuItem = null)
      {
        ((ay)localObject).putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", paramMenuItem);
        AppMethodBeat.o(180654);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */