package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
public final class g$c
  extends c
{
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(134765);
    this.ivD.setVisibility(8);
    al.d((Runnable)new g.c.a(this));
    AppMethodBeat.o(134765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g.c
 * JD-Core Version:    0.7.0.1
 */