package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;

public final class m
{
  public static CharSequence J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(106935);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(2131759321, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(106935);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759321, new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
    AppMethodBeat.o(106935);
    return paramContext;
  }
  
  public static CharSequence h(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(106936);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(106936);
      return "";
    }
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(2131760859);
      AppMethodBeat.o(106936);
      return paramContext;
    }
    l = localGregorianCalendar2.getTimeInMillis() - paramLong;
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(2131760868);
      AppMethodBeat.o(106936);
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
      paramContext = DateFormat.format(paramContext.getString(2131759249), paramLong);
      AppMethodBeat.o(106936);
      return paramContext;
    }
    paramContext = paramContext.getResources().getQuantityString(2131623947, i, new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(106936);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.m
 * JD-Core Version:    0.7.0.1
 */