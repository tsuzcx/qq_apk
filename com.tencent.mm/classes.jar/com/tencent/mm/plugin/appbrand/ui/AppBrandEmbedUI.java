package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class AppBrandEmbedUI
  extends AppBrandUI
{
  public final long hcA = SystemClock.elapsedRealtimeNanos();
  
  private boolean aoR()
  {
    return (this.hei != null) && (this.hei.ZV() != null) && (this.hei.ZV().ZG());
  }
  
  static boolean r(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.getComponent() != null)
      {
        boolean bool = paramIntent.getComponent().getClassName().equals(AppBrandEmbedUI.class.getName());
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.AppBrandEmbedUI", "isIntentForEmbedUI e=%s", new Object[] { paramIntent });
    }
    return false;
  }
  
  public final void finish()
  {
    if (isFinishing()) {
      return;
    }
    apf();
  }
  
  protected final void initActivityCloseAnimation()
  {
    if (aoR())
    {
      super.overridePendingTransition(MMFragmentActivity.a.uOg, MMFragmentActivity.a.uOh);
      return;
    }
    overridePendingTransition(y.a.anim_not_change, y.a.appbrand_ui_push_close_exit);
  }
  
  protected final void initActivityOpenAnimation(Intent paramIntent)
  {
    if (aoR())
    {
      super.overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
      return;
    }
    super.overridePendingTransition(y.a.appbrand_ui_push_open_enter, y.a.anim_not_change);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI
 * JD-Core Version:    0.7.0.1
 */