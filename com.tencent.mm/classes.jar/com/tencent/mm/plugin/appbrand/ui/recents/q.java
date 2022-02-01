package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class q<T>
  extends c.a
{
  protected final List<T> mlO;
  protected final List<T> mlP;
  
  public q(List<T> paramList1, List<T> paramList2)
  {
    this.mlO = paramList1;
    this.mlP = paramList2;
  }
  
  public final int gZ()
  {
    if (this.mlO == null) {
      return 0;
    }
    return this.mlO.size();
  }
  
  public final int ha()
  {
    if (this.mlP == null) {
      return 0;
    }
    return this.mlP.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */