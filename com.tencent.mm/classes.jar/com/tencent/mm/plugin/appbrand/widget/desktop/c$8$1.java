package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class c$8$1
  extends AnimatorListenerAdapter
{
  c$8$1(c.8 param8) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationCancel");
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.setAlpha(1.0F);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.setScaleX(1.0F);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.setScaleY(1.0F);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.animate().setListener(null);
    this.hqa.val$view.setVisibility(0);
    this.hqa.hpW.hpT = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationEnd");
    this.hqa.abL.setListener(null);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.setAlpha(1.0F);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.setScaleX(1.0F);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.setScaleY(1.0F);
    ((BaseAppBrandRecentView.c)this.hqa.abK).hCT.animate().setListener(null);
    this.hqa.hpW.l(this.hqa.abK);
    this.hqa.hpW.abC.remove(this.hqa.abK);
    this.hqa.hpW.gB();
    this.hqa.hpW.hpT = false;
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.8.1
 * JD-Core Version:    0.7.0.1
 */