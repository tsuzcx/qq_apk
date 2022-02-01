package com.tencent.mm.plugin.finder.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.plugin.findersdk.a.y.b;
import com.tencent.mm.plugin.findersdk.a.y.c;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderPoiService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "()V", "poiRedirectRequest", "", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "Companion", "plugin-finder_release"})
public final class e
  implements y
{
  public static final a Adv;
  
  static
  {
    AppMethodBeat.i(270133);
    Adv = new a((byte)0);
    AppMethodBeat.o(270133);
  }
  
  public final void a(eka parameka, y.a parama, String paramString, y.c paramc)
  {
    AppMethodBeat.i(270131);
    p.k(parameka, "location");
    p.k(parama, "fromType");
    p.k(paramc, "callback");
    Log.i("Finder.FinderPoiService", "poiRedirectRequest: poiClassifyId = " + parameka.SOz + ", Longitude = " + parameka.ScO + ", Latitude = " + parameka.ScP + ", fromType = " + parama);
    d locald = d.AjH;
    boolean bool = ((Boolean)d.dXf().aSr()).booleanValue();
    Log.i("Finder.FinderPoiService", "isGoToNewPage = ".concat(String.valueOf(bool)));
    if (bool)
    {
      paramc = new Intent();
      paramc.putExtra("key_location", parameka.toByteArray());
      paramc.putExtra("key_from_type", (Serializable)parama);
      paramc.putExtra("key_sns_feed_id", paramString);
      ((ak)h.ag(ak.class)).fillContextIdToIntent(4, 11, 81, paramc);
      parameka = a.ACH;
      parameka = MMApplicationContext.getContext();
      p.j(parameka, "MMApplicationContext.getContext()");
      a.aq(parameka, paramc);
      AppMethodBeat.o(270131);
      return;
    }
    paramc.a(y.b.Bvm);
    AppMethodBeat.o(270131);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderPoiService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e
 * JD-Core Version:    0.7.0.1
 */