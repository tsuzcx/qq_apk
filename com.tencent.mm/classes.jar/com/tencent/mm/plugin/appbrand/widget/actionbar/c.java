package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  HashSet<View.OnClickListener> mtt;
  HashSet<View.OnClickListener> mtu;
  
  public c()
  {
    AppMethodBeat.i(135442);
    this.mtt = new HashSet();
    this.mtu = new HashSet();
    AppMethodBeat.o(135442);
  }
  
  public final boolean cS(View paramView)
  {
    AppMethodBeat.i(135443);
    if (this.mtu.isEmpty())
    {
      AppMethodBeat.o(135443);
      return false;
    }
    Iterator localIterator = this.mtu.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    AppMethodBeat.o(135443);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.c
 * JD-Core Version:    0.7.0.1
 */