package com.tencent.mm.danmaku.c;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  private static boolean jAf = true;
  public static int jAl = 16;
  public int alM;
  public int jAa;
  public int jAb;
  public int jAc;
  public float jAd;
  public boolean jAe;
  public float jAg;
  public float jAh;
  public float jAi;
  public float jAj;
  private boolean jAk;
  public int jyZ;
  public float jzl;
  public boolean jzm;
  public int mScreenHeight;
  public int mScreenWidth;
  
  public m()
  {
    AppMethodBeat.i(278775);
    this.jAe = true;
    this.jAk = false;
    DisplayMetrics localDisplayMetrics = com.tencent.mm.danmaku.a.c.ayF().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    if (this.jAk) {
      this.mScreenHeight = Math.max(i, j);
    }
    for (this.mScreenWidth = Math.min(i, j);; this.mScreenWidth = Math.max(i, j))
    {
      this.alM = 8000;
      rv(12);
      this.jyZ = 3;
      al(1.5F);
      this.jAc = com.tencent.mm.danmaku.e.c.an(1.0F);
      this.jAd = com.tencent.mm.danmaku.e.c.an(5.0F);
      this.jzl = com.tencent.mm.danmaku.e.c.an(5.0F);
      this.jAe = true;
      this.jzm = true;
      this.jAg = com.tencent.mm.danmaku.e.c.an(16.0F);
      this.jAh = 0.0F;
      am(5.0F);
      this.jAj = com.tencent.mm.danmaku.e.c.an(4.0F);
      AppMethodBeat.o(278775);
      return;
      this.mScreenHeight = Math.min(i, j);
    }
  }
  
  public static void azL()
  {
    jAf = false;
  }
  
  public static boolean azM()
  {
    return jAf;
  }
  
  public final void al(float paramFloat)
  {
    AppMethodBeat.i(278777);
    this.jAb = com.tencent.mm.danmaku.e.c.an(paramFloat);
    AppMethodBeat.o(278777);
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(278779);
    this.jAi = com.tencent.mm.danmaku.e.c.an(paramFloat);
    AppMethodBeat.o(278779);
  }
  
  public final void azN()
  {
    this.jyZ = 2;
  }
  
  public final void azO()
  {
    this.jAe = true;
  }
  
  public final void rv(int paramInt)
  {
    AppMethodBeat.i(278776);
    this.jAa = com.tencent.mm.danmaku.e.c.an(paramInt);
    AppMethodBeat.o(278776);
  }
  
  public final void setDuration(int paramInt)
  {
    this.alM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.c.m
 * JD-Core Version:    0.7.0.1
 */