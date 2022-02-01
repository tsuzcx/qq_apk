package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandVideoView$4
  implements View.OnClickListener
{
  AppBrandVideoView$4(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(137702);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.sAg.q(false, AppBrandVideoView.G(this.sAg));
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(137702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.4
 * JD-Core Version:    0.7.0.1
 */