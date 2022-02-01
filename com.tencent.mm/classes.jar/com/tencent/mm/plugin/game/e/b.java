package com.tencent.mm.plugin.game.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public static HashMap<Long, Long> pMp;
  public static HashMap<Long, String> pMq;
  private static Map<String, List<String>> vVB;
  private static Map<String, List<String>> vVC;
  
  static
  {
    AppMethodBeat.i(42491);
    vVB = new HashMap();
    vVC = new HashMap();
    pMp = new HashMap();
    pMq = new HashMap();
    AppMethodBeat.o(42491);
  }
  
  public static String n(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(42490);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(42490);
      return "";
    }
    long l1 = localGregorianCalendar.getTimeInMillis();
    if (pMp.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)pMp.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (pMq.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)pMq.get(Long.valueOf(paramLong));
          AppMethodBeat.o(42490);
          return paramContext;
        }
      }
      else {
        pMp.remove(Long.valueOf(paramLong));
      }
    }
    if (l1 - paramLong < 60000L)
    {
      paramContext = paramContext.getString(2131761230);
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
      paramContext = paramContext.getResources().getQuantityString(2131623946, i, new Object[] { Integer.valueOf(i) });
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
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
      paramContext = paramContext.getResources().getQuantityString(2131623945, i, new Object[] { Integer.valueOf(i) });
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131760868);
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
      return paramContext;
    }
    int j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    paramContext = paramContext.getResources().getQuantityString(2131623947, i, new Object[] { Integer.valueOf(i) });
    pMq.put(Long.valueOf(paramLong), paramContext);
    pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(42490);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e.b
 * JD-Core Version:    0.7.0.1
 */