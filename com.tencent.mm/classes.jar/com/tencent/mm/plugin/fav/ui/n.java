package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
{
  public static boolean aAs(String paramString)
  {
    AppMethodBeat.i(106958);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(106958);
      return false;
    }
    if (!paramString.equals(MMApplicationContext.getContext().getResources().getString(s.i.location_sub_title_location_with_bracket)))
    {
      AppMethodBeat.o(106958);
      return true;
    }
    AppMethodBeat.o(106958);
    return false;
  }
  
  public static String ab(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106957);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(s.i.favorite_voice_length, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(106957);
      return paramContext;
    }
    int i = paramInt / 60;
    paramInt %= 60;
    if (i == 0)
    {
      paramContext = paramContext.getString(s.i.favorite_voice_length, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(106957);
      return paramContext;
    }
    paramContext = paramContext.getString(s.i.favorite_video_length, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    AppMethodBeat.o(106957);
    return paramContext;
  }
  
  public static String ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106959);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(106959);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.n
 * JD-Core Version:    0.7.0.1
 */