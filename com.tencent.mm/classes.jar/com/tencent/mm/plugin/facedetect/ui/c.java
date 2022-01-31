package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  ViewPager FK;
  View iUL = null;
  Animation jQB = null;
  Button jQx;
  c.a jSh;
  n kC;
  
  public c()
  {
    y.i("MicroMsg.FaceTutorial", "initFaceTutorial");
    this.jQB = AnimationUtils.loadAnimation(ae.getContext(), a.a.alpha_out);
    this.jQB.setDuration(500L);
  }
  
  public final void dismiss()
  {
    y.i("MicroMsg.FaceTutorial", "dismiss()");
    if (this.iUL.getVisibility() == 0) {
      ai.d(new Runnable()
      {
        public final void run()
        {
          c.this.jQB.setAnimationListener(new c.3.1(this));
          c.this.iUL.startAnimation(c.this.jQB);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.c
 * JD-Core Version:    0.7.0.1
 */