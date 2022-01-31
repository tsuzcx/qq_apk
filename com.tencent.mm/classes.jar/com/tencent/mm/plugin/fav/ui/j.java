package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;

public final class j
{
  public static CharSequence C(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(74163);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(2131299821, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(74163);
      return paramContext;
    }
    paramContext = paramContext.getString(2131299821, new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
    AppMethodBeat.o(74163);
    return paramContext;
  }
  
  public static CharSequence g(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(74164);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(74164);
      return "";
    }
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(2131300075);
      AppMethodBeat.o(74164);
      return paramContext;
    }
    l = localGregorianCalendar2.getTimeInMillis() - paramLong;
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(2131300084);
      AppMethodBeat.o(74164);
      return paramContext;
    }
    new GregorianCalendar().setTimeInMillis(paramLong);
    int j = (int)((localGregorianCalendar1.getTimeInMillis() - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    if (i > 30)
    {
      paramContext = DateFormat.format(paramContext.getString(2131299753), paramLong);
      AppMethodBeat.o(74164);
      return paramContext;
    }
    paramContext = paramContext.getResources().getQuantityString(2131361803, i, new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(74164);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.j
 * JD-Core Version:    0.7.0.1
 */