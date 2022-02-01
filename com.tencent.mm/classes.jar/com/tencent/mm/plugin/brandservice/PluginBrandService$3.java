package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.u;
import java.util.ArrayList;

final class PluginBrandService$3
  implements h.a
{
  PluginBrandService$3(PluginBrandService paramPluginBrandService) {}
  
  public final void a(h paramh, final h.c paramc)
  {
    AppMethodBeat.i(5539);
    if ((paramh == null) || (paramc == null))
    {
      AppMethodBeat.o(5539);
      return;
    }
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5538);
        int i;
        if ((("insert".equals(paramc.tyD)) || ("update".equals(paramc.tyD))) && (paramc.tyE != null))
        {
          i = 0;
          while (i < paramc.tyE.size())
          {
            bl localbl = (bl)paramc.tyE.get(i);
            if (localbl.field_isSend != 1) {
              u.aE(localbl);
            }
            i += 1;
          }
          AppMethodBeat.o(5538);
          return;
        }
        if (("delete".equals(paramc.tyD)) && (paramc.tyE != null))
        {
          i = 0;
          while (i < paramc.tyE.size())
          {
            u.aF((bl)paramc.tyE.get(i));
            i += 1;
          }
        }
        AppMethodBeat.o(5538);
      }
    }, 0L);
    AppMethodBeat.o(5539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.3
 * JD-Core Version:    0.7.0.1
 */