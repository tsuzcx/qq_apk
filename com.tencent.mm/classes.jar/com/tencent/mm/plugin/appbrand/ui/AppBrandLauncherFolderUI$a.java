package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherFolderUI$a
{
  public static void n(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(134987);
    j.q(paramContext, "context");
    Intent localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      paramIntent = localBundle;
      if (localBundle != null) {}
    }
    else
    {
      paramIntent = Bundle.EMPTY;
    }
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("KEY_MODE", 1);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(134987);
  }
  
  public static void o(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(134988);
    j.q(paramContext, "context");
    Intent localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      paramIntent = localBundle;
      if (localBundle != null) {}
    }
    else
    {
      paramIntent = Bundle.EMPTY;
    }
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("KEY_MODE", 2);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(134988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a
 * JD-Core Version:    0.7.0.1
 */