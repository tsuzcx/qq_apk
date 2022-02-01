package com.tencent.mm.plugin.hp.c;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;

public final class d
{
  private static String syP = "tinker-boots-install-info";
  private static String syQ = "tinker-boots-last-show";
  private static String syR = "tinker-boots-show-time";
  private static String syS = "";
  
  public static void a(dbz paramdbz)
  {
    AppMethodBeat.i(117529);
    try
    {
      aj.getContext().getSharedPreferences("tinker_patch_share_config", g.XN()).edit().putString(syP, Base64.encodeToString(paramdbz.toByteArray(), 0)).apply();
      ad.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(117529);
      return;
    }
    catch (Exception paramdbz)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.UpdateUtil", paramdbz, "", new Object[0]);
      }
    }
  }
  
  public static void aG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117528);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(117528);
  }
  
  public static String adM(String paramString)
  {
    AppMethodBeat.i(117533);
    paramString = cGu() + paramString + ".apk";
    AppMethodBeat.o(117533);
    return paramString;
  }
  
  public static void cGs()
  {
    AppMethodBeat.i(117530);
    ad.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("tinker_patch_share_config", g.XN());
    localSharedPreferences.edit().putString(syP, "").apply();
    localSharedPreferences.edit().putLong(syQ, 0L).apply();
    localSharedPreferences.edit().putInt(syR, 0).apply();
    AppMethodBeat.o(117530);
  }
  
  public static void cGt()
  {
    AppMethodBeat.i(117531);
    h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117526);
        ad.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
        com.tencent.mm.vfs.i.cO(d.cGu(), true);
        AppMethodBeat.o(117526);
      }
    });
    AppMethodBeat.o(117531);
  }
  
  public static String cGu()
  {
    AppMethodBeat.i(117532);
    if (bt.isNullOrNil(syS)) {
      syS = b.aij() + "bsdiff/";
    }
    String str = syS;
    AppMethodBeat.o(117532);
    return str;
  }
  
  public static String fm(Context paramContext)
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
      ad.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(117527);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.d
 * JD-Core Version:    0.7.0.1
 */