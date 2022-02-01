package com.tencent.mm.compatible.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
{
  public static int D(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200825);
    try
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      if (i != 0)
      {
        i = paramContext.getDimensionPixelSize(i);
        AppMethodBeat.o(200825);
        return i;
      }
      AppMethodBeat.o(200825);
      return paramInt;
    }
    catch (Resources.NotFoundException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ResourceCompat", paramContext, "get res of status_bar_height fail", new Object[0]);
      AppMethodBeat.o(200825);
    }
    return paramInt;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(200824);
    int i = D(paramContext, 0);
    AppMethodBeat.o(200824);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.n
 * JD-Core Version:    0.7.0.1
 */