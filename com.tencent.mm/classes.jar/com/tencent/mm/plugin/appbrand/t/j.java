package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;

public final class j
  implements g
{
  public final void G(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(133578);
    int i = -1;
    Intent localIntent;
    if (1 == paramInt)
    {
      i = 14;
      localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
      localIntent.putExtra("extra_use_system_default_enter_exit_anim", true);
      localIntent.putExtra("extra_enter_scene", i);
      localIntent.putExtra("KEY_MODE", 1);
      if (!(paramContext instanceof Activity)) {
        break label109;
      }
    }
    label109:
    for (paramInt = 0;; paramInt = 268435456)
    {
      localIntent.addFlags(paramInt);
      localIntent.addFlags(536870912);
      localIntent.addFlags(134217728);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(133578);
      return;
      if (2 != paramInt) {
        break;
      }
      i = 15;
      break;
    }
  }
  
  public final void db(Context paramContext)
  {
    AppMethodBeat.i(133579);
    Intent localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
    localIntent.putExtra("extra_use_system_default_enter_exit_anim", true);
    localIntent.putExtra("extra_enter_scene", 4);
    localIntent.putExtra("KEY_MODE", 2);
    if ((paramContext instanceof Activity)) {}
    for (int i = 0;; i = 268435456)
    {
      localIntent.addFlags(i);
      localIntent.addFlags(536870912);
      localIntent.addFlags(134217728);
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(133579);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.j
 * JD-Core Version:    0.7.0.1
 */