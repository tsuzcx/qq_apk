package com.tencent.mm.plugin.brandservice.ui.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class b
{
  private static HashMap<Long, Long> nPE;
  private static HashMap<Long, String> nPF;
  
  static
  {
    AppMethodBeat.i(6238);
    nPE = new HashMap();
    nPF = new HashMap();
    AppMethodBeat.o(6238);
  }
  
  public static void clean()
  {
    try
    {
      AppMethodBeat.i(6236);
      nPE.clear();
      nPF.clear();
      AppMethodBeat.o(6236);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String f(Context paramContext, long paramLong)
  {
    for (;;)
    {
      GregorianCalendar localGregorianCalendar;
      long l1;
      try
      {
        AppMethodBeat.i(6237);
        localGregorianCalendar = new GregorianCalendar();
        if (paramLong < 3600000L)
        {
          paramContext = "";
          AppMethodBeat.o(6237);
          return paramContext;
        }
        l1 = localGregorianCalendar.getTimeInMillis();
        if (nPE.containsKey(Long.valueOf(paramLong))) {
          if (l1 - ((Long)nPE.get(Long.valueOf(paramLong))).longValue() < 60000L)
          {
            if (nPF.containsKey(Long.valueOf(paramLong)))
            {
              paramContext = (String)nPF.get(Long.valueOf(paramLong));
              AppMethodBeat.o(6237);
            }
          }
          else {
            nPE.remove(Long.valueOf(paramLong));
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
        paramContext = paramContext.getResources().getQuantityString(2131623946, i, new Object[] { Integer.valueOf(i) });
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
        AppMethodBeat.o(6237);
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
          paramContext = paramContext.getResources().getQuantityString(2131623945, i, new Object[] { Integer.valueOf(i) });
          nPF.put(Long.valueOf(paramLong), paramContext);
          nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
          AppMethodBeat.o(6237);
        }
        else
        {
          l3 = paramLong - l2 + 86400000L;
          if ((l3 > 0L) && (l3 <= 86400000L))
          {
            paramContext = paramContext.getString(2131759551);
            nPF.put(Long.valueOf(paramLong), paramContext);
            nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(6237);
          }
          else
          {
            j = (int)((l2 + 86400000L - paramLong) / 86400000L);
            i = j;
            if (j <= 0) {
              i = 1;
            }
            paramContext = paramContext.getResources().getQuantityString(2131623947, i, new Object[] { Integer.valueOf(i) });
            nPF.put(Long.valueOf(paramLong), paramContext);
            nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(6237);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.b
 * JD-Core Version:    0.7.0.1
 */