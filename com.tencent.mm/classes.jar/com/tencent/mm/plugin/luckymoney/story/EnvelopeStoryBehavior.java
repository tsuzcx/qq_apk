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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class EnvelopeStoryBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private Vibrator mtQ;
  private boolean sMe;
  private boolean sMf;
  private EnvelopeAppBarLayout uqH;
  private int uqI;
  private RecyclerView uqJ;
  private float uqK;
  private float uqL;
  private boolean uqM;
  private boolean uqN;
  private int uqO;
  boolean uqP;
  AppBarLayout.b uqQ;
  private boolean uqR;
  boolean uqa;
  
  public EnvelopeStoryBehavior()
  {
    AppMethodBeat.i(163614);
    this.uqI = 0;
    this.mtQ = ((Vibrator)ai.getContext().getSystemService("vibrator"));
    this.uqO = a.fromDPToPix(ai.getContext(), 130);
    this.uqP = false;
    this.uqa = false;
    this.sMe = false;
    this.sMf = false;
    AppMethodBeat.o(163614);
  }
  
  public EnvelopeStoryBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163615);
    this.uqI = 0;
    this.mtQ = ((Vibrator)ai.getContext().getSystemService("vibrator"));
    this.uqO = a.fromDPToPix(ai.getContext(), 130);
    this.uqP = false;
    this.uqa = false;
    this.sMe = false;
    this.sMf = false;
    AppMethodBeat.o(163615);
  }
  
  private boolean cZE()
  {
    AppMethodBeat.i(163620);
    int i = bC();
    if (this.uqH.getTotalScrollRange() == Math.abs(i))
    {
      AppMethodBeat.o(163620);
      return true;
    }
    AppMethodBeat.o(163620);
    return false;
  }
  
  private boolean cZF()
  {
    AppMethodBeat.i(163621);
    if (Math.abs(bC()) <= 0)
    {
      AppMethodBeat.o(163621);
      return true;
    }
    AppMethodBeat.o(163621);
    return false;
  }
  
  private void cZG()
  {
    AppMethodBeat.i(163623);
    if (((this.sMf) && (bC() + this.uqH.getTotalScrollRange() <= this.uqI)) || ((this.sMe) && (Math.abs(bC()) >= this.uqI)))
    {
      this.uqH.b(false, true, true);
      AppMethodBeat.o(163623);
      return;
    }
    this.uqH.b(true, true, true);
    AppMethodBeat.o(163623);
  }
  
  private void cZH()
  {
    AppMethodBeat.i(174342);
    int i = bC();
    int j = this.uqH.getTotalScrollRange();
    if (this.uqR)
    {
      if (j - Math.abs(i) < this.uqO)
      {
        this.uqH.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      cZI();
      AppMethodBeat.o(174342);
      return;
    }
    if (this.sMf)
    {
      if (bC() + this.uqH.getTotalScrollRange() <= this.uqI)
      {
        this.uqH.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      cZI();
    }
    AppMethodBeat.o(174342);
  }
  
  private void cZI()
  {
    AppMethodBeat.i(174343);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.setIntValues(new int[] { bC(), -(this.uqH.getTotalScrollRange() - this.uqO) });
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
      int uqA;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(174341);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        this.uqA = i;
        ac.d("MicroMsg.EnvelopeStoryBehavior", "animate middle: %s", new Object[] { Integer.valueOf(i) });
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
    if ((paramInt5 == 1) && (this.sMf))
    {
      if (paramInt2 == 0)
      {
        ac.i("MicroMsg.EnvelopeStoryBehavior", "stop verticalRecyclerView scroll!");
        this.uqJ.kt();
      }
      AppMethodBeat.o(163619);
      return;
    }
    int i = Math.abs(paramInt4);
    i = this.uqH.getTotalScrollRange() - Math.abs(bC()) + i;
    ac.d("MicroMsg.EnvelopeStoryBehavior", "distance: ".concat(String.valueOf(i)));
    float f1 = 0.7F;
    float f2 = this.uqH.getTotalScrollRange();
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
    this.uqH = ((EnvelopeAppBarLayout)paramAppBarLayout);
    this.uqJ = ((RecyclerView)paramCoordinatorLayout.findViewById(2131301770));
    this.uqI = ((int)(paramCoordinatorLayout.getHeight() / 10.0F));
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).a(this);
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
      this.uqK = paramMotionEvent.getX();
      this.uqL = paramMotionEvent.getY();
      this.uqM = false;
      this.uqN = false;
      this.sMe = cZF();
      this.sMf = cZE();
      i = bC();
      if (this.uqH.getTotalScrollRange() - Math.abs(i) == this.uqO)
      {
        i = 1;
        bool1 = bool2;
        if (i == 0)
        {
          if ((this.sMf) || (this.sMe)) {
            break label134;
          }
          bool1 = bool2;
        }
        label114:
        this.uqR = bool1;
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
        if (this.uqP) {
          cZH();
        } else if ((this.uqH != null) && (this.uqa)) {
          this.uqH.b(false, true, true);
        } else if ((!cZF()) && (!cZE())) {
          cZG();
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.uqL;
        if ((this.uqH != null) && (!this.uqa) && (f1 - f2 > 0.0F) && (!this.uqM) && (bC() != 0)) {
          if (bC() + this.uqH.getTotalScrollRange() < this.uqI)
          {
            this.uqN = true;
          }
          else if ((this.uqN) && (bC() + this.uqH.getTotalScrollRange() >= this.uqI))
          {
            this.uqM = true;
            this.mtQ.vibrate(10L);
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