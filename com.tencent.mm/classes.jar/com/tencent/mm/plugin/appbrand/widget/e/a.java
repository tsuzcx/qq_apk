package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int uED;
  private int uEE;
  private int uEF;
  private int uEG;
  private int uEH;
  private int uEI;
  private int uEJ;
  private int uEK;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.uED = Color.red(paramInt1);
    this.uEE = Color.green(paramInt1);
    this.uEF = Color.blue(paramInt1);
    this.uEG = Color.alpha(paramInt1);
    this.uEH = Color.red(paramInt2);
    this.uEI = Color.green(paramInt2);
    this.uEJ = Color.blue(paramInt2);
    this.uEK = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int ca(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.uED + ((this.uEH - this.uED) * paramFloat + 0.5D));
    int j = (int)(this.uEE + ((this.uEI - this.uEE) * paramFloat + 0.5D));
    int k = (int)(this.uEF + ((this.uEJ - this.uEF) * paramFloat + 0.5D));
    i = Color.argb((int)(this.uEG + ((this.uEK - this.uEG) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a
 * JD-Core Version:    0.7.0.1
 */