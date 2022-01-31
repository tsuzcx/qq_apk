package com.tencent.mm.plugin.appbrand.appcache;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

final class ap$c
  extends n.a<a>
{
  private static final ThreadLocal<ap.a> gWg;
  private String gWh;
  final z.a gWi;
  
  static
  {
    AppMethodBeat.i(59498);
    gWg = new ap.c.1();
    AppMethodBeat.o(59498);
  }
  
  ap$c(a parama)
  {
    super(parama);
    AppMethodBeat.i(59492);
    this.gWh = null;
    z.a locala = z.a(parama);
    parama = locala;
    if (locala == null) {
      parama = m.gUk;
    }
    this.gWi = parama;
    AppMethodBeat.o(59492);
  }
  
  public final com.tencent.mm.pluginsdk.g.a.c.m a(com.tencent.mm.pluginsdk.g.a.c.j paramj)
  {
    AppMethodBeat.i(59494);
    try
    {
      localObject1 = (a)super.avY();
      e.deleteFile(((a)localObject1).getFilePath());
      this.gWh = ((l)localObject1).url;
      localObject2 = this.gWi;
      this.gWh.startsWith("https");
      ((z.a)localObject2).avh();
      localObject2 = ((ap.a)gWg.get()).a(this);
      if (localObject2 != null) {
        localObject3 = localObject2;
      }
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        label163:
        label199:
        label235:
        label240:
        Object localObject3 = null;
        ab.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", paramj, "perform failed", new Object[0]);
        localObject1 = localObject3;
      }
      AppMethodBeat.o(59494);
      return localObject1;
    }
    try
    {
      if (((com.tencent.mm.pluginsdk.g.a.c.m)localObject2).status != 3) {
        break label235;
      }
      localObject3 = localObject2;
      if (!this.gWh.startsWith("http://")) {
        break label235;
      }
      i = 1;
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        if (((com.tencent.mm.pluginsdk.g.a.c.m)localObject2).status != 3) {
          break label240;
        }
      }
      localObject3 = localObject2;
      if (!this.gWh.startsWith("https")) {
        break label240;
      }
      localObject3 = localObject2;
      this.gWi.avj();
      localObject3 = localObject2;
      if (!(localObject1 instanceof ak)) {
        break label304;
      }
      i = 0;
    }
    catch (Exception paramj)
    {
      break label269;
      paramj = (com.tencent.mm.pluginsdk.g.a.c.j)localObject2;
      break label309;
      i = 1;
      break label163;
      localObject1 = paramj;
      break label199;
    }
    if (i != 0)
    {
      localObject3 = localObject2;
      this.gWh = this.gWh.replaceFirst("https", "http");
      localObject3 = localObject2;
      paramj = super.a(paramj);
      break label309;
      for (;;)
      {
        localObject3 = localObject1;
        this.gWi.a((com.tencent.mm.pluginsdk.g.a.c.m)localObject1);
        if (localObject1 != null) {
          break label287;
        }
        paramj = new com.tencent.mm.pluginsdk.g.a.c.m(this, null, -1, 3);
        AppMethodBeat.o(59494);
        return paramj;
        i = 0;
        break;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (i == 0) {}
        }
        else
        {
          localObject3 = localObject2;
          localObject1 = super.a(paramj);
        }
      }
    }
  }
  
  protected final a avR()
  {
    AppMethodBeat.i(59493);
    a locala = (a)super.avY();
    AppMethodBeat.o(59493);
    return locala;
  }
  
  public final String avS()
  {
    return "AppBrandWxaPkgDownloader";
  }
  
  public final boolean avT()
  {
    return true;
  }
  
  public final boolean avU()
  {
    return false;
  }
  
  public final boolean avV()
  {
    return true;
  }
  
  public final boolean avW()
  {
    return false;
  }
  
  public final boolean avX()
  {
    AppMethodBeat.i(59496);
    switch (com.tencent.mm.compatible.e.z.LZ())
    {
    default: 
      AppMethodBeat.o(59496);
      return false;
    case 0: 
      AppMethodBeat.o(59496);
      return false;
    }
    boolean bool = super.avX();
    AppMethodBeat.o(59496);
    return bool;
  }
  
  public final String getURL()
  {
    return this.gWh;
  }
  
  public final boolean hq(long paramLong)
  {
    AppMethodBeat.i(59495);
    StatFs localStatFs = new StatFs(com.tencent.mm.vfs.j.p(new b(getFilePath()).dQI().dQJ()));
    long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
    if ((l < 0L) || (l > paramLong))
    {
      AppMethodBeat.o(59495);
      return true;
    }
    AppMethodBeat.o(59495);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.c
 * JD-Core Version:    0.7.0.1
 */