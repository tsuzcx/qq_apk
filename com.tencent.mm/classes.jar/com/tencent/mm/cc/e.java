package com.tencent.mm.cc;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  public static String aJ(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205093);
    paramContext = jp(paramContext).getString(paramInt);
    AppMethodBeat.o(205093);
    return paramContext;
  }
  
  public static Resources jp(Context paramContext)
  {
    AppMethodBeat.i(205094);
    if (paramContext != null) {}
    for (paramContext = paramContext.getResources(); (paramContext instanceof b); paramContext = null)
    {
      AppMethodBeat.o(205094);
      return paramContext;
    }
    paramContext = MMApplicationContext.getResources();
    AppMethodBeat.o(205094);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.e
 * JD-Core Version:    0.7.0.1
 */