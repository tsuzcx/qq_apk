package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements k
{
  public final AppBrandRecentView a(Context paramContext, k.b paramb, k.a parama)
  {
    AppMethodBeat.i(257246);
    if (paramb == k.b.rFn)
    {
      paramb = new MenuAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(au.d.app_brand_recent_view_height));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(au.d.app_brand_recent_view_padding_top), 0, 0);
      paramb.setLayoutParams(parama);
      AppMethodBeat.o(257246);
      return paramb;
    }
    AppMethodBeat.o(257246);
    return null;
  }
  
  public final void cqi()
  {
    AppMethodBeat.i(257248);
    Log.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[] { Integer.valueOf(300), Integer.valueOf(8) });
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      lj locallj = new lj();
      locallj.fJd.fJe = 300;
      locallj.fJd.type = 8;
      EventCenter.instance.publish(locallj);
    }
    AppMethodBeat.o(257248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.g
 * JD-Core Version:    0.7.0.1
 */