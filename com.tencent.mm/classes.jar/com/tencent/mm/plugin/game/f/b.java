package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.game.g.g;
import com.tencent.mm.plugin.game.g.i;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public static HashMap<Long, Long> iiU = new HashMap();
  public static HashMap<Long, String> iiV = new HashMap();
  private static Map<String, List<String>> lgf = new HashMap();
  private static Map<String, List<String>> lgg = new HashMap();
  
  public static String g(Context paramContext, long paramLong)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L) {
      return "";
    }
    long l1 = localGregorianCalendar.getTimeInMillis();
    if (iiU.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)iiU.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (iiV.containsKey(Long.valueOf(paramLong))) {
          return (String)iiV.get(Long.valueOf(paramLong));
        }
      }
      else {
        iiU.remove(Long.valueOf(paramLong));
      }
    }
    if ((l1 - paramLong) / 3600000L == 0L)
    {
      j = (int)((l1 - paramLong) / 60000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getQuantityString(g.g.fmt_in60min, i, new Object[] { Integer.valueOf(i) });
      iiV.put(Long.valueOf(paramLong), paramContext);
      iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      return paramContext;
    }
    localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
    long l2 = paramLong - localGregorianCalendar.getTimeInMillis();
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      j = (int)((l1 - paramLong) / 3600000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getQuantityString(g.g.fmt_in24h, i, new Object[] { Integer.valueOf(i) });
      iiV.put(Long.valueOf(paramLong), paramContext);
      iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(g.i.fmt_pre_yesterday);
      iiV.put(Long.valueOf(paramLong), paramContext);
      iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      return paramContext;
    }
    int j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    paramContext = paramContext.getResources().getQuantityString(g.g.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
    iiV.put(Long.valueOf(paramLong), paramContext);
    iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.b
 * JD-Core Version:    0.7.0.1
 */