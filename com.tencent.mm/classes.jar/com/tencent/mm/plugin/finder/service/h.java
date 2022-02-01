package com.tencent.mm.plugin.finder.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.findersdk.a.bi;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.plugin.findersdk.a.bi.b;
import com.tencent.mm.plugin.findersdk.a.bi.c;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderPoiService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "()V", "poiRedirectRequest", "", "context", "Landroid/content/Context;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements bi
{
  public static final a Fzr;
  
  static
  {
    AppMethodBeat.i(330045);
    Fzr = new a((byte)0);
    AppMethodBeat.o(330045);
  }
  
  public final void a(Context paramContext, fei paramfei, bi.a parama, String paramString, bi.c paramc)
  {
    AppMethodBeat.i(330061);
    s.u(paramContext, "context");
    s.u(paramfei, "location");
    s.u(parama, "fromType");
    s.u(paramc, "callback");
    Log.i("Finder.FinderPoiService", "poiRedirectRequest: poiClassifyId = " + paramfei.ZWG + ", Longitude = " + paramfei.ZaG + ", Latitude = " + paramfei.ZaH + ", fromType = " + parama);
    d locald = d.FAy;
    boolean bool = ((Boolean)d.eVU().bmg()).booleanValue();
    Log.i("Finder.FinderPoiService", s.X("isGoToNewPage = ", Boolean.valueOf(bool)));
    if (bool)
    {
      paramc = new Intent();
      paramc.putExtra("key_location", paramfei.toByteArray());
      paramc.putExtra("key_from_type", (Serializable)parama);
      paramc.putExtra("key_sns_feed_id", paramString);
      paramc.putExtra("key_entrance_type", 0);
      if (parama == bi.a.Hco) {
        paramc.putExtra("key_finder_teen_mode_scene", 3);
      }
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 11, 81, paramc);
      a.GfO.w(paramContext, paramc);
      AppMethodBeat.o(330061);
      return;
    }
    paramc.a(bi.b.Hcr);
    AppMethodBeat.o(330061);
  }
  
  public final long ePz()
  {
    AppMethodBeat.i(330069);
    s.u(this, "this");
    AppMethodBeat.o(330069);
    return 1663L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderPoiService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.h
 * JD-Core Version:    0.7.0.1
 */