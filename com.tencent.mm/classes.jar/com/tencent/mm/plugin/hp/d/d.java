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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;

public final class d
{
  private static String uJm = "tinker-boots-install-info";
  private static String uJn = "tinker-boots-last-show";
  private static String uJo = "tinker-boots-show-time";
  private static String uJp = "";
  
  public static void a(dna paramdna)
  {
    AppMethodBeat.i(117529);
    try
    {
      aj.getContext().getSharedPreferences("tinker_patch_share_config", g.abm()).edit().putString(uJm, Base64.encodeToString(paramdna.toByteArray(), 0)).apply();
      ad.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(117529);
      return;
    }
    catch (Exception paramdna)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.UpdateUtil", paramdna, "", new Object[0]);
      }
    }
  }
  
  public static void aK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117528);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(117528);
  }
  
  public static String anr(String paramString)
  {
    AppMethodBeat.i(117533);
    paramString = dcQ() + paramString + ".apk";
    AppMethodBeat.o(117533);
    return paramString;
  }
  
  public static void dcO()
  {
    AppMethodBeat.i(117530);
    ad.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("tinker_patch_share_config", g.abm());
    localSharedPreferences.edit().putString(uJm, "").apply();
    localSharedPreferences.edit().putLong(uJn, 0L).apply();
    localSharedPreferences.edit().putInt(uJo, 0).apply();
    AppMethodBeat.o(117530);
  }
  
  public static void dcP()
  {
    AppMethodBeat.i(117531);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117526);
        ad.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
        com.tencent.mm.vfs.i.cZ(d.dcQ(), true);
        AppMethodBeat.o(117526);
      }
    });
    AppMethodBeat.o(117531);
  }
  
  public static String dcQ()
  {
    AppMethodBeat.i(117532);
    if (bt.isNullOrNil(uJp)) {
      uJp = b.arX() + "bsdiff/";
    }
    String str = uJp;
    AppMethodBeat.o(117532);
    return str;
  }
  
  public static String fE(Context paramContext)
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
 * Qualified Name:     com.tencent.mm.plugin.hp.d.d
 * JD-Core Version:    0.7.0.1
 */