package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.v.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.base.model.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class m
  extends a<ag>
{
  m()
  {
    super(u.nfg.ordinal());
    AppMethodBeat.i(47644);
    AppMethodBeat.o(47644);
  }
  
  public static final class a
    extends as
  {
    public final String getTag()
    {
      return "MicroMsg.MenuDelegate_SendToDesktop.ConfigMigration";
    }
    
    public final boolean rT(int paramInt)
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
        boolean bool = n.NL().get("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.m
 * JD-Core Version:    0.7.0.1
 */