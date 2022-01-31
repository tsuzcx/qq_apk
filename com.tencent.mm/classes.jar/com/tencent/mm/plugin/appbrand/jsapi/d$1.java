package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.b.b;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class d$1
  implements a.a
{
  d$1(d paramd) {}
  
  public final <T extends b> void a(Class<T> paramClass, T paramT)
  {
    if (paramT == null)
    {
      y.w("MicroMsg.AppBrandComponent", "registerCustomize failed, clazz(%s) or customize(%s) is null.", new Object[] { paramClass, paramT });
      return;
    }
    d.geM.put(paramClass, paramT);
  }
  
  public final <T extends com.tencent.luggage.b.d> void a(Class<T> paramClass, T paramT)
  {
    d.geN.put(paramClass, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.1
 * JD-Core Version:    0.7.0.1
 */