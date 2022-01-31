package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import me.imid.swipebacklayout.lib.SwipeBackLayout.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListenerEx;", "onContentViewSwipedBack", "", "onDispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "", "willSwipeBack", "plugin-appbrand-integration_release"})
public final class g$1
  implements SwipeBackLayout.b
{
  public final void aIN()
  {
    AppMethodBeat.i(134762);
    this.ivD.setVisibility(8);
    this.ivD.post((Runnable)new g.1.a(this));
    AppMethodBeat.o(134762);
  }
  
  public final boolean aZ(boolean paramBoolean)
  {
    return false;
  }
  
  public final void g(int paramInt, float paramFloat) {}
  
  public final void l(MotionEvent paramMotionEvent) {}
  
  public final void uA() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g.1
 * JD-Core Version:    0.7.0.1
 */