package com.tencent.mm.compatible.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
{
  public static int B(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(207444);
    try
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      if (i != 0)
      {
        i = paramContext.getDimensionPixelSize(i);
        AppMethodBeat.o(207444);
        return i;
      }
      AppMethodBeat.o(207444);
      return paramInt;
    }
    catch (Resources.NotFoundException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.ResourceCompat", paramContext, "get res of status_bar_height fail", new Object[0]);
      AppMethodBeat.o(207444);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.n
 * JD-Core Version:    0.7.0.1
 */