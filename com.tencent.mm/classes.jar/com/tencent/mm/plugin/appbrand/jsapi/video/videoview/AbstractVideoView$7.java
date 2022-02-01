package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoView$7
  implements View.OnClickListener
{
  AbstractVideoView$7(AbstractVideoView paramAbstractVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(328889);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { this.sJt.bNL() });
    this.sJt.cxr();
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(328889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.7
 * JD-Core Version:    0.7.0.1
 */