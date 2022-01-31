package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$4
  implements View.OnClickListener
{
  AppBrandVideoView$4(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126445);
    paramView = this.icX;
    if (!AppBrandVideoView.D(this.icX)) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setMute(bool);
      AppMethodBeat.o(126445);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.4
 * JD-Core Version:    0.7.0.1
 */