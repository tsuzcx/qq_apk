package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements f
{
  public final void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    Intent localIntent = new Intent(paramContext, BizBindWxaInfoUI.class);
    localIntent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList(paramList));
    localIntent.putExtra("extra_username", paramString1);
    localIntent.putExtra("extra_appid", paramString2);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public final void b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Context localContext;
    Intent localIntent;
    if (paramContext == null)
    {
      localContext = ae.getContext();
      localIntent = new Intent(localContext, AppBrandLauncherUI.class).putExtra("extra_enter_scene", paramInt).putExtra("extra_show_recommend", paramBoolean);
      if (!(paramContext instanceof Activity)) {
        break label61;
      }
    }
    label61:
    for (paramInt = 0;; paramInt = 268435456)
    {
      localContext.startActivity(localIntent.addFlags(paramInt));
      return;
      localContext = paramContext;
      break;
    }
  }
  
  public final void cb(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    paramContext = new Intent(localContext, AppBrandLauncherUI.class).putExtra("extra_show_recents_from_task_bar", true).putExtra("extra_get_usage_reason", 9);
    if ((localContext instanceof Activity)) {}
    for (int i = 0;; i = 268435456)
    {
      localContext.startActivity(paramContext.addFlags(i));
      return;
    }
  }
  
  public final void cc(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    paramContext = new Intent();
    paramContext.putExtra("extra_get_usage_reason", 7);
    AppBrandLauncherFolderUI.l(localContext, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */