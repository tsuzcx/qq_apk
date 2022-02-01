package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class AppBrandStickyBannerLogic$a
{
  private static final AppBrandStickyBannerLogic.Watcher oai;
  private static final Set<f> oaj;
  private static final HashMap<String, Boolean> oak;
  private static final HashMap<String, f> oal;
  private static final c oam;
  private static final Map<String, String> oan;
  
  static
  {
    AppMethodBeat.i(49006);
    oai = new AppBrandStickyBannerLogic.Watcher();
    oaj = new HashSet();
    oak = new HashMap();
    oal = new HashMap();
    oam = new c();
    oan = new HashMap();
    AppMethodBeat.o(49006);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(49000);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(49000);
      return;
    }
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
      synchronized (oan)
      {
        String str = (String)oan.get(paramString1);
        b.a(localIntent, paramString1, paramInt, paramString2, paramString3, Util.nullAsNil(str));
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString1.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (!(paramContext instanceof Activity)) {}
      }
      AppMethodBeat.o(49000);
      return;
    }
  }
  
  public static boolean bYc()
  {
    AppMethodBeat.i(49001);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(49001);
    return false;
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(49002);
    if (paramf != null) {
      synchronized (oaj)
      {
        oaj.remove(paramf);
        AppMethodBeat.o(49002);
        return;
      }
    }
    AppMethodBeat.o(49002);
  }
  
  static void cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(48999);
    synchronized (oaj)
    {
      Iterator localIterator = oaj.iterator();
      if (localIterator.hasNext()) {
        ((f)localIterator.next()).bJ(paramString, paramInt);
      }
    }
    AppMethodBeat.o(48999);
  }
  
  public static void d(f paramf)
  {
    AppMethodBeat.i(49003);
    oai.oas = MMApplicationContext.getProcessName();
    AppBrandMainProcessService.a(oai);
    if (paramf != null) {
      synchronized (oaj)
      {
        oaj.add(paramf);
        AppMethodBeat.o(49003);
        return;
      }
    }
    AppMethodBeat.o(49003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a
 * JD-Core Version:    0.7.0.1
 */