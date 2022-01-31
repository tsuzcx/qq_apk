package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$g
  implements View.OnClickListener
{
  MPVideoView$g(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153013);
    paramView = MPVideoView.i(this.kjR);
    if (paramView == null) {
      j.ebi();
    }
    if (paramView.isPlaying())
    {
      this.kjR.pause();
      AppMethodBeat.o(153013);
      return;
    }
    this.kjR.start();
    AppMethodBeat.o(153013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.g
 * JD-Core Version:    0.7.0.1
 */