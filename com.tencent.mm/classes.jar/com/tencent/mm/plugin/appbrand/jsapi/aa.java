package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public class aa
  extends s
{
  private static final int CTRL_INDEX = 494;
  private static final String NAME = "onViewDidResize";
  
  public final void a(ac paramac, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, e.b paramb, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(182988);
    HashMap localHashMap1 = new HashMap(10);
    localHashMap1.put("windowWidth", Integer.valueOf(g.zB(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(g.zB(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(g.zB(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(g.zB(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (a.contains(e.b.nEs, paramb)) {
      localHashMap2.put("deviceOrientation", "landscape");
    }
    for (;;)
    {
      if (paramMap != null) {
        localHashMap2.put("pageOrientation", new HashMap(paramMap));
      }
      paramb = h.v(localHashMap2).toString();
      Log.i("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", new Object[] { getName(), paramac.getAppId(), paramac.lBI, paramb });
      Zg(paramb).a(paramac, paramac.getComponentId()).bEo();
      Zg(paramb).a(paramac.NY(), paramac.getComponentId()).bEo();
      AppMethodBeat.o(182988);
      return;
      if (e.b.nEl == paramb) {
        localHashMap2.put("deviceOrientation", "portrait");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */