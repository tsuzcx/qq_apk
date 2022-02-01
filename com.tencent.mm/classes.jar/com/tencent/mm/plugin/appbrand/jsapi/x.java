package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public class x
  extends p
{
  private static final int CTRL_INDEX = 494;
  private static final String NAME = "onViewDidResize";
  
  public final void a(aa paramaa, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, e.b paramb, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(182988);
    HashMap localHashMap1 = new HashMap(10);
    localHashMap1.put("windowWidth", Integer.valueOf(g.uk(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(g.uk(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(g.uk(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(g.uk(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (a.contains(e.b.lmV, paramb)) {
      localHashMap2.put("deviceOrientation", "landscape");
    }
    for (;;)
    {
      if (paramMap != null) {
        localHashMap2.put("pageOrientation", new HashMap(paramMap));
      }
      paramb = h.n(localHashMap2).toString();
      ad.i("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", new Object[] { getName(), paramaa.getAppId(), paramaa.jzm, paramb });
      HJ(paramb).a(paramaa, paramaa.aOd()).aXQ();
      HJ(paramb).a(paramaa.Du(), paramaa.aOd()).aXQ();
      AppMethodBeat.o(182988);
      return;
      if (e.b.lmO == paramb) {
        localHashMap2.put("deviceOrientation", "portrait");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x
 * JD-Core Version:    0.7.0.1
 */