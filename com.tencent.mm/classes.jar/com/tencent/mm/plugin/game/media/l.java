package com.tencent.mm.plugin.game.media;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;

public final class l
  extends j
{
  private a rSw;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bkk()
  {
    AppMethodBeat.i(41068);
    super.bkk();
    if (this.rSw != null) {
      this.rSw.cCn();
    }
    AppMethodBeat.o(41068);
  }
  
  public final void bkl()
  {
    AppMethodBeat.i(41066);
    if (this.rSw != null) {
      this.rSw.bkl();
    }
    AppMethodBeat.o(41066);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(41067);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ldx, "translationY", new float[] { 0.0F, getStayHeight() });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(41063);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        l.this.tw((int)f);
        AppMethodBeat.o(41063);
      }
    });
    bkl();
    AppMethodBeat.o(41067);
  }
  
  public final void j(View paramView1, View paramView2)
  {
    AppMethodBeat.i(41064);
    super.j(paramView1, paramView2);
    setPullDownBackgroundColor(-1);
    AppMethodBeat.o(41064);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.rSw = parama;
  }
  
  public final void tw(int paramInt)
  {
    AppMethodBeat.i(41065);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ldv.getLayoutParams();
    localLayoutParams.topMargin = (paramInt - this.ldv.getHeight());
    this.ldv.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(41065);
  }
  
  static abstract interface a
  {
    public abstract void bkl();
    
    public abstract void cCn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.l
 * JD-Core Version:    0.7.0.1
 */