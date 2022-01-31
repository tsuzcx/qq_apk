package com.tencent.mm.plugin.brandservice.ui.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class b
{
  private static HashMap<Long, Long> kiU;
  private static HashMap<Long, String> kiV;
  
  static
  {
    AppMethodBeat.i(14449);
    kiU = new HashMap();
    kiV = new HashMap();
    AppMethodBeat.o(14449);
  }
  
  public static void clean()
  {
    try
    {
      AppMethodBeat.i(14447);
      kiU.clear();
      kiV.clear();
      AppMethodBeat.o(14447);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String e(Context paramContext, long paramLong)
  {
    for (;;)
    {
      GregorianCalendar localGregorianCalendar;
      long l1;
      try
      {
        AppMethodBeat.i(14448);
        localGregorianCalendar = new GregorianCalendar();
        if (paramLong < 3600000L)
        {
          paramContext = "";
          AppMethodBeat.o(14448);
          return paramContext;
        }
        l1 = localGregorianCalendar.getTimeInMillis();
        if (kiU.containsKey(Long.valueOf(paramLong))) {
          if (l1 - ((Long)kiU.get(Long.valueOf(paramLong))).longValue() < 60000L)
          {
            if (kiV.containsKey(Long.valueOf(paramLong)))
            {
              paramContext = (String)kiV.get(Long.valueOf(paramLong));
              AppMethodBeat.o(14448);
            }
          }
          else {
            kiU.remove(Long.valueOf(paramLong));
          }
        }
      }
      finally {}
      int j;
      int i;
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
        AppMethodBeat.o(14448);
      }
      else
      {
        long l2 = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5)).getTimeInMillis();
        long l3 = paramLong - l2;
        if ((l3 > 0L) && (l3 <= 86400000L))
        {
          j = (int)((l1 - paramLong) / 3600000L);
          i = j;
          if (j <= 0) {
            i = 1;
          }
          paramContext = paramContext.getResources().getQuantityString(2131361801, i, new Object[] { Integer.valueOf(i) });
          kiV.put(Long.valueOf(paramLong), paramContext);
          kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
          AppMethodBeat.o(14448);
        }
        else
        {
          l3 = paramLong - l2 + 86400000L;
          if ((l3 > 0L) && (l3 <= 86400000L))
          {
            paramContext = paramContext.getString(2131300084);
            kiV.put(Long.valueOf(paramLong), paramContext);
            kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(14448);
          }
          else
          {
            j = (int)((l2 + 86400000L - paramLong) / 86400000L);
            i = j;
            if (j <= 0) {
              i = 1;
            }
            paramContext = paramContext.getResources().getQuantityString(2131361803, i, new Object[] { Integer.valueOf(i) });
            kiV.put(Long.valueOf(paramLong), paramContext);
            kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(14448);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.b
 * JD-Core Version:    0.7.0.1
 */