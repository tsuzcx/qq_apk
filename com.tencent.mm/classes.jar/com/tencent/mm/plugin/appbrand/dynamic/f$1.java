package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ah.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements b.a
{
  f$1(f paramf) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.1
 * JD-Core Version:    0.7.0.1
 */