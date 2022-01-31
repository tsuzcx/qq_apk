package com.tencent.mm.plugin.fts.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static final HashMap<String, String> mRf;
  private static String[] mRg;
  
  static
  {
    AppMethodBeat.i(114209);
    mRf = new HashMap();
    mRg = new String[] { "wxid_", "wx_", "gh_" };
    AppMethodBeat.o(114209);
  }
  
  public static String A(String[] paramArrayOfString)
  {
    AppMethodBeat.i(114201);
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append('(');
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      localStringBuilder.append(DatabaseUtils.sqlEscapeString(str) + ',');
      i += 1;
    }
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
    paramArrayOfString = localStringBuilder.toString();
    AppMethodBeat.o(114201);
    return paramArrayOfString;
  }
  
  public static boolean N(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(114205);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    paramLong1 = localCalendar.getTimeInMillis();
    localCalendar.setTimeInMillis(paramLong2);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    if (paramLong1 == localCalendar.getTimeInMillis())
    {
      AppMethodBeat.o(114205);
      return true;
    }
    AppMethodBeat.o(114205);
    return false;
  }
  
  public static String NA(String paramString)
  {
    AppMethodBeat.i(114206);
    ad localad = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString);
    if (localad != null)
    {
      if (!bo.isNullOrNil(localad.field_conRemark))
      {
        paramString = localad.field_conRemark;
        AppMethodBeat.o(114206);
        return paramString;
      }
      if (!bo.isNullOrNil(localad.field_nickname))
      {
        paramString = localad.field_nickname;
        AppMethodBeat.o(114206);
        return paramString;
      }
      if (t.nI(localad.field_username))
      {
        paramString = ((c)com.tencent.mm.kernel.g.E(c.class)).YJ().nE(paramString);
        if (!bo.isNullOrNil(paramString))
        {
          AppMethodBeat.o(114206);
          return paramString;
        }
      }
      paramString = localad.field_username;
      AppMethodBeat.o(114206);
      return paramString;
    }
    AppMethodBeat.o(114206);
    return paramString;
  }
  
  public static String OY(String paramString)
  {
    AppMethodBeat.i(114189);
    if (t.nI(paramString))
    {
      AppMethodBeat.o(114189);
      return paramString;
    }
    ad localad = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString);
    if (localad == null)
    {
      AppMethodBeat.o(114189);
      return paramString;
    }
    if (!bo.isNullOrNil(localad.field_conRemarkPYFull))
    {
      paramString = localad.field_conRemarkPYFull;
      AppMethodBeat.o(114189);
      return paramString;
    }
    if (!bo.isNullOrNil(localad.Hu()))
    {
      paramString = localad.Hu();
      AppMethodBeat.o(114189);
      return paramString;
    }
    if (!bo.isNullOrNil(localad.Hq()))
    {
      paramString = localad.Hq();
      AppMethodBeat.o(114189);
      return paramString;
    }
    AppMethodBeat.o(114189);
    return paramString;
  }
  
  public static final String OZ(String paramString)
  {
    AppMethodBeat.i(114196);
    if (paramString == null)
    {
      AppMethodBeat.o(114196);
      return null;
    }
    paramString = paramString.trim();
    paramString = g.Pf(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).dH(paramString, " "));
    AppMethodBeat.o(114196);
    return paramString;
  }
  
  public static final String Pa(String paramString)
  {
    AppMethodBeat.i(114197);
    paramString = g.Pf(paramString.toLowerCase());
    AppMethodBeat.o(114197);
    return paramString;
  }
  
  public static final String Pb(String paramString)
  {
    AppMethodBeat.i(114198);
    if (paramString != null)
    {
      paramString = paramString.replace('*', ' ').trim();
      AppMethodBeat.o(114198);
      return paramString;
    }
    AppMethodBeat.o(114198);
    return null;
  }
  
  public static boolean Pc(String paramString)
  {
    AppMethodBeat.i(114203);
    if (paramString == null)
    {
      AppMethodBeat.o(114203);
      return false;
    }
    if ((paramString.length() < 20) && (paramString.matches("^[0-9]+$")))
    {
      AppMethodBeat.o(114203);
      return true;
    }
    AppMethodBeat.o(114203);
    return false;
  }
  
  public static boolean Pd(String paramString)
  {
    AppMethodBeat.i(114204);
    if (paramString == null)
    {
      AppMethodBeat.o(114204);
      return false;
    }
    if ((paramString.length() < 20) && (paramString.matches("^[A-Za-z0-9\\-_]+$")))
    {
      AppMethodBeat.o(114204);
      return true;
    }
    AppMethodBeat.o(114204);
    return false;
  }
  
  private static long Pe(String paramString)
  {
    AppMethodBeat.i(142957);
    try
    {
      char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      char[] arrayOfChar2 = new char[paramString.length * 2];
      int i = 0;
      while (i < paramString.length)
      {
        int j = paramString[i] & 0xFF;
        arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
        arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
        i += 1;
      }
      long l = new BigInteger(new String(arrayOfChar2), 16).longValue();
      AppMethodBeat.o(142957);
      return l;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.FTS.FTSApiLogic", paramString, "getMd5UInt", new Object[0]);
      AppMethodBeat.o(142957);
    }
    return 0L;
  }
  
  public static int a(Map<Integer, Integer> paramMap, int paramInt1, int paramInt2)
  {
    int i = 2147483647;
    AppMethodBeat.i(114194);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(114194);
      return 0;
    }
    Integer localInteger = (Integer)paramMap.get(Integer.valueOf(paramInt1));
    if (localInteger == null)
    {
      paramInt1 = 2147483647;
      paramMap = (Integer)paramMap.get(Integer.valueOf(paramInt2));
      if (paramMap != null) {
        break label81;
      }
    }
    label81:
    for (paramInt2 = i;; paramInt2 = paramMap.intValue())
    {
      AppMethodBeat.o(114194);
      return paramInt1 - paramInt2;
      paramInt1 = localInteger.intValue();
      break;
    }
  }
  
  public static List<l> a(List<l> paramList, Map<Integer, Integer> paramMap)
  {
    AppMethodBeat.i(114195);
    paramMap = new d.1(paramMap);
    l locall = new l();
    locall.type = 131073;
    int j = Collections.binarySearch(paramList, locall, paramMap);
    locall.type = 131074;
    int k = Collections.binarySearch(paramList, locall, paramMap);
    int i = j;
    if (j < 0)
    {
      j = -j - 1;
      if (k >= 0) {
        break label130;
      }
      i = -k - 1;
    }
    for (;;)
    {
      paramList = paramList.subList(j, i);
      AppMethodBeat.o(114195);
      return paramList;
      do
      {
        i -= 1;
      } while ((i >= 0) && (((l)paramList.get(i)).type == 131073));
      j = i + 1;
      break;
      label130:
      int m = paramList.size();
      i = k + 1;
      while ((i < m) && (((l)paramList.get(i)).type == 131074)) {
        i += 1;
      }
    }
  }
  
  public static String aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(114200);
    if (paramString == null)
    {
      AppMethodBeat.o(114200);
      return null;
    }
    String str = OZ(paramString).toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < str.length())
    {
      char c = str.charAt(i);
      if (g.w(c))
      {
        String[] arrayOfString = (String[])g.mRL.get(String.valueOf(c));
        if ((arrayOfString != null) && (arrayOfString.length > 0) && (arrayOfString[0].length() > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          j = 0;
          if (j < arrayOfString.length)
          {
            if (paramBoolean) {}
            for (paramString = arrayOfString[j].substring(0, 1);; paramString = arrayOfString[j])
            {
              if (!localArrayList2.contains(paramString)) {
                localArrayList2.add(paramString);
              }
              j += 1;
              break;
            }
          }
          localArrayList1.add(bo.d(localArrayList2, "‏"));
          j = 1;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList1.add(" ");
        continue;
        localArrayList1.add(" ");
      }
    }
    if (j != 0)
    {
      paramString = bo.d(localArrayList1, "‍");
      AppMethodBeat.o(114200);
      return paramString;
    }
    AppMethodBeat.o(114200);
    return null;
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(114208);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = ah.dsO() + ".plugin.fts";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(ah.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramContext.startActivity(localIntent, paramBundle);
        AppMethodBeat.o(114208);
        return;
      }
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent, paramBundle);
      AppMethodBeat.o(114208);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(114208);
    }
  }
  
  public static final HashMap<String, String> bBU()
  {
    AppMethodBeat.i(114190);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = mRf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(114190);
    return localHashMap;
  }
  
  public static final void bT(List<l> paramList)
  {
    AppMethodBeat.i(114191);
    mRf.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l locall = (l)paramList.next();
      if ((locall.userData instanceof String)) {
        mRf.put(locall.mRV, (String)locall.userData);
      } else {
        mRf.put(locall.mRV, "");
      }
    }
    AppMethodBeat.o(114191);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(114207);
    try
    {
      String str2 = ah.dsO() + ".plugin.fts";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(ah.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramContext.startActivity(paramIntent);
        AppMethodBeat.o(114207);
        return;
      }
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
      AppMethodBeat.o(114207);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(114207);
    }
  }
  
  public static boolean e(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == paramArrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114199);
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      AppMethodBeat.o(114199);
      return paramString2;
    }
    paramString2 = mRg;
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      if (paramString1.startsWith(paramString2[i]))
      {
        AppMethodBeat.o(114199);
        return null;
      }
      i += 1;
    }
    if (paramString1.indexOf('@') >= 0)
    {
      AppMethodBeat.o(114199);
      return null;
    }
    AppMethodBeat.o(114199);
    return paramString1;
  }
  
  public static int f(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 2147483647;
    if (paramInt1 == paramInt2) {
      return 0;
    }
    if (paramInt1 >= paramArrayOfInt.length)
    {
      paramInt1 = 2147483647;
      if (paramInt2 < paramArrayOfInt.length) {
        break label38;
      }
    }
    label38:
    for (paramInt2 = i;; paramInt2 = paramArrayOfInt[paramInt2])
    {
      return paramInt1 - paramInt2;
      paramInt1 = paramArrayOfInt[paramInt1];
      break;
    }
  }
  
  public static boolean h(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(114202);
    if (Arrays.binarySearch(paramArrayOfInt, paramInt) >= 0)
    {
      AppMethodBeat.o(114202);
      return true;
    }
    AppMethodBeat.o(114202);
    return false;
  }
  
  public static String v(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114192);
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('(');
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfInt[i]).append(',');
      i += 1;
    }
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
    paramArrayOfInt = localStringBuilder.toString();
    AppMethodBeat.o(114192);
    return paramArrayOfInt;
  }
  
  public static long wp(int paramInt)
  {
    AppMethodBeat.i(142956);
    StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis()).append("_");
    com.tencent.mm.kernel.g.RJ();
    long l = Pe(com.tencent.mm.kernel.a.QC() + "_" + paramInt);
    AppMethodBeat.o(142956);
    return l;
  }
  
  public static final String z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(114193);
    StringBuilder localStringBuilder = new StringBuilder(32);
    int k = paramArrayOfString.length;
    int j = 0;
    if (j < k)
    {
      String str = paramArrayOfString[j];
      localStringBuilder.append("\"");
      localStringBuilder.append(str);
      int i = str.charAt(str.length() - 1);
      if ((i >= 48) && (i <= 57))
      {
        i = 1;
        label76:
        if (i == 0) {
          break label135;
        }
        localStringBuilder.append("\"* ");
      }
      for (;;)
      {
        j += 1;
        break;
        if ((i >= 65) && (i <= 90))
        {
          i = 1;
          break label76;
        }
        if ((i >= 97) && (i <= 122))
        {
          i = 1;
          break label76;
        }
        i = 0;
        break label76;
        label135:
        localStringBuilder.append("\" ");
      }
    }
    paramArrayOfString = localStringBuilder.toString().trim();
    AppMethodBeat.o(114193);
    return paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d
 * JD-Core Version:    0.7.0.1
 */