package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class r<T>
  extends c.a
{
  protected final List<T> iVE;
  protected final List<T> iVF;
  
  public r(List<T> paramList1, List<T> paramList2)
  {
    this.iVE = paramList1;
    this.iVF = paramList2;
  }
  
  public final int fv()
  {
    if (this.iVE == null) {
      return 0;
    }
    return this.iVE.size();
  }
  
  public final int fw()
  {
    if (this.iVF == null) {
      return 0;
    }
    return this.iVF.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.r
 * JD-Core Version:    0.7.0.1
 */