package com.tencent.mm.plugin.game.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.g;
import com.tencent.mm.plugin.game.h.i;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static Map<String, List<String>> GgG;
  private static Map<String, List<String>> GgH;
  public static HashMap<Long, Long> vYD;
  public static HashMap<Long, String> vYE;
  
  static
  {
    AppMethodBeat.i(42491);
    GgG = new HashMap();
    GgH = new HashMap();
    vYD = new HashMap();
    vYE = new HashMap();
    AppMethodBeat.o(42491);
  }
  
  public static String r(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(42490);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(42490);
      return "";
    }
    long l1 = localGregorianCalendar.getTimeInMillis();
    if (vYD.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)vYD.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (vYE.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)vYE.get(Long.valueOf(paramLong));
          AppMethodBeat.o(42490);
          return paramContext;
        }
      }
      else {
        vYD.remove(Long.valueOf(paramLong));
      }
    }
    if (l1 - paramLong < 60000L)
    {
      paramContext = paramContext.getString(h.i.Ibe);
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
      paramContext = paramContext.getResources().getQuantityString(h.g.fmt_in60min, i, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
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
      paramContext = paramContext.getResources().getQuantityString(h.g.fmt_in24h, i, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(h.i.fmt_pre_yesterday);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(42490);
      return paramContext;
    }
    int j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    paramContext = paramContext.getResources().getQuantityString(h.g.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
    vYE.put(Long.valueOf(paramLong), paramContext);
    vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(42490);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.b
 * JD-Core Version:    0.7.0.1
 */