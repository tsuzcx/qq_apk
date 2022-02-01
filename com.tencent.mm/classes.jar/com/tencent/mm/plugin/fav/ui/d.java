package com.tencent.mm.plugin.fav.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hh;
import com.tencent.mm.f.a.hh.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

public final class d
{
  float GB;
  float GC;
  MMActivity activity;
  View jac;
  MMGestureGallery mLL;
  ImageView mLT;
  float scaleX;
  float scaleY;
  int thumbHeight;
  int thumbWidth;
  a wJS;
  int wJT;
  int wJU;
  private ValueAnimator wJV;
  
  public d(MMGestureGallery paramMMGestureGallery, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(106668);
    this.mLL = paramMMGestureGallery;
    this.activity = paramMMActivity;
    this.wJS = parama;
    this.mLT = ((ImageView)this.activity.findViewById(s.e.gallery_bg));
    this.jac = this.activity.findViewById(s.e.root_container);
    this.mLL.setGalleryScaleListener(new MMGestureGallery.b()
    {
      public final void U(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f2 = 1.0F;
        AppMethodBeat.i(106664);
        if ((d.this.mLL == null) || (d.this.wJS == null))
        {
          AppMethodBeat.o(106664);
          return;
        }
        if (d.this.mLL.getHeight() != 0) {}
        for (float f1 = 1.0F - paramAnonymousFloat2 / d.this.mLL.getHeight();; f1 = 1.0F)
        {
          if (f1 > 1.0F) {
            f1 = f2;
          }
          for (;;)
          {
            Log.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
            MultiTouchImageView localMultiTouchImageView = d.this.wJS.dkM();
            if (localMultiTouchImageView == null) {
              break;
            }
            localMultiTouchImageView.setPivotX(d.this.mLL.getWidth() / 2);
            localMultiTouchImageView.setPivotY(d.this.mLL.getHeight() / 2);
            localMultiTouchImageView.setScaleX(f1);
            localMultiTouchImageView.setScaleY(f1);
            localMultiTouchImageView.setTranslationX(paramAnonymousFloat1);
            localMultiTouchImageView.setTranslationY(paramAnonymousFloat2);
            d.this.jac.setAlpha(f1);
            AppMethodBeat.o(106664);
            return;
          }
          Log.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
          AppMethodBeat.o(106664);
          return;
        }
      }
      
      public final void V(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
    });
    this.wJV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.wJV.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
    this.wJV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106665);
        if (d.this.mLL == null)
        {
          AppMethodBeat.o(106665);
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)d.this.mLL.getLayoutParams();
        paramAnonymousValueAnimator.leftMargin = ((int)(d.this.wJT * f));
        paramAnonymousValueAnimator.topMargin = ((int)(d.this.wJU * f));
        paramAnonymousValueAnimator.rightMargin = ((int)(d.this.jac.getWidth() * f - d.this.thumbWidth * f - paramAnonymousValueAnimator.leftMargin));
        paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.jac.getHeight() * f - d.this.thumbHeight * f - paramAnonymousValueAnimator.topMargin));
        d.this.mLL.setLayoutParams(paramAnonymousValueAnimator);
        Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", new Object[] { Integer.valueOf(paramAnonymousValueAnimator.leftMargin), Integer.valueOf(paramAnonymousValueAnimator.topMargin), Integer.valueOf(paramAnonymousValueAnimator.rightMargin), Integer.valueOf(paramAnonymousValueAnimator.bottomMargin) });
        if ((d.this.wJS != null) && (d.this.wJS.dkM() != null))
        {
          paramAnonymousValueAnimator = d.this.wJS.dkM();
          paramAnonymousValueAnimator.setTranslationX(d.this.GB * (1.0F - f));
          paramAnonymousValueAnimator.setTranslationY(d.this.GC * (1.0F - f));
          paramAnonymousValueAnimator.setScaleX((1.0F - f) * d.this.scaleX + f);
          paramAnonymousValueAnimator.setScaleY((1.0F - f) * d.this.scaleY + f);
          d.this.mLT.setAlpha(1.0F - f);
          Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", new Object[] { Float.valueOf(f), Float.valueOf(d.this.GB * (1.0F - f)), Float.valueOf(d.this.GC * (1.0F - f)), Float.valueOf((1.0F - f) * d.this.scaleX + f), Float.valueOf(f + (1.0F - f) * d.this.scaleY) });
        }
        AppMethodBeat.o(106665);
      }
    });
    this.wJV.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(106667);
        super.onAnimationEnd(paramAnonymousAnimator);
        if (d.this.activity == null)
        {
          AppMethodBeat.o(106667);
          return;
        }
        d.this.activity.finish();
        paramAnonymousAnimator = d.this.activity;
        int i = s.a.anim_not_change;
        paramAnonymousAnimator.overridePendingTransition(i, i);
        AppMethodBeat.o(106667);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(106666);
        super.onAnimationStart(paramAnonymousAnimator);
        if (d.this.wJS == null)
        {
          AppMethodBeat.o(106666);
          return;
        }
        paramAnonymousAnimator = d.this.wJS.dkM();
        if (paramAnonymousAnimator != null)
        {
          if (paramAnonymousAnimator.getScale() > 1.0F) {
            paramAnonymousAnimator.hJx();
          }
          d.this.GB = paramAnonymousAnimator.getTranslationX();
          d.this.GC = paramAnonymousAnimator.getTranslationY();
          d.this.scaleX = paramAnonymousAnimator.getScaleX();
          d.this.scaleY = paramAnonymousAnimator.getScaleY();
          Log.d("MicroMsg.FavDragLogic", "onAnimationStart() scale:%s translationX:%s translationY:%s scaleX:%s scaleY:%s", new Object[] { Float.valueOf(paramAnonymousAnimator.getScale()), Float.valueOf(d.this.GB), Float.valueOf(d.this.GC), Float.valueOf(d.this.scaleX), Float.valueOf(d.this.scaleY) });
        }
        AppMethodBeat.o(106666);
      }
    });
    AppMethodBeat.o(106668);
  }
  
  public final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(106669);
    if (this.mLL == null)
    {
      Log.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
      AppMethodBeat.o(106669);
      return;
    }
    this.thumbWidth = 0;
    this.thumbHeight = 0;
    this.wJT = (this.mLL.getWidth() / 2);
    this.wJU = (this.mLL.getHeight() / 2);
    if ((!paramBoolean) && (this.wJS != null))
    {
      hh localhh = new hh();
      localhh.fDY.fEa = this.wJS.dkN();
      EventCenter.instance.publish(localhh);
      this.thumbWidth = localhh.fDZ.fxg;
      this.thumbHeight = localhh.fDZ.fxh;
      this.wJT = localhh.fDZ.fxe;
      this.wJU = localhh.fDZ.fxf;
    }
    if ((this.wJT == 0) && (this.wJU == 0))
    {
      this.wJT = (this.mLL.getWidth() / 2);
      this.wJU = (this.mLL.getHeight() / 2);
    }
    Log.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.wJT), Integer.valueOf(this.wJU), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight) });
    this.wJV.start();
    AppMethodBeat.o(106669);
  }
  
  public final void onDestroy()
  {
    this.mLL = null;
    this.activity = null;
    this.wJS = null;
  }
  
  public static abstract interface a
  {
    public abstract MultiTouchImageView dkM();
    
    public abstract String dkN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */