package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fi.b;
import com.tencent.mm.sdk.platformtools.ab;

final class ExtControlProviderOpenApi$1$1
  implements Runnable
{
  ExtControlProviderOpenApi$1$1(ExtControlProviderOpenApi.1 param1, fi paramfi) {}
  
  public final void run()
  {
    AppMethodBeat.i(20309);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
    if ((this.mec == null) || (this.mec.cto == null) || (this.mec.cto.csU == 0))
    {
      AppMethodBeat.o(20309);
      return;
    }
    ab.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
    this.med.cv(this.mec.cto.ctq);
    AppMethodBeat.o(20309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1.1
 * JD-Core Version:    0.7.0.1
 */