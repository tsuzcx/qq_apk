package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.y;

public final class l
{
  public static boolean bm(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
      return false;
    }
    return paramContext.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true);
  }
  
  public static boolean bn(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
      return false;
    }
    return paramContext.getSharedPreferences("system_config_prefs_showdown", 4).getBoolean("shut_down_weixin", false);
  }
  
  public static void k(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs", 4).edit().putBoolean("settings_fully_exit", paramBoolean).commit();
    y.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to " + paramBoolean);
  }
  
  public static void l(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs_showdown", 4).edit().putBoolean("shut_down_weixin", paramBoolean).commit();
    y.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.l
 * JD-Core Version:    0.7.0.1
 */