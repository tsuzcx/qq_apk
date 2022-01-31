package com.tencent.mm.plugin.appbrand.appcache.b.a;

import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.u.j;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.bct;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.j.c;

final class a$a
  implements a<Boolean, c<and, ane>>
{
  private Boolean a(c<and, ane> paramc)
  {
    Object localObject1 = (and)paramc.get(0);
    Object localObject2 = (ane)paramc.get(1);
    Object localObject3;
    if (((and)localObject1).type == 0)
    {
      paramc = new s(((and)localObject1).bOL);
      localObject3 = com.tencent.mm.vending.g.f.cKX();
      ((com.tencent.mm.vending.g.b)localObject3).cKW();
      localObject3 = new a.a.1(this, (com.tencent.mm.vending.g.b)localObject3);
      y.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[] { paramc.toString(), ((ane)localObject2).bQC, ((ane)localObject2).url });
      paramc = new com.tencent.mm.plugin.appbrand.appcache.f(paramc.toString(), ((and)localObject1).tiY.tyc, ((and)localObject1).sEs, ((ane)localObject2).url);
      localObject1 = e.fBV;
      localObject2 = at.acr();
      if (localObject2 != null) {
        break label218;
      }
      y.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, null updater");
      ((b.a)localObject3).a(paramc.appId, b.a.a.fFa, null);
    }
    for (;;)
    {
      return Boolean.FALSE;
      if (((and)localObject1).type == 4)
      {
        paramc = new s(((and)localObject1).bOL, ((and)localObject1).thh);
        break;
      }
      throw new IllegalArgumentException(String.format("not support request.type %d", new Object[] { Integer.valueOf(((and)localObject1).type) }));
      label218:
      int i = ((at)localObject2).fEK.b(paramc);
      y.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, addRequest(%s) ret = %d", new Object[] { paramc.toShortString(), Integer.valueOf(i) });
      switch (i)
      {
      default: 
        ((e)localObject1).fBW.h(paramc.rVT, localObject3);
        break;
      case 4: 
        ((b.a)localObject3).a(paramc.appId, b.a.a.fFa, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */