package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.k.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.Set;

public enum k
  implements b<l, com.tencent.mm.pluginsdk.k.a.c.l>
{
  public final com.tencent.mm.plugin.appbrand.ac.h<String, b.a<com.tencent.mm.pluginsdk.k.a.c.l, WxaPkgLoadProgress>> nEo;
  
  static
  {
    AppMethodBeat.i(90548);
    nEn = new k("INSTANCE");
    nEp = new k[] { nEn };
    AppMethodBeat.o(90548);
  }
  
  private k()
  {
    AppMethodBeat.i(90546);
    this.nEo = new com.tencent.mm.plugin.appbrand.ac.h();
    AppMethodBeat.o(90546);
  }
  
  public final void a(l paraml, com.tencent.mm.pluginsdk.k.a.c.l paraml1)
  {
    AppMethodBeat.i(90547);
    Object localObject1;
    if (paraml1.status == 2)
    {
      localObject1 = ((e)com.tencent.mm.kernel.h.ae(e.class)).bFc();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.nIM;
      }
    }
    for (;;)
    {
      Object localObject2 = this.nEo.cO(paraml.QYU);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paraml.appId, (b.a.a)localObject1, paraml1);
      }
      localObject2 = ((ao)localObject1).z(paraml.appId, paraml.encryptType, paraml.version);
      if (localObject2 == null)
      {
        Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paraml.bGo() });
        localObject1 = b.a.a.nIM;
      }
      else
      {
        ((an)localObject2).field_pkgPath = paraml.getFilePath();
        boolean bool = ao.a((an)localObject2);
        Log.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paraml.bGo() });
        if (bool)
        {
          ((ao)localObject1).update((IAutoDBItem)localObject2, new String[0]);
          localObject1 = b.a.a.nIF;
        }
        else
        {
          localObject1 = b.a.a.nII;
          continue;
          Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paraml1 });
          if ((paraml1.RaE instanceof a)) {
            localObject1 = b.a.a.nIL;
          } else {
            switch (paraml1.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.nIG;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.nIK;
            }
          }
        }
      }
    }
    AppMethodBeat.o(90547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k
 * JD-Core Version:    0.7.0.1
 */