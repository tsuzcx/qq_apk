package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e lzS;
  
  static
  {
    AppMethodBeat.i(180659);
    lzS = new e();
    AppMethodBeat.o(180659);
  }
  
  static ax Km()
  {
    AppMethodBeat.i(180656);
    ax localax = ax.aFD("AppBrandLauncherUIForceEntryConfig");
    k.g(localax, "MultiProcessMMKV.getSing…ncherUIForceEntryConfig\")");
    AppMethodBeat.o(180656);
    return localax;
  }
  
  public static String boi()
  {
    AppMethodBeat.i(180658);
    String str2 = Km().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = "wxb6d22f922f37b35a";
    }
    AppMethodBeat.o(180658);
    return str1;
  }
  
  public static void dD(Context paramContext)
  {
    AppMethodBeat.i(180657);
    k.h(paramContext, "context");
    paramContext = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext.a((n.c)e.a.lzT);
    paramContext.a((n.d)b.lzU);
    paramContext.csG();
    AppMethodBeat.o(180657);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.d
  {
    public static final b lzU;
    
    static
    {
      AppMethodBeat.i(180655);
      lzU = new b();
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
        localObject = e.lzS;
        e.boj().clearAll();
        k.g(paramMenuItem, "menuItem");
        paramInt = paramMenuItem.getItemId();
        if (paramInt != 0) {
          break;
        }
        paramMenuItem = e.lzS;
        e.boj().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
        AppMethodBeat.o(180654);
        return;
      }
      paramMenuItem = u.lEc;
      if (4 != paramInt) {}
      for (;;)
      {
        u.a.setCanShowAlphaCover(bool);
        AppMethodBeat.o(180654);
        return;
        bool = false;
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        paramMenuItem = e.lzS;
        e.boj().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
        paramMenuItem = e.lzS;
        localObject = e.boj();
        if (paramInt != 2) {
          break label145;
        }
      }
      label145:
      for (paramMenuItem = "wx6bd2fb149a93a9c5";; paramMenuItem = null)
      {
        ((ax)localObject).putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", paramMenuItem);
        AppMethodBeat.o(180654);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */