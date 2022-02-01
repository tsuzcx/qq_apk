package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$14
  implements View.OnClickListener
{
  AppBrandVideoView$14(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(193752);
    if (AppBrandVideoView.b(this.kny).isPlaying())
    {
      this.kny.pause();
      AppMethodBeat.o(193752);
      return;
    }
    this.kny.start();
    AppMethodBeat.o(193752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.14
 * JD-Core Version:    0.7.0.1
 */