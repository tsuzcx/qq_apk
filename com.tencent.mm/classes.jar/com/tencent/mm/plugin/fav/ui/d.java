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
import com.tencent.mm.autogen.a.hs;
import com.tencent.mm.autogen.a.hs.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

public final class d
{
  a Agp;
  int Agq;
  int Agr;
  private ValueAnimator Ags;
  MMActivity activity;
  float ayc;
  float ayd;
  View lBX;
  ImageView pIB;
  MMGestureGallery pIt;
  float scaleX;
  float scaleY;
  int thumbHeight;
  int thumbWidth;
  
  public d(MMGestureGallery paramMMGestureGallery, MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(106668);
    this.pIt = paramMMGestureGallery;
    this.activity = paramMMActivity;
    this.Agp = parama;
    this.pIB = ((ImageView)this.activity.findViewById(q.e.gallery_bg));
    this.lBX = this.activity.findViewById(q.e.root_container);
    this.pIt.setGalleryScaleListener(new MMGestureGallery.b()
    {
      public final void aC(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public final void onGalleryScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f2 = 1.0F;
        AppMethodBeat.i(106664);
        if ((d.this.pIt == null) || (d.this.Agp == null))
        {
          AppMethodBeat.o(106664);
          return;
        }
        if (d.this.pIt.getHeight() != 0) {}
        for (float f1 = 1.0F - paramAnonymousFloat2 / d.this.pIt.getHeight();; f1 = 1.0F)
        {
          if (f1 > 1.0F) {
            f1 = f2;
          }
          for (;;)
          {
            Log.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Float.valueOf(f1) });
            MultiTouchImageView localMultiTouchImageView = d.this.Agp.dRC();
            if (localMultiTouchImageView == null) {
              break;
            }
            localMultiTouchImageView.setPivotX(d.this.pIt.getWidth() / 2);
            localMultiTouchImageView.setPivotY(d.this.pIt.getHeight() / 2);
            localMultiTouchImageView.setScaleX(f1);
            localMultiTouchImageView.setScaleY(f1);
            localMultiTouchImageView.setTranslationX(paramAnonymousFloat1);
            localMultiTouchImageView.setTranslationY(paramAnonymousFloat2);
            d.this.lBX.setAlpha(f1);
            AppMethodBeat.o(106664);
            return;
          }
          Log.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
          AppMethodBeat.o(106664);
          return;
        }
      }
    });
    this.Ags = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Ags.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F));
    this.Ags.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(106665);
        if (d.this.pIt == null)
        {
          AppMethodBeat.o(106665);
          return;
        }
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)d.this.pIt.getLayoutParams();
        paramAnonymousValueAnimator.leftMargin = ((int)(d.this.Agq * f));
        paramAnonymousValueAnimator.topMargin = ((int)(d.this.Agr * f));
        paramAnonymousValueAnimator.rightMargin = ((int)(d.this.lBX.getWidth() * f - d.this.thumbWidth * f - paramAnonymousValueAnimator.leftMargin));
        paramAnonymousValueAnimator.bottomMargin = ((int)(d.this.lBX.getHeight() * f - d.this.thumbHeight * f - paramAnonymousValueAnimator.topMargin));
        d.this.pIt.setLayoutParams(paramAnonymousValueAnimator);
        Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", new Object[] { Integer.valueOf(paramAnonymousValueAnimator.leftMargin), Integer.valueOf(paramAnonymousValueAnimator.topMargin), Integer.valueOf(paramAnonymousValueAnimator.rightMargin), Integer.valueOf(paramAnonymousValueAnimator.bottomMargin) });
        if ((d.this.Agp != null) && (d.this.Agp.dRC() != null))
        {
          paramAnonymousValueAnimator = d.this.Agp.dRC();
          paramAnonymousValueAnimator.setTranslationX(d.this.ayc * (1.0F - f));
          paramAnonymousValueAnimator.setTranslationY(d.this.ayd * (1.0F - f));
          paramAnonymousValueAnimator.setScaleX((1.0F - f) * d.this.scaleX + f);
          paramAnonymousValueAnimator.setScaleY((1.0F - f) * d.this.scaleY + f);
          d.this.pIB.setAlpha(1.0F - f);
          Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", new Object[] { Float.valueOf(f), Float.valueOf(d.this.ayc * (1.0F - f)), Float.valueOf(d.this.ayd * (1.0F - f)), Float.valueOf((1.0F - f) * d.this.scaleX + f), Float.valueOf(f + (1.0F - f) * d.this.scaleY) });
        }
        AppMethodBeat.o(106665);
      }
    });
    this.Ags.addListener(new AnimatorListenerAdapter()
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
        int i = q.a.anim_not_change;
        paramAnonymousAnimator.overridePendingTransition(i, i);
        AppMethodBeat.o(106667);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(106666);
        super.onAnimationStart(paramAnonymousAnimator);
        if (d.this.Agp == null)
        {
          AppMethodBeat.o(106666);
          return;
        }
        paramAnonymousAnimator = d.this.Agp.dRC();
        if (paramAnonymousAnimator != null)
        {
          if (paramAnonymousAnimator.getScale() > 1.0F) {
            paramAnonymousAnimator.jma();
          }
          d.this.ayc = paramAnonymousAnimator.getTranslationX();
          d.this.ayd = paramAnonymousAnimator.getTranslationY();
          d.this.scaleX = paramAnonymousAnimator.getScaleX();
          d.this.scaleY = paramAnonymousAnimator.getScaleY();
          Log.d("MicroMsg.FavDragLogic", "onAnimationStart() scale:%s translationX:%s translationY:%s scaleX:%s scaleY:%s", new Object[] { Float.valueOf(paramAnonymousAnimator.getScale()), Float.valueOf(d.this.ayc), Float.valueOf(d.this.ayd), Float.valueOf(d.this.scaleX), Float.valueOf(d.this.scaleY) });
        }
        AppMethodBeat.o(106666);
      }
    });
    AppMethodBeat.o(106668);
  }
  
  public final void onDestroy()
  {
    this.pIt = null;
    this.activity = null;
    this.Agp = null;
  }
  
  public final void pq(boolean paramBoolean)
  {
    AppMethodBeat.i(106669);
    if (this.pIt == null)
    {
      Log.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
      AppMethodBeat.o(106669);
      return;
    }
    this.thumbWidth = 0;
    this.thumbHeight = 0;
    this.Agq = (this.pIt.getWidth() / 2);
    this.Agr = (this.pIt.getHeight() / 2);
    if ((!paramBoolean) && (this.Agp != null))
    {
      hs localhs = new hs();
      localhs.hIO.hIQ = this.Agp.dRD();
      localhs.publish();
      this.thumbWidth = localhs.hIP.hBL;
      this.thumbHeight = localhs.hIP.hBM;
      this.Agq = localhs.hIP.hBJ;
      this.Agr = localhs.hIP.hBK;
    }
    if ((this.Agq == 0) && (this.Agr == 0))
    {
      this.Agq = (this.pIt.getWidth() / 2);
      this.Agr = (this.pIt.getHeight() / 2);
    }
    Log.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", new Object[] { Integer.valueOf(this.Agq), Integer.valueOf(this.Agr), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight) });
    this.Ags.start();
    AppMethodBeat.o(106669);
  }
  
  public static abstract interface a
  {
    public abstract MultiTouchImageView dRC();
    
    public abstract String dRD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */