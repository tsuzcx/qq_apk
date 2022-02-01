package com.tencent.mm.plugin.fts.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
  private static final HashMap<String, String> HrH;
  private static String[] HrI;
  
  static
  {
    AppMethodBeat.i(131643);
    HrH = new HashMap();
    HrI = new String[] { "wxid_", "wx_", "gh_" };
    AppMethodBeat.o(131643);
  }
  
  public static String G(int[] paramArrayOfInt)
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
  
  public static final String I(String[] paramArrayOfString)
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
  
  public static String J(String[] paramArrayOfString)
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
  
  public static long Wd(int paramInt)
  {
    AppMethodBeat.i(131641);
    StringBuilder localStringBuilder = new StringBuilder().append(System.currentTimeMillis()).append("_");
    h.baC();
    long l = aEm(com.tencent.mm.kernel.b.aZs() + "_" + paramInt);
    AppMethodBeat.o(131641);
    return l;
  }
  
  public static String We(int paramInt)
  {
    AppMethodBeat.i(265556);
    Object localObject = new StringBuilder().append(System.currentTimeMillis()).append("_");
    h.baC();
    localObject = e.rr(aEm(com.tencent.mm.kernel.b.aZs() + "_" + paramInt));
    AppMethodBeat.o(265556);
    return localObject;
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
  
  public static String aEf(String paramString)
  {
    AppMethodBeat.i(131621);
    if (au.bwE(paramString))
    {
      AppMethodBeat.o(131621);
      return paramString;
    }
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (localau == null)
    {
      AppMethodBeat.o(131621);
      return paramString;
    }
    if (!Util.isNullOrNil(localau.field_conRemarkPYFull))
    {
      paramString = localau.field_conRemarkPYFull;
      AppMethodBeat.o(131621);
      return paramString;
    }
    if (!Util.isNullOrNil(localau.aJu()))
    {
      paramString = localau.aJu();
      AppMethodBeat.o(131621);
      return paramString;
    }
    if (!Util.isNullOrNil(localau.aJs()))
    {
      paramString = localau.aJs();
      AppMethodBeat.o(131621);
      return paramString;
    }
    AppMethodBeat.o(131621);
    return paramString;
  }
  
  public static final String aEg(String paramString)
  {
    AppMethodBeat.i(131628);
    if (paramString == null)
    {
      AppMethodBeat.o(131628);
      return null;
    }
    paramString = paramString.trim();
    paramString = g.aEo(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).gF(paramString, " "));
    AppMethodBeat.o(131628);
    return paramString;
  }
  
  public static final String aEh(String paramString)
  {
    AppMethodBeat.i(131629);
    paramString = g.aEo(paramString.toLowerCase());
    AppMethodBeat.o(131629);
    return paramString;
  }
  
  public static final String aEi(String paramString)
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
  
  public static String aEj(String paramString)
  {
    AppMethodBeat.i(265534);
    if (paramString == null)
    {
      AppMethodBeat.o(265534);
      return null;
    }
    paramString = aEg(paramString).replace(" ", "").toUpperCase();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (g.C(c))
      {
        String[] arrayOfString = (String[])g.Hso.get(String.valueOf(c));
        if ((arrayOfString != null) && (arrayOfString.length > 0) && (arrayOfString[0].length() > 0)) {
          localArrayList.add(arrayOfString[0].toUpperCase());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(String.valueOf(c));
        continue;
        localArrayList.add(String.valueOf(c));
      }
    }
    paramString = Util.listToString(localArrayList, "");
    AppMethodBeat.o(265534);
    return paramString;
  }
  
  public static boolean aEk(String paramString)
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
  
  public static boolean aEl(String paramString)
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
  
  private static long aEm(String paramString)
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
      Log.printErrStackTrace("MicroMsg.FTS.FTSApiLogic", paramString, "getMd5UInt", new Object[0]);
      AppMethodBeat.o(131642);
    }
    return 0L;
  }
  
  public static String atS(String paramString)
  {
    AppMethodBeat.i(131638);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (localau != null)
    {
      if (!Util.isNullOrNil(localau.field_conRemark))
      {
        paramString = localau.field_conRemark;
        AppMethodBeat.o(131638);
        return paramString;
      }
      if (!Util.isNullOrNil(localau.field_nickname))
      {
        paramString = localau.aSU();
        AppMethodBeat.o(131638);
        return paramString;
      }
      if (au.bwE(localau.field_username))
      {
        paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().getDisplayName(paramString);
        if (!Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(131638);
          return paramString;
        }
      }
      paramString = localau.field_username;
      AppMethodBeat.o(131638);
      return paramString;
    }
    AppMethodBeat.o(131638);
    return paramString;
  }
  
  public static List<o> b(List<o> paramList, Map<Integer, Integer> paramMap)
  {
    AppMethodBeat.i(131627);
    paramMap = new Comparator() {};
    o localo = new o();
    localo.type = 131073;
    int j = Collections.binarySearch(paramList, localo, paramMap);
    localo.type = 131074;
    int k = Collections.binarySearch(paramList, localo, paramMap);
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
      AppMethodBeat.o(131627);
      return paramList;
      do
      {
        i -= 1;
      } while ((i >= 0) && (((o)paramList.get(i)).type == 131073));
      j = i + 1;
      break;
      label130:
      int m = paramList.size();
      i = k + 1;
      while ((i < m) && (((o)paramList.get(i)).type == 131074)) {
        i += 1;
      }
    }
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(131640);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      String str = MMApplicationContext.getSourcePackageName() + ".plugin.fts";
      paramIntent = paramString;
      if (paramString.startsWith(".")) {
        paramIntent = str + paramString;
      }
      localIntent.setClassName(MMApplicationContext.getPackageName(), paramIntent);
      Class.forName(paramIntent, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle).cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        paramContext.startActivity((Intent)paramString.sb(0), (Bundle)paramString.sb(1));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(131640);
        return;
      }
      localIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle).cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      paramContext.startActivity((Intent)paramString.sb(0), (Bundle)paramString.sb(1));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(131640);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(131640);
    }
  }
  
  public static String bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131632);
    if (paramString == null)
    {
      AppMethodBeat.o(131632);
      return null;
    }
    String str = aEg(paramString).toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < str.length())
    {
      char c = str.charAt(i);
      if (g.C(c))
      {
        String[] arrayOfString = (String[])g.Hso.get(String.valueOf(c));
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
          localArrayList1.add(Util.listToString(localArrayList2, "‏"));
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
      paramString = Util.listToString(localArrayList1, "‍");
      AppMethodBeat.o(131632);
      return paramString;
    }
    AppMethodBeat.o(131632);
    return null;
  }
  
  public static void d(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(131639);
    try
    {
      String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.fts";
      String str1 = paramString;
      if (paramString.startsWith(".")) {
        str1 = str2 + paramString;
      }
      paramIntent.setClassName(MMApplicationContext.getPackageName(), str1);
      Class.forName(str1, false, paramContext.getClassLoader());
      if ((paramContext instanceof Activity))
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(131639);
        return;
      }
      paramIntent.addFlags(268435456);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/fts/api/FTSApiLogic", "startFTSActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(131639);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.FTS.FTSApiLogic", "Class Not Found when startActivity %s", new Object[] { paramContext });
      AppMethodBeat.o(131639);
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
  
  public static final HashMap<String, String> fxs()
  {
    AppMethodBeat.i(131622);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = HrH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(131622);
    return localHashMap;
  }
  
  public static final void hQ(List<o> paramList)
  {
    AppMethodBeat.i(131623);
    HrH.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o localo = (o)paramList.next();
      if ((localo.HtQ instanceof String)) {
        HrH.put(localo.Hsz, (String)localo.HtQ);
      } else {
        HrH.put(localo.Hsz, "");
      }
    }
    AppMethodBeat.o(131623);
  }
  
  public static String iC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131631);
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      AppMethodBeat.o(131631);
      return paramString2;
    }
    paramString2 = HrI;
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
  
  public static boolean isSameDay(long paramLong1, long paramLong2)
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
  
  public static int j(int[] paramArrayOfInt, int paramInt1, int paramInt2)
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
  
  public static boolean x(int[] paramArrayOfInt, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d
 * JD-Core Version:    0.7.0.1
 */