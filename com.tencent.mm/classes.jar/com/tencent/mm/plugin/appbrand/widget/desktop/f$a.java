package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$a
{
  public RecyclerView.v acD;
  public RecyclerView.v acE;
  public int acF;
  public int acG;
  public int acH;
  public int acI;
  public boolean jfU = false;
  
  private f$a(RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    this.acD = paramv1;
    this.acE = paramv2;
  }
  
  f$a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramv1, paramv2);
    this.acF = paramInt1;
    this.acG = paramInt2;
    this.acH = paramInt3;
    this.acI = paramInt4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133914);
    String str = "ChangeInfo{oldHolder=" + this.acD + ", newHolder=" + this.acE + ", fromX=" + this.acF + ", fromY=" + this.acG + ", toX=" + this.acH + ", toY=" + this.acI + '}';
    AppMethodBeat.o(133914);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f.a
 * JD-Core Version:    0.7.0.1
 */