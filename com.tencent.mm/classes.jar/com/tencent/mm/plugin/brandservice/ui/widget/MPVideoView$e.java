package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$e
  implements View.OnClickListener
{
  MPVideoView$e(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7487);
    if (!this.nRy.bjb()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView = this.nRy;
      paramView.q(bool, MPVideoView.y(paramView));
      AppMethodBeat.o(7487);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.e
 * JD-Core Version:    0.7.0.1
 */