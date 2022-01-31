package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.f.a;
import java.util.Iterator;
import java.util.Set;

final class o$1
  implements RecyclerView.f.a
{
  o$1(o paramo) {}
  
  public final void hQ()
  {
    Iterator localIterator = this.hjP.hjy.iterator();
    while (localIterator.hasNext()) {
      ((RecyclerView.f.a)localIterator.next()).hQ();
    }
    this.hjP.hjO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.1
 * JD-Core Version:    0.7.0.1
 */