package com.tencent.mm.plugin.cdndownloader.d;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.Iterator;
import java.util.Set;

final class a$3
  implements ap.a
{
  a$3(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(894);
    ab.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
    if (a.c(this.kDM).size() == 0)
    {
      AppMethodBeat.o(894);
      return false;
    }
    if (a.h(this.kDM) != null) {}
    try
    {
      ab.d("MicroMsg.CDNDownloadClient", "checkActive");
      a.h(this.kDM).bfR();
      AppMethodBeat.o(894);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.CDNDownloadClient", "check process active false");
      h.qsU.idkeyStat(710L, 3L, 1L, false);
      if (a.i(this.kDM))
      {
        a.a(this.kDM, System.currentTimeMillis());
        localIterator = a.c(this.kDM).iterator();
        while (localIterator.hasNext()) {
          ((CDNTaskInfo)localIterator.next()).kDT = true;
        }
        a.j(this.kDM);
        AppMethodBeat.o(894);
        return true;
      }
      ab.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
      h.qsU.idkeyStat(710L, 4L, 1L, false);
      Iterator localIterator = a.c(this.kDM).iterator();
      while (localIterator.hasNext())
      {
        CDNTaskInfo localCDNTaskInfo = (CDNTaskInfo)localIterator.next();
        a.k(this.kDM).f(localCDNTaskInfo.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.kVr, null);
      }
      a.l(this.kDM);
      AppMethodBeat.o(894);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.3
 * JD-Core Version:    0.7.0.1
 */