package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class BizVideoDetailUI$q
  implements View.OnClickListener
{
  BizVideoDetailUI$q(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7122);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    BizVideoDetailUI.f(this.pIu).p(false, 0);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(7122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.q
 * JD-Core Version:    0.7.0.1
 */