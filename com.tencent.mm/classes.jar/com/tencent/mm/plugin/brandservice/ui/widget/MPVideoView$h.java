package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$h
  implements View.OnClickListener
{
  MPVideoView$h(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7490);
    paramView = MPVideoView.h(this.nRy);
    if (paramView == null) {
      k.fOy();
    }
    if (paramView.isPlaying())
    {
      this.nRy.pause();
      AppMethodBeat.o(7490);
      return;
    }
    this.nRy.start();
    AppMethodBeat.o(7490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.h
 * JD-Core Version:    0.7.0.1
 */