package com.tencent.mm.plugin.appbrand.appcache;

import android.os.StatFs;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

final class aj$c
  extends n.a<a>
{
  private static final ThreadLocal<aj.a> fDQ = new aj.c.1();
  String fDR = null;
  final t.a fDS;
  
  aj$c(a parama)
  {
    super(parama);
    t.a locala = t.a(parama);
    parama = locala;
    if (locala == null) {
      parama = g.fBZ;
    }
    this.fDS = parama;
  }
  
  protected final m a(com.tencent.mm.pluginsdk.g.a.c.j paramj)
  {
    try
    {
      localObject1 = (a)super.aci();
      e.deleteFile(((a)localObject1).bjl());
      this.fDR = ((l)localObject1).url;
      localObject2 = this.fDS;
      this.fDR.startsWith("https");
      ((t.a)localObject2).abq();
      localObject2 = ((aj.a)fDQ.get()).a(this);
      if (localObject2 != null) {
        localObject3 = localObject2;
      }
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        label158:
        label194:
        label229:
        label234:
        Object localObject3 = null;
        label263:
        y.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", paramj, "perform failed", new Object[0]);
        paramj = localObject3;
      }
    }
    try
    {
      if (((m)localObject2).status != 3) {
        break label229;
      }
      localObject3 = localObject2;
      if (!this.fDR.startsWith("http://")) {
        break label229;
      }
      i = 1;
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        if (((m)localObject2).status != 3) {
          break label234;
        }
      }
      localObject3 = localObject2;
      if (!this.fDR.startsWith("https")) {
        break label234;
      }
      localObject3 = localObject2;
      this.fDS.abs();
      localObject3 = localObject2;
      if (!(localObject1 instanceof ae)) {
        break label291;
      }
      i = 0;
    }
    catch (Exception paramj)
    {
      break label263;
      paramj = (com.tencent.mm.pluginsdk.g.a.c.j)localObject2;
      break label296;
      i = 1;
      break label158;
      localObject1 = paramj;
      break label194;
    }
    if (i != 0)
    {
      localObject3 = localObject2;
      this.fDR = this.fDR.replaceFirst("https", "http");
      localObject3 = localObject2;
      paramj = super.a(paramj);
      break label296;
      for (;;)
      {
        localObject3 = localObject1;
        this.fDS.a((m)localObject1);
        paramj = (com.tencent.mm.pluginsdk.g.a.c.j)localObject1;
        localObject1 = paramj;
        if (paramj == null) {
          localObject1 = new m(this, null, -1, 3);
        }
        return localObject1;
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
  
  protected final a aca()
  {
    return (a)super.aci();
  }
  
  public final String acb()
  {
    return "AppBrandWxaPkgDownloader";
  }
  
  public final boolean acc()
  {
    return true;
  }
  
  public final boolean acd()
  {
    return false;
  }
  
  public final boolean ace()
  {
    return true;
  }
  
  protected final boolean acf()
  {
    return false;
  }
  
  public final boolean acg()
  {
    return true;
  }
  
  public final boolean ach()
  {
    switch ()
    {
    case 0: 
    default: 
      return false;
    }
    return super.ach();
  }
  
  public final boolean ct(long paramLong)
  {
    StatFs localStatFs = new StatFs(com.tencent.mm.vfs.j.n(new b(bjl()).cLq().cLr()));
    long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
    return (l < 0L) || (l > paramLong);
  }
  
  public final String getURL()
  {
    return this.fDR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.c
 * JD-Core Version:    0.7.0.1
 */