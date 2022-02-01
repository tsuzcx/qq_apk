package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
{
  public static String N(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106957);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(2131759032, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(106957);
      return paramContext;
    }
    int i = paramInt / 60;
    paramInt %= 60;
    if (i == 0)
    {
      paramContext = paramContext.getString(2131759032, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(106957);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759031, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    AppMethodBeat.o(106957);
    return paramContext;
  }
  
  public static String O(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106959);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(106959);
    return paramContext;
  }
  
  public static boolean YB(String paramString)
  {
    AppMethodBeat.i(106958);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106958);
      return false;
    }
    if (!paramString.equals(aj.getContext().getResources().getString(2131760739)))
    {
      AppMethodBeat.o(106958);
      return true;
    }
    AppMethodBeat.o(106958);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.n
 * JD-Core Version:    0.7.0.1
 */