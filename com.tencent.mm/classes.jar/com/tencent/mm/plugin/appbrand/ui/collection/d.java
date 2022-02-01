package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;

public final class d
{
  public static boolean a(boolean paramBoolean, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(49041);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (((ag)g.af(ag.class)).bh(paramString, paramInt))
        {
          new c(paramContext).K(paramContext.getResources().getString(2131755742)).show();
          AppMethodBeat.o(49041);
          return true;
        }
        y(paramContext, paramBoolean);
      }
      catch (Exception localException)
      {
        int i;
        com.tencent.mm.ui.widget.a.d locald1;
        Log.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
        y(paramContext, paramBoolean);
        continue;
        if (i != -3) {
          continue;
        }
        com.tencent.mm.ui.widget.a.d locald2 = h.a(paramContext, paramContext.getResources().getString(2131755345), "", paramContext.getResources().getString(2131755921), null);
        if (locald2 == null) {
          continue;
        }
        locald2.setCanceledOnTouchOutside(false);
        locald2.Dh(true);
        continue;
        y(paramContext, paramBoolean);
        continue;
      }
      AppMethodBeat.o(49041);
      return false;
      i = ((ag)g.af(ag.class)).bg(paramString, paramInt);
      if (i == 0)
      {
        new c(paramContext).K(paramContext.getResources().getString(2131755741)).show();
        AppMethodBeat.o(49041);
        return true;
      }
      if (i != -2) {
        continue;
      }
      i = ((ag)g.af(ag.class)).bxH();
      locald1 = h.a(paramContext, paramContext.getResources().getString(2131755418, new Object[] { Integer.valueOf(i) }), "", paramContext.getResources().getString(2131755921), null);
      if (locald1 != null)
      {
        locald1.setCanceledOnTouchOutside(false);
        locald1.Dh(true);
      }
    }
  }
  
  private static void y(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(49042);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49040);
        Context localContext = this.val$context;
        if (paramBoolean) {}
        for (String str = this.val$context.getString(2131755400);; str = this.val$context.getString(2131755398))
        {
          Toast.makeText(localContext, str, 0).show();
          AppMethodBeat.o(49040);
          return;
        }
      }
    });
    AppMethodBeat.o(49042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.d
 * JD-Core Version:    0.7.0.1
 */