package com.tencent.mm.danmaku.c;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  private static boolean gPM = true;
  public static int gPS = 16;
  public int atU;
  public int gOF;
  public float gOR;
  public boolean gOS;
  public int gPH;
  public int gPI;
  public int gPJ;
  public float gPK;
  public boolean gPL;
  public float gPN;
  public float gPO;
  public float gPP;
  public float gPQ;
  private boolean gPR;
  public int mScreenHeight;
  public int mScreenWidth;
  
  public m()
  {
    AppMethodBeat.i(241693);
    this.gPL = true;
    this.gPR = false;
    DisplayMetrics localDisplayMetrics = com.tencent.mm.danmaku.a.c.arU().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    if (this.gPR) {
      this.mScreenHeight = Math.max(i, j);
    }
    for (this.mScreenWidth = Math.min(i, j);; this.mScreenWidth = Math.max(i, j))
    {
      this.atU = 8000;
      pa(12);
      this.gOF = 3;
      am(1.5F);
      this.gPJ = com.tencent.mm.danmaku.e.c.ao(1.0F);
      this.gPK = com.tencent.mm.danmaku.e.c.ao(5.0F);
      this.gOR = com.tencent.mm.danmaku.e.c.ao(5.0F);
      this.gPL = true;
      this.gOS = true;
      this.gPN = com.tencent.mm.danmaku.e.c.ao(16.0F);
      this.gPO = 0.0F;
      an(5.0F);
      this.gPQ = com.tencent.mm.danmaku.e.c.ao(4.0F);
      AppMethodBeat.o(241693);
      return;
      this.mScreenHeight = Math.min(i, j);
    }
  }
  
  public static void asX()
  {
    gPM = false;
  }
  
  public static boolean asY()
  {
    return gPM;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(241695);
    this.gPI = com.tencent.mm.danmaku.e.c.ao(paramFloat);
    AppMethodBeat.o(241695);
  }
  
  public final void an(float paramFloat)
  {
    AppMethodBeat.i(241696);
    this.gPP = com.tencent.mm.danmaku.e.c.ao(paramFloat);
    AppMethodBeat.o(241696);
  }
  
  public final void asZ()
  {
    this.gOF = 2;
  }
  
  public final void ata()
  {
    this.atU = 6000;
  }
  
  public final void atb()
  {
    this.gPL = true;
  }
  
  public final void pa(int paramInt)
  {
    AppMethodBeat.i(241694);
    this.gPH = com.tencent.mm.danmaku.e.c.ao(paramInt);
    AppMethodBeat.o(241694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.c.m
 * JD-Core Version:    0.7.0.1
 */