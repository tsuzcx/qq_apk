package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public static HashMap<Long, Long> kiU;
  public static HashMap<Long, String> kiV;
  private static Map<String, List<String>> nEa;
  private static Map<String, List<String>> nEb;
  
  static
  {
    AppMethodBeat.i(112292);
    nEa = new HashMap();
    nEb = new HashMap();
    kiU = new HashMap();
    kiV = new HashMap();
    AppMethodBeat.o(112292);
  }
  
  public static String h(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(112291);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(112291);
      return "";
    }
    long l1 = localGregorianCalendar.getTimeInMillis();
    if (kiU.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)kiU.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (kiV.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)kiV.get(Long.valueOf(paramLong));
          AppMethodBeat.o(112291);
          return paramContext;
        }
      }
      else {
        kiU.remove(Long.valueOf(paramLong));
      }
    }
    if ((l1 - paramLong) / 3600000L == 0L)
    {
      j = (int)((l1 - paramLong) / 60000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getQuantityString(2131361802, i, new Object[] { Integer.valueOf(i) });
      kiV.put(Long.valueOf(paramLong), paramContext);
      kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(112291);
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
      paramContext = paramContext.getResources().getQuantityString(2131361801, i, new Object[] { Integer.valueOf(i) });
      kiV.put(Long.valueOf(paramLong), paramContext);
      kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(112291);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131300084);
      kiV.put(Long.valueOf(paramLong), paramContext);
      kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(112291);
      return paramContext;
    }
    int j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    paramContext = paramContext.getResources().getQuantityString(2131361803, i, new Object[] { Integer.valueOf(i) });
    kiV.put(Long.valueOf(paramLong), paramContext);
    kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(112291);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.b
 * JD-Core Version:    0.7.0.1
 */