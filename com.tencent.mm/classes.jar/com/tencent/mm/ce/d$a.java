package com.tencent.mm.ce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class d$a<E>
  extends ArrayList<E>
{
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(141212);
    Log.i("InterceptArrayList", "InterceptArrayList.add index object");
    AppMethodBeat.o(141212);
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(141211);
    Log.i("InterceptArrayList", "InterceptArrayList.add");
    AppMethodBeat.o(141211);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.d.a
 * JD-Core Version:    0.7.0.1
 */