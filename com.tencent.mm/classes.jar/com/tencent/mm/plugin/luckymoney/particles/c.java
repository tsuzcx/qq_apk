package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c
{
  ValueAnimator hsF;
  private Float lSA;
  private int lSB;
  private int lSC;
  private float lSD;
  private float lSE;
  private float lSF;
  private float lSG;
  private Float lSH;
  private Float lSI;
  private long lSJ;
  public float lSK;
  public float lSL;
  private final b lSc;
  private final d lSd;
  final ViewGroup lSe;
  final ConfettiView lSf;
  final Queue<com.tencent.mm.plugin.luckymoney.particles.a.b> lSg = new LinkedList();
  final List<com.tencent.mm.plugin.luckymoney.particles.a.b> lSh = new ArrayList(300);
  long lSi;
  int lSj;
  long lSk;
  float lSl;
  float lSm;
  public Interpolator lSn;
  private Rect lSo;
  private float lSp;
  private float lSq;
  private float lSr;
  private float lSs;
  private float lSt;
  private float lSu;
  private float lSv;
  private float lSw;
  private Float lSx;
  private Float lSy;
  private Float lSz;
  final Random random = new Random();
  
  public c(Context paramContext, b paramb, d paramd, ViewGroup paramViewGroup)
  {
    this(paramb, paramd, paramViewGroup, ConfettiView.dJ(paramContext));
  }
  
  private c(b paramb, d paramd, ViewGroup paramViewGroup, ConfettiView paramConfettiView)
  {
    this.lSc = paramb;
    this.lSd = paramd;
    this.lSe = paramViewGroup;
    this.lSf = paramConfettiView;
    this.lSf.lSh = this.lSh;
    this.lSf.addOnAttachStateChangeListener(new c.1(this));
    this.lSJ = -1L;
    this.lSo = new Rect(0, 0, paramViewGroup.getWidth(), paramViewGroup.getHeight());
  }
  
  private static float a(float paramFloat1, float paramFloat2, Random paramRandom)
  {
    return (paramRandom.nextFloat() * 2.0F - 1.0F) * paramFloat2 + paramFloat1;
  }
  
  final void E(int paramInt, long paramLong)
  {
    int i = 0;
    if (i < paramInt)
    {
      Object localObject2 = (com.tencent.mm.plugin.luckymoney.particles.a.b)this.lSg.poll();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.lSc.b(this.random);
      }
      localObject2 = this.lSd;
      Random localRandom = this.random;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSY = 0L;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTa = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSZ = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTc = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTb = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSv = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSt = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSz = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSx = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTe = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTd = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTf = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTg = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSF = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSH = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTh = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSJ = 0L;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTi = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTj = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSn = null;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTl = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTk = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTm = 0.0F;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).alpha = 255;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTn = false;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).terminated = false;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSY = paramLong;
      float f1 = localRandom.nextFloat();
      float f2 = ((d)localObject2).lSN;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSZ = (f1 * (((d)localObject2).lSP - ((d)localObject2).lSN) + f2);
      f1 = localRandom.nextFloat();
      f2 = ((d)localObject2).lSO;
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTa = ((((d)localObject2).lSQ - ((d)localObject2).lSO) * f1 + f2);
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTb = a(this.lSp, this.lSq, localRandom);
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTc = a(this.lSr, this.lSs, localRandom);
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSt = a(this.lSt, this.lSu, localRandom);
      ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSv = a(this.lSv, this.lSw, localRandom);
      if (this.lSx == null)
      {
        localObject2 = null;
        label381:
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSx = ((Float)localObject2);
        if (this.lSz != null) {
          break label571;
        }
        localObject2 = null;
        label398:
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSz = ((Float)localObject2);
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTf = a(this.lSB, this.lSC, localRandom);
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTg = a(this.lSD, this.lSE, localRandom);
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSF = a(this.lSF, this.lSG, localRandom);
        if (this.lSH != null) {
          break label598;
        }
      }
      label571:
      label598:
      for (localObject2 = null;; localObject2 = Float.valueOf(a(this.lSH.floatValue(), this.lSI.floatValue(), localRandom)))
      {
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSH = ((Float)localObject2);
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSJ = this.lSJ;
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lSn = this.lSn;
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).lTi = a(this.lSK, this.lSL, localRandom);
        ((com.tencent.mm.plugin.luckymoney.particles.a.b)localObject1).i(this.lSo);
        this.lSh.add(localObject1);
        i += 1;
        break;
        localObject2 = Float.valueOf(a(this.lSx.floatValue(), this.lSy.floatValue(), localRandom));
        break label381;
        localObject2 = Float.valueOf(a(this.lSz.floatValue(), this.lSA.floatValue(), localRandom));
        break label398;
      }
    }
  }
  
  public final c R(float paramFloat1, float paramFloat2)
  {
    this.lSp = (paramFloat1 / 1000.0F);
    this.lSq = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c S(float paramFloat1, float paramFloat2)
  {
    this.lSr = (paramFloat1 / 1000.0F);
    this.lSs = (paramFloat2 / 1000.0F);
    return this;
  }
  
  public final c at(float paramFloat)
  {
    this.lSt = (paramFloat / 1000000.0F);
    this.lSu = 0.0F;
    return this;
  }
  
  public final c au(float paramFloat)
  {
    this.lSv = (paramFloat / 1000000.0F);
    this.lSw = 0.0F;
    return this;
  }
  
  public final c bfP()
  {
    this.lSB = 180;
    this.lSC = 180;
    return this;
  }
  
  public final c bfQ()
  {
    this.lSF = 0.00036F;
    this.lSG = 0.00018F;
    return this;
  }
  
  public final c bfR()
  {
    this.lSH = Float.valueOf(0.36F);
    this.lSI = Float.valueOf(0.0F);
    return this;
  }
  
  public final void bfS()
  {
    if (this.hsF != null) {
      this.hsF.cancel();
    }
    this.lSf.bfS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.c
 * JD-Core Version:    0.7.0.1
 */