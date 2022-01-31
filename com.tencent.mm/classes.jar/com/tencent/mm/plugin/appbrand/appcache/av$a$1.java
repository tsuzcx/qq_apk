package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.m.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.platformtools.ab;

final class av$a$1
  implements m.c
{
  av$a$1(av.a parama, String paramString, int paramInt) {}
  
  public final void yA(String paramString)
  {
    AppMethodBeat.i(129430);
    ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramString });
    d.j(this.val$appId, this.bHS, paramString);
    AppMethodBeat.o(129430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av.a.1
 * JD-Core Version:    0.7.0.1
 */