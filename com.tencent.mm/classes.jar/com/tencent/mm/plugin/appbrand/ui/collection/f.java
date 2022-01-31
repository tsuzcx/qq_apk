package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class f
{
  public static boolean a(boolean paramBoolean, Context paramContext, String paramString, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      if (((af)g.r(af.class)).ar(paramString, paramInt))
      {
        new com.tencent.mm.plugin.appbrand.widget.e.c(paramContext).u(paramContext.getResources().getString(y.j.app_brand_usage_modify_collection_removed)).show();
        return true;
      }
      n(paramContext, paramBoolean);
    }
    catch (Exception localException)
    {
      int i;
      com.tencent.mm.ui.widget.a.c localc;
      y.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
      n(paramContext, paramBoolean);
    }
    i = ((af)g.r(af.class)).aq(paramString, paramInt);
    if (i == 0)
    {
      new com.tencent.mm.plugin.appbrand.widget.e.c(paramContext).u(paramContext.getResources().getString(y.j.app_brand_usage_modify_collection_added)).show();
      return true;
    }
    if (i == -2)
    {
      i = ((af)g.r(af.class)).acL();
      localc = h.a(paramContext, paramContext.getResources().getString(y.j.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(i) }), "", paramContext.getResources().getString(y.j.app_ok), null);
      if (localc != null)
      {
        localc.setCanceledOnTouchOutside(false);
        localc.nT(true);
      }
    }
    else
    {
      n(paramContext, paramBoolean);
    }
    return false;
  }
  
  private static void n(Context paramContext, boolean paramBoolean)
  {
    ai.d(new f.1(paramContext, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.f
 * JD-Core Version:    0.7.0.1
 */