package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
{
  public static String L(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(74184);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(2131299855, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(74184);
      return paramContext;
    }
    int i = paramInt / 60;
    paramInt %= 60;
    if (i == 0)
    {
      paramContext = paramContext.getString(2131299855, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(74184);
      return paramContext;
    }
    paramContext = paramContext.getString(2131299854, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    AppMethodBeat.o(74184);
    return paramContext;
  }
  
  public static String M(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(74186);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(74186);
    return paramContext;
  }
  
  public static boolean Ob(String paramString)
  {
    AppMethodBeat.i(74185);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(74185);
      return false;
    }
    if (!paramString.equals(ah.getContext().getResources().getString(2131301115)))
    {
      AppMethodBeat.o(74185);
      return true;
    }
    AppMethodBeat.o(74185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */