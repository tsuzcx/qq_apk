package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class r
  extends l
{
  private static final int CTRL_INDEX = 494;
  private static final String NAME = "onViewDidResize";
  private static r gfq = new r();
  
  public static void a(q paramq, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    y.i("MicroMsg.AppBrandOnViewDidResize", "dispatchOrientationChanged screenW = " + paramInt4 + " screenH = " + paramInt5 + " pageW = " + paramInt2 + " pageH = " + paramInt3);
    HashMap localHashMap1 = new HashMap(1);
    localHashMap1.put("windowWidth", Integer.valueOf(h.mx(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(h.mx(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(h.mx(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(h.mx(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (paramInt6 == 2) {
      localHashMap2.put("deviceOrientation", "landscape");
    }
    for (;;)
    {
      gfq.o(localHashMap2).a(paramq, paramq.hashCode()).dispatch();
      gfq.o(localHashMap2).a(paramq.Zy(), paramq.hashCode()).dispatch();
      return;
      if (paramInt6 == 1) {
        localHashMap2.put("deviceOrientation", "portrait");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r
 * JD-Core Version:    0.7.0.1
 */