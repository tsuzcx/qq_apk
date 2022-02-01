package com.tencent.mm.plugin.fts.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static final HashMap<String, String> swQ;
  private static String[] swR;
  
  static
  {
    AppMethodBeat.i(131643);
    swQ = new HashMap();
    swR = new String[] { "wxid_", "wx_", "gh_" };
    AppMethodBeat.o(131643);
  }
  
  public static final String F(String[] paramArrayOfString)
  {
    AppMethodBeat.i(131625);
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
        label74:
        if (i == 0) {
          break label132;
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
          break label74;
        }
        if ((i >= 97) && (i <= 122))
        {
          i = 1;
          break label74;
        }
        i = 0;
        break label74;
        label132:
        localStringBuilder.append("\" ");
      }
    }
    paramArrayOfString = localStringBuilder.toString().trim();
    AppMethodBeat.o(131625);
    return paramArrayOfString;
  }
  
  public static long Fx(int paramInt)
  {
    AppMethodBeat.i(131641);
    StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis()).append("_");
    com.tencent.mm.kernel.g.agP();
    long l = afU(com.tencent.mm.kernel.a.afE() + "_" + paramInt);
    AppMethodBeat.o(131641);
    return l;
  }
  
  public static String G(String[] paramArrayOfString)
  {
    AppMethodBeat.i(131633);
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
    AppMethodBeat.o(131633);
    return paramArrayOfString;
  }
  
  public static boolean S(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131637);
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
      AppMethodBeat.o(131637);
      return true;
    }
    AppMethodBeat.o(131637);
    return false;
  }
  
  public static int a(Map<Integer, Integer> paramMap, int paramInt1, int paramInt2)
  {
    int i = 2147483647;
    AppMethodBeat.i(131626);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(131626);
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
      AppMethodBeat.o(131626);
      return paramInt1 - paramInt2;
      paramInt1 = localInteger.intValue();
      break;
    }
  }
  
  public static List<m> a(List<m> paramList, Map<Integer, Integer> paramMap)
  {
    AppMethodBeat.i(131627);
    paramMap = new Comparator() {};
    m localm = new m();
    localm.type = 131073;
    int j = Collections.binarySearch(paramList, localm, paramMap);
    localm.type = 131074;
    int k = Collections.binarySearch(paramList, localm, paramMap);
    int i = j;
    if (j < 0)
    {
      j = -j - 1;
      if (k >= 0) {
        break label125;
      }
      i = -k - 1;
    }
    for (;;)
    {
      paramList = paramList.subList(j, i);
      AppMethodBeat.o(131627);
      return paramList;
      do
      {
        i -= 1;
      } while ((i >= 0) && (((m)paramList.get(i)).type == 131073));
      j = i + 1;
      break;
      label125:
      int m = paramList.size();
      i = k + 1;
      while ((i < m) && (((m)paramList.get(i)).type == 131074)) {
        i += 1;
      }
    }
  }
  
  public static String acr(String paramString)
  {
    AppMethodBeat.i(131638);
    com.tencent.mm.storage.ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString);
    if (localai != null)
    {
      if (!bs.isNullOrNil(localai.field_conRemark))
      {
        paramString = localai.field_conRemark;
        AppMethodBeat.o(131638);
        return paramString;
      }
      if (!bs.isNullOrNil(localai.field_nickname))
      {
        paramString = localai.field_nickname;
        AppMethodBeat.o(131638);
        return paramString;
      }
      if (w.wo(localai.field_username))
      {
        paramString = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().wk(paramString);
        if (!bs.isNullOrNil(paramString))
        {
          AppMethodBeat.o(131638);
          return paramString;
        }
      }
      paramString = localai.field_username;
      AppMethodBeat.o(131638);
      return paramString;
    }
    AppMethodBeat.o(131638);
    return paramString;
  }
  
  public static String afO(String paramString)
  {
    AppMethodBeat.i(131621);
    if (w.wo(paramString))
    {
      AppMethodBeat.o(131621);
      return paramString;
    }
    com.tencent.mm.storage.ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString);
    if (localai == null)
    {
      AppMethodBeat.o(131621);
      return paramString;
    }
    if (!bs.isNullOrNil(localai.field_conRemarkPYFull))
    {
      paramString = localai.field_conRemarkPYFull;
      AppMethodBeat.o(131621);
      return paramString;
    }
    if (!bs.isNullOrNil(localai.Tp()))
    {
      paramString = localai.Tp();
      AppMethodBeat.o(131621);
      return paramString;
    }
    if (!bs.isNullOrNil(localai.Tl()))
    {
      paramString = localai.Tl();
      AppMethodBeat.o(131621);
      return paramString;
    }
    AppMethodBeat.o(131621);
    return paramString;
  }
  
  public static final String afP(String paramString)
  {
    AppMethodBeat.i(131628);
    if (paramString == null)
    {
      AppMethodBeat.o(131628);
      return null;
    }
    paramString = paramString.trim();
    paramString = g.afW(((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).fh(paramString, " "));
    AppMethodBeat.o(131628);
    return paramString;
  }
  
  public static final String afQ(String paramString)
  {
    AppMethodBeat.i(131629);
    paramString = g.afW(paramString.toLowerCase());
    AppMethodBeat.o(131629);
    return paramString;
  }
  
  public static final String afR(String paramString)
  {
    AppMethodBeat.i(131630);
    if (paramString != null)
    {
      paramString = paramString.replace('*', ' ').trim();
      AppMethodBeat.o(131630);
      return paramString;
    }
    AppMethodBeat.o(131630);
    return null;
  }
  
  public static boolean afS(String paramString)
  {
    AppMethodBeat.i(131635);
    if (paramString == null)
    {
      AppMethodBeat.o(131635);
      return false;
    }
    if ((paramString.length() < 20) && (paramString.matches("^[0-9]+$")))
    {
      AppMethodBeat.o(131635);
      return true;
    }
    AppMethodBeat.o(131635);
    return false;
  }
  
  public static boolean afT(String paramString)
  {
    AppMethodBeat.i(131636);
    if (paramString == null)
    {
      AppMethodBeat.o(131636);
      return false;
    }
    if ((paramString.length() < 20) && (paramString.matches("^[A-Za-z][A-Za-z0-9\\-_]+$")))
    {
      AppMethodBeat.o(131636);
      return true;
    }
    AppMethodBeat.o(131636);
    return false;
  }
  
  private static long afU(String paramString)
  {
    AppMethodBeat.i(131642);
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
      AppMethodBeat.o(131642);
      return l;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.FTS.FTSApiLogic", paramString, "getMd5UInt", new Object[0]);
      AppMethodBeat.o(131642);
    }
    return 0L;
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(131640);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = com.tencent.mm.sdk.platformtools.ai.eUW() + ".plugin.fts";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.ai.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle).ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.lR(0), (Bundle)paramString.lR(1));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(131640);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle).ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.lR(0), (Bundle)paramString.lR(1));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(131640);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(131640);
    }
  }
  
  public static String bf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131632);
    if (paramString == null)
    {
      AppMethodBeat.o(131632);
      return null;
    }
    String str = afP(paramString).toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < str.length())
    {
      char c = str.charAt(i);
      if (g.y(c))
      {
        String[] arrayOfString = (String[])g.sxw.get(String.valueOf(c));
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
          localArrayList1.add(bs.n(localArrayList2, "‏"));
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
      paramString = bs.n(localArrayList1, "‍");
      AppMethodBeat.o(131632);
      return paramString;
    }
    AppMethodBeat.o(131632);
    return null;
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(131639);
    try
    {
      String str2 = com.tencent.mm.sdk.platformtools.ai.eUW() + ".plugin.fts";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(com.tencent.mm.sdk.platformtools.ai.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(131639);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(131639);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(131639);
    }
  }
  
  public static final HashMap<String, String> cKt()
  {
    AppMethodBeat.i(131622);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = swQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(131622);
    return localHashMap;
  }
  
  public static final void dI(List<m> paramList)
  {
    AppMethodBeat.i(131623);
    swQ.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      if ((localm.userData instanceof String)) {
        swQ.put(localm.sxG, (String)localm.userData);
      } else {
        swQ.put(localm.sxG, "");
      }
    }
    AppMethodBeat.o(131623);
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
  
  public static boolean f(int paramInt, int[] paramArrayOfInt)
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
  
  public static String gA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131631);
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      AppMethodBeat.o(131631);
      return paramString2;
    }
    paramString2 = swR;
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      if (paramString1.startsWith(paramString2[i]))
      {
        AppMethodBeat.o(131631);
        return null;
      }
      i += 1;
    }
    if (paramString1.indexOf('@') >= 0)
    {
      AppMethodBeat.o(131631);
      return null;
    }
    AppMethodBeat.o(131631);
    return paramString1;
  }
  
  public static boolean k(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(131634);
    if (Arrays.binarySearch(paramArrayOfInt, paramInt) >= 0)
    {
      AppMethodBeat.o(131634);
      return true;
    }
    AppMethodBeat.o(131634);
    return false;
  }
  
  public static String z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131624);
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
    AppMethodBeat.o(131624);
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d
 * JD-Core Version:    0.7.0.1
 */