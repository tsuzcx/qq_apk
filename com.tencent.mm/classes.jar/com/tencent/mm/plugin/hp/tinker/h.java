package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
{
  private static void S(Context paramContext, int paramInt)
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
  
  public static void T(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117508);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", paramInt).apply();
    AppMethodBeat.o(117508);
  }
  
  public static boolean aB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117502);
    paramContext = paramContext.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
    ad.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[] { paramContext, paramString });
    if (bu.eGT())
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
  
  public static void aC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117503);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", paramString).apply();
    AppMethodBeat.o(117503);
  }
  
  public static void aD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187228);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", paramString).apply();
    AppMethodBeat.o(187228);
  }
  
  public static void aE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187229);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", paramString).apply();
    AppMethodBeat.o(187229);
  }
  
  public static void aF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117507);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", paramString).apply();
    AppMethodBeat.o(117507);
  }
  
  public static void fk(Context paramContext)
  {
    AppMethodBeat.i(117504);
    S(paramContext, g.Zd().getInt("TinkerCheckUpdateInterval", 12));
    AppMethodBeat.o(117504);
  }
  
  public static int fl(Context paramContext)
  {
    AppMethodBeat.i(117506);
    int i = paramContext.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
    AppMethodBeat.o(117506);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.h
 * JD-Core Version:    0.7.0.1
 */