package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import java.util.ArrayList;

final class c$10$1
  extends AnimatorListenerAdapter
{
  c$10$1(c.10 param10) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133789);
    this.jei.val$view.setAlpha(1.0F);
    this.jei.val$view.setScaleX(1.0F);
    this.jei.val$view.setScaleY(1.0F);
    this.jei.val$view.setVisibility(0);
    AppMethodBeat.o(133789);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133790);
    this.jei.acw.setListener(null);
    ((BaseAppBrandRecentView.c)this.jei.acv).jft.animate().setListener(null);
    this.jei.jed.m(this.jei.acv);
    this.jei.jed.acn.remove(this.jei.acv);
    this.jei.jed.hB();
    AppMethodBeat.o(133790);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.10.1
 * JD-Core Version:    0.7.0.1
 */