package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.a;

@a(1)
public class AppBrandPluginUI
  extends AppBrandUI
  implements o
{
  private boolean hdn = false;
  
  public final boolean Wt()
  {
    return true;
  }
  
  protected void initActivityCloseAnimation()
  {
    if (this.hdn) {
      return;
    }
    super.overridePendingTransition(MMFragmentActivity.a.uOg, MMFragmentActivity.a.uOh);
  }
  
  protected void initActivityOpenAnimation(Intent paramIntent)
  {
    super.overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
  }
  
  public void onResume()
  {
    super.onResume();
    Looper.myQueue().addIdleHandler(new AppBrandPluginUI.1(this));
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    this.hdn = true;
  }
  
  protected final void s(Intent paramIntent)
  {
    super.s(paramIntent);
    if (this.hei == null) {}
    for (paramIntent = null;; paramIntent = this.hei.ZV())
    {
      if ((paramIntent != null) && (paramIntent.ZG())) {
        paramIntent.fyD = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI
 * JD-Core Version:    0.7.0.1
 */