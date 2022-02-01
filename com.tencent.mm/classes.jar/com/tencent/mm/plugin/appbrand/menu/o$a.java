package com.tencent.mm.plugin.appbrand.menu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class o$a
  extends au
{
  public final String getTag()
  {
    return "MicroMsg.MenuDelegate_SendToDesktop.ConfigMigration";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(180323);
    if (PluginAppBrand.getProcessSharedPrefs().contains("key_sendtodesktop_no_more_show_permission_notify_dialog"))
    {
      AppMethodBeat.o(180323);
      return;
    }
    try
    {
      boolean bool = n.aqS().O("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
      PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", bool).apply();
      AppMethodBeat.o(180323);
      return;
    }
    finally
    {
      Log.e("MicroMsg.MenuDelegate_SendToDesktop", "SendToDesktopConfigToMMKVMigration.transfer() error=%s", new Object[] { localObject });
      AppMethodBeat.o(180323);
    }
  }
  
  public final boolean vc(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o.a
 * JD-Core Version:    0.7.0.1
 */