package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.widget.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.a.d;

public final class h
{
  public static boolean a(boolean paramBoolean, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(49041);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (((ah)g.ab(ah.class)).aT(paramString, paramInt))
        {
          new c(paramContext).H(paramContext.getResources().getString(2131755674)).show();
          AppMethodBeat.o(49041);
          return true;
        }
        t(paramContext, paramBoolean);
      }
      catch (Exception localException)
      {
        int i;
        d locald1;
        ad.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
        t(paramContext, paramBoolean);
        continue;
        if (i != -3) {
          continue;
        }
        d locald2 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getResources().getString(2131755309), "", paramContext.getResources().getString(2131755835), null);
        if (locald2 == null) {
          continue;
        }
        locald2.setCanceledOnTouchOutside(false);
        locald2.wU(true);
        continue;
        t(paramContext, paramBoolean);
        continue;
      }
      AppMethodBeat.o(49041);
      return false;
      i = ((ah)g.ab(ah.class)).aS(paramString, paramInt);
      if (i == 0)
      {
        new c(paramContext).H(paramContext.getResources().getString(2131755673)).show();
        AppMethodBeat.o(49041);
        return true;
      }
      if (i != -2) {
        continue;
      }
      i = ((ah)g.ab(ah.class)).aRv();
      locald1 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getResources().getString(2131755380, new Object[] { Integer.valueOf(i) }), "", paramContext.getResources().getString(2131755835), null);
      if (locald1 != null)
      {
        locald1.setCanceledOnTouchOutside(false);
        locald1.wU(true);
      }
    }
  }
  
  private static void t(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(49042);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49040);
        Context localContext = this.val$context;
        if (paramBoolean) {}
        for (String str = this.val$context.getString(2131755363);; str = this.val$context.getString(2131755361))
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.h
 * JD-Core Version:    0.7.0.1
 */