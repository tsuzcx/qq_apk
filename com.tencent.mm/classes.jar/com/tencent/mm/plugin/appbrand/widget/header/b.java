package com.tencent.mm.plugin.appbrand.widget.header;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int jkd;
  private int jke;
  private int jkf;
  private int jkg;
  private int jkh;
  private int jki;
  private int jkj;
  private int jkk;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139621);
    this.jkd = Color.red(paramInt1);
    this.jke = Color.green(paramInt1);
    this.jkf = Color.blue(paramInt1);
    this.jkg = Color.alpha(paramInt1);
    this.jkh = Color.red(paramInt2);
    this.jki = Color.green(paramInt2);
    this.jkj = Color.blue(paramInt2);
    this.jkk = Color.alpha(paramInt2);
    AppMethodBeat.o(139621);
  }
  
  public final int aE(float paramFloat)
  {
    AppMethodBeat.i(139622);
    int i = (int)(this.jkd + ((this.jkh - this.jkd) * paramFloat + 0.5D));
    int j = (int)(this.jke + ((this.jki - this.jke) * paramFloat + 0.5D));
    int k = (int)(this.jkf + ((this.jkj - this.jkf) * paramFloat + 0.5D));
    i = Color.argb((int)(this.jkg + ((this.jkk - this.jkg) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(139622);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.b
 * JD-Core Version:    0.7.0.1
 */