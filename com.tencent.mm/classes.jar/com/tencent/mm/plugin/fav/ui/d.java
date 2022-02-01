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
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

public final class d
{
  MMActivity activity;
  View fvu;
  ImageView iBF;
  MMGestureGallery iBx;
  a qLO;
  int qLP;
  int qLQ;
  private ValueAnimator qLR;
  float scaleX;
  float scaleY;
  int thumbHeight;
  int thumbWidth;
  float translationX;
  float translationY;
  
  public d(MMGestureGallery paramMMGestureGallery, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(106668);
    this.iBx = paramMMGestureGallery;
    this.activity = paramMMActivity;
    this.qLO = parama;
    this.iBF = ((ImageView)this.activity.findViewById(2131300336));
    this.fvu = this.activity.findViewById(2131304241);
    this.iBx.setGalleryScaleListener(new MMGestureGallery.b()
    {
      public final void M(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f2 = 1.0F;
        AppMethodBeat.i(106664);
        if ((d.this.iBx == null) || (d.this.qLO == null))
        {
          AppMethodBeat.o(106664);
          return;
        }
        if (d.this.iBx.getHeight() != 0) {}
        for (float f1 = 1.0F - paramAnonymousFloat2 / d.this.iBx.getHeight();; f1 = 1.0F)
        {
          if (f1 > 1.0F) {
            f1 = f2;
          }
          for (;;)
          {
            ac.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
            MultiTouchImageView localMultiTouchImageView = d.this.qLO.cqw();
            if (localMultiTouchImageView == null) {
              break;
            }
            localMultiTouchImageView.setPivotX(d.this.iBx.getWidth() / 2);
            localMultiTouchImageView.setPivotY(d.this.iBx.getHeight() / 2);
            localMultiTouchImageView.setScaleX(f1);
            localMultiTouchImageView.setScaleY(f1);
            localMultiTouchImageView.setTranslationX(paramAnonymousFloat1);
            localMultiTouchImageView.setTranslationY(paramAnonymousFloat2);
            d.this.fvu.setAlpha(f1);
            AppMethodBeat.o(106664);
            return;
          }
          ac.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
          AppMethodBeat.o(106664);
          return;
        }
      }
      
      public final void N(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
    });
    this.qLR = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qLR.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
    this.qLR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106665);
        if (d.this.iBx == null)
        {
          AppMethodBeat.o(106665);
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)d.this.iBx.getLayoutParams();
        paramAnonymousValueAnimator.leftMargin = ((int)(d.this.qLP * f));
        paramAnonymousValueAnimator.topMargin = ((int)(d.this.qLQ * f));
        paramAnonymousValueAnimator.rightMargin = ((int)(d.this.fvu.getWidth() * f - d.this.thumbWidth * f - paramAnonymousValueAnimator.leftMargin));
        paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.fvu.getHeight() * f - d.this.thumbHeight * f - paramAnonymousValueAnimator.topMargin));
        d.this.iBx.setLayoutParams(paramAnonymousValueAnimator);
        ac.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", new Object[] { Integer.valueOf(paramAnonymousValueAnimator.leftMargin), Integer.valueOf(paramAnonymousValueAnimator.topMargin), Integer.valueOf(paramAnonymousValueAnimator.rightMargin), Integer.valueOf(paramAnonymousValueAnimator.bottomMargin) });
        if ((d.this.qLO != null) && (d.this.qLO.cqw() != null))
        {
          paramAnonymousValueAnimator = d.this.qLO.cqw();
          paramAnonymousValueAnimator.setTranslationX(d.this.translationX * (1.0F - f));
          paramAnonymousValueAnimator.setTranslationY(d.this.translationY * (1.0F - f));
          paramAnonymousValueAnimator.setScaleX((1.0F - f) * d.this.scaleX + f);
          paramAnonymousValueAnimator.setScaleY((1.0F - f) * d.this.scaleY + f);
          d.this.iBF.setAlpha(1.0F - f);
          ac.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", new Object[] { Float.valueOf(f), Float.valueOf(d.this.translationX * (1.0F - f)), Float.valueOf(d.this.translationY * (1.0F - f)), Float.valueOf((1.0F - f) * d.this.scaleX + f), Float.valueOf(f + (1.0F - f) * d.this.scaleY) });
        }
        AppMethodBeat.o(106665);
      }
    });
    this.qLR.addListener(new AnimatorListenerAdapter()
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
        if (d.this.qLO == null)
        {
          AppMethodBeat.o(106666);
          return;
        }
        paramAnonymousAnimator = d.this.qLO.cqw();
        if (paramAnonymousAnimator != null)
        {
          if (paramAnonymousAnimator.getScale() > 1.0F) {
            paramAnonymousAnimator.fij();
          }
          d.this.translationX = paramAnonymousAnimator.getTranslationX();
          d.this.translationY = paramAnonymousAnimator.getTranslationY();
          d.this.scaleX = paramAnonymousAnimator.getScaleX();
          d.this.scaleY = paramAnonymousAnimator.getScaleY();
          ac.d("MicroMsg.FavDragLogic", "onAnimationStart() scale:%s translationX:%s translationY:%s scaleX:%s scaleY:%s", new Object[] { Float.valueOf(paramAnonymousAnimator.getScale()), Float.valueOf(d.this.translationX), Float.valueOf(d.this.translationY), Float.valueOf(d.this.scaleX), Float.valueOf(d.this.scaleY) });
        }
        AppMethodBeat.o(106666);
      }
    });
    AppMethodBeat.o(106668);
  }
  
  public final void lh(boolean paramBoolean)
  {
    AppMethodBeat.i(106669);
    if (this.iBx == null)
    {
      ac.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
      AppMethodBeat.o(106669);
      return;
    }
    this.thumbWidth = 0;
    this.thumbHeight = 0;
    this.qLP = (this.iBx.getWidth() / 2);
    this.qLQ = (this.iBx.getHeight() / 2);
    if ((!paramBoolean) && (this.qLO != null))
    {
      gs localgs = new gs();
      localgs.dhu.dhw = this.qLO.cqx();
      a.GpY.l(localgs);
      this.thumbWidth = localgs.dhv.daH;
      this.thumbHeight = localgs.dhv.daI;
      this.qLP = localgs.dhv.daF;
      this.qLQ = localgs.dhv.daG;
    }
    if ((this.qLP == 0) && (this.qLQ == 0))
    {
      this.qLP = (this.iBx.getWidth() / 2);
      this.qLQ = (this.iBx.getHeight() / 2);
    }
    ac.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.qLP), Integer.valueOf(this.qLQ), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight) });
    this.qLR.start();
    AppMethodBeat.o(106669);
  }
  
  public final void onDestroy()
  {
    this.iBx = null;
    this.activity = null;
    this.qLO = null;
  }
  
  public static abstract interface a
  {
    public abstract MultiTouchImageView cqw();
    
    public abstract String cqx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */