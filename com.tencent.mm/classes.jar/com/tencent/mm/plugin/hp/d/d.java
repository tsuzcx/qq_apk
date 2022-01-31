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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class d
{
  private static String nKX = "tinker-boots-install-info";
  private static String nKY = "tinker-boots-last-show";
  private static String nKZ = "tinker-boots-show-time";
  private static String nLa = "";
  
  public static String QT(String paramString)
  {
    AppMethodBeat.i(90693);
    paramString = bIz() + paramString + ".apk";
    AppMethodBeat.o(90693);
    return paramString;
  }
  
  public static void a(ckf paramckf)
  {
    AppMethodBeat.i(90689);
    try
    {
      ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mp()).edit().putString(nKX, Base64.encodeToString(paramckf.toByteArray(), 0)).apply();
      ab.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      AppMethodBeat.o(90689);
      return;
    }
    catch (Exception paramckf)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.UpdateUtil", paramckf, "", new Object[0]);
      }
    }
  }
  
  public static void aC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90688);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(90688);
  }
  
  public static void bIx()
  {
    AppMethodBeat.i(90690);
    ab.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mp());
    localSharedPreferences.edit().putString(nKX, "").apply();
    localSharedPreferences.edit().putLong(nKY, 0L).apply();
    localSharedPreferences.edit().putInt(nKZ, 0).apply();
    AppMethodBeat.o(90690);
  }
  
  public static void bIy()
  {
    AppMethodBeat.i(90691);
    com.tencent.mm.sdk.g.d.ysm.execute(new d.1());
    AppMethodBeat.o(90691);
  }
  
  public static String bIz()
  {
    AppMethodBeat.i(90692);
    if (bo.isNullOrNil(nLa)) {
      nLa = com.tencent.mm.compatible.util.e.esq + "bsdiff/";
    }
    String str = nLa;
    AppMethodBeat.o(90692);
    return str;
  }
  
  public static String er(Context paramContext)
  {
    AppMethodBeat.i(90687);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(90687);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(90687);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.d
 * JD-Core Version:    0.7.0.1
 */