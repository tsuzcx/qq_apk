package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private static HashMap<Long, Long> nPE;
  private static HashMap<Long, String> nPF;
  private static Map<String, List<String>> rOO;
  private static Map<String, List<String>> rOP;
  
  static
  {
    AppMethodBeat.i(168642);
    rOO = new HashMap();
    rOP = new HashMap();
    nPE = new HashMap();
    nPF = new HashMap();
    AppMethodBeat.o(168642);
  }
  
  public static String Ew(int paramInt)
  {
    AppMethodBeat.i(168639);
    String str = ab.iC(ai.getContext());
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
        str = ai.getContext().getString(2131759292, new Object[] { Float.valueOf(paramInt * 1.0F / 10000.0F) });
        AppMethodBeat.o(168639);
        return str;
      }
      str = ai.getContext().getString(2131759295, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(168639);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = ai.getContext().getString(2131759294, new Object[] { Float.valueOf(paramInt * 1.0F / 1000.0F) });
      AppMethodBeat.o(168639);
      return str;
    }
    str = ai.getContext().getString(2131759298, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168639);
    return str;
  }
  
  public static String Ex(int paramInt)
  {
    AppMethodBeat.i(210216);
    String str = vk(paramInt);
    AppMethodBeat.o(210216);
    return str;
  }
  
  public static String Ey(int paramInt)
  {
    AppMethodBeat.i(201079);
    String str = ab.iC(ai.getContext());
    if (paramInt <= 0)
    {
      AppMethodBeat.o(201079);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(201079);
      return String.valueOf(paramInt);
    }
    if ((str.equals("zh_CN")) || (str.equals("zh_HK")) || (str.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(201079);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 990000)
      {
        str = ai.getContext().getString(2131759292, new Object[] { Float.valueOf(paramInt * 1.0F / 10000.0F) });
        AppMethodBeat.o(201079);
        return str;
      }
      str = ai.getContext().getString(2131759295, new Object[] { Integer.valueOf(99) });
      AppMethodBeat.o(201079);
      return str;
    }
    if (paramInt <= 999000)
    {
      str = ai.getContext().getString(2131759294, new Object[] { Float.valueOf(paramInt * 1.0F / 1000.0F) });
      AppMethodBeat.o(201079);
      return str;
    }
    str = ai.getContext().getString(2131759298, new Object[] { Integer.valueOf(999) });
    AppMethodBeat.o(201079);
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
        l3 = ce.azH();
        if (!nPE.containsKey(Long.valueOf(paramLong))) {
          break label696;
        }
        if (l3 - ((Long)nPE.get(Long.valueOf(paramLong))).longValue() < 60000L)
        {
          if (nPF.containsKey(Long.valueOf(paramLong)))
          {
            paramContext = (String)nPF.get(Long.valueOf(paramLong));
            AppMethodBeat.o(168637);
          }
        }
        else {
          nPE.remove(Long.valueOf(paramLong));
        }
      }
      finally {}
      break label696;
      if (localObject < 0L)
      {
        paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 172800000L)
      {
        paramContext = paramContext.getString(2131759551);
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 259200000L)
      {
        paramContext = paramContext.getString(2131759534);
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 2592000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623947, (int)(localObject / 86400000L), new Object[] { Integer.valueOf((int)(localObject / 86400000L)) });
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 31536000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623948, (int)(localObject / 2592000000L), new Object[] { Integer.valueOf((int)(localObject / 2592000000L)) });
        nPF.put(Long.valueOf(paramLong), paramContext);
        nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      paramContext = paramContext.getResources().getQuantityString(2131623949, (int)(localObject / 31536000000L), new Object[] { Integer.valueOf((int)(localObject / 31536000000L)) });
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
  
  public static String fD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168638);
    Object localObject = n.rPN;
    if (n.EB(paramInt1))
    {
      localObject = vk(paramInt2);
      AppMethodBeat.o(168638);
      return localObject;
    }
    localObject = Ew(paramInt2);
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
    if (nPE.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)nPE.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (nPF.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)nPF.get(Long.valueOf(paramLong));
          AppMethodBeat.o(168636);
          return paramContext;
        }
      }
      else {
        nPE.remove(Long.valueOf(paramLong));
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
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
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
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131759551) + " " + h.formatTime(paramContext.getString(2131759529), paramLong / 1000L);
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    l2 = paramLong - (localGregorianCalendar2.getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759534) + " " + h.formatTime(paramContext.getString(2131759529), paramLong / 1000L);
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759500, new Object[] { " " }), paramLong);
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    nPF.put(Long.valueOf(paramLong), paramContext);
    nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(168636);
    return paramContext;
  }
  
  public static String k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(201077);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(201077);
      return "";
    }
    long l1 = localGregorianCalendar1.getTimeInMillis();
    if (nPE.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)nPE.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (nPF.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)nPF.get(Long.valueOf(paramLong));
          AppMethodBeat.o(201077);
          return paramContext;
        }
      }
      else {
        nPE.remove(Long.valueOf(paramLong));
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
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(201077);
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
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(201077);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(2131759551);
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(201077);
      return paramContext;
    }
    l2 = paramLong - (localGregorianCalendar2.getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759534);
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(201077);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131759498), paramLong);
      nPF.put(Long.valueOf(paramLong), paramContext);
      nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(201077);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131759517), paramLong);
    nPF.put(Long.valueOf(paramLong), paramContext);
    nPE.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(201077);
    return paramContext;
  }
  
  public static String vk(long paramLong)
  {
    AppMethodBeat.i(168641);
    String str = ab.iC(ai.getContext());
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
        str = ai.getContext().getString(2131759292, new Object[] { Float.valueOf((float)paramLong * 1.0F / 10000.0F) });
        AppMethodBeat.o(168641);
        return str;
      }
      str = ai.getContext().getString(2131759296, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 990000L)
    {
      str = ai.getContext().getString(2131759294, new Object[] { Float.valueOf((float)paramLong * 1.0F / 1000.0F) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 99990000L)
    {
      str = ai.getContext().getString(2131759293, new Object[] { Float.valueOf((float)paramLong * 1.0F / 1000000.0F) });
      AppMethodBeat.o(168641);
      return str;
    }
    str = ai.getContext().getString(2131759297, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168641);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.g
 * JD-Core Version:    0.7.0.1
 */