package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class VideoLiteUI$c
  implements View.OnClickListener
{
  VideoLiteUI$c(VideoLiteUI paramVideoLiteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(210108);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = VideoLiteUI.b(this.oqd);
    if (paramView != null) {
      paramView.start();
    }
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(210108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.c
 * JD-Core Version:    0.7.0.1
 */