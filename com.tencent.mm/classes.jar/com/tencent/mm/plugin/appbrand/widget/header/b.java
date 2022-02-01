package com.tencent.mm.plugin.appbrand.widget.header;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int lZP;
  private int lZQ;
  private int lZR;
  private int lZS;
  private int lZT;
  private int lZU;
  private int lZV;
  private int lZW;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.lZP = Color.red(paramInt1);
    this.lZQ = Color.green(paramInt1);
    this.lZR = Color.blue(paramInt1);
    this.lZS = Color.alpha(paramInt1);
    this.lZT = Color.red(paramInt2);
    this.lZU = Color.green(paramInt2);
    this.lZV = Color.blue(paramInt2);
    this.lZW = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int aH(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.lZP + ((this.lZT - this.lZP) * paramFloat + 0.5D));
    int j = (int)(this.lZQ + ((this.lZU - this.lZQ) * paramFloat + 0.5D));
    int k = (int)(this.lZR + ((this.lZV - this.lZR) * paramFloat + 0.5D));
    i = Color.argb((int)(this.lZS + ((this.lZW - this.lZS) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.b
 * JD-Core Version:    0.7.0.1
 */