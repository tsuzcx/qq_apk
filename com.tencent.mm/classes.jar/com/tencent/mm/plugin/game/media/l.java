package com.tencent.mm.plugin.game.media;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.k;

public final class l
  extends k
{
  private a tYe;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bva()
  {
    AppMethodBeat.i(41068);
    super.bva();
    if (this.tYe != null) {
      this.tYe.cYd();
    }
    AppMethodBeat.o(41068);
  }
  
  public final void bvb()
  {
    AppMethodBeat.i(41066);
    if (this.tYe != null) {
      this.tYe.bvb();
    }
    AppMethodBeat.o(41066);
  }
  
  public final void cYc()
  {
    AppMethodBeat.i(41067);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mcR, "translationY", new float[] { 0.0F, getStayHeight() });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(41063);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.uQ((int)f);
        AppMethodBeat.o(41063);
      }
    });
    bvb();
    AppMethodBeat.o(41067);
  }
  
  public final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(41064);
    super.k(paramView1, paramView2);
    setPullDownBackgroundColor(-1);
    AppMethodBeat.o(41064);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.tYe = parama;
  }
  
  public final void uQ(int paramInt)
  {
    AppMethodBeat.i(41065);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mcP.getLayoutParams();
    localLayoutParams.topMargin = (paramInt - this.mcP.getHeight());
    this.mcP.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(41065);
  }
  
  static abstract interface a
  {
    public abstract void bvb();
    
    public abstract void cYd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.l
 * JD-Core Version:    0.7.0.1
 */