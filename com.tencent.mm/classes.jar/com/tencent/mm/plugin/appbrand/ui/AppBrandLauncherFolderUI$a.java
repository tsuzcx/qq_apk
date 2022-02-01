package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandLauncherFolderUI$a
{
  public static void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51107);
    s.u(paramContext, "context");
    Intent localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getExtras())
    {
      Object localObject = paramIntent;
      if (paramIntent == null) {
        localObject = Bundle.EMPTY;
      }
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("KEY_MODE", 2);
      paramIntent = ah.aiuX;
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a
 * JD-Core Version:    0.7.0.1
 */