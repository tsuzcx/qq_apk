package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class c$7
  extends AnimatorListenerAdapter
{
  c$7(c paramc, RecyclerView.v paramv, int paramInt, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationCancel");
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationEnd, pos: %d", new Object[] { Integer.valueOf(this.ffJ) });
    this.abL.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.hpW.w(this.abK);
    this.hpW.abE.remove(this.abK);
    this.hpW.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.hpW.y(this.abK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.7
 * JD-Core Version:    0.7.0.1
 */