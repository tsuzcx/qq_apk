package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.plugin.appbrand.jsapi.version.a.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class o$6$3
  implements Runnable
{
  o$6$3(o.6 param6, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(128985);
    a locala = this.gRB;
    c localc = this.gRA.gRv.atU();
    ab.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", new Object[] { locala.ibH, localc });
    if (localc == null)
    {
      AppMethodBeat.o(128985);
      return;
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("state", locala.ibH);
    new a.a((byte)0).i(localc).w(localHashMap).aBz();
    AppMethodBeat.o(128985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.6.3
 * JD-Core Version:    0.7.0.1
 */