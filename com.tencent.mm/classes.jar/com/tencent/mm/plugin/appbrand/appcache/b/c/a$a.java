package com.tencent.mm.plugin.appbrand.appcache.b.c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a$a<_Key>
  extends SparseIntArray
{
  private int bc(_Key param_Key)
  {
    AppMethodBeat.i(129496);
    if (param_Key == null)
    {
      AppMethodBeat.o(129496);
      return -1;
    }
    int i = super.get(param_Key.hashCode(), -1);
    AppMethodBeat.o(129496);
    return i;
  }
  
  public final void d(_Key param_Key, int paramInt)
  {
    AppMethodBeat.i(129495);
    super.put(param_Key.hashCode(), paramInt);
    AppMethodBeat.o(129495);
  }
  
  public final int get(_Key param_Key)
  {
    AppMethodBeat.i(129497);
    int i = bc(param_Key);
    AppMethodBeat.o(129497);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.a.a
 * JD-Core Version:    0.7.0.1
 */