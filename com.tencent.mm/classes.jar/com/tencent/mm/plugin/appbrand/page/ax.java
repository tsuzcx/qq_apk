package com.tencent.mm.plugin.appbrand.page;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ax
  extends SparseIntArray
{
  final void u(ac paramac)
  {
    AppMethodBeat.i(219457);
    if (paramac == null)
    {
      AppMethodBeat.o(219457);
      return;
    }
    super.put(paramac.getComponentId(), paramac.getComponentId());
    AppMethodBeat.o(219457);
  }
  
  final boolean v(ac paramac)
  {
    AppMethodBeat.i(219458);
    if (paramac == null)
    {
      AppMethodBeat.o(219458);
      return false;
    }
    int i = super.indexOfKey(paramac.getComponentId());
    if (i >= 0)
    {
      super.removeAt(i);
      AppMethodBeat.o(219458);
      return true;
    }
    AppMethodBeat.o(219458);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax
 * JD-Core Version:    0.7.0.1
 */