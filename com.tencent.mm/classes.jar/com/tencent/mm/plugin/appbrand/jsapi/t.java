package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public class t
  extends p
{
  private static final int CTRL_INDEX = 494;
  private static final String NAME = "onViewDidResize";
  
  public final void a(v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(101940);
    HashMap localHashMap1 = new HashMap(1);
    localHashMap1.put("windowWidth", Integer.valueOf(g.pM(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(g.pM(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(g.pM(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(g.pM(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (paramInt6 == 2) {
      localHashMap2.put("deviceOrientation", "landscape");
    }
    for (;;)
    {
      if (paramMap != null) {
        localHashMap2.put("pageOrientation", new HashMap(paramMap));
      }
      paramMap = h.k(localHashMap2).toString();
      ab.i("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", new Object[] { getName(), paramv.getAppId(), paramv.hzM, paramMap });
      BM(paramMap).a(paramv, paramv.hashCode()).aBz();
      BM(paramMap).a(paramv.ws(), paramv.hashCode()).aBz();
      AppMethodBeat.o(101940);
      return;
      if (paramInt6 == 1) {
        localHashMap2.put("deviceOrientation", "portrait");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t
 * JD-Core Version:    0.7.0.1
 */