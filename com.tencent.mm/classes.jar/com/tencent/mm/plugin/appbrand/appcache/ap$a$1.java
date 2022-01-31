package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.n.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.platformtools.y;

final class ap$a$1
  implements n.c
{
  ap$a$1(ap.a parama, String paramString, int paramInt) {}
  
  public final void rf(String paramString)
  {
    y.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramString });
    d.j(this.val$appId, this.bns, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.a.1
 * JD-Core Version:    0.7.0.1
 */