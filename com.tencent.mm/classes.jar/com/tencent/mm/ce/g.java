package com.tencent.mm.ce;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g
{
  public static String bu(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(232991);
    paramContext = mv(paramContext).getString(paramInt);
    AppMethodBeat.o(232991);
    return paramContext;
  }
  
  public static Resources mv(Context paramContext)
  {
    AppMethodBeat.i(233003);
    if (paramContext != null) {}
    for (paramContext = paramContext.getResources(); (paramContext instanceof d); paramContext = null)
    {
      AppMethodBeat.o(233003);
      return paramContext;
    }
    paramContext = MMApplicationContext.getResources();
    AppMethodBeat.o(233003);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.g
 * JD-Core Version:    0.7.0.1
 */