package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper$handleAnimation$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "animationStartTime", "", "getAnimationStartTime", "()J", "setAnimationStartTime", "(J)V", "onPreDraw", "", "plugin-brandservice_release"})
public final class h$a
  implements ViewTreeObserver.OnPreDrawListener
{
  long kiw;
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(15332);
    ab.i(this.kix.TAG, "handleAnimation animation start %b", new Object[] { Boolean.valueOf(this.kix.kiv) });
    Object localObject = h.a(this.kix).getViewTreeObserver();
    if (localObject != null) {
      ((ViewTreeObserver)localObject).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }
    h.b(this.kix).QP(this.kix.duration);
    if (this.kix.kir != null)
    {
      localObject = this.kix.kir;
      if (localObject == null) {
        j.ebi();
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.kix.kir;
      if (localObject == null) {
        j.ebi();
      }
      ((View)localObject).animate().setDuration(1000L).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).alpha(0.0F);
    }
    h.b(this.kix).a(h.a(this.kix), null, (e.b)new h.a.a(this));
    AppMethodBeat.o(15332);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h.a
 * JD-Core Version:    0.7.0.1
 */