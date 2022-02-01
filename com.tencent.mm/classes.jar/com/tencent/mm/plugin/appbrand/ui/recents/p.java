package com.tencent.mm.plugin.appbrand.ui.recents;

import androidx.recyclerview.widget.g.a;
import java.util.List;

public abstract class p<T>
  extends g.a
{
  protected final List<T> uoj;
  protected final List<T> uok;
  
  public p(List<T> paramList1, List<T> paramList2)
  {
    this.uoj = paramList1;
    this.uok = paramList2;
  }
  
  public final int If()
  {
    if (this.uoj == null) {
      return 0;
    }
    return this.uoj.size();
  }
  
  public final int Ig()
  {
    if (this.uok == null) {
      return 0;
    }
    return this.uok.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */