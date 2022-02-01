package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  HashSet<View.OnClickListener> mTZ;
  HashSet<View.OnClickListener> mUa;
  
  public c()
  {
    AppMethodBeat.i(135442);
    this.mTZ = new HashSet();
    this.mUa = new HashSet();
    AppMethodBeat.o(135442);
  }
  
  public final boolean cU(View paramView)
  {
    AppMethodBeat.i(135443);
    if (this.mUa.isEmpty())
    {
      AppMethodBeat.o(135443);
      return false;
    }
    Iterator localIterator = this.mUa.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    AppMethodBeat.o(135443);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.c
 * JD-Core Version:    0.7.0.1
 */