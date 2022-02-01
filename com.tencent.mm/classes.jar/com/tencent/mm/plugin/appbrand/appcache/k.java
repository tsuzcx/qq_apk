package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.z.h;
import com.tencent.mm.pluginsdk.h.a.b.a;
import com.tencent.mm.pluginsdk.h.a.c.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Set;

public enum k
  implements b<l, m, com.tencent.mm.pluginsdk.h.a.c.k>
{
  public final h<String, b.a<m, com.tencent.mm.pluginsdk.h.a.c.k>> jlN;
  
  static
  {
    AppMethodBeat.i(90548);
    jlM = new k("INSTANCE");
    jlO = new k[] { jlM };
    AppMethodBeat.o(90548);
  }
  
  private k()
  {
    AppMethodBeat.i(90546);
    this.jlN = new h();
    AppMethodBeat.o(90546);
  }
  
  public final void a(l paraml, m paramm)
  {
    AppMethodBeat.i(90547);
    Object localObject1;
    if (paramm.status == 2)
    {
      localObject1 = ((e)g.ab(e.class)).aVb();
      if (localObject1 == null)
      {
        ac.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
        localObject1 = b.a.a.jpJ;
      }
    }
    for (;;)
    {
      Object localObject2 = this.jlN.cD(paraml.Dkb);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((b.a)((Iterator)localObject2).next()).a(paraml.appId, (b.a.a)localObject1, paramm);
      }
      localObject2 = ((al)localObject1).x(paraml.appId, paraml.jlP, paraml.version);
      if (localObject2 == null)
      {
        ac.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", new Object[] { paraml.toShortString() });
        localObject1 = b.a.a.jpJ;
      }
      else
      {
        ((ak)localObject2).field_pkgPath = paraml.getFilePath();
        boolean bool = al.a((ak)localObject2);
        ac.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", new Object[] { Boolean.valueOf(bool), paraml.toShortString() });
        if (bool)
        {
          ((al)localObject1).update((c)localObject2, new String[0]);
          localObject1 = b.a.a.jpC;
        }
        else
        {
          localObject1 = b.a.a.jpF;
          continue;
          ac.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", new Object[] { paramm });
          if ((paramm.DlL instanceof a)) {
            localObject1 = b.a.a.jpI;
          } else {
            switch (paramm.httpStatusCode)
            {
            default: 
              localObject1 = b.a.a.jpD;
              break;
            case 403: 
            case 404: 
              localObject1 = b.a.a.jpH;
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