package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class d
{
  private static String DNC = "tinker-boots-install-info";
  private static String DND = "tinker-boots-last-show";
  private static String DNE = "tinker-boots-show-time";
  private static String DNF = "";
  
  public static void a(erv paramerv)
  {
    AppMethodBeat.i(117529);
    try
    {
      MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.avK()).edit().putString(DNC, Base64.encodeToString(paramerv.toByteArray(), 0)).apply();
      Log.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(117529);
      return;
    }
    catch (Exception paramerv)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.UpdateUtil", paramerv, "", new Object[0]);
      }
    }
  }
  
  public static int aLT(String paramString)
  {
    AppMethodBeat.i(194931);
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      try
      {
        i = Integer.decode(paramString).intValue();
        Log.i("MicroMsg.UpdateUtil", "parseClientVersion %s %s", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(194931);
        return i;
      }
      catch (Exception localException) {}
      int i = 0;
    }
  }
  
  public static String aLU(String paramString)
  {
    AppMethodBeat.i(117533);
    paramString = eIz() + paramString + ".apk";
    AppMethodBeat.o(117533);
    return paramString;
  }
  
  public static void bl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117528);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(117528);
  }
  
  public static void eIx()
  {
    AppMethodBeat.i(117530);
    Log.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.avK());
    localSharedPreferences.edit().putString(DNC, "").apply();
    localSharedPreferences.edit().putLong(DND, 0L).apply();
    localSharedPreferences.edit().putInt(DNE, 0).apply();
    AppMethodBeat.o(117530);
  }
  
  public static void eIy()
  {
    AppMethodBeat.i(117531);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117526);
        Log.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
        u.deleteDir(d.eIz());
        AppMethodBeat.o(117526);
      }
    });
    AppMethodBeat.o(117531);
  }
  
  public static String eIz()
  {
    AppMethodBeat.i(117532);
    if (Util.isNullOrNil(DNF)) {
      DNF = b.aSO() + "bsdiff/";
    }
    String str = DNF;
    AppMethodBeat.o(117532);
    return str;
  }
  
  public static String hm(Context paramContext)
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
 * Qualified Name:     com.tencent.mm.plugin.hp.d.d
 * JD-Core Version:    0.7.0.1
 */