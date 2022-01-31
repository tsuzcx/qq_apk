package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.vfs.e;
import java.util.concurrent.CountDownLatch;

final class aj$a$1
  implements am.a
{
  aj$a$1(aj.a parama, String paramString, t.a parama1, a parama2, k paramk, CountDownLatch paramCountDownLatch) {}
  
  public final boolean tC()
  {
    f.Nd().lM(this.fDI);
    this.fDJ.abr();
    e.deleteFile(this.fDK.bjl());
    this.fDL.value = null;
    this.eeA.countDown();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.a.1
 * JD-Core Version:    0.7.0.1
 */