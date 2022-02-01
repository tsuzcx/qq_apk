package com.tencent.mobileqq.vaswebviewplugin;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

class ThemeJsPlugin$6
  implements Runnable
{
  ThemeJsPlugin$6(ThemeJsPlugin paramThemeJsPlugin) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.this$0.tmpScreenShot.getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.this$0.tmpScreenShot);
      localViewGroup.clearDisappearingChildren();
    }
    this.this$0.drawingCache.recycle();
    this.this$0.drawingCache = null;
    this.this$0.isAnimating = false;
    this.this$0.isSwitchTheme = Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */