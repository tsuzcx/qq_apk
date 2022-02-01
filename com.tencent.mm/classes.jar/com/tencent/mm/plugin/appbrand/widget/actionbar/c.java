package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  HashSet<View.OnClickListener> lRq;
  HashSet<View.OnClickListener> lRr;
  
  public c()
  {
    AppMethodBeat.i(135442);
    this.lRq = new HashSet();
    this.lRr = new HashSet();
    AppMethodBeat.o(135442);
  }
  
  public final boolean cQ(View paramView)
  {
    AppMethodBeat.i(135443);
    if (this.lRr.isEmpty())
    {
      AppMethodBeat.o(135443);
      return false;
    }
    Iterator localIterator = this.lRr.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    AppMethodBeat.o(135443);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.c
 * JD-Core Version:    0.7.0.1
 */