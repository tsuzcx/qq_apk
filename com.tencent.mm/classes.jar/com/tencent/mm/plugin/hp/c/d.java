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
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.File;

public final class d
{
  private static String tGA = "tinker-boots-last-show";
  private static String tGB = "tinker-boots-show-time";
  private static String tGC = "";
  private static String tGz = "tinker-boots-install-info";
  
  public static void a(dhl paramdhl)
  {
    AppMethodBeat.i(117529);
    try
    {
      ai.getContext().getSharedPreferences("tinker_patch_share_config", g.YK()).edit().putString(tGz, Base64.encodeToString(paramdhl.toByteArray(), 0)).apply();
      ac.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(117529);
      return;
    }
    catch (Exception paramdhl)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.UpdateUtil", paramdhl, "", new Object[0]);
      }
    }
  }
  
  public static void aH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117528);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(117528);
  }
  
  public static String aiE(String paramString)
  {
    AppMethodBeat.i(117533);
    paramString = cTE() + paramString + ".apk";
    AppMethodBeat.o(117533);
    return paramString;
  }
  
  public static void cTC()
  {
    AppMethodBeat.i(117530);
    ac.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("tinker_patch_share_config", g.YK());
    localSharedPreferences.edit().putString(tGz, "").apply();
    localSharedPreferences.edit().putLong(tGA, 0L).apply();
    localSharedPreferences.edit().putInt(tGB, 0).apply();
    AppMethodBeat.o(117530);
  }
  
  public static void cTD()
  {
    AppMethodBeat.i(117531);
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117526);
        ac.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
        com.tencent.mm.vfs.i.cU(d.cTE(), true);
        AppMethodBeat.o(117526);
      }
    });
    AppMethodBeat.o(117531);
  }
  
  public static String cTE()
  {
    AppMethodBeat.i(117532);
    if (bs.isNullOrNil(tGC)) {
      tGC = b.apj() + "bsdiff/";
    }
    String str = tGC;
    AppMethodBeat.o(117532);
    return str;
  }
  
  public static String fz(Context paramContext)
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
      ac.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(117527);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.d
 * JD-Core Version:    0.7.0.1
 */