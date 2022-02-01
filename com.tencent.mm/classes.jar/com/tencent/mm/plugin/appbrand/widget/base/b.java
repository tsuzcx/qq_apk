package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class b
  implements Iterator<View>
{
  private final ViewGroup fSZ;
  private int fnF = 0;
  
  public b(ViewGroup paramViewGroup)
  {
    this.fSZ = paramViewGroup;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(131470);
    if (this.fnF < this.fSZ.getChildCount())
    {
      AppMethodBeat.o(131470);
      return true;
    }
    AppMethodBeat.o(131470);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(131471);
    this.fSZ.removeViewAt(this.fnF - 1);
    AppMethodBeat.o(131471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.b
 * JD-Core Version:    0.7.0.1
 */