package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoErrorView$a
  implements View.OnClickListener
{
  MPVideoErrorView$a(MPVideoErrorView paramMPVideoErrorView, b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7249);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.ovn.setVisibility(8);
    this.ovo.bSj();
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(7249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView.a
 * JD-Core Version:    0.7.0.1
 */