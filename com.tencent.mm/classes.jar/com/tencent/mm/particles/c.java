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
  private float ipA;
  private float ipB;
  private float ipC;
  private float ipD;
  private Float ipE;
  private Float ipF;
  private Float ipG;
  private Float ipH;
  private int ipI;
  private int ipJ;
  private float ipK;
  private float ipL;
  private float ipM;
  private float ipN;
  private Float ipO;
  private Float ipP;
  private long ipQ;
  public float ipR;
  public float ipS;
  private final b ipj;
  private final d ipk;
  private final ViewGroup ipl;
  final ConfettiView ipm;
  final Queue<com.tencent.mm.particles.a.b> ipn;
  final List<com.tencent.mm.particles.a.b> ipo;
  private long ipp;
  int ipq;
  long ipr;
  private float ips;
  private float ipt;
  public Interpolator ipu;
  private Rect ipv;
  private float ipw;
  private float ipx;
  private float ipy;
  private float ipz;
  private ValueAnimator rT;
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
    this.ipn = new LinkedList();
    this.ipo = new ArrayList(300);
    this.ipj = paramb;
    this.ipk = paramd;
    this.ipl = paramViewGroup;
    this.ipm = paramConfettiView;
    this.ipm.ipo = this.ipo;
    this.ipm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(151348);
        c.this.aMv();
        AppMethodBeat.o(151348);
      }
    });
    this.ipQ = -1L;
    this.ipv = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151351);
  }
  
  private void D(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151357);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.ipn.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.ipj.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.ipk, this.random, paramLong);
      this.ipo.add(localb);
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
    paramb.iqf = paramLong;
    paramb.iqg = paramd.ao(paramRandom.nextFloat());
    paramb.iqh = paramd.ap(paramRandom.nextFloat());
    paramb.iqi = a(this.ipw, this.ipx, paramRandom);
    paramb.iqj = a(this.ipy, this.ipz, paramRandom);
    paramb.ipA = a(this.ipA, this.ipB, paramRandom);
    paramb.ipC = a(this.ipC, this.ipD, paramRandom);
    if (this.ipE == null)
    {
      paramd = null;
      paramb.ipE = paramd;
      if (this.ipG != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.ipG = paramd;
      paramb.iqm = a(this.ipI, this.ipJ, paramRandom);
      paramb.iqn = a(this.ipK, this.ipL, paramRandom);
      paramb.ipM = a(this.ipM, this.ipN, paramRandom);
      if (this.ipO != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.ipO.floatValue(), this.ipP.floatValue(), paramRandom)))
    {
      paramb.ipO = paramd;
      paramb.ipQ = this.ipQ;
      paramb.ipu = this.ipu;
      paramb.iqp = a(this.ipR, this.ipS, paramRandom);
      paramb.j(this.ipv);
      AppMethodBeat.o(151359);
      return;
      paramd = Float.valueOf(a(this.ipE.floatValue(), this.ipF.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.ipG.floatValue(), this.ipH.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void aMw()
  {
    AppMethodBeat.i(151355);
    if (this.rT != null) {
      this.rT.cancel();
    }
    this.ipp = 0L;
    Iterator localIterator = this.ipo.iterator();
    while (localIterator.hasNext())
    {
      this.ipn.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151355);
  }
  
  private void aMx()
  {
    AppMethodBeat.i(151356);
    ViewParent localViewParent = this.ipm.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.ipl) {
        ((ViewGroup)localViewParent).removeView(this.ipm);
      }
    }
    else {
      this.ipl.addView(this.ipm);
    }
    this.ipm.terminated = false;
    AppMethodBeat.o(151356);
  }
  
  private void aMy()
  {
    AppMethodBeat.i(151358);
    this.rT = ValueAnimator.ofInt(new int[] { 0 }).setDuration(9223372036854775807L);
    this.rT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(151349);
        long l1 = paramAnonymousValueAnimator.getCurrentPlayTime();
        c.a(c.this, l1);
        paramAnonymousValueAnimator = c.this;
        Iterator localIterator = paramAnonymousValueAnimator.ipo.iterator();
        label93:
        label358:
        label364:
        label367:
        while (localIterator.hasNext())
        {
          com.tencent.mm.particles.a.b localb = (com.tencent.mm.particles.a.b)localIterator.next();
          if (localb.iqf == -1L) {
            localb.iqf = l1;
          }
          long l2 = l1 - localb.iqf;
          boolean bool;
          if (l2 >= 0L)
          {
            bool = true;
            localb.iqu = bool;
            if ((localb.iqu) && (!localb.terminated))
            {
              localb.iqr = com.tencent.mm.particles.a.b.a(l2, localb.iqg, localb.iqi, localb.ipA, localb.iqk, localb.ipE);
              localb.iqs = com.tencent.mm.particles.a.b.a(l2, localb.iqh, localb.iqj, localb.ipC, localb.iql, localb.ipG);
              localb.iqt = com.tencent.mm.particles.a.b.a(l2, localb.iqm, localb.iqn, localb.ipM, localb.iqo, localb.ipO);
              if (localb.ipu == null) {
                break label347;
              }
              localb.alpha = ((int)(localb.ipu.getInterpolation((float)l2 / localb.iqp) * 255.0F));
              if ((localb.iqv) || ((float)l2 < localb.iqp)) {
                break label358;
              }
              bool = true;
              localb.terminated = bool;
              localb.iqq = Math.min(1.0F, (float)l2 / localb.iqp);
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
            paramAnonymousValueAnimator.ipn.add(localb);
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
        if ((c.this.ipo.size() == 0) && (l1 >= c.this.ipr))
        {
          c.this.aMv();
          AppMethodBeat.o(151349);
          return;
        }
        c.this.ipm.invalidate();
        AppMethodBeat.o(151349);
      }
    });
    this.rT.start();
    AppMethodBeat.o(151358);
  }
  
  public final c B(float paramFloat1, float paramFloat2)
  {
    this.ipw = (paramFloat1 / 1000.0F);
    this.ipx = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c C(float paramFloat1, float paramFloat2)
  {
    this.ipy = (paramFloat1 / 1000.0F);
    this.ipz = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c aMp()
  {
    this.ipq = 1;
    return this;
  }
  
  public final c aMq()
  {
    this.ipr = 9223372036854775807L;
    return this;
  }
  
  public final c aMr()
  {
    this.ipI = 180;
    this.ipJ = 180;
    return this;
  }
  
  public final c aMs()
  {
    this.ipM = 0.00036F;
    this.ipN = 0.00018F;
    return this;
  }
  
  public final c aMt()
  {
    AppMethodBeat.i(151352);
    this.ipO = Float.valueOf(0.36F);
    this.ipP = Float.valueOf(0.0F);
    AppMethodBeat.o(151352);
    return this;
  }
  
  public final c aMu()
  {
    AppMethodBeat.i(151353);
    aMw();
    aMx();
    D(this.ipq, 0L);
    aMy();
    AppMethodBeat.o(151353);
    return this;
  }
  
  public final void aMv()
  {
    AppMethodBeat.i(151354);
    if (this.rT != null) {
      this.rT.cancel();
    }
    this.ipm.aMv();
    AppMethodBeat.o(151354);
  }
  
  public final c al(float paramFloat)
  {
    this.ips = (paramFloat / 1000.0F);
    this.ipt = (1.0F / this.ips);
    return this;
  }
  
  public final c am(float paramFloat)
  {
    this.ipA = (paramFloat / 1000000.0F);
    this.ipB = 0.0F;
    return this;
  }
  
  public final c an(float paramFloat)
  {
    this.ipC = (paramFloat / 1000000.0F);
    this.ipD = 0.0F;
    return this;
  }
  
  public final c qy(long paramLong)
  {
    this.ipQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */