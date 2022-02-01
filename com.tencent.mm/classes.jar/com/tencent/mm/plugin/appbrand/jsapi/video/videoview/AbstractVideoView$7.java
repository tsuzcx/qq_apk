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
    AppMethodBeat.i(235184);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { this.mEV.bgQ() });
    this.mEV.bLg();
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView.7
 * JD-Core Version:    0.7.0.1
 */