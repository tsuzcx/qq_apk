package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class VideoLiteUI$a
  implements View.OnClickListener
{
  VideoLiteUI$a(VideoLiteUI paramVideoLiteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209140);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.owz.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(209140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.a
 * JD-Core Version:    0.7.0.1
 */