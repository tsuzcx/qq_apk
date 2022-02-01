package com.tencent.mm.cj;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  public static String bb(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(214440);
    paramContext = kt(paramContext).getString(paramInt);
    AppMethodBeat.o(214440);
    return paramContext;
  }
  
  public static Resources kt(Context paramContext)
  {
    AppMethodBeat.i(214443);
    if (paramContext != null) {}
    for (paramContext = paramContext.getResources(); (paramContext instanceof b); paramContext = null)
    {
      AppMethodBeat.o(214443);
      return paramContext;
    }
    paramContext = MMApplicationContext.getResources();
    AppMethodBeat.o(214443);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cj.e
 * JD-Core Version:    0.7.0.1
 */