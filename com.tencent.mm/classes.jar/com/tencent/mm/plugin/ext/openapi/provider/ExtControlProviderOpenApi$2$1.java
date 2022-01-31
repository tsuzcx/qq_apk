package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.ff.b;
import com.tencent.mm.sdk.platformtools.ab;

final class ExtControlProviderOpenApi$2$1
  implements Runnable
{
  ExtControlProviderOpenApi$2$1(ExtControlProviderOpenApi.2 param2, ff paramff) {}
  
  public final void run()
  {
    AppMethodBeat.i(20312);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
    if ((this.mee == null) || (this.mee.csS == null) || (this.mee.csS.csU == 0))
    {
      AppMethodBeat.o(20312);
      return;
    }
    ab.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(this.mee.csS.csV), this.mee.csS.csW });
    this.mef.cv(Integer.valueOf(this.mee.csS.csV));
    AppMethodBeat.o(20312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2.1
 * JD-Core Version:    0.7.0.1
 */