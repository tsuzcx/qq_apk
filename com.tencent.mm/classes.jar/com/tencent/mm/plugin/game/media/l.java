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
  private a CFA;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Cq(int paramInt)
  {
    AppMethodBeat.i(41065);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qtw.getLayoutParams();
    localLayoutParams.topMargin = (paramInt - this.qtw.getHeight());
    this.qtw.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(41065);
  }
  
  public final void ceN()
  {
    AppMethodBeat.i(41068);
    super.ceN();
    if (this.CFA != null) {
      this.CFA.exC();
    }
    AppMethodBeat.o(41068);
  }
  
  public final void ceO()
  {
    AppMethodBeat.i(41066);
    if (this.CFA != null) {
      this.CFA.ceO();
    }
    AppMethodBeat.o(41066);
  }
  
  public final void exB()
  {
    AppMethodBeat.i(41067);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.qoa, "translationY", new float[] { 0.0F, getStayHeight() });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(41063);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.Cq((int)f);
        AppMethodBeat.o(41063);
      }
    });
    ceO();
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
    this.CFA = parama;
  }
  
  static abstract interface a
  {
    public abstract void ceO();
    
    public abstract void exC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.l
 * JD-Core Version:    0.7.0.1
 */