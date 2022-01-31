package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoErrorView$a
  implements View.OnClickListener
{
  MPVideoErrorView$a(MPVideoErrorView paramMPVideoErrorView, b paramb, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(15247);
    this.kgB.setVisibility(8);
    this.kgC.aZe();
    paramView = this.kgD;
    if (paramView != null)
    {
      paramView.kis = false;
      if (paramView.enable)
      {
        paramView = paramView.kiq;
        if (paramView == null) {
          j.ays("animationView");
        }
        paramView.setVisibility(0);
      }
      AppMethodBeat.o(15247);
      return;
    }
    AppMethodBeat.o(15247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView.a
 * JD-Core Version:    0.7.0.1
 */