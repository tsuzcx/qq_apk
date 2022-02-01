package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class VideoLiteUI$a
  implements View.OnClickListener
{
  VideoLiteUI$a(VideoLiteUI paramVideoLiteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(210106);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.oqd.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/lite/VideoLiteUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(210106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteUI.a
 * JD-Core Version:    0.7.0.1
 */