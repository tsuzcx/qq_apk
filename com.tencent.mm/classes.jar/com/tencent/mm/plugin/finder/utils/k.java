package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k
{
  private static HashMap<Long, Long> pMp;
  private static HashMap<Long, String> pMq;
  private static Map<String, List<String>> vVB;
  private static Map<String, List<String>> vVC;
  public static String vVD;
  
  static
  {
    AppMethodBeat.i(168642);
    vVB = new HashMap();
    vVC = new HashMap();
    pMp = new HashMap();
    pMq = new HashMap();
    vVD = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(168642);
  }
  
  public static String Gb(long paramLong)
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
    if ((vVD.equals("zh_CN")) || (vVD.equals("zh_HK")) || (vVD.equals("zh_TW")))
    {
      if (paramLong <= 9999L)
      {
        AppMethodBeat.o(168641);
        return String.valueOf(paramLong);
      }
      if (paramLong <= 99990000L)
      {
        str = MMApplicationContext.getContext().getString(2131760357, new Object[] { Double.valueOf((float)paramLong * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(168641);
        return str;
      }
      str = MMApplicationContext.getContext().getString(2131760361, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 990000L)
    {
      str = MMApplicationContext.getContext().getString(2131760359, new Object[] { Double.valueOf((float)paramLong * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 99990000L)
    {
      str = MMApplicationContext.getContext().getString(2131760358, new Object[] { Double.valueOf((float)paramLong * 1.0F / 1000000.0F - 0.05D) });
      AppMethodBeat.o(168641);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(2131760362, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168641);
    return str;
  }
  
  public static String Lv(int paramInt)
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
    if ((vVD.equals("zh_CN")) || (vVD.equals("zh_HK")) || (vVD.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(168639);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 100000)
      {
        str = MMApplicationContext.getContext().getString(2131760357, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(168639);
        return str;
      }
      str = MMApplicationContext.getContext().getString(2131760360, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(168639);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = MMApplicationContext.getContext().getString(2131760359, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(168639);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(2131760365, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168639);
    return str;
  }
  
  public static String Lw(int paramInt)
  {
    AppMethodBeat.i(258533);
    String str = Gb(paramInt);
    AppMethodBeat.o(258533);
    return str;
  }
  
  public static String Lx(int paramInt)
  {
    AppMethodBeat.i(241819);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(241819);
      return "0";
    }
    if ((vVD.equals("zh_CN")) || (vVD.equals("zh_HK")) || (vVD.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(241819);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 99990000)
      {
        str = MMApplicationContext.getContext().getString(2131760357, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(241819);
        return str;
      }
      str = MMApplicationContext.getContext().getString(2131760364, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F - 0.05D) });
      AppMethodBeat.o(241819);
      return str;
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(241819);
      return String.valueOf(paramInt);
    }
    if (paramInt <= 990000)
    {
      str = MMApplicationContext.getContext().getString(2131760359, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(241819);
      return str;
    }
    if (paramInt <= 990000000)
    {
      str = MMApplicationContext.getContext().getString(2131760363, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(241819);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(2131760366, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F / 10.0F - 0.05D) });
    AppMethodBeat.o(241819);
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
        l3 = cl.aWy();
        if (!pMp.containsKey(Long.valueOf(paramLong))) {
          break label696;
        }
        if (l3 - ((Long)pMp.get(Long.valueOf(paramLong))).longValue() < 60000L)
        {
          if (pMq.containsKey(Long.valueOf(paramLong)))
          {
            paramContext = (String)pMq.get(Long.valueOf(paramLong));
            AppMethodBeat.o(168637);
          }
        }
        else {
          pMp.remove(Long.valueOf(paramLong));
        }
      }
      finally {}
      break label696;
      if (localObject < 0L)
      {
        paramContext = DateFormat.format(paramContext.getString(2131760832), paramLong);
        pMq.put(Long.valueOf(paramLong), paramContext);
        pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
      paramContext = paramContext.getResources().getString(2131760622, new Object[] { Integer.valueOf(i) });
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
      AppMethodBeat.o(168637);
      break;
      if (localObject <= 86400000L)
      {
        j = (int)(localObject / 3600000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getString(2131760621, new Object[] { Integer.valueOf(i) });
        pMq.put(Long.valueOf(paramLong), paramContext);
        pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 172800000L)
      {
        paramContext = paramContext.getString(2131760868);
        pMq.put(Long.valueOf(paramLong), paramContext);
        pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 259200000L)
      {
        paramContext = paramContext.getString(2131760851);
        pMq.put(Long.valueOf(paramLong), paramContext);
        pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 2592000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623947, (int)(localObject / 86400000L), new Object[] { Integer.valueOf((int)(localObject / 86400000L)) });
        pMq.put(Long.valueOf(paramLong), paramContext);
        pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 31536000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(2131623948, (int)(localObject / 2592000000L), new Object[] { Integer.valueOf((int)(localObject / 2592000000L)) });
        pMq.put(Long.valueOf(paramLong), paramContext);
        pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      paramContext = paramContext.getResources().getQuantityString(2131623949, (int)(localObject / 31536000000L), new Object[] { Integer.valueOf((int)(localObject / 31536000000L)) });
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
  
  public static String gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241817);
    Object localObject = y.vXH;
    if (y.LC(paramInt1))
    {
      localObject = Gb(paramInt2);
      AppMethodBeat.o(241817);
      return localObject;
    }
    localObject = Lv(paramInt2);
    AppMethodBeat.o(241817);
    return localObject;
  }
  
  public static CharSequence j(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(241813);
    paramContext = DateFormat.format(paramContext.getString(2131760844), paramLong);
    AppMethodBeat.o(241813);
    return paramContext;
  }
  
  public static String k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(241814);
    paramContext = l(paramContext, paramLong);
    AppMethodBeat.o(241814);
    return paramContext;
  }
  
  public static String l(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(241815);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    long l = localGregorianCalendar1.getTimeInMillis();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6))
    {
      paramContext = paramContext.getString(2131760859);
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(241815);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 1)
    {
      paramContext = paramContext.getString(2131760868);
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(241815);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 2)
    {
      paramContext = paramContext.getString(2131760851);
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(241815);
      return paramContext;
    }
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131760813), paramLong);
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(241815);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131760832), paramLong);
    pMq.put(Long.valueOf(paramLong), paramContext);
    pMp.put(Long.valueOf(paramLong), Long.valueOf(l));
    AppMethodBeat.o(241815);
    return paramContext;
  }
  
  public static String m(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(241816);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(241816);
      return "";
    }
    long l1 = System.currentTimeMillis();
    if (pMp.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)pMp.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (pMq.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)pMq.get(Long.valueOf(paramLong));
          AppMethodBeat.o(241816);
          return paramContext;
        }
      }
      else {
        pMp.remove(Long.valueOf(paramLong));
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
      paramContext = paramContext.getResources().getString(2131760622, new Object[] { Integer.valueOf(i) });
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(241816);
      return paramContext;
    }
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l2 = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      j = (int)((l1 - paramLong) / 3600000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(2131760621, new Object[] { Integer.valueOf(i) });
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(241816);
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
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(241816);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(2131760813), paramLong);
      pMq.put(Long.valueOf(paramLong), paramContext);
      pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(241816);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(2131760832), paramLong);
    pMq.put(Long.valueOf(paramLong), paramContext);
    pMp.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(241816);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */