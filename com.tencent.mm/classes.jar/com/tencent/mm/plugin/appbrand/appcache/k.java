package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.pluginsdk.g.a.b.a;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

public enum k
  implements b<l, m, com.tencent.mm.pluginsdk.g.a.c.k>
{
  public final i<String, b.a<m, com.tencent.mm.pluginsdk.g.a.c.k>> gUh;
  
  static
  {
    AppMethodBeat.i(59435);
    gUg = new k("INSTANCE");
    gUi = new k[] { gUg };
    AppMethodBeat.o(59435);
  }
  
  private k()
  {
    AppMethodBeat.i(59433);
    this.gUh = new i();
    AppMethodBeat.o(59433);
  }
  
  public final void a(l paraml, m paramm)
  {
    AppMethodBeat.i(59434);
    Object localObject1;
    if (paramm.status == 2)
    {
      localObject1 = ((d)g.E(d.class)).aur();
      if (localObject1 == null)
      {
        ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.gXs;
      }
    }
    for (;;)
    {
      Object localObject2 = this.gUh.bs(paraml.vMK);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paraml.appId, (b.a.a)localObject1, paramm);
      }
      localObject2 = ((af)localObject1).B(paraml.appId, paraml.gUj, paraml.version);
      if (localObject2 == null)
      {
        ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paraml.toShortString() });
        localObject1 = b.a.a.gXs;
      }
      else
      {
        ((ae)localObject2).field_pkgPath = paraml.getFilePath();
        boolean bool = af.a((ae)localObject2);
        ab.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paraml.toShortString() });
        if (bool)
        {
          ((af)localObject1).update((c)localObject2, new String[0]);
          localObject1 = b.a.a.gXl;
        }
        else
        {
          localObject1 = b.a.a.gXo;
          continue;
          ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paramm });
          if ((paramm.vOv instanceof a)) {
            localObject1 = b.a.a.gXr;
          } else {
            switch (paramm.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.gXm;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.gXq;
            }
          }
        }
      }
    }
    AppMethodBeat.o(59434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k
 * JD-Core Version:    0.7.0.1
 */