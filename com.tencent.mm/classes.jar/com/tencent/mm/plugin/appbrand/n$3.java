package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.e.a;
import com.tencent.mm.plugin.appbrand.config.e.b;
import com.tencent.mm.sdk.platformtools.y;

final class n$3
  implements e.a
{
  n$3(n paramn, i.b paramb) {}
  
  public final void a(e.b paramb, boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntime.onOrientationChanged");
    if (!paramBoolean) {
      if (paramb != null) {
        break label41;
      }
    }
    label41:
    for (paramb = "null";; paramb = paramb.name())
    {
      y.f("MicroMsg.AppBrandRuntimeWC", "OnOrientationChanged failure  ret:[%s]", new Object[] { paramb });
      this.fzN.pP();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.3
 * JD-Core Version:    0.7.0.1
 */