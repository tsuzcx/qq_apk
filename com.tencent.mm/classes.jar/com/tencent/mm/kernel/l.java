package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class l
{
  public static boolean cK(Context paramContext)
  {
    AppMethodBeat.i(132153);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
      AppMethodBeat.o(132153);
      return false;
    }
    boolean bool = MultiProcessMMKV.getMMKV("system_config_prefs").getBoolean("settings_fully_exit", true);
    AppMethodBeat.o(132153);
    return bool;
  }
  
  public static boolean cL(Context paramContext)
  {
    AppMethodBeat.i(132155);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
      AppMethodBeat.o(132155);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs_showdown", g.aps()).getBoolean("shut_down_weixin", false);
    AppMethodBeat.o(132155);
    return bool;
  }
  
  public static void s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(132152);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
      AppMethodBeat.o(132152);
      return;
    }
    MultiProcessMMKV.getMMKV("system_config_prefs").edit().putBoolean("settings_fully_exit", paramBoolean);
    Log.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(132152);
  }
  
  public static void t(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(132154);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
      AppMethodBeat.o(132154);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs_showdown", g.aps()).edit().putBoolean("shut_down_weixin", paramBoolean).commit();
    Log.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(132154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.l
 * JD-Core Version:    0.7.0.1
 */