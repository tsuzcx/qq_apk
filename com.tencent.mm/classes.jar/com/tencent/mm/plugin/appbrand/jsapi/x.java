package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
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
    localHashMap1.put("windowWidth", Integer.valueOf(g.vc(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(g.vc(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(g.vc(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(g.vc(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (a.contains(e.b.lOX, paramb)) {
      localHashMap2.put("deviceOrientation", "landscape");
    }
    for (;;)
    {
      if (paramMap != null) {
        localHashMap2.put("pageOrientation", new HashMap(paramMap));
      }
      paramb = h.m(localHashMap2).toString();
      ac.i("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", new Object[] { getName(), paramaa.getAppId(), paramaa.jZJ, paramb });
      LN(paramb).a(paramaa, paramaa.aUT()).beN();
      LN(paramb).a(paramaa.CX(), paramaa.aUT()).beN();
      AppMethodBeat.o(182988);
      return;
      if (e.b.lOQ == paramb) {
        localHashMap2.put("deviceOrientation", "portrait");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x
 * JD-Core Version:    0.7.0.1
 */