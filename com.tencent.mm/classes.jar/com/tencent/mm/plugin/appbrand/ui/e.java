package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e mbO;
  
  static
  {
    AppMethodBeat.i(180659);
    mbO = new e();
    AppMethodBeat.o(180659);
  }
  
  static aw JW()
  {
    AppMethodBeat.i(180656);
    aw localaw = aw.aKU("AppBrandLauncherUIForceEntryConfig");
    k.g(localaw, "MultiProcessMMKV.getSing…ncherUIForceEntryConfig\")");
    AppMethodBeat.o(180656);
    return localaw;
  }
  
  public static String bve()
  {
    AppMethodBeat.i(180658);
    String str2 = JW().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = "wxb6d22f922f37b35a";
    }
    AppMethodBeat.o(180658);
    return str1;
  }
  
  public static void dM(Context paramContext)
  {
    AppMethodBeat.i(180657);
    k.h(paramContext, "context");
    paramContext = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext.a((n.c)a.mbP);
    paramContext.a((n.d)b.mbQ);
    paramContext.cED();
    AppMethodBeat.o(180657);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements n.c
  {
    public static final a mbP;
    
    static
    {
      AppMethodBeat.i(180653);
      mbP = new a();
      AppMethodBeat.o(180653);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(180652);
      paraml.jw(0, 2131755424);
      paraml.jw(1, 2131755422);
      paraml.jw(2, 2131755423);
      paraml.jw(3, 2131755421);
      paraml.jw(4, 2131755420);
      paraml.jw(10, 2131755419);
      AppMethodBeat.o(180652);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.d
  {
    public static final b mbQ;
    
    static
    {
      AppMethodBeat.i(180655);
      mbQ = new b();
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
        localObject = e.mbO;
        e.bvf().clearAll();
        k.g(paramMenuItem, "menuItem");
        paramInt = paramMenuItem.getItemId();
        if (paramInt != 0) {
          break;
        }
        paramMenuItem = e.mbO;
        e.bvf().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
        AppMethodBeat.o(180654);
        return;
      }
      paramMenuItem = t.mfW;
      if (4 != paramInt) {}
      for (;;)
      {
        t.a.setCanShowAlphaCover(bool);
        AppMethodBeat.o(180654);
        return;
        bool = false;
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        paramMenuItem = e.mbO;
        e.bvf().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
        paramMenuItem = e.mbO;
        localObject = e.bvf();
        if (paramInt != 2) {
          break label145;
        }
      }
      label145:
      for (paramMenuItem = "wx6bd2fb149a93a9c5";; paramMenuItem = null)
      {
        ((aw)localObject).putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", paramMenuItem);
        AppMethodBeat.o(180654);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */