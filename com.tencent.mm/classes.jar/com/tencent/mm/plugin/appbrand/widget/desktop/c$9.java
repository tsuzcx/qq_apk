package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import java.util.ArrayList;

final class c$9
  extends AnimatorListenerAdapter
{
  c$9(c paramc, RecyclerView.v paramv, View paramView, int paramInt, boolean paramBoolean, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133787);
    paramAnimator = this.val$view;
    if (this.jed.jeb.qQ(this.gxr)) {}
    for (float f = 0.3F;; f = 1.0F)
    {
      paramAnimator.setAlpha(f);
      this.val$view.setScaleX(1.0F);
      this.val$view.setScaleY(1.0F);
      if (this.jeg) {
        break;
      }
      this.val$view.setVisibility(4);
      AppMethodBeat.o(133787);
      return;
    }
    this.val$view.setVisibility(0);
    AppMethodBeat.o(133787);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133788);
    this.acw.setListener(null);
    this.jed.m(this.acv);
    this.jed.acn.remove(this.acv);
    this.jed.hB();
    AppMethodBeat.o(133788);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.9
 * JD-Core Version:    0.7.0.1
 */