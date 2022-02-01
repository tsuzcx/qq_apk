package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.eaa;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService;", "Lcom/tencent/mm/kernel/service/IService;", "poiRedirectRequest", "", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "snsFeedId", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "FinderPoiFromType", "FinderPoiRedirectType", "LbsAgentPoiSourceFlag", "PoiRedirectCallBack", "finder-sdk_release"})
public abstract interface y
  extends a
{
  public abstract void a(eaa parameaa, y.a parama, String paramString, c paramc);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "", "(Ljava/lang/String;I)V", "FINDER_POI_REDIRECT_TYPE_DEFAULT", "FINDER_POI_REDIRECT_TYPE_POI_PAGE", "FINDER_POI_REDIRECT_TYPE_MPH5", "FINDER_POI_REDIRECT_TYPE_USER_PAGE", "FINDER_POI_REDIRECT_TYPE_MAP", "finder-sdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(208793);
      b localb1 = new b("FINDER_POI_REDIRECT_TYPE_DEFAULT", 0);
      wEg = localb1;
      b localb2 = new b("FINDER_POI_REDIRECT_TYPE_POI_PAGE", 1);
      wEh = localb2;
      b localb3 = new b("FINDER_POI_REDIRECT_TYPE_MPH5", 2);
      wEi = localb3;
      b localb4 = new b("FINDER_POI_REDIRECT_TYPE_USER_PAGE", 3);
      wEj = localb4;
      b localb5 = new b("FINDER_POI_REDIRECT_TYPE_MAP", 4);
      wEk = localb5;
      wEl = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(208793);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "", "onPoiRedirect", "", "type", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "finder-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(y.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.y
 * JD-Core Version:    0.7.0.1
 */