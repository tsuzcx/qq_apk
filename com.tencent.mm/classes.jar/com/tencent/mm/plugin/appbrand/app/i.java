package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.List;

public final class i
  implements t
{
  public final void O(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(180186);
    boolean bool = c.clA();
    Context localContext;
    Intent localIntent;
    if (paramContext == null)
    {
      localContext = MMApplicationContext.getContext();
      localIntent = new Intent(localContext, AppBrandLauncherUI.class).putExtra("extra_start_activity_click_timestamp_ms", Util.nowMilliSecond()).putExtra("extra_enter_scene", paramInt).putExtra("extra_show_recommend", bool);
      if (!(paramContext instanceof Activity)) {
        break label142;
      }
    }
    label142:
    for (paramInt = 0;; paramInt = 268435456)
    {
      paramContext = localIntent.addFlags(paramInt);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bm(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(localContext, paramContext.aFh(), "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openLauncherUI", "(Landroid/content/Context;IZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)paramContext.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openLauncherUI", "(Landroid/content/Context;IZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(180186);
      return;
      localContext = paramContext;
      break;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(44128);
    Intent localIntent = new Intent(paramContext, BizBindWxaInfoUI.class);
    localIntent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList(paramList));
    localIntent.putExtra("extra_username", paramString1);
    localIntent.putExtra("extra_appid", paramString2);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openBizWxaEntryInfoUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/app/ExportUILauncher", "openBizWxaEntryInfoUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(44128);
  }
  
  public final boolean bFs()
  {
    AppMethodBeat.i(279202);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(279202);
      return true;
    }
    AppMethodBeat.o(279202);
    return false;
  }
  
  public final void dE(Context paramContext)
  {
    AppMethodBeat.i(44131);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("extra_get_usage_reason", 3);
    paramContext.putExtra("extra_enter_scene", 5);
    AppBrandLauncherFolderUI.m(localContext, paramContext);
    AppMethodBeat.o(44131);
  }
  
  public final boolean dF(Context paramContext)
  {
    AppMethodBeat.i(180187);
    if (bFs())
    {
      g localg = g.qVy;
      g.el(paramContext);
      AppMethodBeat.o(180187);
      return true;
    }
    AppMethodBeat.o(180187);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.i
 * JD-Core Version:    0.7.0.1
 */