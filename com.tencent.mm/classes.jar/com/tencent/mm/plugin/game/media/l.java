package com.tencent.mm.plugin.game.media;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.plugin.webview.luggage.l
{
  private a IzE;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void CG(int paramInt)
  {
    AppMethodBeat.i(41065);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.tyc.getLayoutParams();
    localLayoutParams.topMargin = (paramInt - this.tyc.getHeight());
    this.tyc.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(41065);
  }
  
  public final void cFq()
  {
    AppMethodBeat.i(41068);
    super.cFq();
    if (this.IzE != null) {
      this.IzE.fFy();
    }
    AppMethodBeat.o(41068);
  }
  
  public final void cFr()
  {
    AppMethodBeat.i(41066);
    if (this.IzE != null) {
      this.IzE.cFr();
    }
    AppMethodBeat.o(41066);
  }
  
  public final void fFx()
  {
    AppMethodBeat.i(41067);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.tsH, "translationY", new float[] { 0.0F, getStayHeight() });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(41063);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.CG((int)f);
        AppMethodBeat.o(41063);
      }
    });
    cFr();
    AppMethodBeat.o(41067);
  }
  
  public final void h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(41064);
    super.h(paramView1, paramView2);
    setPullDownBackgroundColor(-1);
    AppMethodBeat.o(41064);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.IzE = parama;
  }
  
  static abstract interface a
  {
    public abstract void cFr();
    
    public abstract void fFy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.l
 * JD-Core Version:    0.7.0.1
 */