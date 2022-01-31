package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import java.util.GregorianCalendar;

public final class j
{
  public static CharSequence f(Context paramContext, long paramLong)
  {
    if (paramLong < 3600000L) {
      return "";
    }
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L)) {
      return paramContext.getString(n.i.fmt_pre_nowday);
    }
    l = localGregorianCalendar2.getTimeInMillis() - paramLong;
    if ((l > 0L) && (l <= 86400000L)) {
      return paramContext.getString(n.i.fmt_pre_yesterday);
    }
    new GregorianCalendar().setTimeInMillis(paramLong);
    int j = (int)((localGregorianCalendar1.getTimeInMillis() - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    if (i > 30) {
      return DateFormat.format(paramContext.getString(n.i.favorite_longdate), paramLong);
    }
    return paramContext.getResources().getQuantityString(n.g.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
  }
  
  public static CharSequence x(Context paramContext, int paramInt)
  {
    if (paramInt <= 0) {
      return paramContext.getString(n.i.favorite_second_format, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    }
    int i = paramInt / 60;
    return paramContext.getString(n.i.favorite_second_format, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.j
 * JD-Core Version:    0.7.0.1
 */