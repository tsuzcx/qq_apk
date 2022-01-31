package com.tencent.mm.plugin.appbrand.ui;

import a.d.b.g;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.a.a;
import com.tencent.mm.plugin.appbrand.ui.collection.e;
import com.tencent.mm.plugin.appbrand.ui.recents.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public final class AppBrandLauncherFolderUI
  extends DrawStatusBarActivity
  implements com.tencent.mm.plugin.appbrand.ui.a.b
{
  public static final AppBrandLauncherFolderUI.a hcQ = new AppBrandLauncherFolderUI.a((byte)0);
  private a hcP;
  
  public static final void l(Context paramContext, Intent paramIntent)
  {
    AppBrandLauncherFolderUI.a.l(paramContext, paramIntent);
  }
  
  public final void dC(boolean paramBoolean)
  {
    a locala = this.hcP;
    if (locala != null) {
      locala.dC(paramBoolean);
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      return;
    }
    if (com.tencent.mm.ui.base.b.ab(getClass())) {
      super.overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    }
    int i = getIntent().getIntExtra("KEY_MODE", 0);
    switch (i)
    {
    default: 
      y.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + i + ')');
      finish();
      ta(-855310);
      getContentView().setBackgroundColor(czq());
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandLauncherFolderUI.b(this));
      setTitleBarDoubleClickListener((Runnable)new AppBrandLauncherFolderUI.c(this));
      paramBundle = getLifecycle();
      a locala = this.hcP;
      if (locala == null) {
        g.cUk();
      }
      paramBundle.addObserver((LifecycleObserver)locala);
      return;
    }
    for (paramBundle = (a)new n((MMActivity)this);; paramBundle = (a)new e((MMActivity)this))
    {
      this.hcP = paramBundle;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI
 * JD-Core Version:    0.7.0.1
 */