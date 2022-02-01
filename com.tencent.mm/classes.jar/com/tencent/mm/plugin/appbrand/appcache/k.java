package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.j.a.b.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.Set;

public enum k
  implements b<l, m, com.tencent.mm.pluginsdk.j.a.c.k>
{
  public final h<String, b.a<m, com.tencent.mm.pluginsdk.j.a.c.k>> kKy;
  
  static
  {
    AppMethodBeat.i(90548);
    kKx = new k("INSTANCE");
    kKz = new k[] { kKx };
    AppMethodBeat.o(90548);
  }
  
  private k()
  {
    AppMethodBeat.i(90546);
    this.kKy = new h();
    AppMethodBeat.o(90546);
  }
  
  public final void a(l paraml, m paramm)
  {
    AppMethodBeat.i(90547);
    Object localObject1;
    if (paramm.status == 2)
    {
      localObject1 = ((e)g.af(e.class)).buc();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.kOJ;
      }
    }
    for (;;)
    {
      Object localObject2 = this.kKy.cN(paraml.JYs);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paraml.appId, (b.a.a)localObject1, paramm);
      }
      localObject2 = ((an)localObject1).z(paraml.appId, paraml.kKA, paraml.version);
      if (localObject2 == null)
      {
        Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paraml.toShortString() });
        localObject1 = b.a.a.kOJ;
      }
      else
      {
        ((am)localObject2).field_pkgPath = paraml.getFilePath();
        boolean bool = an.a((am)localObject2);
        Log.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paraml.toShortString() });
        if (bool)
        {
          ((an)localObject1).update((IAutoDBItem)localObject2, new String[0]);
          localObject1 = b.a.a.kOC;
        }
        else
        {
          localObject1 = b.a.a.kOF;
          continue;
          Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paramm });
          if ((paramm.Kab instanceof a)) {
            localObject1 = b.a.a.kOI;
          } else {
            switch (paramm.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.kOD;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.kOH;
            }
          }
        }
      }
    }
    AppMethodBeat.o(90547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k
 * JD-Core Version:    0.7.0.1
 */