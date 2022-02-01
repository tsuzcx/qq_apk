package com.tencent.mm.plugin.appbrand.ui.recents;

import androidx.recyclerview.widget.h.a;
import java.util.List;

public abstract class q<T>
  extends h.a
{
  protected final List<T> rgi;
  protected final List<T> rgj;
  
  public q(List<T> paramList1, List<T> paramList2)
  {
    this.rgi = paramList1;
    this.rgj = paramList2;
  }
  
  public final int jL()
  {
    if (this.rgi == null) {
      return 0;
    }
    return this.rgi.size();
  }
  
  public final int jM()
  {
    if (this.rgj == null) {
      return 0;
    }
    return this.rgj.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */