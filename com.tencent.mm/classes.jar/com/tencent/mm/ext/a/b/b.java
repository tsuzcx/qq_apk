package com.tencent.mm.ext.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static int dr(Context paramContext)
  {
    AppMethodBeat.i(235312);
    try
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      if (i != 0)
      {
        i = paramContext.getDimensionPixelSize(i);
        AppMethodBeat.o(235312);
        return i;
      }
      AppMethodBeat.o(235312);
      return 25;
    }
    catch (Resources.NotFoundException paramContext)
    {
      com.tencent.liteapp.b.b.e("MicroMsg.ResourceCompat", "get res of status_bar_height fail %s", new Object[] { paramContext.toString() });
      AppMethodBeat.o(235312);
    }
    return 25;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.a.b.b
 * JD-Core Version:    0.7.0.1
 */