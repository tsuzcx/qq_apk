package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import java.util.ArrayList;

final class c$10$1
  extends AnimatorListenerAdapter
{
  c$10$1(c.10 param10) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.hqb.val$view.setAlpha(1.0F);
    this.hqb.val$view.setScaleX(1.0F);
    this.hqb.val$view.setScaleY(1.0F);
    this.hqb.val$view.setVisibility(0);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.hqb.abL.setListener(null);
    ((BaseAppBrandRecentView.c)this.hqb.abK).hCT.animate().setListener(null);
    this.hqb.hpW.l(this.hqb.abK);
    this.hqb.hpW.abC.remove(this.hqb.abK);
    this.hqb.hpW.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.10.1
 * JD-Core Version:    0.7.0.1
 */