package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.u.j;
import com.tencent.mm.pluginsdk.g.a.b.a;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import java.util.Iterator;
import java.util.Set;

public enum e
  implements b<f, m, k>
{
  public final j<String, b.a<m, k>> fBW = new j();
  
  private e() {}
  
  public final void a(f paramf, m paramm)
  {
    Object localObject1;
    if (paramm.status == 2)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaH();
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.fFa;
      }
    }
    for (;;)
    {
      Object localObject2 = this.fBW.aW(paramf.rVT);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paramf.appId, (b.a.a)localObject1, paramm);
      }
      localObject2 = ((z)localObject1).p(paramf.appId, paramf.fBY, paramf.version);
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paramf.toShortString() });
        localObject1 = b.a.a.fFa;
      }
      else
      {
        ((y)localObject2).field_pkgPath = paramf.bjl();
        boolean bool = z.a((y)localObject2);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paramf.toShortString() });
        if (bool)
        {
          ((z)localObject1).c((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
          localObject1 = b.a.a.fET;
        }
        else
        {
          localObject1 = b.a.a.fEW;
          continue;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paramm });
          if ((paramm.rXE instanceof a)) {
            localObject1 = b.a.a.fEZ;
          } else {
            switch (paramm.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.fEU;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.fEY;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.e
 * JD-Core Version:    0.7.0.1
 */