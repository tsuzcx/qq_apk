package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.j;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.res.downloader.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.Set;

public enum l
  implements b<m, com.tencent.mm.pluginsdk.res.downloader.model.l>
{
  public final j<String, b.a<com.tencent.mm.pluginsdk.res.downloader.model.l, WxaPkgLoadProgress>> qEj;
  
  static
  {
    AppMethodBeat.i(90548);
    qEi = new l("INSTANCE");
    qEk = new l[] { qEi };
    AppMethodBeat.o(90548);
  }
  
  private l()
  {
    AppMethodBeat.i(90546);
    this.qEj = new j();
    AppMethodBeat.o(90546);
  }
  
  public final void a(m paramm, com.tencent.mm.pluginsdk.res.downloader.model.l paraml)
  {
    AppMethodBeat.i(90547);
    Object localObject1;
    if (paraml.status == 2)
    {
      localObject1 = ((e)h.ax(e.class)).cep();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.qIC;
      }
    }
    for (;;)
    {
      Object localObject2 = this.qEj.ek(paramm.XUX);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paramm.appId, (b.a.a)localObject1, paraml);
      }
      localObject2 = ((ap)localObject1).D(paramm.appId, paramm.encryptType, paramm.version);
      if (localObject2 == null)
      {
        Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paramm.cfO() });
        localObject1 = b.a.a.qIC;
      }
      else
      {
        ((ao)localObject2).field_pkgPath = paramm.getFilePath();
        boolean bool = ap.a((ao)localObject2);
        Log.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paramm.cfO() });
        if (bool)
        {
          ((ap)localObject1).update((IAutoDBItem)localObject2, new String[0]);
          localObject1 = b.a.a.qIw;
        }
        else
        {
          localObject1 = b.a.a.qIz;
          continue;
          Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paraml });
          if ((paraml.XWJ instanceof a)) {
            localObject1 = b.a.a.qIB;
          } else {
            switch (paraml.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.qIx;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.qIA;
            }
          }
        }
      }
    }
    AppMethodBeat.o(90547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.l
 * JD-Core Version:    0.7.0.1
 */