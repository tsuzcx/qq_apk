package com.tencent.mm.plugin.appbrand.widget.header;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int ncq;
  private int ncr;
  private int ncs;
  private int nct;
  private int ncu;
  private int ncv;
  private int ncw;
  private int ncx;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153229);
    this.ncq = Color.red(paramInt1);
    this.ncr = Color.green(paramInt1);
    this.ncs = Color.blue(paramInt1);
    this.nct = Color.alpha(paramInt1);
    this.ncu = Color.red(paramInt2);
    this.ncv = Color.green(paramInt2);
    this.ncw = Color.blue(paramInt2);
    this.ncx = Color.alpha(paramInt2);
    AppMethodBeat.o(153229);
  }
  
  public final int aO(float paramFloat)
  {
    AppMethodBeat.i(153230);
    int i = (int)(this.ncq + ((this.ncu - this.ncq) * paramFloat + 0.5D));
    int j = (int)(this.ncr + ((this.ncv - this.ncr) * paramFloat + 0.5D));
    int k = (int)(this.ncs + ((this.ncw - this.ncs) * paramFloat + 0.5D));
    i = Color.argb((int)(this.nct + ((this.ncx - this.nct) * paramFloat + 0.5D)), i, j, k);
    AppMethodBeat.o(153230);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.b
 * JD-Core Version:    0.7.0.1
 */