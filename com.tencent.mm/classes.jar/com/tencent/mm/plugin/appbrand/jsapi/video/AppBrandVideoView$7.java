package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

final class AppBrandVideoView$7
  implements c.d
{
  AppBrandVideoView$7(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void bX(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 > paramInt2) {
        i = paramInt2;
      }
      paramInt1 = i * AppBrandVideoView.D(this.gDS).getWidth() / paramInt2;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AppBrandVideoView.E(this.gDS).getLayoutParams();
      localLayoutParams.width = paramInt1;
      AppBrandVideoView.E(this.gDS).setLayoutParams(localLayoutParams);
      AppBrandVideoView.E(this.gDS).requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.7
 * JD-Core Version:    0.7.0.1
 */