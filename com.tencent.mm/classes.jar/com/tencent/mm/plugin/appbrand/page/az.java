package com.tencent.mm.plugin.appbrand.page;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class az
  extends SparseIntArray
{
  final boolean v(ad paramad)
  {
    AppMethodBeat.i(325171);
    if (paramad == null)
    {
      AppMethodBeat.o(325171);
      return false;
    }
    if (super.indexOfKey(paramad.getComponentId()) >= 0)
    {
      AppMethodBeat.o(325171);
      return false;
    }
    super.put(paramad.getComponentId(), paramad.getComponentId());
    AppMethodBeat.o(325171);
    return true;
  }
  
  final boolean w(ad paramad)
  {
    AppMethodBeat.i(325173);
    if (paramad == null)
    {
      AppMethodBeat.o(325173);
      return false;
    }
    int i = super.indexOfKey(paramad.getComponentId());
    if (i >= 0)
    {
      super.removeAt(i);
      AppMethodBeat.o(325173);
      return true;
    }
    AppMethodBeat.o(325173);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.az
 * JD-Core Version:    0.7.0.1
 */