package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  HashSet<View.OnClickListener> hoM = new HashSet();
  private HashSet<View.OnClickListener> hoN = new HashSet();
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.hoN.add(paramOnClickListener);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    this.hoM.add(paramOnClickListener);
  }
  
  public final boolean cb(View paramView)
  {
    if (this.hoN.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.hoN.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */