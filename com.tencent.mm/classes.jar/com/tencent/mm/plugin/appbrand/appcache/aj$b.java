package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.u;
import com.tencent.mm.sdk.platformtools.ah;

final class aj$b
  extends n
{
  aj$b(aj paramaj)
  {
    super(new u("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new aj.d(paramaj));
  }
  
  protected final f.d a(l paraml)
  {
    paraml = new aj.c((a)paraml);
    paraml.rXJ = this.rXG;
    return paraml;
  }
  
  protected final int b(l paraml)
  {
    int j = super.b(paraml);
    int i = j;
    if (j == 1)
    {
      super.b(paraml);
      i = 2;
    }
    return i;
  }
  
  public final void shutdown()
  {
    super.shutdown();
    ((aj.d)this.rXG).fDT.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.b
 * JD-Core Version:    0.7.0.1
 */