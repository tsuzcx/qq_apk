package com.tencent.mm.plugin.luckymoney.story;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.Behavior;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class EnvelopeStoryBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private boolean BXi;
  private boolean BXj;
  boolean EDV;
  private EnvelopeAppBarLayout EEN;
  private int EEO;
  private RecyclerView EEP;
  private float EEQ;
  private float EER;
  private boolean EES;
  private boolean EET;
  private int EEU;
  boolean EEV;
  AppBarLayout.b EEW;
  private boolean EEX;
  private Vibrator rqy;
  
  public EnvelopeStoryBehavior()
  {
    AppMethodBeat.i(163614);
    this.EEO = 0;
    this.rqy = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    this.EEU = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    this.EEV = false;
    this.EDV = false;
    this.BXi = false;
    this.BXj = false;
    AppMethodBeat.o(163614);
  }
  
  public EnvelopeStoryBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163615);
    this.EEO = 0;
    this.rqy = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    this.EEU = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    this.EEV = false;
    this.EDV = false;
    this.BXi = false;
    this.BXj = false;
    AppMethodBeat.o(163615);
  }
  
  private boolean ePl()
  {
    AppMethodBeat.i(163620);
    int i = vY();
    if (this.EEN.getTotalScrollRange() == Math.abs(i))
    {
      AppMethodBeat.o(163620);
      return true;
    }
    AppMethodBeat.o(163620);
    return false;
  }
  
  private boolean ePm()
  {
    AppMethodBeat.i(163621);
    if (Math.abs(vY()) <= 0)
    {
      AppMethodBeat.o(163621);
      return true;
    }
    AppMethodBeat.o(163621);
    return false;
  }
  
  private void ePn()
  {
    AppMethodBeat.i(163623);
    if (((this.BXj) && (vY() + this.EEN.getTotalScrollRange() <= this.EEO)) || ((this.BXi) && (Math.abs(vY()) >= this.EEO)))
    {
      this.EEN.c(false, true, true);
      AppMethodBeat.o(163623);
      return;
    }
    if (!ePo()) {
      this.EEN.c(true, true, true);
    }
    AppMethodBeat.o(163623);
  }
  
  private boolean ePo()
  {
    AppMethodBeat.i(206771);
    int i = vY();
    if (this.EEN.getTotalScrollRange() - Math.abs(i) == this.EEU)
    {
      AppMethodBeat.o(206771);
      return true;
    }
    AppMethodBeat.o(206771);
    return false;
  }
  
  private void ePp()
  {
    AppMethodBeat.i(174342);
    int i = vY();
    int j = this.EEN.getTotalScrollRange();
    if (this.EEX)
    {
      if (j - Math.abs(i) < this.EEU)
      {
        this.EEN.c(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      if (this.EDV)
      {
        ePq();
        AppMethodBeat.o(174342);
        return;
      }
      ePn();
      AppMethodBeat.o(174342);
      return;
    }
    if (this.BXj)
    {
      if (vY() + this.EEN.getTotalScrollRange() <= this.EEO)
      {
        this.EEN.c(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      ePq();
      AppMethodBeat.o(174342);
      return;
    }
    if ((this.BXi) && (Math.abs(vY()) >= this.EEO))
    {
      if (j - Math.abs(i) < this.EEU)
      {
        this.EEN.c(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      ePq();
      AppMethodBeat.o(174342);
      return;
    }
    ePn();
    AppMethodBeat.o(174342);
  }
  
  private void ePq()
  {
    AppMethodBeat.i(174343);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.setIntValues(new int[] { vY(), -(this.EEN.getTotalScrollRange() - this.EEU) });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(174339);
        EnvelopeStoryBehavior.this.fT(-(EnvelopeStoryBehavior.a(EnvelopeStoryBehavior.this).getTotalScrollRange() - EnvelopeStoryBehavior.b(EnvelopeStoryBehavior.this)));
        AppMethodBeat.o(174339);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      int EED;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(174341);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        this.EED = i;
        Log.d("MicroMsg.EnvelopeStoryBehavior", "animate middle: %s", new Object[] { Integer.valueOf(i) });
        EnvelopeStoryBehavior.this.fT(i);
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
    AppMethodBeat.i(206763);
    if ((paramInt5 == 1) && (this.BXj))
    {
      if (paramInt2 == 0)
      {
        Log.i("MicroMsg.EnvelopeStoryBehavior", "stop verticalRecyclerView scroll!");
        this.EEP.ld();
      }
      AppMethodBeat.o(206763);
      return;
    }
    int i = Math.abs(paramInt4);
    i = this.EEN.getTotalScrollRange() - Math.abs(vY()) + i;
    Log.d("MicroMsg.EnvelopeStoryBehavior", "distance: ".concat(String.valueOf(i)));
    float f1 = 0.7F;
    float f2 = this.EEN.getTotalScrollRange();
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
      AppMethodBeat.o(206763);
      return;
      f1 = (f2 - i) / f2;
      break;
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(206761);
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    AppMethodBeat.o(206761);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206759);
    boolean bool = super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(206759);
    return bool;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(206757);
    this.EEN = ((EnvelopeAppBarLayout)paramAppBarLayout);
    this.EEP = ((RecyclerView)paramCoordinatorLayout.findViewById(a.f.lucky_money_detail_record_list));
    this.EEO = ((int)(paramCoordinatorLayout.getHeight() / 10.0F));
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).b(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(206757);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(163622);
    boolean bool1;
    if (paramMotionEvent.getAction() == 0)
    {
      this.EEQ = paramMotionEvent.getX();
      this.EER = paramMotionEvent.getY();
      this.EES = false;
      this.EET = false;
      this.BXi = ePm();
      this.BXj = ePl();
      bool1 = bool2;
      if (!ePo())
      {
        if ((!this.BXj) && (!this.BXi)) {
          bool1 = bool2;
        }
      }
      else {
        this.EEX = bool1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(163622);
      return false;
      bool1 = false;
      break;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.EEV) {
          ePp();
        } else if ((this.EEN != null) && (this.EDV)) {
          this.EEN.c(false, true, true);
        } else if ((!ePm()) && (!ePl())) {
          ePn();
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.EER;
        if ((this.EEN != null) && (!this.EDV) && (f1 - f2 > 0.0F) && (vY() != 0)) {
          if (vY() + this.EEN.getTotalScrollRange() < this.EEO)
          {
            this.EET = true;
          }
          else if ((this.EEX) && (!this.EES) && (vY() + this.EEU >= this.EEO))
          {
            this.EES = true;
            this.rqy.vibrate(10L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryBehavior
 * JD-Core Version:    0.7.0.1
 */