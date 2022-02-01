package com.tencent.mm.plugin.finder.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.plugin.i.a.y.a;
import com.tencent.mm.plugin.i.a.y.b;
import com.tencent.mm.plugin.i.a.y.c;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderPoiService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "()V", "poiRedirectRequest", "", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "Companion", "plugin-finder_release"})
public final class d
  implements y
{
  public static final a vvV;
  
  static
  {
    AppMethodBeat.i(251463);
    vvV = new a((byte)0);
    AppMethodBeat.o(251463);
  }
  
  public final void a(eaa parameaa, y.a parama, String paramString, y.c paramc)
  {
    AppMethodBeat.i(251462);
    p.h(parameaa, "location");
    p.h(parama, "fromType");
    p.h(paramc, "callback");
    Log.i("Finder.FinderPoiService", "poiRedirectRequest: poiClassifyId = " + parameaa.LIb + ", Longitude = " + parameaa.LbC + ", Latitude = " + parameaa.LbD + ", fromType = " + parama);
    c localc = c.vCb;
    boolean bool = ((Boolean)c.dxd().value()).booleanValue();
    Log.i("Finder.FinderPoiService", "isGoToNewPage = ".concat(String.valueOf(bool)));
    if (bool)
    {
      paramc = new Intent();
      paramc.putExtra("key_location", parameaa.toByteArray());
      paramc.putExtra("key_from_type", (Serializable)parama);
      paramc.putExtra("key_sns_feed_id", paramString);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 11, 81, paramc);
      parameaa = a.vUU;
      parameaa = MMApplicationContext.getContext();
      p.g(parameaa, "MMApplicationContext.getContext()");
      a.aj(parameaa, paramc);
      AppMethodBeat.o(251462);
      return;
    }
    paramc.a(y.b.wEg);
    AppMethodBeat.o(251462);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderPoiService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.d
 * JD-Core Version:    0.7.0.1
 */