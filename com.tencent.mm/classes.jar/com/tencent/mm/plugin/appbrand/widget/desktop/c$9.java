package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import java.util.ArrayList;

final class c$9
  extends AnimatorListenerAdapter
{
  c$9(c paramc, RecyclerView.v paramv, View paramView, int paramInt, boolean paramBoolean, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.val$view;
    if (this.hpW.hpU.nj(this.ffJ)) {}
    for (float f = 0.3F;; f = 1.0F)
    {
      paramAnimator.setAlpha(f);
      this.val$view.setScaleX(1.0F);
      this.val$view.setScaleY(1.0F);
      if (this.hpZ) {
        break;
      }
      this.val$view.setVisibility(4);
      return;
    }
    this.val$view.setVisibility(0);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.abL.setListener(null);
    this.hpW.l(this.abK);
    this.hpW.abC.remove(this.abK);
    this.hpW.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.9
 * JD-Core Version:    0.7.0.1
 */