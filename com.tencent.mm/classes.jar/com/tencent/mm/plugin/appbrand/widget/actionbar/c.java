package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  HashSet<View.OnClickListener> jbv;
  HashSet<View.OnClickListener> jbw;
  
  public c()
  {
    AppMethodBeat.i(87482);
    this.jbv = new HashSet();
    this.jbw = new HashSet();
    AppMethodBeat.o(87482);
  }
  
  public final boolean cE(View paramView)
  {
    AppMethodBeat.i(87483);
    if (this.jbw.isEmpty())
    {
      AppMethodBeat.o(87483);
      return false;
    }
    Iterator localIterator = this.jbw.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    AppMethodBeat.o(87483);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.c
 * JD-Core Version:    0.7.0.1
 */