package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class h
{
  public static boolean aU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117502);
    paramContext = paramContext.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
    Log.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[] { paramContext, paramString });
    if (WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(117502);
      return false;
    }
    if ((!Util.isNullOrNil(paramContext)) && (!Util.isNullOrNil(paramString)) && (paramContext.equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(117502);
      return true;
    }
    AppMethodBeat.o(117502);
    return false;
  }
  
  public static void aV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117503);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", paramString).apply();
    AppMethodBeat.o(117503);
  }
  
  public static void aW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(196797);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", paramString).apply();
    AppMethodBeat.o(196797);
  }
  
  public static void aX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(196798);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", paramString).apply();
    AppMethodBeat.o(196798);
  }
  
  public static void aY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(117507);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", paramString).apply();
    AppMethodBeat.o(117507);
  }
  
  private static void ai(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117505);
    if (paramInt < 0)
    {
      Log.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
      AppMethodBeat.o(117505);
      return;
    }
    Log.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", new Object[] { Integer.valueOf(paramInt) });
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", paramInt).apply();
    AppMethodBeat.o(117505);
  }
  
  public static void aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(117508);
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", paramInt).apply();
    AppMethodBeat.o(117508);
  }
  
  public static void gn(Context paramContext)
  {
    AppMethodBeat.i(117504);
    ai(paramContext, com.tencent.mm.n.h.aqJ().getInt("TinkerCheckUpdateInterval", 12));
    AppMethodBeat.o(117504);
  }
  
  public static int go(Context paramContext)
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