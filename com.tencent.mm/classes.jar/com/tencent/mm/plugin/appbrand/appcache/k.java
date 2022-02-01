package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.pluginsdk.j.a.b.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Set;

public enum k
  implements b<l, m, com.tencent.mm.pluginsdk.j.a.c.k>
{
  public final h<String, b.a<m, com.tencent.mm.pluginsdk.j.a.c.k>> jIC;
  
  static
  {
    AppMethodBeat.i(90548);
    jIB = new k("INSTANCE");
    jID = new k[] { jIB };
    AppMethodBeat.o(90548);
  }
  
  private k()
  {
    AppMethodBeat.i(90546);
    this.jIC = new h();
    AppMethodBeat.o(90546);
  }
  
  public final void a(l paraml, m paramm)
  {
    AppMethodBeat.i(90547);
    Object localObject1;
    if (paramm.status == 2)
    {
      localObject1 = ((e)g.ab(e.class)).aYQ();
      if (localObject1 == null)
      {
        ae.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.jMF;
      }
    }
    for (;;)
    {
      Object localObject2 = this.jIC.cG(paraml.Fhz);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paraml.appId, (b.a.a)localObject1, paramm);
      }
      localObject2 = ((an)localObject1).z(paraml.appId, paraml.jIE, paraml.version);
      if (localObject2 == null)
      {
        ae.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paraml.toShortString() });
        localObject1 = b.a.a.jMF;
      }
      else
      {
        ((am)localObject2).field_pkgPath = paraml.getFilePath();
        boolean bool = an.a((am)localObject2);
        ae.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paraml.toShortString() });
        if (bool)
        {
          ((an)localObject1).update((c)localObject2, new String[0]);
          localObject1 = b.a.a.jMy;
        }
        else
        {
          localObject1 = b.a.a.jMB;
          continue;
          ae.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paramm });
          if ((paramm.Fji instanceof a)) {
            localObject1 = b.a.a.jME;
          } else {
            switch (paramm.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.jMz;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.jMD;
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