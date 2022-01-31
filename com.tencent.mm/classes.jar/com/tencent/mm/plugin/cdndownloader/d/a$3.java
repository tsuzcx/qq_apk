package com.tencent.mm.plugin.cdndownloader.d;

import android.os.RemoteException;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

final class a$3
  implements am.a
{
  a$3(a parama) {}
  
  public final boolean tC()
  {
    y.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
    if (a.c(this.iAG).size() == 0) {
      return false;
    }
    if (a.h(this.iAG) != null) {}
    try
    {
      y.d("MicroMsg.CDNDownloadClient", "checkActive");
      a.h(this.iAG).aDu();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.CDNDownloadClient", "check process active false");
      h.nFQ.a(710L, 3L, 1L, false);
      if (a.i(this.iAG))
      {
        a.a(this.iAG, System.currentTimeMillis());
        localIterator = a.c(this.iAG).iterator();
        while (localIterator.hasNext()) {
          ((CDNTaskInfo)localIterator.next()).iAN = true;
        }
        a.j(this.iAG);
        return true;
      }
      y.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
      h.nFQ.a(710L, 4L, 1L, false);
      Iterator localIterator = a.c(this.iAG).iterator();
      while (localIterator.hasNext())
      {
        CDNTaskInfo localCDNTaskInfo = (CDNTaskInfo)localIterator.next();
        a.k(this.iAG).f(localCDNTaskInfo.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.iOl, null);
      }
      a.l(this.iAG);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.3
 * JD-Core Version:    0.7.0.1
 */