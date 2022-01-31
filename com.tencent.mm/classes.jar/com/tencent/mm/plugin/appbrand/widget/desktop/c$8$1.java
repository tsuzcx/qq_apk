package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class c$8$1
  extends AnimatorListenerAdapter
{
  c$8$1(c.8 param8) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133784);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationCancel");
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.setAlpha(1.0F);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.setScaleX(1.0F);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.setScaleY(1.0F);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.animate().setListener(null);
    this.jeh.val$view.setVisibility(0);
    this.jeh.jed.jea = false;
    AppMethodBeat.o(133784);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133785);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationEnd");
    this.jeh.acw.setListener(null);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.setAlpha(1.0F);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.setScaleX(1.0F);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.setScaleY(1.0F);
    ((BaseAppBrandRecentView.c)this.jeh.acv).jft.animate().setListener(null);
    this.jeh.jed.m(this.jeh.acv);
    this.jeh.jed.acn.remove(this.jeh.acv);
    this.jeh.jed.hB();
    this.jeh.jed.jea = false;
    AppMethodBeat.o(133785);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.8.1
 * JD-Core Version:    0.7.0.1
 */