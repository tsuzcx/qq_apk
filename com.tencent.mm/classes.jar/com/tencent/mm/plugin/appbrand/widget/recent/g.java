package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mp;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements k
{
  public final AppBrandRecentView a(Context paramContext, k.b paramb, k.a parama)
  {
    AppMethodBeat.i(324039);
    if (paramb == k.b.uQz)
    {
      paramb = new MenuAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(ba.d.app_brand_recent_view_height));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(ba.d.app_brand_recent_view_padding_top), 0, 0);
      paramb.setLayoutParams(parama);
      AppMethodBeat.o(324039);
      return paramb;
    }
    AppMethodBeat.o(324039);
    return null;
  }
  
  public final void cSO()
  {
    AppMethodBeat.i(324049);
    Log.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[] { Integer.valueOf(300), Integer.valueOf(8) });
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      mp localmp = new mp();
      localmp.hOL.UZ = 300;
      localmp.hOL.type = 8;
      localmp.publish();
    }
    AppMethodBeat.o(324049);
  }
  
  public final boolean cSP()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.g
 * JD-Core Version:    0.7.0.1
 */