package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.a;
import java.util.List;

public abstract class q<T>
  extends c.a
{
  protected final List<T> mMq;
  protected final List<T> mMr;
  
  public q(List<T> paramList1, List<T> paramList2)
  {
    this.mMq = paramList1;
    this.mMr = paramList2;
  }
  
  public final int aA()
  {
    if (this.mMr == null) {
      return 0;
    }
    return this.mMr.size();
  }
  
  public final int az()
  {
    if (this.mMq == null) {
      return 0;
    }
    return this.mMq.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */