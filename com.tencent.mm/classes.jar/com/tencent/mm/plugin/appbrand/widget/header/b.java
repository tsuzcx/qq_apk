package com.tencent.mm.plugin.appbrand.widget.header;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int mBQ;
  private int mBR;
  private int mBS;
  private int mBT;
  private int mBU;
  private int mBV;
  private int mBW;
  private int mBX;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.mBQ = Color.red(paramInt1);
    this.mBR = Color.green(paramInt1);
    this.mBS = Color.blue(paramInt1);
    this.mBT = Color.alpha(paramInt1);
    this.mBU = Color.red(paramInt2);
    this.mBV = Color.green(paramInt2);
    this.mBW = Color.blue(paramInt2);
    this.mBX = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int aL(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.mBQ + ((this.mBU - this.mBQ) * paramFloat + 0.5D));
    int j = (int)(this.mBR + ((this.mBV - this.mBR) * paramFloat + 0.5D));
    int k = (int)(this.mBS + ((this.mBW - this.mBS) * paramFloat + 0.5D));
    i = Color.argb((int)(this.mBT + ((this.mBX - this.mBT) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.b
 * JD-Core Version:    0.7.0.1
 */