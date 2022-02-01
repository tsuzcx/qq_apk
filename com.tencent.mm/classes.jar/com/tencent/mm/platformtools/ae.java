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
import com.tencent.mm.plugin.q.c;
import com.tencent.mm.plugin.q.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class ae
{
  private static final TimeZone GMT;
  private static final long[] hWP;
  
  static
  {
    AppMethodBeat.i(20749);
    hWP = new long[] { 300L, 200L, 300L, 200L };
    GMT = TimeZone.getTimeZone("GMT");
    AppMethodBeat.o(20749);
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
        ad.e("MicroMsg.Util", "hide VKB(View) exception %s", new Object[] { paramContext });
        boolean bool = false;
      }
    }
  }
  
  public static long aGK()
  {
    AppMethodBeat.i(20721);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(20721);
    return l;
  }
  
  public static void aGL()
  {
    AppMethodBeat.i(20732);
    ad.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", new Object[] { mK(Debug.getGlobalAllocSize()), mK(Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize()), mK(Debug.getGlobalExternalAllocSize()), mK(Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize()), mK(Debug.getNativeHeapAllocatedSize()), mK(Debug.getNativeHeapSize()) });
    AppMethodBeat.o(20732);
  }
  
  public static ae.a aGM()
  {
    AppMethodBeat.i(20745);
    ae.a locala = new ae.a();
    AppMethodBeat.o(20745);
    return locala;
  }
  
  @Deprecated
  public static long aa(String paramString)
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
  
  public static String by(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static List<String> bz(String paramString1, String paramString2)
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
  
  public static long c(Long paramLong)
  {
    AppMethodBeat.i(20738);
    if (paramLong == null)
    {
      AppMethodBeat.o(20738);
      return 0L;
    }
    long l = paramLong.longValue();
    AppMethodBeat.o(20738);
    return l;
  }
  
  public static boolean cW(Context paramContext)
  {
    AppMethodBeat.i(20747);
    if (d.cRq() != null) {
      d.cRq().cRo();
    }
    if ((i.cJT & 0x1) != 0)
    {
      ad.e("MicroMsg.Util", "package has set external update mode");
      Object localObject = Uri.parse(i.ETv);
      Intent localIntent = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
      int i;
      if ((localObject != null) && (localIntent != null))
      {
        if (paramContext.getPackageManager().queryIntentActivities(localIntent, 65536).size() > 0)
        {
          i = 1;
          if (i != 0) {
            break label196;
          }
        }
      }
      else
      {
        ad.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
        localObject = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        AppMethodBeat.o(20747);
        return true;
        i = 0;
        break;
        label196:
        ad.i("MicroMsg.Util", "parse market uri ok");
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/platformtools/Util", "checkUpdate", "(Landroid/content/Context;Ljava/lang/Runnable;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000L).commit();
    if (d.cRq() != null)
    {
      paramContext = d.cRq().c(paramContext, new DialogInterface.OnCancelListener()
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
  
  public static int cd(Object paramObject)
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
  
  public static boolean du(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
  
  public static boolean dv(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
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
      ad.printErrStackTrace("MicroMsg.Util", paramString, "", new Object[0]);
      AppMethodBeat.o(20742);
    }
    return paramInt;
  }
  
  public static int h(Integer paramInteger)
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
  
  public static List<String> l(String[] paramArrayOfString)
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
  
  public static long lZ(long paramLong)
  {
    AppMethodBeat.i(20724);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(20724);
    return l - paramLong;
  }
  
  public static String mK(long paramLong)
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
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String pL(int paramInt)
  {
    AppMethodBeat.i(20722);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(20722);
    return str;
  }
  
  public static boolean pM(int paramInt)
  {
    AppMethodBeat.i(20731);
    long l1 = paramInt * 1000L;
    long l2 = l1 - System.currentTimeMillis();
    ad.d("MicroMsg.Util", "time " + l1 + "  systime " + System.currentTimeMillis() + " diff " + l2);
    if (l2 < 0L)
    {
      AppMethodBeat.o(20731);
      return true;
    }
    AppMethodBeat.o(20731);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */