package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class ad$1
  implements Runnable
{
  ad$1(boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.fDf)
    {
      y.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
      g.DP().Dz().c(ac.a.usG, Long.valueOf(bk.UX() - 1L));
    }
    ad.access$000();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad.1
 * JD-Core Version:    0.7.0.1
 */