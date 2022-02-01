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
  private a xBz;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bRQ()
  {
    AppMethodBeat.i(41068);
    super.bRQ();
    if (this.xBz != null) {
      this.xBz.dUv();
    }
    AppMethodBeat.o(41068);
  }
  
  public final void bRR()
  {
    AppMethodBeat.i(41066);
    if (this.xBz != null) {
      this.xBz.bRR();
    }
    AppMethodBeat.o(41066);
  }
  
  public final void dUu()
  {
    AppMethodBeat.i(41067);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nms, "translationY", new float[] { 0.0F, getStayHeight() });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(41063);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.yM((int)f);
        AppMethodBeat.o(41063);
      }
    });
    bRR();
    AppMethodBeat.o(41067);
  }
  
  public final void l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(41064);
    super.l(paramView1, paramView2);
    setPullDownBackgroundColor(-1);
    AppMethodBeat.o(41064);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.xBz = parama;
  }
  
  public final void yM(int paramInt)
  {
    AppMethodBeat.i(41065);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nrE.getLayoutParams();
    localLayoutParams.topMargin = (paramInt - this.nrE.getHeight());
    this.nrE.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(41065);
  }
  
  static abstract interface a
  {
    public abstract void bRR();
    
    public abstract void dUv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.l
 * JD-Core Version:    0.7.0.1
 */