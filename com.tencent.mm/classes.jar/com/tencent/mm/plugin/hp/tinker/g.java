package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.m.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  public static void E(Context paramContext, int paramInt)
  {
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", paramInt).apply();
  }
  
  public static boolean ar(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
    y.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[] { paramContext, paramString });
    return (!bk.bl(paramContext)) && (!bk.bl(paramString)) && (paramContext.equalsIgnoreCase(paramString));
  }
  
  public static void as(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", paramString).apply();
  }
  
  public static void at(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", paramString).apply();
  }
  
  public static void dE(Context paramContext)
  {
    int i = com.tencent.mm.m.g.AA().getInt("TinkerCheckUpdateInterval", 12);
    if (i < 0)
    {
      y.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
      return;
    }
    y.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", new Object[] { Integer.valueOf(i) });
    paramContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i).apply();
  }
  
  public static int dF(Context paramContext)
  {
    return paramContext.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */