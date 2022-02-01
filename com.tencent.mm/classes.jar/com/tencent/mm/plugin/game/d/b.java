package com.tencent.mm.plugin.game.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.g;
import com.tencent.mm.plugin.game.g.i;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static Map<String, List<String>> ADv;
  private static Map<String, List<String>> ADw;
  public static HashMap<Long, Long> sTn;
  public static HashMap<Long, String> sTo;
  
  static
  {
    AppMethodBeat.i(42491);
    ADv = new HashMap();
    ADw = new HashMap();
    sTn = new HashMap();
    sTo = new HashMap();
    AppMethodBeat.o(42491);
  }
  
  public static String p(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(42490);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(42490);
      return "";
    }
    long l1 = localGregorianCalendar.getTimeInMillis();
    if (sTn.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)sTn.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (sTo.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)sTo.get(Long.valueOf(paramLong));
          AppMethodBeat.o(42490);
          return paramContext;
        }
      }
      else {
        sTn.remove(Long.valueOf(paramLong));
      }
    }
    if (l1 - paramLong < 60000L)
    {
      paramContext = paramContext.getString(g.i.CoW);
      AppMethodBeat.o(42490);
      return paramContext;
    }
    if ((l1 - paramLong) / 3600000L == 0L)
    {
      j = (int)((l1 - paramLong) / 60000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getQuantityString(g.g.fmt_in60min, i, new Object[] { Integer.valueOf(i) });
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
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
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(g.i.fmt_pre_yesterday);
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
      return paramContext;
    }
    int j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    paramContext = paramContext.getResources().getQuantityString(g.g.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
    sTo.put(Long.valueOf(paramLong), paramContext);
    sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(42490);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.b
 * JD-Core Version:    0.7.0.1
 */