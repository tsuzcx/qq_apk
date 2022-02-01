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
  private final b hOO;
  private final d hOP;
  private final ViewGroup hOQ;
  final ConfettiView hOR;
  final Queue<com.tencent.mm.particles.a.b> hOS;
  final List<com.tencent.mm.particles.a.b> hOT;
  private long hOU;
  int hOV;
  long hOW;
  private float hOX;
  private float hOY;
  public Interpolator hOZ;
  private Rect hPa;
  private float hPb;
  private float hPc;
  private float hPd;
  private float hPe;
  private float hPf;
  private float hPg;
  private float hPh;
  private float hPi;
  private Float hPj;
  private Float hPk;
  private Float hPl;
  private Float hPm;
  private int hPn;
  private int hPo;
  private float hPp;
  private float hPq;
  private float hPr;
  private float hPs;
  private Float hPt;
  private Float hPu;
  private long hPv;
  public float hPw;
  public float hPx;
  private ValueAnimator qT;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.cK(paramContext));
    AppMethodBeat.i(151350);
    AppMethodBeat.o(151350);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151351);
    this.random = new Random();
    this.hOS = new LinkedList();
    this.hOT = new ArrayList(300);
    this.hOO = paramb;
    this.hOP = paramd;
    this.hOQ = paramViewGroup;
    this.hOR = paramConfettiView;
    this.hOR.hOT = this.hOT;
    this.hOR.addOnAttachStateChangeListener(new c.1(this));
    this.hPv = -1L;
    this.hPa = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void E(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.hOS.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.hOO.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.hOP, this.random, paramLong);
      this.hOT.add(localb);
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
    paramb.hPK = paramLong;
    paramb.hPL = paramd.ak(paramRandom.nextFloat());
    paramb.hPM = paramd.al(paramRandom.nextFloat());
    paramb.hPN = a(this.hPb, this.hPc, paramRandom);
    paramb.hPO = a(this.hPd, this.hPe, paramRandom);
    paramb.hPf = a(this.hPf, this.hPg, paramRandom);
    paramb.hPh = a(this.hPh, this.hPi, paramRandom);
    if (this.hPj == null)
    {
      paramd = null;
      paramb.hPj = paramd;
      if (this.hPl != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.hPl = paramd;
      paramb.hPR = a(this.hPn, this.hPo, paramRandom);
      paramb.hPS = a(this.hPp, this.hPq, paramRandom);
      paramb.hPr = a(this.hPr, this.hPs, paramRandom);
      if (this.hPt != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.hPt.floatValue(), this.hPu.floatValue(), paramRandom)))
    {
      paramb.hPt = paramd;
      paramb.hPv = this.hPv;
      paramb.hOZ = this.hOZ;
      paramb.hPU = a(this.hPw, this.hPx, paramRandom);
      paramb.k(this.hPa);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.hPj.floatValue(), this.hPk.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.hPl.floatValue(), this.hPm.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void aFF()
  {
    AppMethodBeat.i(151355);
    if (this.qT != null) {
      this.qT.cancel();
    }
    this.hOU = 0L;
    Iterator localIterator = this.hOT.iterator();
    while (localIterator.hasNext())
    {
      this.hOS.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  private void aFG()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.hOR.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.hOQ) {
        ((ViewGroup)localViewParent).removeView(this.hOR);
      }
    }
    else {
      this.hOQ.addView(this.hOR);
    }
    this.hOR.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void aFH()
  {
    AppMethodBeat.i(151358);
    this.qT = ValueAnimator.ofInt(new int[] { 0 }).setDuration(9223372036854775807L);
    this.qT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(151349);
        long l1 = paramAnonymousValueAnimator.getCurrentPlayTime();
        c.a(c.this, l1);
        paramAnonymousValueAnimator = c.this;
        Iterator localIterator = paramAnonymousValueAnimator.hOT.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.hPK == -1L) {
            localb.hPK = l1;
          }
          long l2 = l1 - localb.hPK;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.hPZ = bool;
            if ((localb.hPZ) && (!localb.terminated))
            {
              localb.hPW = com.tencent.mm.particles.a.b.a(l2, localb.hPL, localb.hPN, localb.hPf, localb.hPP, localb.hPj);
              localb.hPX = com.tencent.mm.particles.a.b.a(l2, localb.hPM, localb.hPO, localb.hPh, localb.hPQ, localb.hPl);
              localb.hPY = com.tencent.mm.particles.a.b.a(l2, localb.hPR, localb.hPS, localb.hPr, localb.hPT, localb.hPt);
              if (localb.hOZ == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.hOZ.getInterpolation((float)l2 / localb.hPU) * 255.0F));
              if ((localb.hQa) || ((float)l2 < localb.hPU)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.hPV = Math.min(1.0F, (float)l2 / localb.hPU);
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
            paramAnonymousValueAnimator.hOS.add(localb);
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
        if ((c.this.hOT.size() == 0) && (l1 >= c.this.hOW))
        {
          c.this.aFE();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.hOR.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.qT.start();
    AppMethodBeat.o(151358);
  }
  
  public final c Bm(long paramLong)
  {
    this.hPv = paramLong;
    return this;
  }
  
  public final c aFA()
  {
    this.hPr = 0.00036F;
    this.hPs = 0.00018F;
    return this;
  }
  
  public final c aFB()
  {
    AppMethodBeat.i(151352);
    this.hPt = Float.valueOf(0.36F);
    this.hPu = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c aFD()
  {
    AppMethodBeat.i(151353);
    aFF();
    aFG();
    E(this.hOV, 0L);
    aFH();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void aFE()
  {
    AppMethodBeat.i(151354);
    if (this.qT != null) {
      this.qT.cancel();
    }
    this.hOR.aFE();
    AppMethodBeat.o(151354);
  }
  
  public final c aFy()
  {
    this.hOW = 9223372036854775807L;
    return this;
  }
  
  public final c aFz()
  {
    this.hPn = 180;
    this.hPo = 180;
    return this;
  }
  
  public final c ah(float paramFloat)
  {
    this.hOX = (paramFloat / 1000.0F);
    this.hOY = (1.0F / this.hOX);
    return this;
  }
  
  public final c ai(float paramFloat)
  {
    this.hPf = (paramFloat / 1000000.0F);
    this.hPg = 0.0F;
    return this;
  }
  
  public final c aj(float paramFloat)
  {
    this.hPh = (paramFloat / 1000000.0F);
    this.hPi = 0.0F;
    return this;
  }
  
  public final c fQO()
  {
    this.hOV = 1;
    return this;
  }
  
  public final c y(float paramFloat1, float paramFloat2)
  {
    this.hPb = (paramFloat1 / 1000.0F);
    this.hPc = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c z(float paramFloat1, float paramFloat2)
  {
    this.hPd = (paramFloat1 / 1000.0F);
    this.hPe = (paramFloat2 / 1000.0F);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */