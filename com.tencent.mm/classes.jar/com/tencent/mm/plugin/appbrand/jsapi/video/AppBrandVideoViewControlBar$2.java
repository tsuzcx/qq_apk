package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoViewControlBar$2
  implements View.OnClickListener
{
  AppBrandVideoViewControlBar$2(AppBrandVideoViewControlBar paramAppBrandVideoViewControlBar, d.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131535);
    AppBrandVideoViewControlBar.a(this.idw);
    if (this.idx != null) {
      this.idx.ez(AppBrandVideoViewControlBar.b(this.idw));
    }
    AppMethodBeat.o(131535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.2
 * JD-Core Version:    0.7.0.1
 */