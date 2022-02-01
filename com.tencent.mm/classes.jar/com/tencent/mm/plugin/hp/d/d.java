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
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.File;

public final class d
{
  private static String uUZ = "tinker-boots-install-info";
  private static String uVa = "tinker-boots-last-show";
  private static String uVb = "tinker-boots-show-time";
  private static String uVc = "";
  
  public static void a(dnx paramdnx)
  {
    AppMethodBeat.i(117529);
    try
    {
      ak.getContext().getSharedPreferences("tinker_patch_share_config", g.abv()).edit().putString(uUZ, Base64.encodeToString(paramdnx.toByteArray(), 0)).apply();
      ae.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(117529);
      return;
    }
    catch (Exception paramdnx)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.UpdateUtil", paramdnx, "", new Object[0]);
      }
    }
  }
  
  public static void aM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117528);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(117528);
  }
  
  public static String aot(String paramString)
  {
    AppMethodBeat.i(117533);
    paramString = dfI() + paramString + ".apk";
    AppMethodBeat.o(117533);
    return paramString;
  }
  
  public static void dfG()
  {
    AppMethodBeat.i(117530);
    ae.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("tinker_patch_share_config", g.abv());
    localSharedPreferences.edit().putString(uUZ, "").apply();
    localSharedPreferences.edit().putLong(uVa, 0L).apply();
    localSharedPreferences.edit().putInt(uVb, 0).apply();
    AppMethodBeat.o(117530);
  }
  
  public static void dfH()
  {
    AppMethodBeat.i(117531);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117526);
        ae.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
        o.dd(d.dfI(), true);
        AppMethodBeat.o(117526);
      }
    });
    AppMethodBeat.o(117531);
  }
  
  public static String dfI()
  {
    AppMethodBeat.i(117532);
    if (bu.isNullOrNil(uVc)) {
      uVc = b.asm() + "bsdiff/";
    }
    String str = uVc;
    AppMethodBeat.o(117532);
    return str;
  }
  
  public static String fJ(Context paramContext)
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
      ae.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(117527);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.d
 * JD-Core Version:    0.7.0.1
 */