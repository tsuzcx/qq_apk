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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class EnvelopeStoryBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private boolean HJv;
  private boolean HJw;
  boolean KwZ;
  private EnvelopeAppBarLayout KxS;
  private int KxT;
  private RecyclerView KxU;
  private float KxV;
  private float KxW;
  private boolean KxX;
  private boolean KxY;
  private int KxZ;
  boolean Kya;
  AppBarLayout.b Kyb;
  private boolean Kyc;
  private Vibrator cqQ;
  
  public EnvelopeStoryBehavior()
  {
    AppMethodBeat.i(163614);
    this.KxT = 0;
    this.cqQ = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    this.KxZ = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    this.Kya = false;
    this.KwZ = false;
    this.HJv = false;
    this.HJw = false;
    AppMethodBeat.o(163614);
  }
  
  public EnvelopeStoryBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163615);
    this.KxT = 0;
    this.cqQ = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
    this.KxZ = a.fromDPToPix(MMApplicationContext.getContext(), 300);
    this.Kya = false;
    this.KwZ = false;
    this.HJv = false;
    this.HJw = false;
    AppMethodBeat.o(163615);
  }
  
  private boolean fXP()
  {
    AppMethodBeat.i(163620);
    int i = Vx();
    if (this.KxS.getTotalScrollRange() == Math.abs(i))
    {
      AppMethodBeat.o(163620);
      return true;
    }
    AppMethodBeat.o(163620);
    return false;
  }
  
  private boolean fXQ()
  {
    AppMethodBeat.i(163621);
    if (Math.abs(Vx()) <= 0)
    {
      AppMethodBeat.o(163621);
      return true;
    }
    AppMethodBeat.o(163621);
    return false;
  }
  
  private void fXR()
  {
    AppMethodBeat.i(163623);
    if (((this.HJw) && (Vx() + this.KxS.getTotalScrollRange() <= this.KxT)) || ((this.HJv) && (Math.abs(Vx()) >= this.KxT)))
    {
      this.KxS.c(false, true, true);
      AppMethodBeat.o(163623);
      return;
    }
    if (!fXS()) {
      this.KxS.c(true, true, true);
    }
    AppMethodBeat.o(163623);
  }
  
  private boolean fXS()
  {
    AppMethodBeat.i(284033);
    int i = Vx();
    if (this.KxS.getTotalScrollRange() - Math.abs(i) == this.KxZ)
    {
      AppMethodBeat.o(284033);
      return true;
    }
    AppMethodBeat.o(284033);
    return false;
  }
  
  private void fXT()
  {
    AppMethodBeat.i(174342);
    int i = Vx();
    int j = this.KxS.getTotalScrollRange();
    if (this.Kyc)
    {
      if (j - Math.abs(i) < this.KxZ)
      {
        this.KxS.c(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      if (this.KwZ)
      {
        fXU();
        AppMethodBeat.o(174342);
        return;
      }
      fXR();
      AppMethodBeat.o(174342);
      return;
    }
    if (this.HJw)
    {
      if (Vx() + this.KxS.getTotalScrollRange() <= this.KxT)
      {
        this.KxS.c(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      fXU();
      AppMethodBeat.o(174342);
      return;
    }
    if ((this.HJv) && (Math.abs(Vx()) >= this.KxT))
    {
      if (j - Math.abs(i) < this.KxZ)
      {
        this.KxS.c(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      fXU();
      AppMethodBeat.o(174342);
      return;
    }
    fXR();
    AppMethodBeat.o(174342);
  }
  
  private void fXU()
  {
    AppMethodBeat.i(174343);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.setIntValues(new int[] { Vx(), -(this.KxS.getTotalScrollRange() - this.KxZ) });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(174339);
        EnvelopeStoryBehavior.this.ji(-(EnvelopeStoryBehavior.a(EnvelopeStoryBehavior.this).getTotalScrollRange() - EnvelopeStoryBehavior.b(EnvelopeStoryBehavior.this)));
        AppMethodBeat.o(174339);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      int KxI;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(174341);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        this.KxI = i;
        Log.d("MicroMsg.EnvelopeStoryBehavior", "animate middle: %s", new Object[] { Integer.valueOf(i) });
        EnvelopeStoryBehavior.this.ji(i);
        if (EnvelopeStoryBehavior.c(EnvelopeStoryBehavior.this) != null) {
          EnvelopeStoryBehavior.c(EnvelopeStoryBehavior.this).onOffsetChanged(EnvelopeStoryBehavior.a(EnvelopeStoryBehavior.this), i);
        }
        AppMethodBeat.o(174341);
      }
    });
    localValueAnimator.start();
    AppMethodBeat.o(174343);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(284046);
    if ((paramInt5 == 1) && (this.HJw))
    {
      if (paramInt2 == 0)
      {
        Log.i("MicroMsg.EnvelopeStoryBehavior", "stop verticalRecyclerView scroll!");
        this.KxU.JO();
      }
      AppMethodBeat.o(284046);
      return;
    }
    int i = Math.abs(paramInt4);
    i = this.KxS.getTotalScrollRange() - Math.abs(Vx()) + i;
    Log.d("MicroMsg.EnvelopeStoryBehavior", "distance: ".concat(String.valueOf(i)));
    float f1 = 0.7F;
    float f2 = this.KxS.getTotalScrollRange();
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
      paramInt4 = (int)((float)((float)(f1 * 0.2D * d) + 0.8D) * paramInt4);
    }
    label195:
    for (;;)
    {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      AppMethodBeat.o(284046);
      return;
      f1 = (f2 - i) / f2;
      break;
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(284045);
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    AppMethodBeat.o(284045);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284044);
    boolean bool = super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(284044);
    return bool;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(284043);
    this.KxS = ((EnvelopeAppBarLayout)paramAppBarLayout);
    this.KxU = ((RecyclerView)paramCoordinatorLayout.findViewById(a.f.lucky_money_detail_record_list));
    this.KxT = ((int)(paramCoordinatorLayout.getHeight() / 10.0F));
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).a(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(284043);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(163622);
    boolean bool1;
    if (paramMotionEvent.getAction() == 0)
    {
      this.KxV = paramMotionEvent.getX();
      this.KxW = paramMotionEvent.getY();
      this.KxX = false;
      this.KxY = false;
      this.HJv = fXQ();
      this.HJw = fXP();
      bool1 = bool2;
      if (!fXS())
      {
        if ((!this.HJw) && (!this.HJv)) {
          bool1 = bool2;
        }
      }
      else {
        this.Kyc = bool1;
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
        if (this.Kya) {
          fXT();
        } else if ((this.KxS != null) && (this.KwZ)) {
          this.KxS.c(false, true, true);
        } else if ((!fXQ()) && (!fXP())) {
          fXR();
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.KxW;
        if ((this.KxS != null) && (!this.KwZ) && (f1 - f2 > 0.0F) && (Vx() != 0)) {
          if (Vx() + this.KxS.getTotalScrollRange() < this.KxT)
          {
            this.KxY = true;
          }
          else if ((this.Kyc) && (!this.KxX) && (Vx() + this.KxZ >= this.KxT))
          {
            this.KxX = true;
            this.cqQ.vibrate(10L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryBehavior
 * JD-Core Version:    0.7.0.1
 */