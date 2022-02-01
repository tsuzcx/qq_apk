package com.tencent.mm.plugin.appbrand.page;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class az
  extends SparseIntArray
{
  final void u(ad paramad)
  {
    AppMethodBeat.i(245702);
    if (paramad == null)
    {
      AppMethodBeat.o(245702);
      return;
    }
    super.put(paramad.getComponentId(), paramad.getComponentId());
    AppMethodBeat.o(245702);
  }
  
  final boolean v(ad paramad)
  {
    AppMethodBeat.i(245703);
    if (paramad == null)
    {
      AppMethodBeat.o(245703);
      return false;
    }
    int i = super.indexOfKey(paramad.getComponentId());
    if (i >= 0)
    {
      super.removeAt(i);
      AppMethodBeat.o(245703);
      return true;
    }
    AppMethodBeat.o(245703);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.az
 * JD-Core Version:    0.7.0.1
 */