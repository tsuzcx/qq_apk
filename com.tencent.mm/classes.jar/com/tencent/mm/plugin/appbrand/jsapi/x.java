package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public class x
  extends p
{
  private static final int CTRL_INDEX = 494;
  private static final String NAME = "onViewDidResize";
  
  public final void a(z paramz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, e.b paramb, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(182988);
    HashMap localHashMap1 = new HashMap(10);
    localHashMap1.put("windowWidth", Integer.valueOf(g.vM(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(g.vM(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(g.vM(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(g.vM(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (a.contains(e.b.mtK, paramb)) {
      localHashMap2.put("deviceOrientation", "landscape");
    }
    for (;;)
    {
      if (paramMap != null) {
        localHashMap2.put("pageOrientation", new HashMap(paramMap));
      }
      paramb = h.t(localHashMap2).toString();
      ae.i("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", new Object[] { getName(), paramz.getAppId(), paramz.kxv, paramb });
      PP(paramb).a(paramz, paramz.aXX()).bja();
      PP(paramb).a(paramz.Ey(), paramz.aXX()).bja();
      AppMethodBeat.o(182988);
      return;
      if (e.b.mtD == paramb) {
        localHashMap2.put("deviceOrientation", "portrait");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x
 * JD-Core Version:    0.7.0.1
 */