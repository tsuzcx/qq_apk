package com.tencent.mm.particles;

import android.animation.ValueAnimator;
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
  private float emissionRate;
  private final b ggR;
  private final d ggS;
  private final ViewGroup ggT;
  final ConfettiView ggU;
  final Queue<com.tencent.mm.particles.a.b> ggV;
  final List<com.tencent.mm.particles.a.b> ggW;
  private ValueAnimator ggX;
  private long ggY;
  int ggZ;
  public float ghA;
  long gha;
  private float ghb;
  public Interpolator ghc;
  private Rect ghd;
  private float ghe;
  private float ghf;
  private float ghg;
  private float ghh;
  private float ghi;
  private float ghj;
  private float ghk;
  private float ghl;
  private Float ghm;
  private Float ghn;
  private Float gho;
  private Float ghp;
  private int ghq;
  private int ghr;
  private float ghs;
  private float ght;
  private float ghu;
  private float ghv;
  private Float ghw;
  private Float ghx;
  private long ghy;
  public float ghz;
  private final Random random;
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.cn(paramContext));
    AppMethodBeat.i(151575);
    AppMethodBeat.o(151575);
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    AppMethodBeat.i(151576);
    this.random = new Random();
    this.ggV = new LinkedList();
    this.ggW = new ArrayList(300);
    this.ggR = paramb;
    this.ggS = paramd;
    this.ggT = paramViewGroup;
    this.ggU = paramConfettiView;
    this.ggU.ggW = this.ggW;
    this.ggU.addOnAttachStateChangeListener(new c.1(this));
    this.ghy = -1L;
    this.ghd = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    AppMethodBeat.o(151576);
  }
  
  private void B(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151582);
    int i = 0;
    com.tencent.mm.particles.a.b localb;
    if (i < paramInt)
    {
      localb = (com.tencent.mm.particles.a.b)this.ggV.poll();
      if (localb != null) {
        break label90;
      }
      localb = this.ggR.a(this.random);
    }
    label90:
    for (;;)
    {
      a(localb, this.ggS, this.random, paramLong);
      this.ggW.add(localb);
      i += 1;
      break;
      AppMethodBeat.o(151582);
      return;
    }
  }
  
  private static float a(float paramFloat1, float paramFloat2, Random paramRandom)
  {
    AppMethodBeat.i(151585);
    float f = paramRandom.nextFloat();
    AppMethodBeat.o(151585);
    return (f * 2.0F - 1.0F) * paramFloat2 + paramFloat1;
  }
  
  private void a(com.tencent.mm.particles.a.b paramb, d paramd, Random paramRandom, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(151584);
    paramb.reset();
    paramb.ghN = paramLong;
    paramb.ghO = paramd.ak(paramRandom.nextFloat());
    paramb.ghP = paramd.al(paramRandom.nextFloat());
    paramb.ghQ = a(this.ghe, this.ghf, paramRandom);
    paramb.ghR = a(this.ghg, this.ghh, paramRandom);
    paramb.ghi = a(this.ghi, this.ghj, paramRandom);
    paramb.ghk = a(this.ghk, this.ghl, paramRandom);
    if (this.ghm == null)
    {
      paramd = null;
      paramb.ghm = paramd;
      if (this.gho != null) {
        break label270;
      }
      paramd = null;
      label129:
      paramb.gho = paramd;
      paramb.ghU = a(this.ghq, this.ghr, paramRandom);
      paramb.ghV = a(this.ghs, this.ght, paramRandom);
      paramb.ghu = a(this.ghu, this.ghv, paramRandom);
      if (this.ghw != null) {
        break label295;
      }
    }
    label270:
    label295:
    for (paramd = localObject;; paramd = Float.valueOf(a(this.ghw.floatValue(), this.ghx.floatValue(), paramRandom)))
    {
      paramb.ghw = paramd;
      paramb.ghy = this.ghy;
      paramb.ghc = this.ghc;
      paramb.ghX = a(this.ghz, this.ghA, paramRandom);
      paramb.j(this.ghd);
      AppMethodBeat.o(151584);
      return;
      paramd = Float.valueOf(a(this.ghm.floatValue(), this.ghn.floatValue(), paramRandom));
      break;
      paramd = Float.valueOf(a(this.gho.floatValue(), this.ghp.floatValue(), paramRandom));
      break label129;
    }
  }
  
  private void anX()
  {
    AppMethodBeat.i(151580);
    if (this.ggX != null) {
      this.ggX.cancel();
    }
    this.ggY = 0L;
    Iterator localIterator = this.ggW.iterator();
    while (localIterator.hasNext())
    {
      this.ggV.add(localIterator.next());
      localIterator.remove();
    }
    AppMethodBeat.o(151580);
  }
  
  private void anY()
  {
    AppMethodBeat.i(151581);
    ViewParent localViewParent = this.ggU.getParent();
    if (localViewParent != null)
    {
      if (localViewParent != this.ggT) {
        ((ViewGroup)localViewParent).removeView(this.ggU);
      }
    }
    else {
      this.ggT.addView(this.ggU);
    }
    this.ggU.terminated = false;
    AppMethodBeat.o(151581);
  }
  
  private void anZ()
  {
    AppMethodBeat.i(151583);
    this.ggX = ValueAnimator.ofInt(new int[] { 0 }).setDuration(9223372036854775807L);
    this.ggX.addUpdateListener(new c.2(this));
    this.ggX.start();
    AppMethodBeat.o(151583);
  }
  
  public final c H(float paramFloat1, float paramFloat2)
  {
    this.ghe = (paramFloat1 / 1000.0F);
    this.ghf = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c I(float paramFloat1, float paramFloat2)
  {
    this.ghg = (paramFloat1 / 1000.0F);
    this.ghh = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c ah(float paramFloat)
  {
    this.emissionRate = (paramFloat / 1000.0F);
    this.ghb = (1.0F / this.emissionRate);
    return this;
  }
  
  public final c ai(float paramFloat)
  {
    this.ghi = (paramFloat / 1000000.0F);
    this.ghj = 0.0F;
    return this;
  }
  
  public final c aj(float paramFloat)
  {
    this.ghk = (paramFloat / 1000000.0F);
    this.ghl = 0.0F;
    return this;
  }
  
  public final c anQ()
  {
    this.gha = 9223372036854775807L;
    return this;
  }
  
  public final c anR()
  {
    this.ghq = 180;
    this.ghr = 180;
    return this;
  }
  
  public final c anS()
  {
    this.ghu = 0.00036F;
    this.ghv = 0.00018F;
    return this;
  }
  
  public final c anT()
  {
    AppMethodBeat.i(151577);
    this.ghw = Float.valueOf(0.36F);
    this.ghx = Float.valueOf(0.0F);
    AppMethodBeat.o(151577);
    return this;
  }
  
  public final c anU()
  {
    this.ghy = 1500L;
    return this;
  }
  
  public final c anV()
  {
    AppMethodBeat.i(151578);
    anX();
    anY();
    B(this.ggZ, 0L);
    anZ();
    AppMethodBeat.o(151578);
    return this;
  }
  
  public final void anW()
  {
    AppMethodBeat.i(151579);
    if (this.ggX != null) {
      this.ggX.cancel();
    }
    this.ggU.anW();
    AppMethodBeat.o(151579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.particles.c
 * JD-Core Version:    0.7.0.1
 */