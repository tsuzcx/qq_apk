package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;

public final class l
{
  public static boolean cp(Context paramContext)
  {
    AppMethodBeat.i(132153);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
      AppMethodBeat.o(132153);
      return false;
    }
    boolean bool = aw.aKT("system_config_prefs").getBoolean("settings_fully_exit", true);
    AppMethodBeat.o(132153);
    return bool;
  }
  
  public static boolean cq(Context paramContext)
  {
    AppMethodBeat.i(132155);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
      AppMethodBeat.o(132155);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs_showdown", g.YK()).getBoolean("shut_down_weixin", false);
    AppMethodBeat.o(132155);
    return bool;
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(132152);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
      AppMethodBeat.o(132152);
      return;
    }
    aw.aKT("system_config_prefs").edit().putBoolean("settings_fully_exit", paramBoolean);
    ac.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(132152);
  }
  
  public static void p(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(132154);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
      AppMethodBeat.o(132154);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs_showdown", g.YK()).edit().putBoolean("shut_down_weixin", paramBoolean).commit();
    ac.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(132154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.l
 * JD-Core Version:    0.7.0.1
 */