package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public static u.a bWp;
  
  public static t AF()
  {
    AppMethodBeat.i(123960);
    t localt = bWp.AG();
    AppMethodBeat.o(123960);
    return localt;
  }
  
  public static SmileyPanel aW(Context paramContext)
  {
    AppMethodBeat.i(123958);
    paramContext = bWp.aX(paramContext);
    AppMethodBeat.o(123958);
    return paramContext;
  }
  
  public static SmileyPanel j(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(123959);
    paramContext = bWp.k(paramContext, paramBoolean);
    AppMethodBeat.o(123959);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.api.u
 * JD-Core Version:    0.7.0.1
 */