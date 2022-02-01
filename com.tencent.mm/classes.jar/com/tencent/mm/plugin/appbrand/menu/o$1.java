package com.tencent.mm.plugin.appbrand.menu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.base.model.c.a;
import com.tencent.mm.plugin.report.service.h;

final class o$1
  implements c.a
{
  o$1(o paramo) {}
  
  public final void d(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(47639);
    if (paramBoolean)
    {
      h.IzE.a(15789, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), paramString });
      PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", true).apply();
    }
    AppMethodBeat.o(47639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o.1
 * JD-Core Version:    0.7.0.1
 */