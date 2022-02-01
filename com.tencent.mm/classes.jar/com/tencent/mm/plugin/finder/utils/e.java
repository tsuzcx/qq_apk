package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
{
  private static HashMap<Long, Long> nmE;
  private static HashMap<Long, String> nmF;
  private static Map<String, List<String>> qSp;
  private static Map<String, List<String>> qSq;
  
  static
  {
    AppMethodBeat.i(168642);
    qSp = new HashMap();
    qSq = new HashMap();
    nmE = new HashMap();
    nmF = new HashMap();
    AppMethodBeat.o(168642);
  }
  
  public static String De(int paramInt)
  {
    AppMethodBeat.i(168639);
    String str = ac.ir(aj.getContext());
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
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
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
    str = aj.getContext().getString(2131759298, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168639);
    return str;
  }
  
  public static String Df(int paramInt)
  {
    AppMethodBeat.i(197226);
    String str = qN(paramInt);
    AppMethodBeat.o(197226);
    return str;
  }
  
  public static String ahF(int paramInt)
  {
    AppMethodBeat.i(197227);
    String str = ac.ir(aj.getContext());
    if (paramInt <= 0)
    {
      AppMethodBeat.o(197227);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(197227);
      return String.valueOf(paramInt);
    }
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(197227);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 990000)
      {
        str = aj.getContext().getString(2131759292, new Object[] { Float.valueOf(paramInt * 1.0F / 10000.0F) });
        AppMethodBeat.o(197227);
        return str;
      }
      str = aj.getContext().getString(2131759295, new Object[] { Integer.valueOf(99) });
      AppMethodBeat.o(197227);
      return str;
    }
    if (paramInt <= 999000)
    {
      str = aj.getContext().getString(2131759294, new Object[] { Float.valueOf(paramInt * 1.0F / 1000.0F) });
      AppMethodBeat.o(197227);
      return str;
    }
    str = aj.getContext().getString(2131759298, new Object[] { Integer.valueOf(999) });
    AppMethodBeat.o(197227);
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
        l3 = ce.asQ();
        if (!nmE.containsKey(Long.valueOf(paramLong))) {
          break label696;
        }
        if (l3 - ((Long)nmE.get(Long.valueOf(paramLong))).longValue() < 60000L)
        {
          if (nmF.containsKey(Long.valueOf(paramLong)))
          {
            paramContext = (String)nmF.get(Long.valueOf(paramLong));
            AppMethodBeat.o(168637);
          }
        }
        else {
          nmE.remove(Long.valueOf(paramLong));
        }
      }
      finally {}
      break label696;
      if (localObject < 0L)
      {
        paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
        nmF.put(Long.valueOf(paramLong), paramContext);
        nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
        nmF.put(Long.valueOf(paramLong), paramContext);
        nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 172800000L)
      {
        paramContext = paramContext.getString(2131759551);
        nmF.put(Long.valueOf(paramLong), paramContext);
        nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 259200000L)
      {
        paramContext = paramContext.getString(2131759534);
        nmF.put(Long.valueOf(paramLong), paramContext);
        nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 2592000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623947, (int)(localObject / 86400000L), new Object[] { Integer.valueOf((int)(localObject / 86400000L)) });
        nmF.put(Long.valueOf(paramLong), paramContext);
        nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 31536000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623948, (int)(localObject / 2592000000L), new Object[] { Integer.valueOf((int)(localObject / 2592000000L)) });
        nmF.put(Long.valueOf(paramLong), paramContext);
        nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      paramContext = paramContext.getResources().getQuantityString(2131623949, (int)(localObject / 31536000000L), new Object[] { Integer.valueOf((int)(localObject / 31536000000L)) });
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
  
  public static String fz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168638);
    Object localObject = i.qTa;
    if (i.Di(paramInt1))
    {
      localObject = qN(paramInt2);
      AppMethodBeat.o(168638);
      return localObject;
    }
    localObject = De(paramInt2);
    AppMethodBeat.o(168638);
    return localObject;
  }
  
  public static String j(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(168636);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(168636);
      return "";
    }
    long l1 = localGregorianCalendar1.getTimeInMillis();
    if (nmE.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)nmE.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (nmF.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)nmF.get(Long.valueOf(paramLong));
          AppMethodBeat.o(168636);
          return paramContext;
        }
      }
      else {
        nmE.remove(Long.valueOf(paramLong));
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
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
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
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131759551) + " " + h.formatTime(paramContext.getString(2131759529), paramLong / 1000L);
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    l2 = paramLong - (localGregorianCalendar2.getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759534) + " " + h.formatTime(paramContext.getString(2131759529), paramLong / 1000L);
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759500, new Object[] { " " }), paramLong);
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    nmF.put(Long.valueOf(paramLong), paramContext);
    nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(168636);
    return paramContext;
  }
  
  public static String qN(long paramLong)
  {
    AppMethodBeat.i(168641);
    String str = ac.ir(aj.getContext());
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
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
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
    str = aj.getContext().getString(2131759297, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168641);
    return str;
  }
  
  public static String u(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(197225);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(197225);
      return "";
    }
    long l1 = localGregorianCalendar1.getTimeInMillis();
    if (nmE.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)nmE.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (nmF.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)nmF.get(Long.valueOf(paramLong));
          AppMethodBeat.o(197225);
          return paramContext;
        }
      }
      else {
        nmE.remove(Long.valueOf(paramLong));
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
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(197225);
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
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(197225);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131759551);
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(197225);
      return paramContext;
    }
    l2 = paramLong - (localGregorianCalendar2.getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759534);
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(197225);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759498), paramLong);
      nmF.put(Long.valueOf(paramLong), paramContext);
      nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(197225);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    nmF.put(Long.valueOf(paramLong), paramContext);
    nmE.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(197225);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.e
 * JD-Core Version:    0.7.0.1
 */