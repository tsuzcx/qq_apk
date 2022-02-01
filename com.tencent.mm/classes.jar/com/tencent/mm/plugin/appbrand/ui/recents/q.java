package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class q<T>
  extends c.a
{
  protected final List<T> lJR;
  protected final List<T> lJS;
  
  public q(List<T> paramList1, List<T> paramList2)
  {
    this.lJR = paramList1;
    this.lJS = paramList2;
  }
  
  public final int gR()
  {
    if (this.lJR == null) {
      return 0;
    }
    return this.lJR.size();
  }
  
  public final int gS()
  {
    if (this.lJS == null) {
      return 0;
    }
    return this.lJS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */