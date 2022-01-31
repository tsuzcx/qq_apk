package com.tencent.mm.plugin.brandservice.ui.widget;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$i
  implements View.OnClickListener
{
  MPVideoView$i(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153016);
    paramView = this.kjR;
    if (!MPVideoView.E(this.kjR)) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setMute(bool);
      AppMethodBeat.o(153016);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.i
 * JD-Core Version:    0.7.0.1
 */