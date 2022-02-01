package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class q<T>
  extends c.a
{
  protected final List<T> oew;
  protected final List<T> oex;
  
  public q(List<T> paramList1, List<T> paramList2)
  {
    this.oew = paramList1;
    this.oex = paramList2;
  }
  
  public final int aB()
  {
    if (this.oew == null) {
      return 0;
    }
    return this.oew.size();
  }
  
  public final int aC()
  {
    if (this.oex == null) {
      return 0;
    }
    return this.oex.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */