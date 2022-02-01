package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoErrorView$a
  implements View.OnClickListener
{
  MPVideoErrorView$a(MPVideoErrorView paramMPVideoErrorView, b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7249);
    this.nMP.setVisibility(8);
    this.nMQ.bMI();
    AppMethodBeat.o(7249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView.a
 * JD-Core Version:    0.7.0.1
 */