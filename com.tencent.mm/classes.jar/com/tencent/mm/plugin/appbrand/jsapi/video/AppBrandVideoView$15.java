package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$15
  implements View.OnClickListener
{
  AppBrandVideoView$15(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194095);
    if (AppBrandVideoView.b(this.kOS).isPlaying())
    {
      this.kOS.pause();
      AppMethodBeat.o(194095);
      return;
    }
    this.kOS.start();
    AppMethodBeat.o(194095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.15
 * JD-Core Version:    0.7.0.1
 */