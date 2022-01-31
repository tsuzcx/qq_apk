package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.mm.plugin.appbrand.v.b.a.a;
import com.tencent.mm.plugin.appbrand.v.b.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class f$1
  implements a.b
{
  public final void a(int paramInt, String paramString, a.a parama)
  {
    if (paramInt != 0)
    {
      y.e("MicroMsg.AppBrandMapManager", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    y.d("MicroMsg.AppBrandMapManager", "refresh location latitude = %f, longitude = %f", new Object[] { Double.valueOf(parama.latitude), Double.valueOf(parama.longitude) });
    if (!f.access$000())
    {
      y.w("MicroMsg.AppBrandMapManager", "refresh location fail, no perrmission");
      return;
    }
    paramString = f.Qq().values().iterator();
    while (paramString.hasNext())
    {
      Iterator localIterator = ((HashMap)paramString.next()).values().iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          localb.a(parama.latitude, parama.longitude, parama.bbx, parama.hlU);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.f.1
 * JD-Core Version:    0.7.0.1
 */