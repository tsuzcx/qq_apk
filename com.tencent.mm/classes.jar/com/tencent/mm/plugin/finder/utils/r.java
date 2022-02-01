package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.w.a.a.a.a;
import com.tencent.mm.w.a.a.a.g;
import com.tencent.mm.w.a.a.a.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r
{
  private static Map<String, List<String>> GgG;
  private static Map<String, List<String>> GgH;
  private static HashMap<Long, String> GgI;
  public static String GgJ;
  private static HashMap<Long, Long> vYD;
  private static HashMap<Long, String> vYE;
  
  static
  {
    AppMethodBeat.i(168642);
    GgG = new HashMap();
    GgH = new HashMap();
    vYD = new HashMap();
    vYE = new HashMap();
    GgI = new HashMap();
    GgJ = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(168642);
  }
  
  private static double L(double paramDouble)
  {
    AppMethodBeat.i(333826);
    paramDouble = new BigDecimal(paramDouble).setScale(1, RoundingMode.UP).doubleValue();
    AppMethodBeat.o(333826);
    return paramDouble;
  }
  
  public static String TP(int paramInt)
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
    if ((GgJ.equals("zh_CN")) || (GgJ.equals("zh_HK")) || (GgJ.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(168639);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 100000)
      {
        str = MMApplicationContext.getContext().getString(a.i.finder_number_10000, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(168639);
        return str;
      }
      str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_10000, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(168639);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(168639);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_10000_en, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168639);
    return str;
  }
  
  public static String TQ(int paramInt)
  {
    AppMethodBeat.i(370233);
    String str = qE(paramInt);
    AppMethodBeat.o(370233);
    return str;
  }
  
  public static String TR(int paramInt)
  {
    AppMethodBeat.i(333805);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(333805);
      return "0";
    }
    if ((GgJ.equals("zh_CN")) || (GgJ.equals("zh_HK")) || (GgJ.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(333805);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 99990000)
      {
        str = MMApplicationContext.getContext().getString(a.i.finder_number_10000, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(333805);
        return str;
      }
      str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_100000000_v2, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F - 0.05D) });
      AppMethodBeat.o(333805);
      return str;
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(333805);
      return String.valueOf(paramInt);
    }
    if (paramInt <= 990000)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(333805);
      return str;
    }
    if (paramInt <= 990000000)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_100000000_en_v2, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(333805);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_billion_en, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F / 10000.0F / 10.0F - 0.05D) });
    AppMethodBeat.o(333805);
    return str;
  }
  
  public static String TS(int paramInt)
  {
    AppMethodBeat.i(333810);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(333810);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(333810);
      return String.valueOf(paramInt);
    }
    if ((GgJ.equals("zh_CN")) || (GgJ.equals("zh_HK")) || (GgJ.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(333810);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 100000)
      {
        double d = L(paramInt * 1.0F / 10000.0F - 0.05D);
        str = MMApplicationContext.getContext().getString(a.i.finder_number_10000, new Object[] { Double.valueOf(d) });
        if (Math.round(d) - d == 0.0D) {
          str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_w, new Object[] { Integer.valueOf((int)Math.round(d)) });
        }
        AppMethodBeat.o(333810);
        return str;
      }
      str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_10000, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(333810);
      return str;
    }
    if (paramInt <= 100000)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(333810);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_10000_en, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(333810);
    return str;
  }
  
  public static String TT(int paramInt)
  {
    AppMethodBeat.i(333819);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(333819);
      return "0";
    }
    if ((GgJ.equals("zh_CN")) || (GgJ.equals("zh_HK")) || (GgJ.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(333819);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 1000000)
      {
        double d = L(paramInt * 1.0F / 10000.0F - 0.05D);
        str = MMApplicationContext.getContext().getString(a.i.finder_number_10000, new Object[] { Double.valueOf(d) });
        if (Math.round(d) - d == 0.0D) {
          str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_w, new Object[] { Integer.valueOf((int)Math.round(d)) });
        }
        AppMethodBeat.o(333819);
        return str;
      }
      str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_10000, new Object[] { Integer.valueOf(100) });
      AppMethodBeat.o(333819);
      return str;
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(333819);
      return String.valueOf(paramInt);
    }
    if (paramInt <= 1000000)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(333819);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_100000000_en, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(333819);
    return str;
  }
  
  private static void aM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(333757);
    paramContext = paramContext.getResources().getStringArray(a.a.time_day);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    GgG.put(paramString, localArrayList);
    AppMethodBeat.o(333757);
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
        l3 = cn.bDu();
        if (!vYD.containsKey(Long.valueOf(paramLong))) {
          break label704;
        }
        if (l3 - ((Long)vYD.get(Long.valueOf(paramLong))).longValue() < 60000L)
        {
          if (vYE.containsKey(Long.valueOf(paramLong)))
          {
            paramContext = (String)vYE.get(Long.valueOf(paramLong));
            AppMethodBeat.o(168637);
          }
        }
        else {
          vYD.remove(Long.valueOf(paramLong));
        }
      }
      finally {}
      break label704;
      if (localObject < 0L)
      {
        paramContext = DateFormat.format(paramContext.getString(a.i.fmt_longdate), paramLong);
        vYE.put(Long.valueOf(paramLong), paramContext);
        vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
      paramContext = paramContext.getResources().getString(a.i.finder_time_min_format, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
      AppMethodBeat.o(168637);
      break;
      if (localObject <= 86400000L)
      {
        j = (int)(localObject / 3600000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getString(a.i.finder_time_hour_format, new Object[] { Integer.valueOf(i) });
        vYE.put(Long.valueOf(paramLong), paramContext);
        vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 172800000L)
      {
        paramContext = paramContext.getString(a.i.fmt_pre_yesterday);
        vYE.put(Long.valueOf(paramLong), paramContext);
        vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 259200000L)
      {
        paramContext = paramContext.getString(a.i.fmt_pre_daybeforyesterday);
        vYE.put(Long.valueOf(paramLong), paramContext);
        vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 2592000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(a.g.fmt_indayh, (int)(localObject / 86400000L), new Object[] { Integer.valueOf((int)(localObject / 86400000L)) });
        vYE.put(Long.valueOf(paramLong), paramContext);
        vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      if (localObject <= 31536000000L)
      {
        paramContext = paramContext.getResources().getQuantityString(a.g.fmt_month_ago, (int)(localObject / 2592000000L), new Object[] { Integer.valueOf((int)(localObject / 2592000000L)) });
        vYE.put(Long.valueOf(paramLong), paramContext);
        vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
        AppMethodBeat.o(168637);
        break;
      }
      paramContext = paramContext.getResources().getQuantityString(a.g.fmt_years_ago, (int)(localObject / 31536000000L), new Object[] { Integer.valueOf((int)(localObject / 31536000000L)) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l3));
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
  
  public static String h(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(333767);
    if (GgG.get(paramString) == null) {
      aM(paramContext, paramString);
    }
    List localList = (List)GgG.get(paramString);
    if ((paramInt >= localList.size()) || (localList.get(paramInt) == null) || (((String)localList.get(paramInt)).equals(""))) {
      aM(paramContext, paramString);
    }
    paramContext = (List)GgG.get(paramString);
    if (paramInt < paramContext.size())
    {
      paramContext = (String)paramContext.get(paramInt);
      AppMethodBeat.o(333767);
      return paramContext;
    }
    AppMethodBeat.o(333767);
    return "";
  }
  
  public static String io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(333702);
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((paramString1 == null) || (paramString1.isEmpty()))
      {
        AppMethodBeat.o(333702);
        return paramString2;
      }
      if ((paramString1.equals(z.bAM())) || (paramString1.equals(z.bAW())) || (paramString1.equals(z.bAX())))
      {
        if (paramString2.isEmpty())
        {
          AppMethodBeat.o(333702);
          return "**";
        }
        paramString1 = paramString2.charAt(0) + "**";
        AppMethodBeat.o(333702);
        return paramString1;
      }
      AppMethodBeat.o(333702);
      return paramString2;
    }
  }
  
  public static String ip(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333776);
    if (((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).yi(paramInt1))
    {
      str = qE(paramInt2);
      AppMethodBeat.o(333776);
      return str;
    }
    String str = TP(paramInt2);
    AppMethodBeat.o(333776);
    return str;
  }
  
  public static CharSequence l(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(333661);
    paramContext = DateFormat.format(paramContext.getString(a.i.fmt_normal_time_24), paramLong);
    AppMethodBeat.o(333661);
    return paramContext;
  }
  
  public static String m(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(333669);
    paramContext = n(paramContext, paramLong);
    AppMethodBeat.o(333669);
    return paramContext;
  }
  
  public static String n(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(333677);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    long l = localGregorianCalendar1.getTimeInMillis();
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6))
    {
      paramContext = paramContext.getString(a.i.fmt_pre_nowday);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(333677);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 1)
    {
      paramContext = paramContext.getString(a.i.fmt_pre_yesterday);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(333677);
      return paramContext;
    }
    if (localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6) + 2)
    {
      paramContext = paramContext.getString(a.i.fmt_pre_daybeforyesterday);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(333677);
      return paramContext;
    }
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(a.i.fmt_date), paramLong);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(333677);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(a.i.fmt_longdate), paramLong);
    vYE.put(Long.valueOf(paramLong), paramContext);
    vYD.put(Long.valueOf(paramLong), Long.valueOf(l));
    AppMethodBeat.o(333677);
    return paramContext;
  }
  
  public static String o(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(333692);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(333692);
      return "";
    }
    long l1 = System.currentTimeMillis();
    if (vYD.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)vYD.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (GgI.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)GgI.get(Long.valueOf(paramLong));
          AppMethodBeat.o(333692);
          return paramContext;
        }
      }
      else {
        vYD.remove(Long.valueOf(paramLong));
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
      paramContext = paramContext.getResources().getString(a.i.finder_activity_end_time_in_minute, new Object[] { Integer.valueOf(i) });
      GgI.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333692);
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
      paramContext = paramContext.getResources().getString(a.i.finder_activity_end_time_in_hour, new Object[] { Integer.valueOf(i) });
      GgI.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333692);
      return paramContext;
    }
    if (l2 > 86400000L)
    {
      i = Math.max((int)((paramLong - l1) / 86400000L), 1);
      paramContext = paramContext.getResources().getString(a.i.finder_activity_end_time_in_day, new Object[] { Integer.valueOf(i) });
      GgI.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333692);
      return paramContext;
    }
    AppMethodBeat.o(333692);
    return "";
  }
  
  public static String p(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(168636);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(168636);
      return "";
    }
    long l1 = localGregorianCalendar1.getTimeInMillis();
    if (vYD.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)vYD.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (vYE.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)vYE.get(Long.valueOf(paramLong));
          AppMethodBeat.o(168636);
          return paramContext;
        }
      }
      else {
        vYD.remove(Long.valueOf(paramLong));
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
      paramContext = paramContext.getResources().getString(a.i.finder_time_min_format, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
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
      paramContext = paramContext.getResources().getString(a.i.finder_time_hour_format, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    l2 = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l2 > 0L) && (l2 <= 86400000L))
    {
      paramContext = paramContext.getString(a.i.fmt_pre_yesterday) + " " + f.formatTime(paramContext.getString(a.i.fmt_normal_time_24), paramLong / 1000L);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    l2 = paramLong - (localGregorianCalendar2.getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(a.i.fmt_pre_daybeforyesterday) + " " + f.formatTime(paramContext.getString(a.i.fmt_normal_time_24), paramLong / 1000L);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(a.i.fmt_datetime, new Object[] { " " }), paramLong);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(168636);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(a.i.fmt_longdate), paramLong);
    vYE.put(Long.valueOf(paramLong), paramContext);
    vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(168636);
    return paramContext;
  }
  
  public static String q(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(333733);
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(333733);
      return "";
    }
    long l1 = System.currentTimeMillis();
    if (vYD.containsKey(Long.valueOf(paramLong))) {
      if (l1 - ((Long)vYD.get(Long.valueOf(paramLong))).longValue() < 60000L)
      {
        if (vYE.containsKey(Long.valueOf(paramLong)))
        {
          paramContext = (String)vYE.get(Long.valueOf(paramLong));
          AppMethodBeat.o(333733);
          return paramContext;
        }
      }
      else {
        vYD.remove(Long.valueOf(paramLong));
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
      paramContext = paramContext.getResources().getString(a.i.finder_time_min_format, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333733);
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
      paramContext = paramContext.getResources().getString(a.i.finder_time_hour_format, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333733);
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
      paramContext = paramContext.getResources().getQuantityString(a.g.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333733);
      return paramContext;
    }
    localGregorianCalendar2 = new GregorianCalendar();
    localGregorianCalendar2.setTimeInMillis(paramLong);
    if (localGregorianCalendar1.get(1) == localGregorianCalendar2.get(1))
    {
      paramContext = DateFormat.format(paramContext.getString(a.i.fmt_date), paramLong);
      vYE.put(Long.valueOf(paramLong), paramContext);
      vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(333733);
      return paramContext;
    }
    paramContext = DateFormat.format(paramContext.getString(a.i.fmt_longdate), paramLong);
    vYE.put(Long.valueOf(paramLong), paramContext);
    vYD.put(Long.valueOf(paramLong), Long.valueOf(l1));
    AppMethodBeat.o(333733);
    return paramContext;
  }
  
  public static String qE(long paramLong)
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
    if ((GgJ.equals("zh_CN")) || (GgJ.equals("zh_HK")) || (GgJ.equals("zh_TW")))
    {
      if (paramLong <= 9999L)
      {
        AppMethodBeat.o(168641);
        return String.valueOf(paramLong);
      }
      if (paramLong <= 99990000L)
      {
        str = MMApplicationContext.getContext().getString(a.i.finder_number_10000, new Object[] { Double.valueOf((float)paramLong * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(168641);
        return str;
      }
      str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_100000000, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 990000L)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_10000_en, new Object[] { Double.valueOf((float)paramLong * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(168641);
      return str;
    }
    if (paramLong <= 99990000L)
    {
      str = MMApplicationContext.getContext().getString(a.i.finder_number_1000000_en, new Object[] { Double.valueOf((float)paramLong * 1.0F / 1000000.0F - 0.05D) });
      AppMethodBeat.o(168641);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(a.i.finder_number_more_than_100000000_en, new Object[] { Integer.valueOf(100) });
    AppMethodBeat.o(168641);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */