package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
{
  public static boolean aF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117502);
    paramContext = paramContext.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
    ad.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[] { paramContext, paramString });
    if (bu.flY())
    {
      AppMethodBeat.o(117502);
      return false;
    }
    if ((!bt.isNullOrNil(paramContext)) && (!bt.isNullOrNil(paramString)) && (paramContext.equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(117502);
      return true;
    }
    AppMethodBeat.o(117502);
    return false;
  }
  
  public static void aG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117503);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", paramString).apply();
    AppMethodBeat.o(117503);
  }
  
  public static void aH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(218922);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", paramString).apply();
    AppMethodBeat.o(218922);
  }
  
  public static void aI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(218923);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", paramString).apply();
    AppMethodBeat.o(218923);
  }
  
  public static void aJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117507);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", paramString).apply();
    AppMethodBeat.o(117507);
  }
  
  private static void ab(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117505);
    if (paramInt < 0)
    {
      ad.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
      AppMethodBeat.o(117505);
      return;
    }
    ad.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", new Object[] { Integer.valueOf(paramInt) });
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", paramInt).apply();
    AppMethodBeat.o(117505);
  }
  
  public static void ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117508);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", paramInt).apply();
    AppMethodBeat.o(117508);
  }
  
  public static void fC(Context paramContext)
  {
    AppMethodBeat.i(117504);
    ab(paramContext, g.acA().getInt("TinkerCheckUpdateInterval", 12));
    AppMethodBeat.o(117504);
  }
  
  public static int fD(Context paramContext)
  {
    AppMethodBeat.i(117506);
    int i = paramContext.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
    AppMethodBeat.o(117506);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.h
 * JD-Core Version:    0.7.0.1
 */