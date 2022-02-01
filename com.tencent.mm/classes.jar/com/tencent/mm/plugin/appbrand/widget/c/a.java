package com.tencent.mm.plugin.appbrand.widget.c;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int orp;
  private int orq;
  private int orr;
  private int ors;
  private int ort;
  private int oru;
  private int orv;
  private int orw;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.orp = Color.red(paramInt1);
    this.orq = Color.green(paramInt1);
    this.orr = Color.blue(paramInt1);
    this.ors = Color.alpha(paramInt1);
    this.ort = Color.red(paramInt2);
    this.oru = Color.green(paramInt2);
    this.orv = Color.blue(paramInt2);
    this.orw = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int aW(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.orp + ((this.ort - this.orp) * paramFloat + 0.5D));
    int j = (int)(this.orq + ((this.oru - this.orq) * paramFloat + 0.5D));
    int k = (int)(this.orr + ((this.orv - this.orr) * paramFloat + 0.5D));
    i = Color.argb((int)(this.ors + ((this.orw - this.ors) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.a
 * JD-Core Version:    0.7.0.1
 */