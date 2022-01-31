package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
public final class g$d
  extends c
{
  g$d(Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(134766);
    g.a(this.ivD);
    paramAnimation = this.ivG;
    if (paramAnimation != null)
    {
      paramAnimation.run();
      AppMethodBeat.o(134766);
      return;
    }
    AppMethodBeat.o(134766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g.d
 * JD-Core Version:    0.7.0.1
 */