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
  private final b iIG;
  private final d iIH;
  private final ViewGroup iII;
  final ConfettiView iIJ;
  final Queue<com.tencent.mm.particles.a.b> iIK;
  final List<com.tencent.mm.particles.a.b> iIL;
  private long iIM;
  int iIN;
  long iIO;
  private float iIP;
  private float iIQ;
  public Interpolator iIR;
  private Rect iIS;
  private float iIT;
  private float iIU;
  private float iIV;
  private float iIW;
  private float iIX;
  private float iIY;
  private float iIZ;
  private float iJa;
  private Float iJb;
  private Float iJc;
  private Float iJd;
  private Float iJe;
  private int iJf;
  private int iJg;
  private float iJh;
  private float iJi;
  private float iJj;
  private float iJk;
  private Float iJl;
  private Float iJm;
  private long iJn;
  public float iJo;
  public float iJp;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.cR(paramContext));
    AppMethodBeat.i(151350);
    AppMethodBeat.o(151350);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151351);
    this.random = new Random();
    this.iIK = new LinkedList();
    this.iIL = new ArrayList(300);
    this.iIG = paramb;
    this.iIH = paramd;
    this.iII = paramViewGroup;
    this.iIJ = paramConfettiView;
    this.iIJ.iIL = this.iIL;
    this.iIJ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(151348);
        c.this.aPI();
        AppMethodBeat.o(151348);
      }
    });
    this.iJn = -1L;
    this.iIS = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void F(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.iIK.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.iIG.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.iIH, this.random, paramLong);
      this.iIL.add(localb);
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
    paramb.iJC = paramLong;
    paramb.iJD = paramd.ar(paramRandom.nextFloat());
    paramb.iJE = paramd.as(paramRandom.nextFloat());
    paramb.iJF = a(this.iIT, this.iIU, paramRandom);
    paramb.iJG = a(this.iIV, this.iIW, paramRandom);
    paramb.iIX = a(this.iIX, this.iIY, paramRandom);
    paramb.iIZ = a(this.iIZ, this.iJa, paramRandom);
    if (this.iJb == null)
    {
      paramd = null;
      paramb.iJb = paramd;
      if (this.iJd != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.iJd = paramd;
      paramb.iJJ = a(this.iJf, this.iJg, paramRandom);
      paramb.iJK = a(this.iJh, this.iJi, paramRandom);
      paramb.iJj = a(this.iJj, this.iJk, paramRandom);
      if (this.iJl != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.iJl.floatValue(), this.iJm.floatValue(), paramRandom)))
    {
      paramb.iJl = paramd;
      paramb.iJn = this.iJn;
      paramb.iIR = this.iIR;
      paramb.iJM = a(this.iJo, this.iJp, paramRandom);
      paramb.j(this.iIS);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.iJb.floatValue(), this.iJc.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.iJd.floatValue(), this.iJe.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void aPJ()
  {
    AppMethodBeat.i(151355);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.iIM = 0L;
    Iterator localIterator = this.iIL.iterator();
    while (localIterator.hasNext())
    {
      this.iIK.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  private void aPK()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.iIJ.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.iII) {
        ((ViewGroup)localViewParent).removeView(this.iIJ);
      }
    }
    else {
      this.iII.addView(this.iIJ);
    }
    this.iIJ.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void aPL()
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
        Iterator localIterator = paramAnonymousValueAnimator.iIL.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.iJC == -1L) {
            localb.iJC = l1;
          }
          long l2 = l1 - localb.iJC;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.iJR = bool;
            if ((localb.iJR) && (!localb.terminated))
            {
              localb.iJO = com.tencent.mm.particles.a.b.a(l2, localb.iJD, localb.iJF, localb.iIX, localb.iJH, localb.iJb);
              localb.iJP = com.tencent.mm.particles.a.b.a(l2, localb.iJE, localb.iJG, localb.iIZ, localb.iJI, localb.iJd);
              localb.iJQ = com.tencent.mm.particles.a.b.a(l2, localb.iJJ, localb.iJK, localb.iJj, localb.iJL, localb.iJl);
              if (localb.iIR == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.iIR.getInterpolation((float)l2 / localb.iJM) * 255.0F));
              if ((localb.iJS) || ((float)l2 < localb.iJM)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.iJN = Math.min(1.0F, (float)l2 / localb.iJM);
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
            paramAnonymousValueAnimator.iIK.add(localb);
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
        if ((c.this.iIL.size() == 0) && (l1 >= c.this.iIO))
        {
          c.this.aPI();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.iIJ.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.animator.start();
    AppMethodBeat.o(151358);
  }
  
  public final c C(float paramFloat1, float paramFloat2)
  {
    this.iIT = (paramFloat1 / 1000.0F);
    this.iIU = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c D(float paramFloat1, float paramFloat2)
  {
    this.iIV = (paramFloat1 / 1000.0F);
    this.iIW = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c aPC()
  {
    this.iIN = 1;
    return this;
  }
  
  public final c aPD()
  {
    this.iIO = 9223372036854775807L;
    return this;
  }
  
  public final c aPE()
  {
    this.iJf = 180;
    this.iJg = 180;
    return this;
  }
  
  public final c aPF()
  {
    this.iJj = 0.00036F;
    this.iJk = 0.00018F;
    return this;
  }
  
  public final c aPG()
  {
    AppMethodBeat.i(151352);
    this.iJl = Float.valueOf(0.36F);
    this.iJm = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c aPH()
  {
    AppMethodBeat.i(151353);
    aPJ();
    aPK();
    F(this.iIN, 0L);
    aPL();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void aPI()
  {
    AppMethodBeat.i(151354);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.iIJ.aPI();
    AppMethodBeat.o(151354);
  }
  
  public final c ao(float paramFloat)
  {
    this.iIP = (paramFloat / 1000.0F);
    this.iIQ = (1.0F / this.iIP);
    return this;
  }
  
  public final c ap(float paramFloat)
  {
    this.iIX = (paramFloat / 1000000.0F);
    this.iIY = 0.0F;
    return this;
  }
  
  public final c aq(float paramFloat)
  {
    this.iIZ = (paramFloat / 1000000.0F);
    this.iJa = 0.0F;
    return this;
  }
  
  public final c sx(long paramLong)
  {
    this.iJn = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */