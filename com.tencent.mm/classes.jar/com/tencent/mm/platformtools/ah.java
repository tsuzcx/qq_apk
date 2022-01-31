package com.tencent.mm.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Debug;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.g;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class ah
{
  private static final TimeZone GMT;
  private static final long[] glS;
  
  static
  {
    AppMethodBeat.i(16706);
    glS = new long[] { 300L, 200L, 300L, 200L };
    GMT = TimeZone.getTimeZone("GMT");
    AppMethodBeat.o(16706);
  }
  
  public static boolean M(Context paramContext, String paramString)
  {
    AppMethodBeat.i(16701);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if (!k(paramContext, localIntent))
    {
      ab.e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(16701);
      return false;
    }
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(16701);
    return true;
  }
  
  public static boolean a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(16705);
    if (paramView == null)
    {
      AppMethodBeat.o(16705);
      return false;
    }
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext == null)
    {
      AppMethodBeat.o(16705);
      return false;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null)
    {
      AppMethodBeat.o(16705);
      return false;
    }
    try
    {
      bool = paramContext.hideSoftInputFromWindow(paramView, 0);
      AppMethodBeat.o(16705);
      return bool;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.Util", "hide VKB(View) exception %s", new Object[] { paramContext });
        boolean bool = false;
      }
    }
  }
  
  public static int aW(Object paramObject)
  {
    AppMethodBeat.i(16697);
    if (paramObject == null)
    {
      AppMethodBeat.o(16697);
      return 0;
    }
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(16697);
      return i;
    }
    if ((paramObject instanceof Long))
    {
      i = ((Long)paramObject).intValue();
      AppMethodBeat.o(16697);
      return i;
    }
    AppMethodBeat.o(16697);
    return 0;
  }
  
  public static ah.a aoA()
  {
    AppMethodBeat.i(16702);
    ah.a locala = new ah.a();
    AppMethodBeat.o(16702);
    return locala;
  }
  
  public static long aox()
  {
    AppMethodBeat.i(16678);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(16678);
    return l;
  }
  
  public static long aoy()
  {
    AppMethodBeat.i(16680);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(16680);
    return l;
  }
  
  public static void aoz()
  {
    AppMethodBeat.i(16689);
    ab.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", new Object[] { hk(Debug.getGlobalAllocSize()), hk(Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize()), hk(Debug.getGlobalExternalAllocSize()), hk(Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize()), hk(Debug.getNativeHeapAllocatedSize()), hk(Debug.getNativeHeapSize()) });
    AppMethodBeat.o(16689);
  }
  
  public static long av(long paramLong)
  {
    AppMethodBeat.i(16683);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(16683);
    return l - paramLong;
  }
  
  public static String bf(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static List<String> bg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(16703);
    String str = null;
    if (paramString1 != null)
    {
      paramString2 = Pattern.compile(paramString2).matcher(paramString1);
      int j = paramString2.groupCount();
      int i = 1;
      paramString1 = new ArrayList();
      str = paramString1;
      if (paramString2.find()) {
        for (;;)
        {
          str = paramString1;
          if (i > j) {
            break;
          }
          paramString1.add(paramString2.group(i));
          i += 1;
        }
      }
    }
    AppMethodBeat.o(16703);
    return str;
  }
  
  public static long c(Long paramLong)
  {
    AppMethodBeat.i(16691);
    if (paramLong == null)
    {
      AppMethodBeat.o(16691);
      return 0L;
    }
    long l = paramLong.longValue();
    AppMethodBeat.o(16691);
    return l;
  }
  
  public static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(16685);
    String str = paramContext.getClass().getName();
    paramContext = ch(paramContext);
    ab.d("MicroMsg.Util", "top activity=" + paramContext + ", context=" + str);
    boolean bool = paramContext.equalsIgnoreCase(str);
    AppMethodBeat.o(16685);
    return bool;
  }
  
  public static boolean cC(Context paramContext)
  {
    AppMethodBeat.i(16704);
    if (d.bSu() != null) {
      d.bSu().bSs();
    }
    if ((g.bWw & 0x1) != 0)
    {
      ab.e("MicroMsg.Util", "package has set external update mode");
      Uri localUri = Uri.parse(g.ymK);
      Intent localIntent = new Intent("android.intent.action.VIEW", localUri).addFlags(268435456);
      if ((localUri == null) || (localIntent == null) || (!k(paramContext, localIntent)))
      {
        ab.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
      }
      for (;;)
      {
        AppMethodBeat.o(16704);
        return true;
        ab.i("MicroMsg.Util", "parse market uri ok");
        paramContext.startActivity(localIntent);
      }
    }
    com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000L).commit();
    if (d.bSu() != null)
    {
      paramContext = d.bSu().c(paramContext, new ah.1());
      if (paramContext == null)
      {
        AppMethodBeat.o(16704);
        return false;
      }
      paramContext.update(3);
    }
    AppMethodBeat.o(16704);
    return true;
  }
  
  public static boolean cN(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
  
  public static boolean cO(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
  }
  
  private static String ch(Context paramContext)
  {
    AppMethodBeat.i(16686);
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      ab.i("MicroMsg.Util", "top activity name =".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(16686);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(16686);
    }
    return "(null)";
  }
  
  public static long d(Long paramLong)
  {
    AppMethodBeat.i(16695);
    if (paramLong == null)
    {
      AppMethodBeat.o(16695);
      return 0L;
    }
    long l = paramLong.longValue();
    AppMethodBeat.o(16695);
    return l;
  }
  
  public static String d(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(16675);
    if (paramList == null)
    {
      AppMethodBeat.o(16675);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    if (i < paramList.size())
    {
      if (i == paramList.size() - 1) {
        localStringBuilder.append(((String)paramList.get(i)).trim());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(((String)paramList.get(i)).trim() + paramString);
      }
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(16675);
    return paramList;
  }
  
  public static boolean d(Boolean paramBoolean)
  {
    AppMethodBeat.i(16692);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(16692);
      return true;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(16692);
    return bool;
  }
  
  public static boolean e(Boolean paramBoolean)
  {
    AppMethodBeat.i(16693);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(16693);
      return false;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(16693);
    return bool;
  }
  
  public static boolean f(Boolean paramBoolean)
  {
    AppMethodBeat.i(16696);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(16696);
      return true;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(16696);
    return bool;
  }
  
  public static int g(Integer paramInteger)
  {
    AppMethodBeat.i(16690);
    if (paramInteger == null)
    {
      AppMethodBeat.o(16690);
      return 0;
    }
    int i = paramInteger.intValue();
    AppMethodBeat.o(16690);
    return i;
  }
  
  @Deprecated
  public static int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(16699);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(16699);
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(16699);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(16699);
    }
    return paramInt;
  }
  
  public static long gz(long paramLong)
  {
    AppMethodBeat.i(16681);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(16681);
    return l - paramLong;
  }
  
  public static int h(Integer paramInteger)
  {
    AppMethodBeat.i(16694);
    if (paramInteger == null)
    {
      AppMethodBeat.o(16694);
      return 0;
    }
    int i = paramInteger.intValue();
    AppMethodBeat.o(16694);
    return i;
  }
  
  public static List<String> h(String[] paramArrayOfString)
  {
    AppMethodBeat.i(16676);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(16676);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(16676);
    return localArrayList;
  }
  
  public static String hk(long paramLong)
  {
    AppMethodBeat.i(16677);
    float f;
    if (paramLong >> 20 > 0L)
    {
      f = Math.round((float)paramLong * 10.0F / 1048576.0F) / 10.0F;
      str = f + "MB";
      AppMethodBeat.o(16677);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      f = Math.round((float)paramLong * 10.0F / 1024.0F) / 10.0F;
      str = f + "KB";
      AppMethodBeat.o(16677);
      return str;
    }
    String str = paramLong + "B";
    AppMethodBeat.o(16677);
    return str;
  }
  
  public static long hl(long paramLong)
  {
    AppMethodBeat.i(16682);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(16682);
    return l - paramLong;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(16698);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(16698);
      return true;
    }
    AppMethodBeat.o(16698);
    return false;
  }
  
  private static boolean k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(16687);
    if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0)
    {
      AppMethodBeat.o(16687);
      return true;
    }
    AppMethodBeat.o(16687);
    return false;
  }
  
  @Deprecated
  public static long lU(String paramString)
  {
    AppMethodBeat.i(16700);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(16700);
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      long l;
      ab.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(16700);
    }
    l = Long.parseLong(paramString);
    AppMethodBeat.o(16700);
    return l;
    return -1L;
  }
  
  public static String mH(int paramInt)
  {
    AppMethodBeat.i(16679);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(16679);
    return str;
  }
  
  public static boolean mI(int paramInt)
  {
    AppMethodBeat.i(16688);
    long l1 = paramInt * 1000L;
    long l2 = l1 - System.currentTimeMillis();
    ab.d("MicroMsg.Util", "time " + l1 + "  systime " + System.currentTimeMillis() + " diff " + l2);
    if (l2 < 0L)
    {
      AppMethodBeat.o(16688);
      return true;
    }
    AppMethodBeat.o(16688);
    return false;
  }
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String wC(String paramString)
  {
    AppMethodBeat.i(16674);
    String str = paramString;
    if (paramString != null) {
      str = paramString.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
    }
    AppMethodBeat.o(16674);
    return str;
  }
  
  public static long yB()
  {
    AppMethodBeat.i(16684);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(16684);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.ah
 * JD-Core Version:    0.7.0.1
 */