package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.vfs.e;
import java.util.concurrent.CountDownLatch;

final class ap$a$1
  implements com.tencent.mm.sdk.platformtools.ap.a
{
  ap$a$1(ap.a parama, String paramString, z.a parama1, a parama2, j paramj, CountDownLatch paramCountDownLatch) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(59483);
    f.afO().sJ(this.gVY);
    this.gVZ.avi();
    e.deleteFile(this.gWa.getFilePath());
    this.gWb.value = null;
    this.fuC.countDown();
    AppMethodBeat.o(59483);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.a.1
 * JD-Core Version:    0.7.0.1
 */