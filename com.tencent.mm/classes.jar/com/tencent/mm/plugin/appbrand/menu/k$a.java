package com.tencent.mm.plugin.appbrand.menu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class k$a
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.MenuDelegate_SendToDesktop.ConfigMigration";
  }
  
  public final boolean nb(int paramInt)
  {
    return true;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(180323);
    if (PluginAppBrand.getProcessSharedPrefs().contains("key_sendtodesktop_no_more_show_permission_notify_dialog"))
    {
      AppMethodBeat.o(180323);
      return;
    }
    try
    {
      boolean bool = j.Dh().get("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
      PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", bool).apply();
      AppMethodBeat.o(180323);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.MenuDelegate_SendToDesktop", "SendToDesktopConfigToMMKVMigration.transfer() error=%s", new Object[] { localThrowable });
      AppMethodBeat.o(180323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.k.a
 * JD-Core Version:    0.7.0.1
 */