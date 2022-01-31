package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.v.i;
import com.tencent.mm.plugin.appbrand.v.j;
import com.tencent.mm.sdk.platformtools.y;

final class f$3
  implements e
{
  f$3(f paramf, d paramd) {}
  
  public final void x(String paramString1, String paramString2)
  {
    y.e("MicroMsg.AppBrandJSContextInterfaceWC", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramString1, paramString2 });
    j.b(this.fxF, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { i.wI(paramString1), i.wI(paramString2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.3
 * JD-Core Version:    0.7.0.1
 */