package com.tencent.mm.plugin.appbrand.ui;

import a.d.b.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class AppBrandLauncherFolderUI$a
{
  public static void l(Context paramContext, Intent paramIntent)
  {
    g.k(paramContext, "context");
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.a
 * JD-Core Version:    0.7.0.1
 */