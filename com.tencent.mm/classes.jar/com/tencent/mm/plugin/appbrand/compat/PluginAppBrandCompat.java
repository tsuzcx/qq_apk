package com.tencent.mm.plugin.appbrand.compat;

import android.support.annotation.Keep;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.t.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.d;

@Deprecated
@Keep
public final class PluginAppBrandCompat
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.appbrand.compat.a.c
{
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.b.class, new com.tencent.mm.kernel.c.e(new b()));
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.appbrand.compat.a.a.class, new com.tencent.mm.kernel.c.e(new a()));
      return;
      com.tencent.luggage.b.e.a(c.a.class, new d());
    }
  }
  
  public final void installed()
  {
    super.installed();
    alias(com.tencent.mm.plugin.appbrand.compat.a.c.class);
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat
 * JD-Core Version:    0.7.0.1
 */