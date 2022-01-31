package com.tencent.mm.plugin.appbrand.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.j;

final class AppBrandLauncherFolderUI$c
  implements Runnable
{
  AppBrandLauncherFolderUI$c(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
  
  public final void run()
  {
    Fragment localFragment = this.hcR.getSupportFragmentManager().Z(16908290);
    Object localObject = localFragment;
    if (!(localFragment instanceof AppBrandLauncherUI.a)) {
      localObject = null;
    }
    localObject = (AppBrandLauncherUI.a)localObject;
    if (localObject != null) {
      ((AppBrandLauncherUI.a)localObject).aoV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI.c
 * JD-Core Version:    0.7.0.1
 */