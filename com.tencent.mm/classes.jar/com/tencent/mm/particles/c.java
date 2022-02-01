package com.tencent.mm.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
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
  private final d iLA;
  private final ViewGroup iLB;
  final ConfettiView iLC;
  final Queue<com.tencent.mm.particles.a.b> iLD;
  final List<com.tencent.mm.particles.a.b> iLE;
  private long iLF;
  int iLG;
  long iLH;
  private float iLI;
  private float iLJ;
  public Interpolator iLK;
  private Rect iLL;
  private float iLM;
  private float iLN;
  private float iLO;
  private float iLP;
  private float iLQ;
  private float iLR;
  private float iLS;
  private float iLT;
  private Float iLU;
  private Float iLV;
  private Float iLW;
  private Float iLX;
  private int iLY;
  private int iLZ;
  private final b iLz;
  private float iMa;
  private float iMb;
  private float iMc;
  private float iMd;
  private Float iMe;
  private Float iMf;
  private long iMg;
  public float iMh;
  public float iMi;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.cT(paramContext));
    AppMethodBeat.i(151350);
    AppMethodBeat.o(151350);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151351);
    this.random = new Random();
    this.iLD = new LinkedList();
    this.iLE = new ArrayList(300);
    this.iLz = paramb;
    this.iLA = paramd;
    this.iLB = paramViewGroup;
    this.iLC = paramConfettiView;
    this.iLC.iLE = this.iLE;
    this.iLC.addOnAttachStateChangeListener(new c.1(this));
    this.iMg = -1L;
    this.iLL = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void E(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.iLD.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.iLz.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.iLA, this.random, paramLong);
      this.iLE.add(localb);
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
    paramb.iMv = paramLong;
    paramb.iMw = paramd.ar(paramRandom.nextFloat());
    paramb.iMx = paramd.as(paramRandom.nextFloat());
    paramb.iMy = a(this.iLM, this.iLN, paramRandom);
    paramb.iMz = a(this.iLO, this.iLP, paramRandom);
    paramb.iLQ = a(this.iLQ, this.iLR, paramRandom);
    paramb.iLS = a(this.iLS, this.iLT, paramRandom);
    if (this.iLU == null)
    {
      paramd = null;
      paramb.iLU = paramd;
      if (this.iLW != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.iLW = paramd;
      paramb.iMC = a(this.iLY, this.iLZ, paramRandom);
      paramb.iMD = a(this.iMa, this.iMb, paramRandom);
      paramb.iMc = a(this.iMc, this.iMd, paramRandom);
      if (this.iMe != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.iMe.floatValue(), this.iMf.floatValue(), paramRandom)))
    {
      paramb.iMe = paramd;
      paramb.iMg = this.iMg;
      paramb.iLK = this.iLK;
      paramb.iMF = a(this.iMh, this.iMi, paramRandom);
      paramb.j(this.iLL);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.iLU.floatValue(), this.iLV.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.iLW.floatValue(), this.iLX.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void aQi()
  {
    AppMethodBeat.i(151355);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.iLF = 0L;
    Iterator localIterator = this.iLE.iterator();
    while (localIterator.hasNext())
    {
      this.iLD.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  private void aQj()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.iLC.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.iLB) {
        ((ViewGroup)localViewParent).removeView(this.iLC);
      }
    }
    else {
      this.iLB.addView(this.iLC);
    }
    this.iLC.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void aQk()
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
        Iterator localIterator = paramAnonymousValueAnimator.iLE.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.iMv == -1L) {
            localb.iMv = l1;
          }
          long l2 = l1 - localb.iMv;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.iMK = bool;
            if ((localb.iMK) && (!localb.terminated))
            {
              localb.iMH = com.tencent.mm.particles.a.b.a(l2, localb.iMw, localb.iMy, localb.iLQ, localb.iMA, localb.iLU);
              localb.iMI = com.tencent.mm.particles.a.b.a(l2, localb.iMx, localb.iMz, localb.iLS, localb.iMB, localb.iLW);
              localb.iMJ = com.tencent.mm.particles.a.b.a(l2, localb.iMC, localb.iMD, localb.iMc, localb.iME, localb.iMe);
              if (localb.iLK == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.iLK.getInterpolation((float)l2 / localb.iMF) * 255.0F));
              if ((localb.iML) || ((float)l2 < localb.iMF)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.iMG = Math.min(1.0F, (float)l2 / localb.iMF);
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
            paramAnonymousValueAnimator.iLD.add(localb);
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
        if ((c.this.iLE.size() == 0) && (l1 >= c.this.iLH))
        {
          c.this.aQh();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.iLC.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.animator.start();
    AppMethodBeat.o(151358);
  }
  
  public final c C(float paramFloat1, float paramFloat2)
  {
    this.iLM = (paramFloat1 / 1000.0F);
    this.iLN = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c D(float paramFloat1, float paramFloat2)
  {
    this.iLO = (paramFloat1 / 1000.0F);
    this.iLP = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c aQb()
  {
    this.iLG = 1;
    return this;
  }
  
  public final c aQc()
  {
    this.iLH = 9223372036854775807L;
    return this;
  }
  
  public final c aQd()
  {
    this.iLY = 180;
    this.iLZ = 180;
    return this;
  }
  
  public final c aQe()
  {
    this.iMc = 0.00036F;
    this.iMd = 0.00018F;
    return this;
  }
  
  public final c aQf()
  {
    AppMethodBeat.i(151352);
    this.iMe = Float.valueOf(0.36F);
    this.iMf = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c aQg()
  {
    AppMethodBeat.i(151353);
    aQi();
    aQj();
    E(this.iLG, 0L);
    aQk();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(151354);
    if (this.animator != null) {
      this.animator.cancel();
    }
    this.iLC.aQh();
    AppMethodBeat.o(151354);
  }
  
  public final c ao(float paramFloat)
  {
    this.iLI = (paramFloat / 1000.0F);
    this.iLJ = (1.0F / this.iLI);
    return this;
  }
  
  public final c ap(float paramFloat)
  {
    this.iLQ = (paramFloat / 1000000.0F);
    this.iLR = 0.0F;
    return this;
  }
  
  public final c aq(float paramFloat)
  {
    this.iLS = (paramFloat / 1000000.0F);
    this.iLT = 0.0F;
    return this;
  }
  
  public final c sK(long paramLong)
  {
    this.iMg = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */