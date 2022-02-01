package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class q<T>
  extends c.a
{
  protected final List<T> mRt;
  protected final List<T> mRu;
  
  public q(List<T> paramList1, List<T> paramList2)
  {
    this.mRt = paramList1;
    this.mRu = paramList2;
  }
  
  public final int aA()
  {
    if (this.mRu == null) {
      return 0;
    }
    return this.mRu.size();
  }
  
  public final int az()
  {
    if (this.mRt == null) {
      return 0;
    }
    return this.mRt.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */