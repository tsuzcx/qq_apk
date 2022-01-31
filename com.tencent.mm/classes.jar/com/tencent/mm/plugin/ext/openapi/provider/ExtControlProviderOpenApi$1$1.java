package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.h.a.ff;
import com.tencent.mm.h.a.ff.b;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderOpenApi$1$1
  implements Runnable
{
  ExtControlProviderOpenApi$1$1(ExtControlProviderOpenApi.1 param1, ff paramff) {}
  
  public final void run()
  {
    y.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
    if ((this.jJX == null) || (this.jJX.bLU == null) || (this.jJX.bLU.bLA == 0)) {
      return;
    }
    y.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
    this.jJY.bS(this.jJX.bLU.bLW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1.1
 * JD-Core Version:    0.7.0.1
 */