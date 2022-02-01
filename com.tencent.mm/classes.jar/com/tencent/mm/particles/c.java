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
  private final ViewGroup parentView;
  private Float pwA;
  private int pwB;
  private int pwC;
  private float pwD;
  private float pwE;
  private float pwF;
  private float pwG;
  private Float pwH;
  private Float pwI;
  public long pwJ;
  public float pwK;
  public float pwL;
  private final b pwd;
  private final d pwe;
  final ConfettiView pwf;
  final Queue<com.tencent.mm.particles.a.b> pwg;
  final List<com.tencent.mm.particles.a.b> pwh;
  private long pwi;
  public int pwj;
  public long pwk;
  private float pwl;
  private float pwm;
  public Interpolator pwn;
  private Rect pwo;
  private float pwp;
  private float pwq;
  private float pwr;
  private float pws;
  private float pwt;
  private float pwu;
  private float pwv;
  private float pww;
  private Float pwx;
  private Float pwy;
  private Float pwz;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.ed(paramContext));
    AppMethodBeat.i(151350);
    AppMethodBeat.o(151350);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151351);
    this.random = new Random();
    this.pwg = new LinkedList();
    this.pwh = new ArrayList(300);
    this.pwd = paramb;
    this.pwe = paramd;
    this.parentView = paramViewGroup;
    this.pwf = paramConfettiView;
    this.pwf.pwh = this.pwh;
    this.pwf.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(151348);
        c.this.bSJ();
        AppMethodBeat.o(151348);
      }
    });
    this.pwJ = -1L;
    this.pwo = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void K(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.pwg.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.pwd.generateConfetti(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.pwe, this.random, paramLong);
      this.pwh.add(localb);
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
    paramb.pwY = paramLong;
    paramb.pwZ = paramd.by(paramRandom.nextFloat());
    paramb.pxa = paramd.bz(paramRandom.nextFloat());
    paramb.pxb = a(this.pwp, this.pwq, paramRandom);
    paramb.pxc = a(this.pwr, this.pws, paramRandom);
    paramb.pwt = a(this.pwt, this.pwu, paramRandom);
    paramb.pwv = a(this.pwv, this.pww, paramRandom);
    if (this.pwx == null)
    {
      paramd = null;
      paramb.pwx = paramd;
      if (this.pwz != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.pwz = paramd;
      paramb.pxf = a(this.pwB, this.pwC, paramRandom);
      paramb.pxg = a(this.pwD, this.pwE, paramRandom);
      paramb.pwF = a(this.pwF, this.pwG, paramRandom);
      if (this.pwH != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.pwH.floatValue(), this.pwI.floatValue(), paramRandom)))
    {
      paramb.pwH = paramd;
      paramb.pwJ = this.pwJ;
      paramb.pwn = this.pwn;
      paramb.pxi = a(this.pwK, this.pwL, paramRandom);
      paramb.u(this.pwo);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.pwx.floatValue(), this.pwy.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.pwz.floatValue(), this.pwA.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void bSK()
  {
    AppMethodBeat.i(151355);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.pwi = 0L;
    Iterator localIterator = this.pwh.iterator();
    while (localIterator.hasNext())
    {
      this.pwg.add((com.tencent.mm.particles.a.b)localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  private void bSL()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.pwf.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.parentView) {
        ((ViewGroup)localViewParent).removeView(this.pwf);
      }
    }
    else {
      this.parentView.addView(this.pwf);
    }
    this.pwf.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void bSM()
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
        Iterator localIterator = paramAnonymousValueAnimator.pwh.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.pwY == -1L) {
            localb.pwY = l1;
          }
          long l2 = l1 - localb.pwY;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.pxn = bool;
            if ((localb.pxn) && (!localb.terminated))
            {
              localb.pxk = com.tencent.mm.particles.a.b.a(l2, localb.pwZ, localb.pxb, localb.pwt, localb.pxd, localb.pwx);
              localb.pxl = com.tencent.mm.particles.a.b.a(l2, localb.pxa, localb.pxc, localb.pwv, localb.pxe, localb.pwz);
              localb.pxm = com.tencent.mm.particles.a.b.a(l2, localb.pxf, localb.pxg, localb.pwF, localb.pxh, localb.pwH);
              if (localb.pwn == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.pwn.getInterpolation((float)l2 / localb.pxi) * 255.0F));
              if ((localb.pxo) || ((float)l2 < localb.pxi)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.pxj = Math.min(1.0F, (float)l2 / localb.pxi);
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
            paramAnonymousValueAnimator.pwg.add(localb);
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
        if ((c.this.pwh.size() == 0) && (l1 >= c.this.pwk))
        {
          c.this.bSJ();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.pwf.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.animator.start();
    AppMethodBeat.o(151358);
  }
  
  public final c an(float paramFloat1, float paramFloat2)
  {
    this.pwp = (paramFloat1 / 1000.0F);
    this.pwq = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c ao(float paramFloat1, float paramFloat2)
  {
    this.pwr = (paramFloat1 / 1000.0F);
    this.pws = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c bSF()
  {
    this.pwB = 180;
    this.pwC = 180;
    return this;
  }
  
  public final c bSG()
  {
    this.pwF = 0.00036F;
    this.pwG = 0.00018F;
    return this;
  }
  
  public final c bSH()
  {
    AppMethodBeat.i(151352);
    this.pwH = Float.valueOf(0.36F);
    this.pwI = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c bSI()
  {
    AppMethodBeat.i(151353);
    bSK();
    bSL();
    K(this.pwj, 0L);
    bSM();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void bSJ()
  {
    AppMethodBeat.i(151354);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.pwf.bSJ();
    AppMethodBeat.o(151354);
  }
  
  public final c bv(float paramFloat)
  {
    this.pwl = (paramFloat / 1000.0F);
    this.pwm = (1.0F / this.pwl);
    return this;
  }
  
  public final c bw(float paramFloat)
  {
    this.pwt = (paramFloat / 1000000.0F);
    this.pwu = 0.0F;
    return this;
  }
  
  public final c bx(float paramFloat)
  {
    this.pwv = (paramFloat / 1000000.0F);
    this.pww = 0.0F;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */