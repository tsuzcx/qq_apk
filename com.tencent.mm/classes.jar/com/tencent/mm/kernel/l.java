package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
{
  public static boolean bQ(Context paramContext)
  {
    AppMethodBeat.i(58021);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
      AppMethodBeat.o(58021);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs", h.Mp()).getBoolean("settings_fully_exit", true);
    AppMethodBeat.o(58021);
    return bool;
  }
  
  public static boolean bR(Context paramContext)
  {
    AppMethodBeat.i(58023);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
      AppMethodBeat.o(58023);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs_showdown", h.Mp()).getBoolean("shut_down_weixin", false);
    AppMethodBeat.o(58023);
    return bool;
  }
  
  public static void n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(58020);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
      AppMethodBeat.o(58020);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs", h.Mp()).edit().putBoolean("settings_fully_exit", paramBoolean).commit();
    ab.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(58020);
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(58022);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
      AppMethodBeat.o(58022);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs_showdown", h.Mp()).edit().putBoolean("shut_down_weixin", paramBoolean).commit();
    ab.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(58022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.l
 * JD-Core Version:    0.7.0.1
 */