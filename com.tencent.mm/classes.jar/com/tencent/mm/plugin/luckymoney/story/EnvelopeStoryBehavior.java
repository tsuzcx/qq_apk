package com.tencent.mm.plugin.luckymoney.story;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Vibrator;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.AppBarLayout.b;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class EnvelopeStoryBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private Vibrator ooM;
  private boolean xkO;
  private boolean xkP;
  boolean yZK;
  AppBarLayout.b zaA;
  private boolean zaB;
  private EnvelopeAppBarLayout zar;
  private int zas;
  private RecyclerView zat;
  private float zau;
  private float zav;
  private boolean zaw;
  private boolean zax;
  private int zay;
  boolean zaz;
  
  public EnvelopeStoryBehavior()
  {
    AppMethodBeat.i(163614);
    this.zas = 0;
    this.ooM = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    this.zay = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    this.zaz = false;
    this.yZK = false;
    this.xkO = false;
    this.xkP = false;
    AppMethodBeat.o(163614);
  }
  
  public EnvelopeStoryBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163615);
    this.zas = 0;
    this.ooM = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    this.zay = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    this.zaz = false;
    this.yZK = false;
    this.xkO = false;
    this.xkP = false;
    AppMethodBeat.o(163615);
  }
  
  private boolean efK()
  {
    AppMethodBeat.i(163620);
    int i = bT();
    if (this.zar.getTotalScrollRange() == Math.abs(i))
    {
      AppMethodBeat.o(163620);
      return true;
    }
    AppMethodBeat.o(163620);
    return false;
  }
  
  private boolean efL()
  {
    AppMethodBeat.i(163621);
    if (Math.abs(bT()) <= 0)
    {
      AppMethodBeat.o(163621);
      return true;
    }
    AppMethodBeat.o(163621);
    return false;
  }
  
  private void efM()
  {
    AppMethodBeat.i(163623);
    if (((this.xkP) && (bT() + this.zar.getTotalScrollRange() <= this.zas)) || ((this.xkO) && (Math.abs(bT()) >= this.zas)))
    {
      this.zar.b(false, true, true);
      AppMethodBeat.o(163623);
      return;
    }
    this.zar.b(true, true, true);
    AppMethodBeat.o(163623);
  }
  
  private void efN()
  {
    AppMethodBeat.i(174342);
    int i = bT();
    int j = this.zar.getTotalScrollRange();
    if (this.zaB)
    {
      if (j - Math.abs(i) < this.zay)
      {
        this.zar.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      if (this.yZK)
      {
        efO();
        AppMethodBeat.o(174342);
        return;
      }
      efM();
      AppMethodBeat.o(174342);
      return;
    }
    if (this.xkP)
    {
      if (bT() + this.zar.getTotalScrollRange() <= this.zas)
      {
        this.zar.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      efO();
      AppMethodBeat.o(174342);
      return;
    }
    if ((this.xkO) && (Math.abs(bT()) >= this.zas))
    {
      if (j - Math.abs(i) < this.zay)
      {
        this.zar.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      efO();
      AppMethodBeat.o(174342);
      return;
    }
    efM();
    AppMethodBeat.o(174342);
  }
  
  private void efO()
  {
    AppMethodBeat.i(174343);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.setIntValues(new int[] { bT(), -(this.zar.getTotalScrollRange() - this.zay) });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(174339);
        EnvelopeStoryBehavior.this.G(-(EnvelopeStoryBehavior.a(EnvelopeStoryBehavior.this).getTotalScrollRange() - EnvelopeStoryBehavior.b(EnvelopeStoryBehavior.this)));
        AppMethodBeat.o(174339);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      int zak;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(174341);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        this.zak = i;
        Log.d("MicroMsg.EnvelopeStoryBehavior", "animate middle: %s", new Object[] { Integer.valueOf(i) });
        EnvelopeStoryBehavior.this.G(i);
        if (EnvelopeStoryBehavior.c(EnvelopeStoryBehavior.this) != null) {
          EnvelopeStoryBehavior.c(EnvelopeStoryBehavior.this).c(EnvelopeStoryBehavior.a(EnvelopeStoryBehavior.this), i);
        }
        AppMethodBeat.o(174341);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(174343);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(163619);
    if ((paramInt5 == 1) && (this.xkP))
    {
      if (paramInt2 == 0)
      {
        Log.i("MicroMsg.EnvelopeStoryBehavior", "stop verticalRecyclerView scroll!");
        this.zat.kQ();
      }
      AppMethodBeat.o(163619);
      return;
    }
    int i = Math.abs(paramInt4);
    i = this.zar.getTotalScrollRange() - Math.abs(bT()) + i;
    Log.d("MicroMsg.EnvelopeStoryBehavior", "distance: ".concat(String.valueOf(i)));
    float f1 = 0.7F;
    float f2 = this.zar.getTotalScrollRange();
    if (f2 != 0.0F)
    {
      if (i > f2) {
        f1 = 0.0F;
      }
    }
    else
    {
      if (i <= 0) {
        break label195;
      }
      f1 = 1.0F - f1;
      double d = f1;
      paramInt4 = (int)((float)((float)(f1 * 0.2D * d) + 0.5D) * paramInt4);
    }
    label195:
    for (;;)
    {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      AppMethodBeat.o(163619);
      return;
      f1 = (f2 - i) / f2;
      break;
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(163618);
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    AppMethodBeat.o(163618);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163617);
    boolean bool = super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(163617);
    return bool;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(163616);
    this.zar = ((EnvelopeAppBarLayout)paramAppBarLayout);
    this.zat = ((RecyclerView)paramCoordinatorLayout.findViewById(2131304073));
    this.zas = ((int)(paramCoordinatorLayout.getHeight() / 10.0F));
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).b(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(163616);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(163622);
    int i;
    boolean bool1;
    if (paramMotionEvent.getAction() == 0)
    {
      this.zau = paramMotionEvent.getX();
      this.zav = paramMotionEvent.getY();
      this.zaw = false;
      this.zax = false;
      this.xkO = efL();
      this.xkP = efK();
      i = bT();
      if (this.zar.getTotalScrollRange() - Math.abs(i) == this.zay)
      {
        i = 1;
        bool1 = bool2;
        if (i == 0)
        {
          if ((this.xkP) || (this.xkO)) {
            break label134;
          }
          bool1 = bool2;
        }
        label114:
        this.zaB = bool1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(163622);
      return false;
      i = 0;
      break;
      label134:
      bool1 = false;
      break label114;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.zaz) {
          efN();
        } else if ((this.zar != null) && (this.yZK)) {
          this.zar.b(false, true, true);
        } else if ((!efL()) && (!efK())) {
          efM();
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.zav;
        if ((this.zar != null) && (!this.yZK) && (f1 - f2 > 0.0F) && (bT() != 0)) {
          if (bT() + this.zar.getTotalScrollRange() < this.zas)
          {
            this.zax = true;
          }
          else if ((this.zaB) && (!this.zaw) && (bT() + this.zay >= this.zas))
          {
            this.zaw = true;
            this.ooM.vibrate(10L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryBehavior
 * JD-Core Version:    0.7.0.1
 */