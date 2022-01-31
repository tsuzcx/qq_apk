package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$7
  implements d.d
{
  AppBrandVideoView$7(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void dj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126448);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(126448);
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
      paramInt1 = i * AppBrandVideoView.E(this.icX).getWidth() / paramInt2;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AppBrandVideoView.F(this.icX).getLayoutParams();
      localLayoutParams.width = paramInt1;
      AppBrandVideoView.F(this.icX).setLayoutParams(localLayoutParams);
      AppBrandVideoView.F(this.icX).requestLayout();
      AppMethodBeat.o(126448);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.7
 * JD-Core Version:    0.7.0.1
 */