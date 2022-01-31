package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.g.c.a;
import java.util.List;

public abstract class r<T>
  extends c.a
{
  public final List<T> hjX;
  public final List<T> hjY;
  
  public r(List<T> paramList1, List<T> paramList2)
  {
    this.hjX = paramList1;
    this.hjY = paramList2;
  }
  
  public final int eI()
  {
    if (this.hjX == null) {
      return 0;
    }
    return this.hjX.size();
  }
  
  public final int eJ()
  {
    if (this.hjY == null) {
      return 0;
    }
    return this.hjY.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.r
 * JD-Core Version:    0.7.0.1
 */