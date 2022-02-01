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
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

public final class d
{
  MMActivity activity;
  View fOB;
  MMGestureGallery iUH;
  ImageView iUP;
  a rvQ;
  int rvR;
  int rvS;
  private ValueAnimator rvT;
  float scaleX;
  float scaleY;
  int thumbHeight;
  int thumbWidth;
  float translationX;
  float translationY;
  
  public d(MMGestureGallery paramMMGestureGallery, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(106668);
    this.iUH = paramMMGestureGallery;
    this.activity = paramMMActivity;
    this.rvQ = parama;
    this.iUP = ((ImageView)this.activity.findViewById(2131300336));
    this.fOB = this.activity.findViewById(2131304241);
    this.iUH.setGalleryScaleListener(new MMGestureGallery.b()
    {
      public final void O(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f2 = 1.0F;
        AppMethodBeat.i(106664);
        if ((d.this.iUH == null) || (d.this.rvQ == null))
        {
          AppMethodBeat.o(106664);
          return;
        }
        if (d.this.iUH.getHeight() != 0) {}
        for (float f1 = 1.0F - paramAnonymousFloat2 / d.this.iUH.getHeight();; f1 = 1.0F)
        {
          if (f1 > 1.0F) {
            f1 = f2;
          }
          for (;;)
          {
            ad.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
            MultiTouchImageView localMultiTouchImageView = d.this.rvQ.cwb();
            if (localMultiTouchImageView == null) {
              break;
            }
            localMultiTouchImageView.setPivotX(d.this.iUH.getWidth() / 2);
            localMultiTouchImageView.setPivotY(d.this.iUH.getHeight() / 2);
            localMultiTouchImageView.setScaleX(f1);
            localMultiTouchImageView.setScaleY(f1);
            localMultiTouchImageView.setTranslationX(paramAnonymousFloat1);
            localMultiTouchImageView.setTranslationY(paramAnonymousFloat2);
            d.this.fOB.setAlpha(f1);
            AppMethodBeat.o(106664);
            return;
          }
          ad.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
          AppMethodBeat.o(106664);
          return;
        }
      }
      
      public final void P(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
    });
    this.rvT = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rvT.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
    this.rvT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106665);
        if (d.this.iUH == null)
        {
          AppMethodBeat.o(106665);
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)d.this.iUH.getLayoutParams();
        paramAnonymousValueAnimator.leftMargin = ((int)(d.this.rvR * f));
        paramAnonymousValueAnimator.topMargin = ((int)(d.this.rvS * f));
        paramAnonymousValueAnimator.rightMargin = ((int)(d.this.fOB.getWidth() * f - d.this.thumbWidth * f - paramAnonymousValueAnimator.leftMargin));
        paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.fOB.getHeight() * f - d.this.thumbHeight * f - paramAnonymousValueAnimator.topMargin));
        d.this.iUH.setLayoutParams(paramAnonymousValueAnimator);
        ad.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", new Object[] { Integer.valueOf(paramAnonymousValueAnimator.leftMargin), Integer.valueOf(paramAnonymousValueAnimator.topMargin), Integer.valueOf(paramAnonymousValueAnimator.rightMargin), Integer.valueOf(paramAnonymousValueAnimator.bottomMargin) });
        if ((d.this.rvQ != null) && (d.this.rvQ.cwb() != null))
        {
          paramAnonymousValueAnimator = d.this.rvQ.cwb();
          paramAnonymousValueAnimator.setTranslationX(d.this.translationX * (1.0F - f));
          paramAnonymousValueAnimator.setTranslationY(d.this.translationY * (1.0F - f));
          paramAnonymousValueAnimator.setScaleX((1.0F - f) * d.this.scaleX + f);
          paramAnonymousValueAnimator.setScaleY((1.0F - f) * d.this.scaleY + f);
          d.this.iUP.setAlpha(1.0F - f);
          ad.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", new Object[] { Float.valueOf(f), Float.valueOf(d.this.translationX * (1.0F - f)), Float.valueOf(d.this.translationY * (1.0F - f)), Float.valueOf((1.0F - f) * d.this.scaleX + f), Float.valueOf(f + (1.0F - f) * d.this.scaleY) });
        }
        AppMethodBeat.o(106665);
      }
    });
    this.rvT.addListener(new AnimatorListenerAdapter()
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
        if (d.this.rvQ == null)
        {
          AppMethodBeat.o(106666);
          return;
        }
        paramAnonymousAnimator = d.this.rvQ.cwb();
        if (paramAnonymousAnimator != null)
        {
          if (paramAnonymousAnimator.getScale() > 1.0F) {
            paramAnonymousAnimator.fyy();
          }
          d.this.translationX = paramAnonymousAnimator.getTranslationX();
          d.this.translationY = paramAnonymousAnimator.getTranslationY();
          d.this.scaleX = paramAnonymousAnimator.getScaleX();
          d.this.scaleY = paramAnonymousAnimator.getScaleY();
          ad.d("MicroMsg.FavDragLogic", "onAnimationStart() scale:%s translationX:%s translationY:%s scaleX:%s scaleY:%s", new Object[] { Float.valueOf(paramAnonymousAnimator.getScale()), Float.valueOf(d.this.translationX), Float.valueOf(d.this.translationY), Float.valueOf(d.this.scaleX), Float.valueOf(d.this.scaleY) });
        }
        AppMethodBeat.o(106666);
      }
    });
    AppMethodBeat.o(106668);
  }
  
  public final void lA(boolean paramBoolean)
  {
    AppMethodBeat.i(106669);
    if (this.iUH == null)
    {
      ad.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
      AppMethodBeat.o(106669);
      return;
    }
    this.thumbWidth = 0;
    this.thumbHeight = 0;
    this.rvR = (this.iUH.getWidth() / 2);
    this.rvS = (this.iUH.getHeight() / 2);
    if ((!paramBoolean) && (this.rvQ != null))
    {
      gv localgv = new gv();
      localgv.dsS.dsU = this.rvQ.cwc();
      a.IbL.l(localgv);
      this.thumbWidth = localgv.dsT.dmb;
      this.thumbHeight = localgv.dsT.dmc;
      this.rvR = localgv.dsT.dlZ;
      this.rvS = localgv.dsT.dma;
    }
    if ((this.rvR == 0) && (this.rvS == 0))
    {
      this.rvR = (this.iUH.getWidth() / 2);
      this.rvS = (this.iUH.getHeight() / 2);
    }
    ad.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.rvR), Integer.valueOf(this.rvS), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight) });
    this.rvT.start();
    AppMethodBeat.o(106669);
  }
  
  public final void onDestroy()
  {
    this.iUH = null;
    this.activity = null;
    this.rvQ = null;
  }
  
  public static abstract interface a
  {
    public abstract MultiTouchImageView cwb();
    
    public abstract String cwc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */