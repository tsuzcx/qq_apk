package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.y;

final class PluginBrandService$7
  implements x.c
{
  PluginBrandService$7(PluginBrandService paramPluginBrandService) {}
  
  public final void a(Object paramObject, x.a parama)
  {
    AppMethodBeat.i(208387);
    b.a("UpdateBizMainCellThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5543);
        y.ftC();
        AppMethodBeat.o(5543);
      }
    }, 0L);
    AppMethodBeat.o(208387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.7
 * JD-Core Version:    0.7.0.1
 */