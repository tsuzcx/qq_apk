package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherFolderUI$a
{
  public static void m(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51106);
    k.h(paramContext, "context");
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startRecentsList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startRecentsList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(51106);
  }
  
  public static void n(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51107);
    k.h(paramContext, "context");
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(51107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a
 * JD-Core Version:    0.7.0.1
 */