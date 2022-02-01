package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.pluginsdk.j.a.c.j;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

final class az$c
  extends n.a<com.tencent.mm.plugin.appbrand.appcache.a.a>
{
  private static final ThreadLocal<az.a> jKX;
  private String jKY;
  final ae.a jKZ;
  
  static
  {
    AppMethodBeat.i(90609);
    jKX = new ThreadLocal() {};
    AppMethodBeat.o(90609);
  }
  
  az$c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(90602);
    this.jKY = null;
    ae.a locala = ae.b(parama);
    parama = locala;
    if (locala == null) {
      parama = m.jIF;
    }
    this.jKZ = parama;
    AppMethodBeat.o(90602);
  }
  
  private com.tencent.mm.pluginsdk.j.a.c.m a(j paramj)
  {
    AppMethodBeat.i(90604);
    paramj = super.b(paramj);
    if (paramj != null) {
      paramj.bundle.putBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", true);
    }
    AppMethodBeat.o(90604);
    return paramj;
  }
  
  public final String afK()
  {
    return "AppBrandWxaPkgDownloader";
  }
  
  public final com.tencent.mm.pluginsdk.j.a.c.m b(j paramj)
  {
    AppMethodBeat.i(90605);
    try
    {
      locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.bbf();
      o.deleteFile(locala.getFilePath());
      this.jKY = locala.url;
      localObject = this.jKZ;
      this.jKY.startsWith("https");
      ((ae.a)localObject).aZS();
      localObject = (az.a)jKX.get();
      zw localzw = new zw();
      localzw.dQq.dQs = ((com.tencent.mm.plugin.appbrand.appcache.a.a)super.bbf());
      localzw.dQq.dQr = 1;
      com.tencent.mm.sdk.b.a.IvT.a(localzw, Looper.getMainLooper());
      localObject = ((az.a)localObject).a(this);
      localzw = new zw();
      localzw.dQq.dQs = ((com.tencent.mm.plugin.appbrand.appcache.a.a)super.bbf());
      localzw.dQq.dQt = ((com.tencent.mm.pluginsdk.j.a.c.m)localObject);
      localzw.dQq.dQr = 2;
      com.tencent.mm.sdk.b.a.IvT.a(localzw, Looper.getMainLooper());
      if (localObject == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.appcache.a.a locala;
        Object localObject;
        label235:
        paramj = null;
        label260:
        label293:
        label298:
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", localException1, "perform failed", new Object[0]);
      }
      AppMethodBeat.o(90605);
      return paramj;
    }
    try
    {
      if ((((com.tencent.mm.pluginsdk.j.a.c.m)localObject).status != 3) || (!this.jKY.startsWith("http://"))) {
        break label293;
      }
      i = 1;
      if (((localObject != null) && (((com.tencent.mm.pluginsdk.j.a.c.m)localObject).status != 3)) || (!this.jKY.startsWith("https"))) {
        break label298;
      }
      this.jKZ.aZU();
      if (!(locala instanceof av)) {
        break label359;
      }
      i = 0;
    }
    catch (Exception localException4)
    {
      paramj = localException1;
      localException2 = localException4;
      break label318;
      break label260;
      i = 1;
      break label235;
    }
    if (i != 0) {
      this.jKY = this.jKY.replaceFirst("https", "http");
    }
    for (paramj = a(paramj);; paramj = a(paramj))
    {
      try
      {
        this.jKZ.a(paramj);
        if (paramj != null) {
          break label333;
        }
        paramj = new com.tencent.mm.pluginsdk.j.a.c.m(this, null, -1, 3);
        AppMethodBeat.o(90605);
        return paramj;
      }
      catch (Exception localException3)
      {
        Exception localException2;
        break label318;
        paramj = localException3;
      }
      i = 0;
      break;
      if ((localObject != null) && (i == 0)) {
        break label354;
      }
    }
  }
  
  protected final com.tencent.mm.plugin.appbrand.appcache.a.a baZ()
  {
    AppMethodBeat.i(90603);
    com.tencent.mm.plugin.appbrand.appcache.a.a locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.bbf();
    AppMethodBeat.o(90603);
    return locala;
  }
  
  public final boolean bba()
  {
    return true;
  }
  
  public final boolean bbb()
  {
    return false;
  }
  
  public final boolean bbc()
  {
    return true;
  }
  
  public final boolean bbd()
  {
    return false;
  }
  
  public final boolean bbe()
  {
    AppMethodBeat.i(90607);
    switch (ab.abf())
    {
    default: 
      AppMethodBeat.o(90607);
      return false;
    case 0: 
      AppMethodBeat.o(90607);
      return false;
    }
    boolean bool = super.bbe();
    AppMethodBeat.o(90607);
    return bool;
  }
  
  public final String getURL()
  {
    return this.jKY;
  }
  
  public final boolean sR(long paramLong)
  {
    AppMethodBeat.i(90606);
    StatFs localStatFs = new StatFs(w.B(new k(getFilePath()).fTg().fTh()));
    long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
    if ((l < 0L) || (l > paramLong))
    {
      AppMethodBeat.o(90606);
      return true;
    }
    AppMethodBeat.o(90606);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az.c
 * JD-Core Version:    0.7.0.1
 */