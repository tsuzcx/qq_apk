package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.ObjectAnimator;
import android.widget.ImageButton;

final class AppBrandOptionButton$1
  implements Runnable
{
  AppBrandOptionButton$1(AppBrandOptionButton paramAppBrandOptionButton) {}
  
  public final void run()
  {
    this.hoX.hoW.setVisibility(0);
    AppBrandOptionButton.a(this.hoX).end();
    AppBrandOptionButton.a(this.hoX).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton.1
 * JD-Core Version:    0.7.0.1
 */