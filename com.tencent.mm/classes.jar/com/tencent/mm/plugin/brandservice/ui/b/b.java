package com.tencent.mm.plugin.brandservice.ui.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.b.h;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class b
{
  private static HashMap<Long, Long> iiU = new HashMap();
  private static HashMap<Long, String> iiV = new HashMap();
  
  public static void clean()
  {
    try
    {
      iiU.clear();
      iiV.clear();
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
      long l1;
      int j;
      int i;
      try
      {
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        if (paramLong < 3600000L)
        {
          paramContext = "";
          return paramContext;
        }
        l1 = localGregorianCalendar.getTimeInMillis();
        if (iiU.containsKey(Long.valueOf(paramLong))) {
          if (l1 - ((Long)iiU.get(Long.valueOf(paramLong))).longValue() < 60000L)
          {
            if (iiV.containsKey(Long.valueOf(paramLong))) {
              paramContext = (String)iiV.get(Long.valueOf(paramLong));
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
          paramContext = paramContext.getResources().getQuantityString(b.f.fmt_in60min, i, new Object[] { Integer.valueOf(i) });
          iiV.put(Long.valueOf(paramLong), paramContext);
          iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
          continue;
        }
        l2 = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5)).getTimeInMillis();
      }
      finally {}
      long l2;
      long l3 = paramLong - l2;
      if ((l3 > 0L) && (l3 <= 86400000L))
      {
        j = (int)((l1 - paramLong) / 3600000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getQuantityString(b.f.fmt_in24h, i, new Object[] { Integer.valueOf(i) });
        iiV.put(Long.valueOf(paramLong), paramContext);
        iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      }
      else
      {
        l3 = paramLong - l2 + 86400000L;
        if ((l3 > 0L) && (l3 <= 86400000L))
        {
          paramContext = paramContext.getString(b.h.fmt_pre_yesterday);
          iiV.put(Long.valueOf(paramLong), paramContext);
          iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
        }
        else
        {
          j = (int)((l2 + 86400000L - paramLong) / 86400000L);
          i = j;
          if (j <= 0) {
            i = 1;
          }
          paramContext = paramContext.getResources().getQuantityString(b.f.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
          iiV.put(Long.valueOf(paramLong), paramContext);
          iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.b
 * JD-Core Version:    0.7.0.1
 */