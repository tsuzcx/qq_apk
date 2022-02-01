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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class EnvelopeStoryBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private Vibrator mUw;
  private boolean tIL;
  private boolean tIM;
  boolean vsE;
  private EnvelopeAppBarLayout vtm;
  private int vtn;
  private RecyclerView vto;
  private float vtp;
  private float vtq;
  private boolean vtr;
  private boolean vts;
  private int vtt;
  boolean vtu;
  AppBarLayout.b vtv;
  private boolean vtw;
  
  public EnvelopeStoryBehavior()
  {
    AppMethodBeat.i(163614);
    this.vtn = 0;
    this.mUw = ((Vibrator)aj.getContext().getSystemService("vibrator"));
    this.vtt = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 300);
    this.vtu = false;
    this.vsE = false;
    this.tIL = false;
    this.tIM = false;
    AppMethodBeat.o(163614);
  }
  
  public EnvelopeStoryBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163615);
    this.vtn = 0;
    this.mUw = ((Vibrator)aj.getContext().getSystemService("vibrator"));
    this.vtt = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 300);
    this.vtu = false;
    this.vsE = false;
    this.tIL = false;
    this.tIM = false;
    AppMethodBeat.o(163615);
  }
  
  private boolean diQ()
  {
    AppMethodBeat.i(163620);
    int i = bR();
    if (this.vtm.getTotalScrollRange() == Math.abs(i))
    {
      AppMethodBeat.o(163620);
      return true;
    }
    AppMethodBeat.o(163620);
    return false;
  }
  
  private boolean diR()
  {
    AppMethodBeat.i(163621);
    if (Math.abs(bR()) <= 0)
    {
      AppMethodBeat.o(163621);
      return true;
    }
    AppMethodBeat.o(163621);
    return false;
  }
  
  private void diS()
  {
    AppMethodBeat.i(163623);
    if (((this.tIM) && (bR() + this.vtm.getTotalScrollRange() <= this.vtn)) || ((this.tIL) && (Math.abs(bR()) >= this.vtn)))
    {
      this.vtm.b(false, true, true);
      AppMethodBeat.o(163623);
      return;
    }
    this.vtm.b(true, true, true);
    AppMethodBeat.o(163623);
  }
  
  private void diT()
  {
    AppMethodBeat.i(174342);
    int i = bR();
    int j = this.vtm.getTotalScrollRange();
    if (this.vtw)
    {
      if (j - Math.abs(i) < this.vtt)
      {
        this.vtm.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      diU();
      AppMethodBeat.o(174342);
      return;
    }
    if (this.tIM)
    {
      if (bR() + this.vtm.getTotalScrollRange() <= this.vtn)
      {
        this.vtm.b(false, true, true);
        AppMethodBeat.o(174342);
        return;
      }
      diU();
    }
    AppMethodBeat.o(174342);
  }
  
  private void diU()
  {
    AppMethodBeat.i(174343);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.setIntValues(new int[] { bR(), -(this.vtm.getTotalScrollRange() - this.vtt) });
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
      int vtf;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(174341);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        this.vtf = i;
        ad.d("MicroMsg.EnvelopeStoryBehavior", "animate middle: %s", new Object[] { Integer.valueOf(i) });
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
    if ((paramInt5 == 1) && (this.tIM))
    {
      if (paramInt2 == 0)
      {
        ad.i("MicroMsg.EnvelopeStoryBehavior", "stop verticalRecyclerView scroll!");
        this.vto.kJ();
      }
      AppMethodBeat.o(163619);
      return;
    }
    int i = Math.abs(paramInt4);
    i = this.vtm.getTotalScrollRange() - Math.abs(bR()) + i;
    ad.d("MicroMsg.EnvelopeStoryBehavior", "distance: ".concat(String.valueOf(i)));
    float f1 = 0.7F;
    float f2 = this.vtm.getTotalScrollRange();
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
    this.vtm = ((EnvelopeAppBarLayout)paramAppBarLayout);
    this.vto = ((RecyclerView)paramCoordinatorLayout.findViewById(2131301770));
    this.vtn = ((int)(paramCoordinatorLayout.getHeight() / 10.0F));
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).a(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(163616);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(163622);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryBehavior", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    int i;
    boolean bool;
    if (paramMotionEvent.getAction() == 0)
    {
      this.vtp = paramMotionEvent.getX();
      this.vtq = paramMotionEvent.getY();
      this.vtr = false;
      this.vts = false;
      this.tIL = diR();
      this.tIM = diQ();
      i = bR();
      if (this.vtm.getTotalScrollRange() - Math.abs(i) == this.vtt)
      {
        i = 1;
        if ((i == 0) && ((this.tIM) || (this.tIL))) {
          break label185;
        }
        bool = true;
        label148:
        this.vtw = bool;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryBehavior", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(163622);
      return false;
      i = 0;
      break;
      label185:
      bool = false;
      break label148;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.vtu) {
          diT();
        } else if ((this.vtm != null) && (this.vsE)) {
          this.vtm.b(false, true, true);
        } else if ((!diR()) && (!diQ())) {
          diS();
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.vtq;
        if ((this.vtm != null) && (!this.vsE) && (f1 - f2 > 0.0F) && (!this.vtr) && (bR() != 0)) {
          if (bR() + this.vtm.getTotalScrollRange() < this.vtn)
          {
            this.vts = true;
          }
          else if ((this.vts) && (bR() + this.vtm.getTotalScrollRange() >= this.vtn))
          {
            this.vtr = true;
            this.mUw.vibrate(10L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryBehavior
 * JD-Core Version:    0.7.0.1
 */