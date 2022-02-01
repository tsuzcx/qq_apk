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
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gr.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

public final class d
{
  MMActivity activity;
  View frN;
  MMGestureGallery ibu;
  ImageView qdk;
  a qdl;
  int qdm;
  int qdn;
  private ValueAnimator qdo;
  float scaleX;
  float scaleY;
  int thumbHeight;
  int thumbWidth;
  float translationX;
  float translationY;
  
  public d(MMGestureGallery paramMMGestureGallery, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(106668);
    this.ibu = paramMMGestureGallery;
    this.activity = paramMMActivity;
    this.qdl = parama;
    this.qdk = ((ImageView)this.activity.findViewById(2131300336));
    this.frN = this.activity.findViewById(2131304241);
    this.ibu.setGalleryScaleListener(new MMGestureGallery.b()
    {
      public final void J(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f2 = 1.0F;
        AppMethodBeat.i(106664);
        if ((d.this.ibu == null) || (d.this.qdl == null))
        {
          AppMethodBeat.o(106664);
          return;
        }
        if (d.this.ibu.getHeight() != 0) {}
        for (float f1 = 1.0F - paramAnonymousFloat2 / d.this.ibu.getHeight();; f1 = 1.0F)
        {
          if (f1 > 1.0F) {
            f1 = f2;
          }
          for (;;)
          {
            ad.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
            MultiTouchImageView localMultiTouchImageView = d.this.qdl.ciP();
            if (localMultiTouchImageView == null) {
              break;
            }
            localMultiTouchImageView.setPivotX(d.this.ibu.getWidth() / 2);
            localMultiTouchImageView.setPivotY(d.this.ibu.getHeight() / 2);
            localMultiTouchImageView.setScaleX(f1);
            localMultiTouchImageView.setScaleY(f1);
            localMultiTouchImageView.setTranslationX(paramAnonymousFloat1);
            localMultiTouchImageView.setTranslationY(paramAnonymousFloat2);
            d.this.frN.setAlpha(f1);
            AppMethodBeat.o(106664);
            return;
          }
          ad.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
          AppMethodBeat.o(106664);
          return;
        }
      }
      
      public final void K(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
    });
    this.qdo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qdo.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
    this.qdo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106665);
        if (d.this.ibu == null)
        {
          AppMethodBeat.o(106665);
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)d.this.ibu.getLayoutParams();
        paramAnonymousValueAnimator.leftMargin = ((int)(d.this.qdm * f));
        paramAnonymousValueAnimator.topMargin = ((int)(d.this.qdn * f));
        paramAnonymousValueAnimator.rightMargin = ((int)(d.this.frN.getWidth() * f - d.this.thumbWidth * f - paramAnonymousValueAnimator.leftMargin));
        paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.frN.getHeight() * f - d.this.thumbHeight * f - paramAnonymousValueAnimator.topMargin));
        d.this.ibu.setLayoutParams(paramAnonymousValueAnimator);
        ad.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", new Object[] { Integer.valueOf(paramAnonymousValueAnimator.leftMargin), Integer.valueOf(paramAnonymousValueAnimator.topMargin), Integer.valueOf(paramAnonymousValueAnimator.rightMargin), Integer.valueOf(paramAnonymousValueAnimator.bottomMargin) });
        if ((d.this.qdl != null) && (d.this.qdl.ciP() != null))
        {
          paramAnonymousValueAnimator = d.this.qdl.ciP();
          paramAnonymousValueAnimator.setTranslationX(d.this.translationX * (1.0F - f));
          paramAnonymousValueAnimator.setTranslationY(d.this.translationY * (1.0F - f));
          paramAnonymousValueAnimator.setScaleX((1.0F - f) * d.this.scaleX + f);
          paramAnonymousValueAnimator.setScaleY((1.0F - f) * d.this.scaleY + f);
          d.this.qdk.setAlpha(1.0F - f);
          ad.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", new Object[] { Float.valueOf(f), Float.valueOf(d.this.translationX * (1.0F - f)), Float.valueOf(d.this.translationY * (1.0F - f)), Float.valueOf((1.0F - f) * d.this.scaleX + f), Float.valueOf(f + (1.0F - f) * d.this.scaleY) });
        }
        AppMethodBeat.o(106665);
      }
    });
    this.qdo.addListener(new AnimatorListenerAdapter()
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
        if (d.this.qdl == null)
        {
          AppMethodBeat.o(106666);
          return;
        }
        paramAnonymousAnimator = d.this.qdl.ciP();
        if (paramAnonymousAnimator != null)
        {
          if (paramAnonymousAnimator.getScale() > 1.0F) {
            paramAnonymousAnimator.eSz();
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
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(106669);
    if (this.ibu == null)
    {
      ad.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
      AppMethodBeat.o(106669);
      return;
    }
    this.thumbWidth = 0;
    this.thumbHeight = 0;
    this.qdm = (this.ibu.getWidth() / 2);
    this.qdn = (this.ibu.getHeight() / 2);
    if ((!paramBoolean) && (this.qdl != null))
    {
      gr localgr = new gr();
      localgr.djZ.dkb = this.qdl.ciQ();
      a.ESL.l(localgr);
      this.thumbWidth = localgr.dka.ddj;
      this.thumbHeight = localgr.dka.ddk;
      this.qdm = localgr.dka.ddh;
      this.qdn = localgr.dka.ddi;
    }
    if ((this.qdm == 0) && (this.qdn == 0))
    {
      this.qdm = (this.ibu.getWidth() / 2);
      this.qdn = (this.ibu.getHeight() / 2);
    }
    ad.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.qdm), Integer.valueOf(this.qdn), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight) });
    this.qdo.start();
    AppMethodBeat.o(106669);
  }
  
  public final void onDestroy()
  {
    this.ibu = null;
    this.activity = null;
    this.qdl = null;
  }
  
  public static abstract interface a
  {
    public abstract MultiTouchImageView ciP();
    
    public abstract String ciQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */