package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Debug;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.e;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class af
{
  private static final TimeZone GMT;
  private static final long[] VIRBRATOR_PATTERN;
  
  static
  {
    AppMethodBeat.i(20749);
    VIRBRATOR_PATTERN = new long[] { 300L, 200L, 300L, 200L };
    GMT = TimeZone.getTimeZone("GMT");
    AppMethodBeat.o(20749);
  }
  
  @Deprecated
  public static long Fk(String paramString)
  {
    AppMethodBeat.i(20743);
    if (paramString == null) {}
    try
    {
      AppMethodBeat.o(20743);
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      long l;
      AppMethodBeat.o(20743);
    }
    l = Long.parseLong(paramString);
    AppMethodBeat.o(20743);
    return l;
    return -1L;
  }
  
  public static boolean a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(20748);
    if (paramView == null)
    {
      AppMethodBeat.o(20748);
      return false;
    }
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext == null)
    {
      AppMethodBeat.o(20748);
      return false;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null)
    {
      AppMethodBeat.o(20748);
      return false;
    }
    try
    {
      bool = paramContext.hideSoftInputFromWindow(paramView, 0);
      AppMethodBeat.o(20748);
      return bool;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.Util", "hide VKB(View) exception %s", new Object[] { paramContext });
        boolean bool = false;
      }
    }
  }
  
  public static List<String> bS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20746);
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
    AppMethodBeat.o(20746);
    return str;
  }
  
  public static void blM()
  {
    AppMethodBeat.i(20732);
    Log.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", new Object[] { getSizeKB(Debug.getGlobalAllocSize()), getSizeKB(Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize()), getSizeKB(Debug.getGlobalExternalAllocSize()), getSizeKB(Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize()), getSizeKB(Debug.getNativeHeapAllocatedSize()), getSizeKB(Debug.getNativeHeapSize()) });
    AppMethodBeat.o(20732);
  }
  
  public static a blN()
  {
    AppMethodBeat.i(20745);
    a locala = new a();
    AppMethodBeat.o(20745);
    return locala;
  }
  
  public static int cm(Object paramObject)
  {
    AppMethodBeat.i(20740);
    if (paramObject == null)
    {
      AppMethodBeat.o(20740);
      return 0;
    }
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(20740);
      return i;
    }
    if ((paramObject instanceof Long))
    {
      i = ((Long)paramObject).intValue();
      AppMethodBeat.o(20740);
      return i;
    }
    AppMethodBeat.o(20740);
    return 0;
  }
  
  public static boolean dA(Context paramContext)
  {
    AppMethodBeat.i(20747);
    if (d.elq() != null) {
      d.elq().elo();
    }
    if ((ChannelUtil.updateMode & 0x1) != 0)
    {
      Log.e("MicroMsg.Util", "package has set external update mode");
      Object localObject = Uri.parse(ChannelUtil.marketURL);
      Intent localIntent = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
      int i;
      if ((localObject != null) && (localIntent != null))
      {
        if (paramContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0)
        {
          i = 1;
          if (i != 0) {
            break label193;
          }
        }
      }
      else
      {
        Log.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(e.OyP)).addFlags(268435456);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(20747);
        return true;
        i = 0;
        break;
        label193:
        Log.i("MicroMsg.Util", "parse market uri ok");
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000L).commit();
    if (d.elq() != null)
    {
      paramContext = d.elq().c(paramContext, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramContext == null)
      {
        AppMethodBeat.o(20747);
        return false;
      }
      paramContext.update(3);
    }
    AppMethodBeat.o(20747);
    return true;
  }
  
  public static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(20722);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(20722);
    return str;
  }
  
  @Deprecated
  public static int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(20742);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(20742);
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(20742);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      Log.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(20742);
    }
    return paramInt;
  }
  
  public static String getSizeKB(long paramLong)
  {
    AppMethodBeat.i(20720);
    float f;
    if (paramLong >> 20 > 0L)
    {
      f = Math.round((float)paramLong * 10.0F / 1048576.0F) / 10.0F;
      str = f + "MB";
      AppMethodBeat.o(20720);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      f = Math.round((float)paramLong * 10.0F / 1024.0F) / 10.0F;
      str = f + "KB";
      AppMethodBeat.o(20720);
      return str;
    }
    String str = paramLong + "B";
    AppMethodBeat.o(20720);
    return str;
  }
  
  public static int i(Integer paramInteger)
  {
    AppMethodBeat.i(20737);
    if (paramInteger == null)
    {
      AppMethodBeat.o(20737);
      return 0;
    }
    int i = paramInteger.intValue();
    AppMethodBeat.o(20737);
    return i;
  }
  
  public static boolean isLongHorizontal(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
  }
  
  public static boolean isLongVertical(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(20741);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(20741);
      return true;
    }
    AppMethodBeat.o(20741);
    return false;
  }
  
  public static List<String> k(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20719);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(20719);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    AppMethodBeat.o(20719);
    return localArrayList;
  }
  
  public static String nullAs(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean uT(int paramInt)
  {
    AppMethodBeat.i(20731);
    long l1 = paramInt * 1000L;
    long l2 = l1 - System.currentTimeMillis();
    Log.d("MicroMsg.Util", "time " + l1 + "  systime " + System.currentTimeMillis() + " diff " + l2);
    if (l2 < 0L)
    {
      AppMethodBeat.o(20731);
      return true;
    }
    AppMethodBeat.o(20731);
    return false;
  }
  
  public static final class a
  {
    public final String toString()
    {
      AppMethodBeat.i(20716);
      Object localObject = new Throwable().getStackTrace();
      if ((localObject == null) || (localObject.length < 4))
      {
        AppMethodBeat.o(20716);
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 3;
      while (i < localObject.length)
      {
        if (localObject[i].getClassName().contains("com.tencent.mm"))
        {
          localStringBuilder.append("[");
          localStringBuilder.append(localObject[i].getClassName().substring(15));
          localStringBuilder.append(":");
          localStringBuilder.append(localObject[i].getMethodName());
          localStringBuilder.append("(" + localObject[i].getLineNumber() + ")]");
        }
        i += 1;
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(20716);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.af
 * JD-Core Version:    0.7.0.1
 */