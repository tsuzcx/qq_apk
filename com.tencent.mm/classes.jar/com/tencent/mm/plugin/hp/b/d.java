package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.File;

public final class d
{
  private static String JEQ = "tinker-boots-install-info";
  private static String JER = "tinker-boots-last-show";
  private static String JES = "tinker-boots-show-time";
  private static String JET = "hdiff-boots-install-info";
  private static String JEU = "";
  
  public static void a(czn paramczn)
  {
    AppMethodBeat.i(261870);
    if (paramczn != null) {}
    try
    {
      MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe()).edit().putString(JET, Base64.encodeToString(paramczn.toByteArray(), 0)).apply();
      Log.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(261870);
      return;
    }
    catch (Exception paramczn)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.UpdateUtil", paramczn, "", new Object[0]);
      }
    }
  }
  
  public static void a(fne paramfne)
  {
    AppMethodBeat.i(117529);
    try
    {
      MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe()).edit().putString(JEQ, Base64.encodeToString(paramfne.toByteArray(), 0)).apply();
      Log.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(117529);
      return;
    }
    catch (Exception paramfne)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.UpdateUtil", paramfne, "", new Object[0]);
      }
    }
  }
  
  public static int aIN(String paramString)
  {
    AppMethodBeat.i(261835);
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      try
      {
        i = Integer.decode(paramString).intValue();
        Log.i("MicroMsg.UpdateUtil", "parseClientVersion %s %s", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(261835);
        return i;
      }
      catch (Exception localException) {}
      int i = 0;
    }
  }
  
  public static String aIO(String paramString)
  {
    AppMethodBeat.i(117533);
    paramString = fQv() + paramString + ".apk";
    AppMethodBeat.o(117533);
    return paramString;
  }
  
  public static void bn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117528);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(117528);
  }
  
  public static void fQA()
  {
    AppMethodBeat.i(261871);
    Log.i("MicroMsg.UpdateUtil", "clearHdiffInstallStatus.");
    MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe()).edit().putString(JET, "").apply();
    AppMethodBeat.o(261871);
  }
  
  public static fne fQq()
  {
    AppMethodBeat.i(261826);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe()).getString(JEQ, "");
    if (!Util.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new fne();
        Log.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (fne)((fne)localObject1).parseFrom(Base64.decode((String)localObject2, 0));
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label86;
          }
          AppMethodBeat.o(261826);
          return localObject1;
        }
        catch (Exception localException2)
        {
          break label71;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label71:
      continue;
      label86:
      Log.i("MicroMsg.UpdateUtil", "update info is null.");
      AppMethodBeat.o(261826);
      return null;
      Object localObject1 = null;
    }
  }
  
  public static boolean fQr()
  {
    AppMethodBeat.i(261842);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe());
    long l1 = localSharedPreferences.getLong(JER, 0L);
    int i = localSharedPreferences.getInt(JES, 0);
    long l2 = System.currentTimeMillis();
    Log.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
    if ((l2 - l1 > 21600000L) && (i < 3))
    {
      AppMethodBeat.o(261842);
      return true;
    }
    AppMethodBeat.o(261842);
    return false;
  }
  
  public static void fQs()
  {
    AppMethodBeat.i(261844);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe());
    localSharedPreferences.edit().putLong(JER, System.currentTimeMillis()).apply();
    int i = localSharedPreferences.getInt(JES, 0);
    localSharedPreferences.edit().putInt(JES, i + 1).apply();
    AppMethodBeat.o(261844);
  }
  
  public static void fQt()
  {
    AppMethodBeat.i(117530);
    Log.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe());
    localSharedPreferences.edit().putString(JEQ, "").apply();
    localSharedPreferences.edit().putLong(JER, 0L).apply();
    localSharedPreferences.edit().putInt(JES, 0).apply();
    AppMethodBeat.o(117530);
  }
  
  public static void fQu()
  {
    AppMethodBeat.i(117531);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117526);
        Log.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
        y.ew(d.fQv(), true);
        AppMethodBeat.o(117526);
      }
    });
    AppMethodBeat.o(117531);
  }
  
  public static String fQv()
  {
    AppMethodBeat.i(261852);
    if (Util.isNullOrNil(JEU)) {
      JEU = com.tencent.mm.loader.i.b.bmC() + "diff/";
    }
    String str = JEU;
    AppMethodBeat.o(261852);
    return str;
  }
  
  public static czn fQw()
  {
    AppMethodBeat.i(261856);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aQe()).getString(JET, "");
    if (!Util.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new czn();
        Log.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (czn)((czn)localObject1).parseFrom(Base64.decode((String)localObject2, 0));
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label88;
          }
          AppMethodBeat.o(261856);
          return localObject1;
        }
        catch (Exception localException2)
        {
          break label73;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label73:
      continue;
      label88:
      Log.i("MicroMsg.UpdateUtil", "update info is null.");
      AppMethodBeat.o(261856);
      return null;
      Object localObject1 = null;
    }
  }
  
  public static boolean fQx()
  {
    AppMethodBeat.i(261859);
    if (fQw() == null)
    {
      AppMethodBeat.o(261859);
      return true;
    }
    czn localczn = fQw();
    int i;
    if (localczn == null) {
      i = 1;
    }
    while (i != 0)
    {
      fQA();
      AppMethodBeat.o(261859);
      return true;
      long l1 = localczn.startTime;
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.UpdateUtil", "Hdiffapk, isNeedShowTinkerDialog now:%d last:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
      if (l2 - l1 > 30000L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        i = 1;
        break;
      }
      label109:
      i = 0;
    }
    if (fQy())
    {
      AppMethodBeat.o(261859);
      return false;
    }
    if (fQz())
    {
      AppMethodBeat.o(261859);
      return false;
    }
    AppMethodBeat.o(261859);
    return true;
  }
  
  public static boolean fQy()
  {
    AppMethodBeat.i(261863);
    Object localObject = fQw();
    if (localObject == null)
    {
      AppMethodBeat.o(261863);
      return false;
    }
    l1 = -1L;
    try
    {
      long l2 = Long.parseLong(((czn)localObject).aaEU);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.UpdateUtil", "Hdiffapk, isNeedShowTinkerDialog e = ".concat(String.valueOf(localException)));
        continue;
        com.tencent.mm.plugin.downloader.f.a locala = localException.ll(l1);
        continue;
        boolean bool = false;
      }
    }
    Log.e("MicroMsg.UpdateUtil", "Hdiffapk, downloadId downloadId = ".concat(String.valueOf(l1)));
    localObject = com.tencent.mm.plugin.downloader.model.d.bzH();
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (((com.tencent.mm.plugin.downloader.f.a)localObject).field_status != 1)) {
        break label125;
      }
      bool = true;
      AppMethodBeat.o(261863);
      return bool;
    }
  }
  
  public static boolean fQz()
  {
    AppMethodBeat.i(261868);
    czn localczn = fQw();
    if (localczn == null)
    {
      AppMethodBeat.o(261868);
      return false;
    }
    boolean bool = "3".equals(localczn.vXL);
    Log.e("MicroMsg.UpdateUtil", "Hdiffapk, isPatchMergeing = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(261868);
    return bool;
  }
  
  public static String iH(Context paramContext)
  {
    AppMethodBeat.i(117527);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(117527);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(117527);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */