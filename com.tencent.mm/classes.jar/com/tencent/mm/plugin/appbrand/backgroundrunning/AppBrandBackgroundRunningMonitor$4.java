package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.sdk.platformtools.ae;

final class AppBrandBackgroundRunningMonitor$4
  implements MMToClientEvent.c
{
  public final void ch(Object paramObject)
  {
    AppMethodBeat.i(222189);
    if ((paramObject instanceof MMBackgroundRunningOperationParcel))
    {
      ae.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", new Object[] { (MMBackgroundRunningOperationParcel)paramObject });
      if (g.ab(f.class) != null) {
        ((f)g.ab(f.class)).a((MMBackgroundRunningOperationParcel)paramObject);
      }
    }
    AppMethodBeat.o(222189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.4
 * JD-Core Version:    0.7.0.1
 */