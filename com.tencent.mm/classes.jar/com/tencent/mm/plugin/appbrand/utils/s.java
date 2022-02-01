package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;

public final class s
  implements o
{
  public final void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49315);
    Intent localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
    localIntent.putExtra("extra_use_system_default_enter_exit_anim", true);
    localIntent.putExtra("extra_enter_scene", 4);
    localIntent.putExtra("extra_enter_scene_note", paramString);
    localIntent.putExtra("KEY_MODE", 2);
    if ((paramContext instanceof Activity)) {}
    for (int i = 0;; i = 268435456)
    {
      localIntent.addFlags(i);
      localIntent.addFlags(536870912);
      localIntent.addFlags(134217728);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaMyFavorite", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaMyFavorite", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(49315);
      return;
    }
  }
  
  public final void b(Context paramContext, int paramInt, String paramString)
  {
    int j = 14;
    AppMethodBeat.i(49314);
    int i;
    Intent localIntent;
    if (1 == paramInt)
    {
      i = 15;
      localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
      localIntent.putExtra("extra_use_system_default_enter_exit_anim", true);
      localIntent.putExtra("extra_enter_scene", i);
      localIntent.putExtra("extra_enter_scene_note", paramString);
      localIntent.putExtra("KEY_MODE", 1);
      if (!(paramContext instanceof Activity)) {
        break label189;
      }
    }
    label189:
    for (paramInt = 0;; paramInt = 268435456)
    {
      localIntent.addFlags(paramInt);
      localIntent.addFlags(536870912);
      localIntent.addFlags(134217728);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaDesktop", "(Landroid/content/Context;ILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/utils/ExtOpenWxaDesktopFavoriteHelperImpl", "openWxaDesktop", "(Landroid/content/Context;ILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(49314);
      return;
      i = j;
      if (2 == paramInt) {
        break;
      }
      i = j;
      if (paramInt == 0) {
        break;
      }
      i = -1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.s
 * JD-Core Version:    0.7.0.1
 */