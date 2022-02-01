package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

public final class l
{
  public static boolean cm(Context paramContext)
  {
    AppMethodBeat.i(132153);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
      AppMethodBeat.o(132153);
      return false;
    }
    boolean bool = ax.aQz("system_config_prefs").getBoolean("settings_fully_exit", true);
    AppMethodBeat.o(132153);
    return bool;
  }
  
  public static boolean cn(Context paramContext)
  {
    AppMethodBeat.i(132155);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
      AppMethodBeat.o(132155);
      return false;
    }
    boolean bool = paramContext.getSharedPreferences("system_config_prefs_showdown", g.abm()).getBoolean("shut_down_weixin", false);
    AppMethodBeat.o(132155);
    return bool;
  }
  
  public static void q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(132152);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
      AppMethodBeat.o(132152);
      return;
    }
    ax.aQz("system_config_prefs").edit().putBoolean("settings_fully_exit", paramBoolean);
    ad.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(132152);
  }
  
  public static void r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(132154);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
      AppMethodBeat.o(132154);
      return;
    }
    paramContext.getSharedPreferences("system_config_prefs_showdown", g.abm()).edit().putBoolean("shut_down_weixin", paramBoolean).commit();
    ad.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(132154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.l
 * JD-Core Version:    0.7.0.1
 */