package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.base.model.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.atomic.AtomicBoolean;

public final class k
  extends a<ae>
{
  k()
  {
    super(q.ltJ.ordinal());
    AppMethodBeat.i(47644);
    AppMethodBeat.o(47644);
  }
  
  public static final class a
    extends al
  {
    public final String getTag()
    {
      return "MicroMsg.MenuDelegate_SendToDesktop.ConfigMigration";
    }
    
    public final boolean nP(int paramInt)
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
        boolean bool = j.CK().get("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
        PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", bool).apply();
        AppMethodBeat.o(180323);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.e("MicroMsg.MenuDelegate_SendToDesktop", "SendToDesktopConfigToMMKVMigration.transfer() error=%s", new Object[] { localThrowable });
        AppMethodBeat.o(180323);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.k
 * JD-Core Version:    0.7.0.1
 */