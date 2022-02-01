package com.tencent.mm.plugin.appbrand.menu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class o$a
  extends at
{
  public final String getTag()
  {
    return "MicroMsg.MenuDelegate_SendToDesktop.ConfigMigration";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(180323);
    if (PluginAppBrand.getProcessSharedPrefs().contains("key_sendtodesktop_no_more_show_permission_notify_dialog"))
    {
      AppMethodBeat.o(180323);
      return;
    }
    try
    {
      boolean bool = m.QG().L("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
      PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", bool).apply();
      AppMethodBeat.o(180323);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MenuDelegate_SendToDesktop", "SendToDesktopConfigToMMKVMigration.transfer() error=%s", new Object[] { localThrowable });
      AppMethodBeat.o(180323);
    }
  }
  
  public final boolean uQ(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o.a
 * JD-Core Version:    0.7.0.1
 */