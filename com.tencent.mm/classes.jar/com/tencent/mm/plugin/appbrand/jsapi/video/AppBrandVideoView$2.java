package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$2
  implements View.OnClickListener
{
  AppBrandVideoView$2(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126442);
    if (AppBrandVideoView.b(this.icX).isPlaying())
    {
      this.icX.pause();
      AppMethodBeat.o(126442);
      return;
    }
    this.icX.start();
    AppMethodBeat.o(126442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.2
 * JD-Core Version:    0.7.0.1
 */