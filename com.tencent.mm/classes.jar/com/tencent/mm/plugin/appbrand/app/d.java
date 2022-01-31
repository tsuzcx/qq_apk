package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

public final class d
  implements l
{
  public final void D(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(129211);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    paramContext = new Intent().putExtra("extra_get_usage_reason", 9).putExtra("extra_enter_scene", paramInt);
    if ((c.aNA()) && (c.aNB()))
    {
      AppBrandLauncherFolderUI.n(localContext, paramContext);
      AppMethodBeat.o(129211);
      return;
    }
    paramContext = new Intent(localContext, AppBrandLauncherUI.class).putExtra("extra_show_recents_from_task_bar", true).putExtras(paramContext);
    if ((localContext instanceof Activity)) {}
    for (paramInt = 0;; paramInt = 268435456)
    {
      localContext.startActivity(paramContext.addFlags(paramInt));
      AppMethodBeat.o(129211);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(129209);
    Intent localIntent = new Intent(paramContext, BizBindWxaInfoUI.class);
    localIntent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList(paramList));
    localIntent.putExtra("extra_username", paramString1);
    localIntent.putExtra("extra_appid", paramString2);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(129209);
  }
  
  public final void c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129210);
    boolean bool = paramBoolean;
    if (!paramBoolean) {
      bool = c.aNA();
    }
    Context localContext;
    Intent localIntent;
    if (paramContext == null)
    {
      localContext = ah.getContext();
      localIntent = new Intent(localContext, AppBrandLauncherUI.class).putExtra("extra_enter_scene", paramInt).putExtra("extra_show_recommend", bool);
      if (!(paramContext instanceof Activity)) {
        break label84;
      }
    }
    label84:
    for (paramInt = 0;; paramInt = 268435456)
    {
      localContext.startActivity(localIntent.addFlags(paramInt));
      AppMethodBeat.o(129210);
      return;
      localContext = paramContext;
      break;
    }
  }
  
  public final void cG(Context paramContext)
  {
    AppMethodBeat.i(129212);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("extra_get_usage_reason", 7);
    paramContext.putExtra("extra_enter_scene", 3);
    AppBrandLauncherFolderUI.o(localContext, paramContext);
    AppMethodBeat.o(129212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.d
 * JD-Core Version:    0.7.0.1
 */