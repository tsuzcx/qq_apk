package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.y;
import java.util.ArrayList;

final class PluginBrandService$5
  implements i.a
{
  PluginBrandService$5(PluginBrandService paramPluginBrandService) {}
  
  public final void a(i parami, final i.c paramc)
  {
    AppMethodBeat.i(208384);
    if ((parami == null) || (paramc == null))
    {
      AppMethodBeat.o(208384);
      return;
    }
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5541);
        int i;
        if ((("insert".equals(paramc.vWi)) || ("update".equals(paramc.vWi))) && (paramc.gQn != null))
        {
          i = 0;
          while (i < paramc.gQn.size())
          {
            bv localbv = (bv)paramc.gQn.get(i);
            if (localbv.field_isSend != 1) {
              y.aI(localbv);
            }
            i += 1;
          }
          AppMethodBeat.o(5541);
          return;
        }
        if (("delete".equals(paramc.vWi)) && (paramc.gQn != null))
        {
          i = 0;
          while (i < paramc.gQn.size())
          {
            y.aJ((bv)paramc.gQn.get(i));
            i += 1;
          }
        }
        AppMethodBeat.o(5541);
      }
    }, 0L);
    AppMethodBeat.o(208384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.5
 * JD-Core Version:    0.7.0.1
 */