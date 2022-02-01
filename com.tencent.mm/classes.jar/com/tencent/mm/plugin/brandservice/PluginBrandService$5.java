package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.t.c;
import com.tencent.mm.storage.u;

final class PluginBrandService$5
  implements t.c
{
  PluginBrandService$5(PluginBrandService paramPluginBrandService) {}
  
  public final void a(Object paramObject, t.a parama)
  {
    AppMethodBeat.i(5542);
    b.a("UpdateBizMainCellThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5541);
        u.eKg();
        AppMethodBeat.o(5541);
      }
    }, 0L);
    AppMethodBeat.o(5542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.5
 * JD-Core Version:    0.7.0.1
 */