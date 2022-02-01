package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.fei;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "Lcom/tencent/mm/kernel/service/IService;", "idKeyStatId", "", "getIdKeyStatId", "()J", "poiRedirectRequest", "", "context", "Landroid/content/Context;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "FinderPoiFromType", "FinderPoiRedirectType", "LbsAgentPoiSourceFlag", "PoiRedirectCallBack", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bi
  extends a
{
  public abstract void a(Context paramContext, fei paramfei, a parama, String paramString, c paramc);
  
  public abstract long ePz();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "", "(Ljava/lang/String;I)V", "FINDER_POI_FROM_TYPE_DEFAULT", "FINDER_POI_FROM_TYPE_SNS", "FINDER_POI_FROM_TYPE_FINDER", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(274060);
      Hcn = new a("FINDER_POI_FROM_TYPE_DEFAULT", 0);
      Hco = new a("FINDER_POI_FROM_TYPE_SNS", 1);
      Hcp = new a("FINDER_POI_FROM_TYPE_FINDER", 2);
      Hcq = new a[] { Hcn, Hco, Hcp };
      AppMethodBeat.o(274060);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "", "onPoiRedirect", "", "type", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(bi.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.bi
 * JD-Core Version:    0.7.0.1
 */