package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.b;
import com.tencent.mm.plugin.finder.b.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m
{
  private static Map<String, List<String>> ADv;
  private static Map<String, List<String>> ADw;
  private static HashMap<Long, String> ADx;
  public static String ADy;
  private static HashMap<Long, Long> sTn;
  private static HashMap<Long, String> sTo;
  
  static
  {
    AppMethodBeat.i(168642);
    ADv = new HashMap();
    ADw = new HashMap();
    sTn = new HashMap();
    sTo = new HashMap();
    ADx = new HashMap();
    ADy = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(168642);
  }
  
  public static String Nb(long paramLong)
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
    if ((ADy.equals("zh_CN")) || (ADy.equals("zh_HK")) || (ADy.equals("zh_TW")))
    {
      if (paramLong <= 9999L)
      {
        AppMethodBeat.o(168641);
        return String.valueOf(paramLong);
      }
      if (paramLong <= 99990000L)
      {
        str = MMApplicationContext.getContext().getString(b.j.finder_number_10000, new Object[] { Double.valueOf((float)paramLong * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(168641);
        return str;
      }
      str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_100000000, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 990000L)
    {
      str = MMApplicationContext.getContext().getString(b.j.finder_number_10000_en, new Object[] { Double.valueOf((float)paramLong * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 99990000L)
    {
      str = MMApplicationContext.getContext().getString(b.j.finder_number_1000000_en, new Object[] { Double.valueOf((float)paramLong * 1.0F / 1000000.0F - 0.05D) });
      AppMethodBeat.o(168641);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_100000000_en, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168641);
    return str;
  }
  
  public static String QF(int paramInt)
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
    if ((ADy.equals("zh_CN")) || (ADy.equals("zh_HK")) || (ADy.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(168639);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 100000)
      {
        str = MMApplicationContext.getContext().getString(b.j.finder_number_10000, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(168639);
        return str;
      }
      str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_10000, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(168639);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = MMApplicationContext.getContext().getString(b.j.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(168639);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_10000_en, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168639);
    return str;
  }
  
  public static String QG(int paramInt)
  {
    AppMethodBeat.i(293375);
    String str = Nb(paramInt);
    AppMethodBeat.o(293375);
    return str;
  }
  
  public static String QH(int paramInt)
  {
    AppMethodBeat.i(290869);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(290869);
      return "0";
    }
    if ((ADy.equals("zh_CN")) || (ADy.equals("zh_HK")) || (ADy.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(290869);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 99990000)
      {
        str = MMApplicationContext.getContext().getString(b.j.finder_number_10000, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(290869);
        return str;
      }
      str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_100000000_v2, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F - 0.05D) });
      AppMethodBeat.o(290869);
      return str;
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(290869);
      return String.valueOf(paramInt);
    }
    if (paramInt <= 990000)
    {
      str = MMApplicationContext.getContext().getString(b.j.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(290869);
      return str;
    }
    if (paramInt <= 990000000)
    {
      str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_100000000_en_v2, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(290869);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_billion_en, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F / 10.0F - 0.05D) });
    AppMethodBeat.o(290869);
    return str;
  }
  
  public static String QI(int paramInt)
  {
    AppMethodBeat.i(290870);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(290870);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(290870);
      return String.valueOf(paramInt);
    }
    if ((ADy.equals("zh_CN")) || (ADy.equals("zh_HK")) || (ADy.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(290870);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 100000)
      {
        double d = new BigDecimal(paramInt * 1.0F / 10000.0F - 0.05D).setScale(1, RoundingMode.UP).doubleValue();
        str = MMApplicationContext.getContext().getString(b.j.finder_number_10000, new Object[] { Double.valueOf(d) });
        if (Math.round(d) - d == 0.0D) {
          str = MMApplicationContext.getContext().getString(b.j.finder_number_10000_w, new Object[] { Integer.valueOf((int)Math.round(d)) });
        }
        AppMethodBeat.o(290870);
        return str;
      }
      str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_10000, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(290870);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = MMApplicationContext.getContext().getString(b.j.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(290870);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(b.j.finder_number_more_than_10000_en, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(290870);
    return str;
  }
  
  private static void aI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(290865);
    paramContext = paramContext.getResources().getStringArray(b.b.time_day);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    ADv.put(paramString, localArrayList);
    AppMethodBeat.o(290865);
  }
  
  public static String d(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(290866);
    if (ADv.get(paramString) == null) {
      aI(paramContext, paramString);
    }
    List localList = (List)ADv.get(paramString);
    if ((paramInt >= localList.size()) || (localList.get(paramInt) == null) || (((String)localList.get(paramInt)).equals(""))) {
      aI(paramContext, paramString);
    }
    paramContext = (List)ADv.get(paramString);
    if (paramInt < paramContext.size())
    {
      paramContext = (String)paramContext.get(paramInt);
      AppMethodBeat.o(290866);
      return paramContext;
    }
    AppMethodBeat.o(290866);
    return "";
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
        l3 = cm.bfC();
        if (!sTn.containsKey(Long.valueOf(paramLong))) {
          break label704;
        }
        if (l3 - ((Long)sTn.get(Long.valueOf(paramLong))).longValue() < 60000L)
        {
          if (sTo.containsKey(Long.valueOf(paramLong)))
          {
            paramContext = (String)sTo.get(Long.valueOf(paramLong));
            AppMethodBeat.o(168637);
          }
        }
        else {
          sTn.remove(Long.valueOf(paramLong));
        }
      }
      finally {}
      break label704;
      if (localObject < 0L)
      {
        paramContext = DateFormat.format(paramContext.getString(b.j.fmt_longdate), paramLong);
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
      }
      else if (localObject / 3600000L == 0L)
      {
        j = (int)(localObject / 60000L);
        if (j > 0) {
          break label740;
        }
      }
    }
    for (;;)
    {
      paramContext = paramContext.getResources().getString(b.j.finder_time_min_format, new Object[] { Integer.valueOf(i) });
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
      AppMethodBeat.o(168637);
      break;
      if (localObject <= 86400000L)
      {
        j = (int)(localObject / 3600000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getString(b.j.finder_time_hour_format, new Object[] { Integer.valueOf(i) });
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 172800000L)
      {
        paramContext = paramContext.getString(b.j.fmt_pre_yesterday);
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 259200000L)
      {
        paramContext = paramContext.getString(b.j.fmt_pre_daybeforyesterday);
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 2592000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(b.h.fmt_indayh, (int)(localObject / 86400000L), new Object[] { Integer.valueOf((int)(localObject / 86400000L)) });
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 31536000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(b.h.fmt_month_ago, (int)(localObject / 2592000000L), new Object[] { Integer.valueOf((int)(localObject / 2592000000L)) });
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      paramContext = paramContext.getResources().getQuantityString(b.h.fmt_years_ago, (int)(localObject / 31536000000L), new Object[] { Integer.valueOf((int)(localObject / 31536000000L)) });
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l3));
      AppMethodBeat.o(168637);
      break;
      label704:
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
      label740:
      i = j;
    }
  }
  
  public static String gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290867);
    Object localObject = aj.AGc;
    if (aj.QQ(paramInt1))
    {
      localObject = Nb(paramInt2);
      AppMethodBeat.o(290867);
      return localObject;
    }
    localObject = QF(paramInt2);
    AppMethodBeat.o(290867);
    return localObject;
  }
  
  public static CharSequence k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(290860);
    paramContext = DateFormat.format(paramContext.getString(b.j.fmt_normal_time_24), paramLong);
    AppMethodBeat.o(290860);
    return paramContext;
  }
  
  public static String l(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(290861);
    paramContext = m(paramContext, paramLong);
    AppMethodBeat.o(290861);
    return paramContext;
  }
  
  public static String m(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(290862);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    long l = localGregorianCalendar1.getTimeInMillis();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6))
    {
      paramContext = paramContext.getString(b.j.fmt_pre_nowday);
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(290862);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 1)
    {
      paramContext = paramContext.getString(b.j.fmt_pre_yesterday);
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(290862);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 2)
    {
      paramContext = paramContext.getString(b.j.fmt_pre_daybeforyesterday);
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(290862);
      return paramContext;
    }
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(b.j.fmt_date), paramLong);
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(290862);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(b.j.fmt_longdate), paramLong);
    sTo.put(Long.valueOf(paramLong), paramContext);
    sTn.put(Long.valueOf(paramLong), Long.valueOf(l));
    AppMethodBeat.o(290862);
    return paramContext;
  }
  
  public static String n(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(290863);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(290863);
      return "";
    }
    long l1 = System.currentTimeMillis();
    if (sTn.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)sTn.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (ADx.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)ADx.get(Long.valueOf(paramLong));
          AppMethodBeat.o(290863);
          return paramContext;
        }
      }
      else {
        sTn.remove(Long.valueOf(paramLong));
      }
    }
    int j;
    int i;
    if ((paramLong - l1) / 3600000L == 0L)
    {
      j = (int)((paramLong - l1) / 60000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(b.j.finder_activity_end_time_in_minute, new Object[] { Integer.valueOf(i) });
      ADx.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290863);
      return paramContext;
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    long l2 = paramLong - new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5), localGregorianCalendar.get(11), localGregorianCalendar.get(12)).getTimeInMillis();
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      j = (int)((paramLong - l1) / 3600000L);
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramContext = paramContext.getResources().getString(b.j.finder_activity_end_time_in_hour, new Object[] { Integer.valueOf(i) });
      ADx.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290863);
      return paramContext;
    }
    if (l2 > 86400000L)
    {
      i = Math.max((int)((paramLong - l1) / 86400000L), 1);
      paramContext = paramContext.getResources().getString(b.j.finder_activity_end_time_in_day, new Object[] { Integer.valueOf(i) });
      ADx.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290863);
      return paramContext;
    }
    AppMethodBeat.o(290863);
    return "";
  }
  
  public static String o(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(290864);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(290864);
      return "";
    }
    long l1 = System.currentTimeMillis();
    if (sTn.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)sTn.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (sTo.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)sTo.get(Long.valueOf(paramLong));
          AppMethodBeat.o(290864);
          return paramContext;
        }
      }
      else {
        sTn.remove(Long.valueOf(paramLong));
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
      paramContext = paramContext.getResources().getString(b.j.finder_time_min_format, new Object[] { Integer.valueOf(i) });
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290864);
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
      paramContext = paramContext.getResources().getString(b.j.finder_time_hour_format, new Object[] { Integer.valueOf(i) });
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290864);
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
      paramContext = paramContext.getResources().getQuantityString(b.h.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290864);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(b.j.fmt_date), paramLong);
      sTo.put(Long.valueOf(paramLong), paramContext);
      sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(290864);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(b.j.fmt_longdate), paramLong);
    sTo.put(Long.valueOf(paramLong), paramContext);
    sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(290864);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m
 * JD-Core Version:    0.7.0.1
 */