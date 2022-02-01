package com.tencent.mm.plugin.appbrand.widget.header;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int nhA;
  private int nhB;
  private int nhC;
  private int nhD;
  private int nhE;
  private int nhF;
  private int nhG;
  private int nhz;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.nhz = Color.red(paramInt1);
    this.nhA = Color.green(paramInt1);
    this.nhB = Color.blue(paramInt1);
    this.nhC = Color.alpha(paramInt1);
    this.nhD = Color.red(paramInt2);
    this.nhE = Color.green(paramInt2);
    this.nhF = Color.blue(paramInt2);
    this.nhG = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int aO(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.nhz + ((this.nhD - this.nhz) * paramFloat + 0.5D));
    int j = (int)(this.nhA + ((this.nhE - this.nhA) * paramFloat + 0.5D));
    int k = (int)(this.nhB + ((this.nhF - this.nhB) * paramFloat + 0.5D));
    i = Color.argb((int)(this.nhC + ((this.nhG - this.nhC) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.b
 * JD-Core Version:    0.7.0.1
 */