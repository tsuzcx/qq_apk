package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.widget.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public final class d
{
  private static void D(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(49042);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49040);
        Context localContext = d.this;
        if (paramBoolean) {}
        for (String str = d.this.getString(ba.i.app_brand_collection_remove_failed);; str = d.this.getString(ba.i.app_brand_collection_add_failed))
        {
          Toast.makeText(localContext, str, 0).show();
          AppMethodBeat.o(49040);
          return;
        }
      }
    });
    AppMethodBeat.o(49042);
  }
  
  public static boolean a(boolean paramBoolean, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(49041);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (((af)h.ax(af.class)).bS(paramString, paramInt))
        {
          new c(paramContext).X(paramContext.getResources().getString(ba.i.app_brand_usage_modify_collection_removed)).show();
          AppMethodBeat.o(49041);
          return true;
        }
        D(paramContext, paramBoolean);
      }
      catch (Exception localException)
      {
        int i;
        e locale1;
        Log.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
        D(paramContext, paramBoolean);
        continue;
        if (i != -3) {
          continue;
        }
        e locale2 = k.a(paramContext, paramContext.getResources().getString(ba.i.app_brand_add_collection_blocked), "", paramContext.getResources().getString(ba.i.app_ok), null);
        if (locale2 == null) {
          continue;
        }
        locale2.setCanceledOnTouchOutside(false);
        locale2.Nz(true);
        continue;
        D(paramContext, paramBoolean);
        continue;
      }
      AppMethodBeat.o(49041);
      return false;
      i = ((af)h.ax(af.class)).bR(paramString, paramInt);
      if (i == 0)
      {
        new c(paramContext).X(paramContext.getResources().getString(ba.i.app_brand_usage_modify_collection_added)).show();
        AppMethodBeat.o(49041);
        return true;
      }
      if (i != -2) {
        continue;
      }
      i = ((af)h.ax(af.class)).ciA();
      locale1 = k.a(paramContext, paramContext.getResources().getString(ba.i.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", paramContext.getResources().getString(ba.i.app_ok), null);
      if (locale1 != null)
      {
        locale1.setCanceledOnTouchOutside(false);
        locale1.Nz(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.d
 * JD-Core Version:    0.7.0.1
 */