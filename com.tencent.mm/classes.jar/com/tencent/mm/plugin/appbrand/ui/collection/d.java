package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.widget.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class d
{
  private static void B(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(49042);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49040);
        Context localContext = this.val$context;
        if (paramBoolean) {}
        for (String str = this.val$context.getString(au.i.app_brand_collection_remove_failed);; str = this.val$context.getString(au.i.app_brand_collection_add_failed))
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
        if (((ag)com.tencent.mm.kernel.h.ae(ag.class)).bA(paramString, paramInt))
        {
          new c(paramContext).T(paramContext.getResources().getString(au.i.app_brand_usage_modify_collection_removed)).show();
          AppMethodBeat.o(49041);
          return true;
        }
        B(paramContext, paramBoolean);
      }
      catch (Exception localException)
      {
        int i;
        com.tencent.mm.ui.widget.a.d locald1;
        Log.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
        B(paramContext, paramBoolean);
        continue;
        if (i != -3) {
          continue;
        }
        com.tencent.mm.ui.widget.a.d locald2 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getResources().getString(au.i.app_brand_add_collection_blocked), "", paramContext.getResources().getString(au.i.app_ok), null);
        if (locald2 == null) {
          continue;
        }
        locald2.setCanceledOnTouchOutside(false);
        locald2.HD(true);
        continue;
        B(paramContext, paramBoolean);
        continue;
      }
      AppMethodBeat.o(49041);
      return false;
      i = ((ag)com.tencent.mm.kernel.h.ae(ag.class)).bz(paramString, paramInt);
      if (i == 0)
      {
        new c(paramContext).T(paramContext.getResources().getString(au.i.app_brand_usage_modify_collection_added)).show();
        AppMethodBeat.o(49041);
        return true;
      }
      if (i != -2) {
        continue;
      }
      i = ((ag)com.tencent.mm.kernel.h.ae(ag.class)).bIW();
      locald1 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getResources().getString(au.i.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", paramContext.getResources().getString(au.i.app_ok), null);
      if (locald1 != null)
      {
        locald1.setCanceledOnTouchOutside(false);
        locald1.HD(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.d
 * JD-Core Version:    0.7.0.1
 */