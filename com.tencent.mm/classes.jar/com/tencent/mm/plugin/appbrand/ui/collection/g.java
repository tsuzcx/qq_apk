package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

public final class g
{
  public static boolean a(boolean paramBoolean, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(133322);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (((af)com.tencent.mm.kernel.g.E(af.class)).aE(paramString, paramInt))
        {
          new com.tencent.mm.plugin.appbrand.widget.f.c(paramContext).D(paramContext.getResources().getString(2131296873)).show();
          AppMethodBeat.o(133322);
          return true;
        }
        r(paramContext, paramBoolean);
      }
      catch (Exception localException)
      {
        int i;
        com.tencent.mm.ui.widget.b.c localc1;
        ab.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
        r(paramContext, paramBoolean);
        continue;
        if (i != -3) {
          continue;
        }
        com.tencent.mm.ui.widget.b.c localc2 = h.a(paramContext, paramContext.getResources().getString(2131296563), "", paramContext.getResources().getString(2131297018), null);
        if (localc2 == null) {
          continue;
        }
        localc2.setCanceledOnTouchOutside(false);
        localc2.rD(true);
        continue;
        r(paramContext, paramBoolean);
        continue;
      }
      AppMethodBeat.o(133322);
      return false;
      i = ((af)com.tencent.mm.kernel.g.E(af.class)).aD(paramString, paramInt);
      if (i == 0)
      {
        new com.tencent.mm.plugin.appbrand.widget.f.c(paramContext).D(paramContext.getResources().getString(2131296872)).show();
        AppMethodBeat.o(133322);
        return true;
      }
      if (i != -2) {
        continue;
      }
      i = ((af)com.tencent.mm.kernel.g.E(af.class)).awR();
      localc1 = h.a(paramContext, paramContext.getResources().getString(2131296612, new Object[] { Integer.valueOf(i) }), "", paramContext.getResources().getString(2131297018), null);
      if (localc1 != null)
      {
        localc1.setCanceledOnTouchOutside(false);
        localc1.rD(true);
      }
    }
  }
  
  private static void r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(133323);
    al.d(new g.1(paramContext, paramBoolean));
    AppMethodBeat.o(133323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.g
 * JD-Core Version:    0.7.0.1
 */