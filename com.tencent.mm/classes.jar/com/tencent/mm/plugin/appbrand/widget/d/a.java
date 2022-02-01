package com.tencent.mm.plugin.appbrand.widget.d;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int rtA;
  private int rtB;
  private int rtC;
  private int rtD;
  private int rtE;
  private int rtF;
  private int rty;
  private int rtz;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.rty = Color.red(paramInt1);
    this.rtz = Color.green(paramInt1);
    this.rtA = Color.blue(paramInt1);
    this.rtB = Color.alpha(paramInt1);
    this.rtC = Color.red(paramInt2);
    this.rtD = Color.green(paramInt2);
    this.rtE = Color.blue(paramInt2);
    this.rtF = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int aY(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.rty + ((this.rtC - this.rty) * paramFloat + 0.5D));
    int j = (int)(this.rtz + ((this.rtD - this.rtz) * paramFloat + 0.5D));
    int k = (int)(this.rtA + ((this.rtE - this.rtA) * paramFloat + 0.5D));
    i = Color.argb((int)(this.rtB + ((this.rtF - this.rtB) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a
 * JD-Core Version:    0.7.0.1
 */