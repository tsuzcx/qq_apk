package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.h.a.fm;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.ad;

final class ExtControlProviderSNS$2
  implements Runnable
{
  ExtControlProviderSNS$2(ExtControlProviderSNS paramExtControlProviderSNS, ad paramad, b paramb) {}
  
  public final void run()
  {
    fm localfm = new fm();
    localfm.bMm.type = 1;
    localfm.bMm.username = this.doS.field_username;
    localfm.bMm.bMn = ExtControlProviderSNS.a(this.jKM);
    localfm.bMm.bMo = ExtControlProviderSNS.b(this.jKM);
    localfm.bMm.bMp = ExtControlProviderSNS.c(this.jKM);
    localfm.bMm.bMq = new ExtControlProviderSNS.2.1(this);
    a.udP.m(localfm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.2
 * JD-Core Version:    0.7.0.1
 */