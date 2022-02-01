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
  private float jIA;
  private float jIB;
  private float jIC;
  private float jID;
  private float jIE;
  private float jIF;
  private float jIG;
  private float jIH;
  private Float jII;
  private Float jIJ;
  private Float jIK;
  private Float jIL;
  private int jIM;
  private int jIN;
  private float jIO;
  private float jIP;
  private float jIQ;
  private float jIR;
  private Float jIS;
  private Float jIT;
  private long jIU;
  public float jIV;
  public float jIW;
  private final b jIn;
  private final d jIo;
  private final ViewGroup jIp;
  final ConfettiView jIq;
  final Queue<com.tencent.mm.particles.a.b> jIr;
  final List<com.tencent.mm.particles.a.b> jIs;
  private long jIt;
  int jIu;
  long jIv;
  private float jIw;
  private float jIx;
  public Interpolator jIy;
  private Rect jIz;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.jdMethod_do(paramContext));
    AppMethodBeat.i(151350);
    AppMethodBeat.o(151350);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151351);
    this.random = new Random();
    this.jIr = new LinkedList();
    this.jIs = new ArrayList(300);
    this.jIn = paramb;
    this.jIo = paramd;
    this.jIp = paramViewGroup;
    this.jIq = paramConfettiView;
    this.jIq.jIs = this.jIs;
    this.jIq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(151348);
        c.this.bkK();
        AppMethodBeat.o(151348);
      }
    });
    this.jIU = -1L;
    this.jIz = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void H(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.jIr.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.jIn.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.jIo, this.random, paramLong);
      this.jIs.add(localb);
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
    paramb.jJj = paramLong;
    paramb.jJk = paramd.aA(paramRandom.nextFloat());
    paramb.jJl = paramd.aB(paramRandom.nextFloat());
    paramb.jJm = a(this.jIA, this.jIB, paramRandom);
    paramb.jJn = a(this.jIC, this.jID, paramRandom);
    paramb.jIE = a(this.jIE, this.jIF, paramRandom);
    paramb.jIG = a(this.jIG, this.jIH, paramRandom);
    if (this.jII == null)
    {
      paramd = null;
      paramb.jII = paramd;
      if (this.jIK != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.jIK = paramd;
      paramb.jJq = a(this.jIM, this.jIN, paramRandom);
      paramb.jJr = a(this.jIO, this.jIP, paramRandom);
      paramb.jIQ = a(this.jIQ, this.jIR, paramRandom);
      if (this.jIS != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.jIS.floatValue(), this.jIT.floatValue(), paramRandom)))
    {
      paramb.jIS = paramd;
      paramb.jIU = this.jIU;
      paramb.jIy = this.jIy;
      paramb.jJt = a(this.jIV, this.jIW, paramRandom);
      paramb.k(this.jIz);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.jII.floatValue(), this.jIJ.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.jIK.floatValue(), this.jIL.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void bkL()
  {
    AppMethodBeat.i(151355);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.jIt = 0L;
    Iterator localIterator = this.jIs.iterator();
    while (localIterator.hasNext())
    {
      this.jIr.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  private void bkM()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.jIq.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.jIp) {
        ((ViewGroup)localViewParent).removeView(this.jIq);
      }
    }
    else {
      this.jIp.addView(this.jIq);
    }
    this.jIq.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void bkN()
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
        Iterator localIterator = paramAnonymousValueAnimator.jIs.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.jJj == -1L) {
            localb.jJj = l1;
          }
          long l2 = l1 - localb.jJj;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.jJy = bool;
            if ((localb.jJy) && (!localb.terminated))
            {
              localb.jJv = com.tencent.mm.particles.a.b.a(l2, localb.jJk, localb.jJm, localb.jIE, localb.jJo, localb.jII);
              localb.jJw = com.tencent.mm.particles.a.b.a(l2, localb.jJl, localb.jJn, localb.jIG, localb.jJp, localb.jIK);
              localb.jJx = com.tencent.mm.particles.a.b.a(l2, localb.jJq, localb.jJr, localb.jIQ, localb.jJs, localb.jIS);
              if (localb.jIy == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.jIy.getInterpolation((float)l2 / localb.jJt) * 255.0F));
              if ((localb.jJz) || ((float)l2 < localb.jJt)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.jJu = Math.min(1.0F, (float)l2 / localb.jJt);
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
            paramAnonymousValueAnimator.jIr.add(localb);
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
        if ((c.this.jIs.size() == 0) && (l1 >= c.this.jIv))
        {
          c.this.bkK();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.jIq.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.animator.start();
    AppMethodBeat.o(151358);
  }
  
  public final c AQ(long paramLong)
  {
    this.jIU = paramLong;
    return this;
  }
  
  public final c G(float paramFloat1, float paramFloat2)
  {
    this.jIA = (paramFloat1 / 1000.0F);
    this.jIB = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c H(float paramFloat1, float paramFloat2)
  {
    this.jIC = (paramFloat1 / 1000.0F);
    this.jID = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c ax(float paramFloat)
  {
    this.jIw = (paramFloat / 1000.0F);
    this.jIx = (1.0F / this.jIw);
    return this;
  }
  
  public final c ay(float paramFloat)
  {
    this.jIE = (paramFloat / 1000000.0F);
    this.jIF = 0.0F;
    return this;
  }
  
  public final c az(float paramFloat)
  {
    this.jIG = (paramFloat / 1000000.0F);
    this.jIH = 0.0F;
    return this;
  }
  
  public final c bkD()
  {
    this.jIu = 1;
    return this;
  }
  
  public final c bkE()
  {
    this.jIv = 9223372036854775807L;
    return this;
  }
  
  public final c bkF()
  {
    AppMethodBeat.i(223652);
    c localc = G(0.0F, 0.0F);
    AppMethodBeat.o(223652);
    return localc;
  }
  
  public final c bkG()
  {
    this.jIM = 180;
    this.jIN = 180;
    return this;
  }
  
  public final c bkH()
  {
    this.jIQ = 0.00036F;
    this.jIR = 0.00018F;
    return this;
  }
  
  public final c bkI()
  {
    AppMethodBeat.i(151352);
    this.jIS = Float.valueOf(0.36F);
    this.jIT = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c bkJ()
  {
    AppMethodBeat.i(151353);
    bkL();
    bkM();
    H(this.jIu, 0L);
    bkN();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void bkK()
  {
    AppMethodBeat.i(151354);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.jIq.bkK();
    AppMethodBeat.o(151354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */