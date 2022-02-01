package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
{
  private static HashMap<Long, Long> osk;
  private static HashMap<Long, String> osl;
  private static Map<String, List<String>> sLk;
  private static Map<String, List<String>> sLl;
  public static String sLm;
  
  static
  {
    AppMethodBeat.i(168642);
    sLk = new HashMap();
    sLl = new HashMap();
    osk = new HashMap();
    osl = new HashMap();
    sLm = ac.iM(aj.getContext());
    AppMethodBeat.o(168642);
  }
  
  public static String FG(int paramInt)
  {
    AppMethodBeat.i(168639);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(168639);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(168639);
      return String.valueOf(paramInt);
    }
    if ((sLm.equals("zh_CN")) || (sLm.equals("zh_HK")) || (sLm.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(168639);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 100000)
      {
        str = aj.getContext().getString(2131759292, new Object[] { Float.valueOf(paramInt * 1.0F / 10000.0F) });
        AppMethodBeat.o(168639);
        return str;
      }
      str = aj.getContext().getString(2131759295, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(168639);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = aj.getContext().getString(2131759294, new Object[] { Float.valueOf(paramInt * 1.0F / 1000.0F) });
      AppMethodBeat.o(168639);
      return str;
    }
    String str = aj.getContext().getString(2131759298, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168639);
    return str;
  }
  
  public static String FH(int paramInt)
  {
    AppMethodBeat.i(221445);
    String str = xn(paramInt);
    AppMethodBeat.o(221445);
    return str;
  }
  
  public static String FI(int paramInt)
  {
    AppMethodBeat.i(200927);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(200927);
      return "0";
    }
    if ((sLm.equals("zh_CN")) || (sLm.equals("zh_HK")) || (sLm.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(200927);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 99990000)
      {
        str = aj.getContext().getString(2131759292, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(200927);
        return str;
      }
      str = aj.getContext().getString(2131767014, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F - 0.05D) });
      AppMethodBeat.o(200927);
      return str;
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(200927);
      return String.valueOf(paramInt);
    }
    if (paramInt <= 990000)
    {
      str = aj.getContext().getString(2131759294, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(200927);
      return str;
    }
    if (paramInt <= 990000000)
    {
      str = aj.getContext().getString(2131767013, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(200927);
      return str;
    }
    String str = aj.getContext().getString(2131767015, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F / 10.0F + 0.05D) });
    AppMethodBeat.o(200927);
    return str;
  }
  
  public static String f(Context paramContext, long paramLong)
  {
    int i = 1;
    long l3;
    label130:
    Object localObject;
    int j;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(168637);
        if (paramLong < 3600000L)
        {
          paramContext = "";
          AppMethodBeat.o(168637);
          return paramContext;
        }
        l3 = cf.aCK();
        if (!osk.containsKey(Long.valueOf(paramLong))) {
          break label696;
        }
        if (l3 - ((Long)osk.get(Long.valueOf(paramLong))).longValue() < 60000L)
        {
          if (osl.containsKey(Long.valueOf(paramLong)))
          {
            paramContext = (String)osl.get(Long.valueOf(paramLong));
            AppMethodBeat.o(168637);
          }
        }
        else {
          osk.remove(Long.valueOf(paramLong));
        }
      }
      finally {}
      break label696;
      if (localObject < 0L)
      {
        paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
        osl.put(Long.valueOf(paramLong), paramContext);
        osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
      }
      else if (localObject / 3600000L == 0L)
      {
        j = (int)(localObject / 60000L);
        if (j > 0) {
          break label732;
        }
      }
    }
    for (;;)
    {
      paramContext = paramContext.getResources().getString(2131759368, new Object[] { Integer.valueOf(i) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
      AppMethodBeat.o(168637);
      break;
      if (localObject <= 86400000L)
      {
        j = (int)(localObject / 3600000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getString(2131759367, new Object[] { Integer.valueOf(i) });
        osl.put(Long.valueOf(paramLong), paramContext);
        osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 172800000L)
      {
        paramContext = paramContext.getString(2131759551);
        osl.put(Long.valueOf(paramLong), paramContext);
        osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 259200000L)
      {
        paramContext = paramContext.getString(2131759534);
        osl.put(Long.valueOf(paramLong), paramContext);
        osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 2592000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623947, (int)(localObject / 86400000L), new Object[] { Integer.valueOf((int)(localObject / 86400000L)) });
        osl.put(Long.valueOf(paramLong), paramContext);
        osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 31536000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623948, (int)(localObject / 2592000000L), new Object[] { Integer.valueOf((int)(localObject / 2592000000L)) });
        osl.put(Long.valueOf(paramLong), paramContext);
        osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      paramContext = paramContext.getResources().getQuantityString(2131623949, (int)(localObject / 31536000000L), new Object[] { Integer.valueOf((int)(localObject / 31536000000L)) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l3));
      AppMethodBeat.o(168637);
      break;
      label696:
      long l2 = l3 - paramLong;
      long l1 = l2;
      if (l2 >= 0L) {
        break label130;
      }
      l1 = l2;
      if (l2 <= -3600000L) {
        break label130;
      }
      l1 = 0L;
      break label130;
      label732:
      i = j;
    }
  }
  
  public static String fR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168638);
    Object localObject = p.sMo;
    if (p.FL(paramInt1))
    {
      localObject = xn(paramInt2);
      AppMethodBeat.o(168638);
      return localObject;
    }
    localObject = FG(paramInt2);
    AppMethodBeat.o(168638);
    return localObject;
  }
  
  public static String j(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(200924);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    long l = localGregorianCalendar1.getTimeInMillis();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6))
    {
      paramContext = paramContext.getString(2131759542);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(200924);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 1)
    {
      paramContext = paramContext.getString(2131759551);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(200924);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 2)
    {
      paramContext = paramContext.getString(2131759534);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(200924);
      return paramContext;
    }
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759498), paramLong);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(200924);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    osl.put(Long.valueOf(paramLong), paramContext);
    osk.put(Long.valueOf(paramLong), Long.valueOf(l));
    AppMethodBeat.o(200924);
    return paramContext;
  }
  
  public static String k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(200925);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(200925);
      return "";
    }
    long l1 = localGregorianCalendar1.getTimeInMillis();
    if (osk.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)osk.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (osl.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)osl.get(Long.valueOf(paramLong));
          AppMethodBeat.o(200925);
          return paramContext;
        }
      }
      else {
        osk.remove(Long.valueOf(paramLong));
      }
    }
    int j;
    int i;
    if ((l1 - paramLong) / 3600000L == 0L)
    {
      j = (int)((l1 - paramLong) / 60000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(2131759368, new Object[] { Integer.valueOf(i) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(200925);
      return paramContext;
    }
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l2 = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      j = (int)((l1 - paramLong) / 3600000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(2131759367, new Object[] { Integer.valueOf(i) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(200925);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131759551);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(200925);
      return paramContext;
    }
    l2 = paramLong - (localGregorianCalendar2.getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759534);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(200925);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759498), paramLong);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(200925);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    osl.put(Long.valueOf(paramLong), paramContext);
    osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(200925);
    return paramContext;
  }
  
  public static String v(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(221444);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(221444);
      return "";
    }
    long l1 = localGregorianCalendar1.getTimeInMillis();
    if (osk.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)osk.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (osl.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)osl.get(Long.valueOf(paramLong));
          AppMethodBeat.o(221444);
          return paramContext;
        }
      }
      else {
        osk.remove(Long.valueOf(paramLong));
      }
    }
    int i;
    if ((l1 - paramLong) / 3600000L == 0L)
    {
      j = (int)((l1 - paramLong) / 60000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(2131759368, new Object[] { Integer.valueOf(i) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(221444);
      return paramContext;
    }
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l2 = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      j = (int)((l1 - paramLong) / 3600000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(2131759367, new Object[] { Integer.valueOf(i) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(221444);
      return paramContext;
    }
    l2 = localGregorianCalendar2.getTimeInMillis();
    int j = (int)((l2 + 86400000L - paramLong) / 86400000L);
    if ((paramLong - l2 + 2592000000L > 0L) && (j <= 30))
    {
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getQuantityString(2131623947, i, new Object[] { Integer.valueOf(i) });
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(221444);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759498), paramLong);
      osl.put(Long.valueOf(paramLong), paramContext);
      osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(221444);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    osl.put(Long.valueOf(paramLong), paramContext);
    osk.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(221444);
    return paramContext;
  }
  
  public static String xn(long paramLong)
  {
    AppMethodBeat.i(168641);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(168641);
      return "0";
    }
    if (paramLong <= 999L)
    {
      AppMethodBeat.o(168641);
      return String.valueOf(paramLong);
    }
    if ((sLm.equals("zh_CN")) || (sLm.equals("zh_HK")) || (sLm.equals("zh_TW")))
    {
      if (paramLong <= 9999L)
      {
        AppMethodBeat.o(168641);
        return String.valueOf(paramLong);
      }
      if (paramLong <= 99990000L)
      {
        str = aj.getContext().getString(2131759292, new Object[] { Float.valueOf((float)paramLong * 1.0F / 10000.0F) });
        AppMethodBeat.o(168641);
        return str;
      }
      str = aj.getContext().getString(2131759296, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 990000L)
    {
      str = aj.getContext().getString(2131759294, new Object[] { Float.valueOf((float)paramLong * 1.0F / 1000.0F) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 99990000L)
    {
      str = aj.getContext().getString(2131759293, new Object[] { Float.valueOf((float)paramLong * 1.0F / 1000000.0F) });
      AppMethodBeat.o(168641);
      return str;
    }
    String str = aj.getContext().getString(2131759297, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168641);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.h
 * JD-Core Version:    0.7.0.1
 */