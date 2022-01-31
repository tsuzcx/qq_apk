package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.h.a.fc;
import com.tencent.mm.h.a.fc.b;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderOpenApi$2$1
  implements Runnable
{
  ExtControlProviderOpenApi$2$1(ExtControlProviderOpenApi.2 param2, fc paramfc) {}
  
  public final void run()
  {
    y.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
    if ((this.jJZ == null) || (this.jJZ.bLy == null) || (this.jJZ.bLy.bLA == 0)) {
      return;
    }
    y.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(this.jJZ.bLy.bLB), this.jJZ.bLy.bLC });
    this.jKa.bS(Integer.valueOf(this.jJZ.bLy.bLB));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2.1
 * JD-Core Version:    0.7.0.1
 */