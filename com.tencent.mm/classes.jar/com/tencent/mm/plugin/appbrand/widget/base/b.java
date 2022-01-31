package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class b
  implements Iterator<View>
{
  private int counter = 0;
  private final ViewGroup eyt;
  
  public b(ViewGroup paramViewGroup)
  {
    this.eyt = paramViewGroup;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(77397);
    if (this.counter < this.eyt.getChildCount())
    {
      AppMethodBeat.o(77397);
      return true;
    }
    AppMethodBeat.o(77397);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(77398);
    this.eyt.removeViewAt(this.counter - 1);
    AppMethodBeat.o(77398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.b
 * JD-Core Version:    0.7.0.1
 */