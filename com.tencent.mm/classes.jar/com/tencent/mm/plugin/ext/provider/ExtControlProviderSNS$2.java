package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.ad;

final class ExtControlProviderSNS$2
  implements Runnable
{
  ExtControlProviderSNS$2(ExtControlProviderSNS paramExtControlProviderSNS, ad paramad, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20379);
    fp localfp = new fp();
    localfp.ctH.type = 1;
    localfp.ctH.username = this.ego.field_username;
    localfp.ctH.ctI = ExtControlProviderSNS.a(this.meQ);
    localfp.ctH.ctJ = ExtControlProviderSNS.b(this.meQ);
    localfp.ctH.ctK = ExtControlProviderSNS.c(this.meQ);
    localfp.ctH.ctL = new ExtControlProviderSNS.2.1(this);
    a.ymk.l(localfp);
    AppMethodBeat.o(20379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.2
 * JD-Core Version:    0.7.0.1
 */