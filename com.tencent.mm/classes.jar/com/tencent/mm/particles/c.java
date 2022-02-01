package com.tencent.mm.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c
{
  private ValueAnimator animator;
  public float mAa;
  public float mAb;
  long mzA;
  private float mzB;
  private float mzC;
  public Interpolator mzD;
  private Rect mzE;
  private float mzF;
  private float mzG;
  private float mzH;
  private float mzI;
  private float mzJ;
  private float mzK;
  private float mzL;
  private float mzM;
  private Float mzN;
  private Float mzO;
  private Float mzP;
  private Float mzQ;
  private int mzR;
  private int mzS;
  private float mzT;
  private float mzU;
  private float mzV;
  private float mzW;
  private Float mzX;
  private Float mzY;
  private long mzZ;
  private final b mzs;
  private final d mzt;
  private final ViewGroup mzu;
  final ConfettiView mzv;
  final Queue<com.tencent.mm.particles.a.b> mzw;
  final List<com.tencent.mm.particles.a.b> mzx;
  private long mzy;
  int mzz;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.dl(paramContext));
    AppMethodBeat.i(151350);
    AppMethodBeat.o(151350);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151351);
    this.random = new Random();
    this.mzw = new LinkedList();
    this.mzx = new ArrayList(300);
    this.mzs = paramb;
    this.mzt = paramd;
    this.mzu = paramViewGroup;
    this.mzv = paramConfettiView;
    this.mzv.mzx = this.mzx;
    this.mzv.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(151348);
        c.this.buy();
        AppMethodBeat.o(151348);
      }
    });
    this.mzZ = -1L;
    this.mzE = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void H(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.mzw.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.mzs.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.mzt, this.random, paramLong);
      this.mzx.add(localb);
      i += 1;
      break;
      AppMethodBeat.o(151357);
      return;
    }
  }
  
  private static float a(float paramFloat1, float paramFloat2, Random paramRandom)
  {
    AppMethodBeat.i(151360);
    float f = paramRandom.nextFloat();
    AppMethodBeat.o(151360);
    return (f * 2.0F - 1.0F) * paramFloat2 + paramFloat1;
  }
  
  private void a(com.tencent.mm.particles.a.b paramb, d paramd, Random paramRandom, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(151359);
    paramb.reset();
    paramb.mAo = paramLong;
    paramb.mAp = paramd.aA(paramRandom.nextFloat());
    paramb.mAq = paramd.aB(paramRandom.nextFloat());
    paramb.mAr = a(this.mzF, this.mzG, paramRandom);
    paramb.mAs = a(this.mzH, this.mzI, paramRandom);
    paramb.mzJ = a(this.mzJ, this.mzK, paramRandom);
    paramb.mzL = a(this.mzL, this.mzM, paramRandom);
    if (this.mzN == null)
    {
      paramd = null;
      paramb.mzN = paramd;
      if (this.mzP != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.mzP = paramd;
      paramb.mAv = a(this.mzR, this.mzS, paramRandom);
      paramb.mAw = a(this.mzT, this.mzU, paramRandom);
      paramb.mzV = a(this.mzV, this.mzW, paramRandom);
      if (this.mzX != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.mzX.floatValue(), this.mzY.floatValue(), paramRandom)))
    {
      paramb.mzX = paramd;
      paramb.mzZ = this.mzZ;
      paramb.mzD = this.mzD;
      paramb.mAy = a(this.mAa, this.mAb, paramRandom);
      paramb.p(this.mzE);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.mzN.floatValue(), this.mzO.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.mzP.floatValue(), this.mzQ.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void buA()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.mzv.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.mzu) {
        ((ViewGroup)localViewParent).removeView(this.mzv);
      }
    }
    else {
      this.mzu.addView(this.mzv);
    }
    this.mzv.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void buB()
  {
    AppMethodBeat.i(151358);
    this.animator = ValueAnimator.ofInt(new int[] { 0 }).setDuration(9223372036854775807L);
    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(151349);
        long l1 = paramAnonymousValueAnimator.getCurrentPlayTime();
        c.a(c.this, l1);
        paramAnonymousValueAnimator = c.this;
        Iterator localIterator = paramAnonymousValueAnimator.mzx.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.mAo == -1L) {
            localb.mAo = l1;
          }
          long l2 = l1 - localb.mAo;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.mAD = bool;
            if ((localb.mAD) && (!localb.terminated))
            {
              localb.mAA = com.tencent.mm.particles.a.b.a(l2, localb.mAp, localb.mAr, localb.mzJ, localb.mAt, localb.mzN);
              localb.mAB = com.tencent.mm.particles.a.b.a(l2, localb.mAq, localb.mAs, localb.mzL, localb.mAu, localb.mzP);
              localb.mAC = com.tencent.mm.particles.a.b.a(l2, localb.mAv, localb.mAw, localb.mzV, localb.mAx, localb.mzX);
              if (localb.mzD == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.mzD.getInterpolation((float)l2 / localb.mAy) * 255.0F));
              if ((localb.mAE) || ((float)l2 < localb.mAy)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.mAz = Math.min(1.0F, (float)l2 / localb.mAy);
            }
            if (localb.terminated) {
              break label364;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label367;
            }
            localIterator.remove();
            paramAnonymousValueAnimator.mzw.add(localb);
            break;
            bool = false;
            break label93;
            localb.alpha = 255;
            break label257;
            bool = false;
            break label280;
          }
        }
        label257:
        label280:
        label347:
        if ((c.this.mzx.size() == 0) && (l1 >= c.this.mzA))
        {
          c.this.buy();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.mzv.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.animator.start();
    AppMethodBeat.o(151358);
  }
  
  private void buz()
  {
    AppMethodBeat.i(151355);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.mzy = 0L;
    Iterator localIterator = this.mzx.iterator();
    while (localIterator.hasNext())
    {
      this.mzw.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  public final c GZ(long paramLong)
  {
    this.mzZ = paramLong;
    return this;
  }
  
  public final c H(float paramFloat1, float paramFloat2)
  {
    this.mzF = (paramFloat1 / 1000.0F);
    this.mzG = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c I(float paramFloat1, float paramFloat2)
  {
    this.mzH = (paramFloat1 / 1000.0F);
    this.mzI = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c ax(float paramFloat)
  {
    this.mzB = (paramFloat / 1000.0F);
    this.mzC = (1.0F / this.mzB);
    return this;
  }
  
  public final c ay(float paramFloat)
  {
    this.mzJ = (paramFloat / 1000000.0F);
    this.mzK = 0.0F;
    return this;
  }
  
  public final c az(float paramFloat)
  {
    this.mzL = (paramFloat / 1000000.0F);
    this.mzM = 0.0F;
    return this;
  }
  
  public final c bur()
  {
    this.mzz = 1;
    return this;
  }
  
  public final c bus()
  {
    this.mzA = 9223372036854775807L;
    return this;
  }
  
  public final c but()
  {
    AppMethodBeat.i(196478);
    c localc = H(0.0F, 0.0F);
    AppMethodBeat.o(196478);
    return localc;
  }
  
  public final c buu()
  {
    this.mzR = 180;
    this.mzS = 180;
    return this;
  }
  
  public final c buv()
  {
    this.mzV = 0.00036F;
    this.mzW = 0.00018F;
    return this;
  }
  
  public final c buw()
  {
    AppMethodBeat.i(151352);
    this.mzX = Float.valueOf(0.36F);
    this.mzY = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c bux()
  {
    AppMethodBeat.i(151353);
    buz();
    buA();
    H(this.mzz, 0L);
    buB();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void buy()
  {
    AppMethodBeat.i(151354);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.mzv.buy();
    AppMethodBeat.o(151354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */