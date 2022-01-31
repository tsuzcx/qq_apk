package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;

final class PluginBrandService$3
  implements h.a
{
  PluginBrandService$3(PluginBrandService paramPluginBrandService) {}
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(13805);
    if ((paramh == null) || (paramc == null))
    {
      AppMethodBeat.o(13805);
      return;
    }
    b.a("BrandServiceWorkerThread", new PluginBrandService.3.1(this, paramc), 0L);
    AppMethodBeat.o(13805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.3
 * JD-Core Version:    0.7.0.1
 */