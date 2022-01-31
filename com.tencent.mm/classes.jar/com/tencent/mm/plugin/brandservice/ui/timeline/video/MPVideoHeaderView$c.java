package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoHeaderView$c
  implements View.OnClickListener
{
  MPVideoHeaderView$c(MPVideoHeaderView paramMPVideoHeaderView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(15252);
    MPVideoHeaderView.a(this.kgT).setVisibility(8);
    MPVideoHeaderView.b(this.kgT).setMaxLines(2147483647);
    MPVideoHeaderView.b(this.kgT).requestLayout();
    AppMethodBeat.o(15252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView.c
 * JD-Core Version:    0.7.0.1
 */