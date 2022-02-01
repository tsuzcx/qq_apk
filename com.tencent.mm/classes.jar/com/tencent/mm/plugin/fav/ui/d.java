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
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.ha.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

public final class d
{
  MMActivity activity;
  View gvQ;
  ImageView jUG;
  MMGestureGallery jUy;
  float scaleX;
  float scaleY;
  a tdH;
  int tdI;
  int tdJ;
  private ValueAnimator tdK;
  int thumbHeight;
  int thumbWidth;
  float translationX;
  float translationY;
  
  public d(MMGestureGallery paramMMGestureGallery, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(106668);
    this.jUy = paramMMGestureGallery;
    this.activity = paramMMActivity;
    this.tdH = parama;
    this.jUG = ((ImageView)this.activity.findViewById(2131301854));
    this.gvQ = this.activity.findViewById(2131307160);
    this.jUy.setGalleryScaleListener(new MMGestureGallery.b()
    {
      public final void S(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f2 = 1.0F;
        AppMethodBeat.i(106664);
        if ((d.this.jUy == null) || (d.this.tdH == null))
        {
          AppMethodBeat.o(106664);
          return;
        }
        if (d.this.jUy.getHeight() != 0) {}
        for (float f1 = 1.0F - paramAnonymousFloat2 / d.this.jUy.getHeight();; f1 = 1.0F)
        {
          if (f1 > 1.0F) {
            f1 = f2;
          }
          for (;;)
          {
            Log.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
            MultiTouchImageView localMultiTouchImageView = d.this.tdH.cVG();
            if (localMultiTouchImageView == null) {
              break;
            }
            localMultiTouchImageView.setPivotX(d.this.jUy.getWidth() / 2);
            localMultiTouchImageView.setPivotY(d.this.jUy.getHeight() / 2);
            localMultiTouchImageView.setScaleX(f1);
            localMultiTouchImageView.setScaleY(f1);
            localMultiTouchImageView.setTranslationX(paramAnonymousFloat1);
            localMultiTouchImageView.setTranslationY(paramAnonymousFloat2);
            d.this.gvQ.setAlpha(f1);
            AppMethodBeat.o(106664);
            return;
          }
          Log.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
          AppMethodBeat.o(106664);
          return;
        }
      }
      
      public final void T(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
    });
    this.tdK = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tdK.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
    this.tdK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106665);
        if (d.this.jUy == null)
        {
          AppMethodBeat.o(106665);
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)d.this.jUy.getLayoutParams();
        paramAnonymousValueAnimator.leftMargin = ((int)(d.this.tdI * f));
        paramAnonymousValueAnimator.topMargin = ((int)(d.this.tdJ * f));
        paramAnonymousValueAnimator.rightMargin = ((int)(d.this.gvQ.getWidth() * f - d.this.thumbWidth * f - paramAnonymousValueAnimator.leftMargin));
        paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.gvQ.getHeight() * f - d.this.thumbHeight * f - paramAnonymousValueAnimator.topMargin));
        d.this.jUy.setLayoutParams(paramAnonymousValueAnimator);
        Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", new Object[] { Integer.valueOf(paramAnonymousValueAnimator.leftMargin), Integer.valueOf(paramAnonymousValueAnimator.topMargin), Integer.valueOf(paramAnonymousValueAnimator.rightMargin), Integer.valueOf(paramAnonymousValueAnimator.bottomMargin) });
        if ((d.this.tdH != null) && (d.this.tdH.cVG() != null))
        {
          paramAnonymousValueAnimator = d.this.tdH.cVG();
          paramAnonymousValueAnimator.setTranslationX(d.this.translationX * (1.0F - f));
          paramAnonymousValueAnimator.setTranslationY(d.this.translationY * (1.0F - f));
          paramAnonymousValueAnimator.setScaleX((1.0F - f) * d.this.scaleX + f);
          paramAnonymousValueAnimator.setScaleY((1.0F - f) * d.this.scaleY + f);
          d.this.jUG.setAlpha(1.0F - f);
          Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", new Object[] { Float.valueOf(f), Float.valueOf(d.this.translationX * (1.0F - f)), Float.valueOf(d.this.translationY * (1.0F - f)), Float.valueOf((1.0F - f) * d.this.scaleX + f), Float.valueOf(f + (1.0F - f) * d.this.scaleY) });
        }
        AppMethodBeat.o(106665);
      }
    });
    this.tdK.addListener(new AnimatorListenerAdapter()
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
        d.this.activity.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(106667);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(106666);
        super.onAnimationStart(paramAnonymousAnimator);
        if (d.this.tdH == null)
        {
          AppMethodBeat.o(106666);
          return;
        }
        paramAnonymousAnimator = d.this.tdH.cVG();
        if (paramAnonymousAnimator != null)
        {
          if (paramAnonymousAnimator.getScale() > 1.0F) {
            paramAnonymousAnimator.gKy();
          }
          d.this.translationX = paramAnonymousAnimator.getTranslationX();
          d.this.translationY = paramAnonymousAnimator.getTranslationY();
          d.this.scaleX = paramAnonymousAnimator.getScaleX();
          d.this.scaleY = paramAnonymousAnimator.getScaleY();
          Log.d("MicroMsg.FavDragLogic", "onAnimationStart() scale:%s translationX:%s translationY:%s scaleX:%s scaleY:%s", new Object[] { Float.valueOf(paramAnonymousAnimator.getScale()), Float.valueOf(d.this.translationX), Float.valueOf(d.this.translationY), Float.valueOf(d.this.scaleX), Float.valueOf(d.this.scaleY) });
        }
        AppMethodBeat.o(106666);
      }
    });
    AppMethodBeat.o(106668);
  }
  
  public final void mD(boolean paramBoolean)
  {
    AppMethodBeat.i(106669);
    if (this.jUy == null)
    {
      Log.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
      AppMethodBeat.o(106669);
      return;
    }
    this.thumbWidth = 0;
    this.thumbHeight = 0;
    this.tdI = (this.jUy.getWidth() / 2);
    this.tdJ = (this.jUy.getHeight() / 2);
    if ((!paramBoolean) && (this.tdH != null))
    {
      ha localha = new ha();
      localha.dLj.dLl = this.tdH.cVH();
      EventCenter.instance.publish(localha);
      this.thumbWidth = localha.dLk.dEs;
      this.thumbHeight = localha.dLk.dEt;
      this.tdI = localha.dLk.dEq;
      this.tdJ = localha.dLk.dEr;
    }
    if ((this.tdI == 0) && (this.tdJ == 0))
    {
      this.tdI = (this.jUy.getWidth() / 2);
      this.tdJ = (this.jUy.getHeight() / 2);
    }
    Log.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.tdI), Integer.valueOf(this.tdJ), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight) });
    this.tdK.start();
    AppMethodBeat.o(106669);
  }
  
  public final void onDestroy()
  {
    this.jUy = null;
    this.activity = null;
    this.tdH = null;
  }
  
  public static abstract interface a
  {
    public abstract MultiTouchImageView cVG();
    
    public abstract String cVH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */