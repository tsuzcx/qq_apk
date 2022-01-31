package com.tencent.mm.plugin.downloader.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(141089);
    Object localObject2;
    Object localObject3;
    long l;
    if (at.isWifi(this.kZp))
    {
      localObject1 = d.YG();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          localObject1 = ((LinkedList)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label369;
          }
          localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
          ab.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status) });
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status == 2)
          {
            localObject3 = f.bjl();
            l = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
            localObject2 = d.iJ(l);
            if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3))
            {
              localObject2 = ((f)localObject3).bjq();
              localObject3 = d.iJ(l);
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
                d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
              }
              com.tencent.mm.plugin.downloader.f.a.o(l, 14);
              ((com.tencent.mm.plugin.downloader.model.b)localObject2).o(l, true);
              continue;
              ab.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1")));
              localObject3 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1", new String[0]);
              localObject2 = new LinkedList();
              localObject1 = localObject2;
              if (localObject3 == null) {
                break;
              }
              while (((Cursor)localObject3).moveToNext())
              {
                localObject1 = new com.tencent.mm.plugin.downloader.g.a();
                ((com.tencent.mm.plugin.downloader.g.a)localObject1).convertFrom((Cursor)localObject3);
                ((LinkedList)localObject2).add(localObject1);
              }
              ((Cursor)localObject3).close();
              localObject1 = localObject2;
              break;
            }
            localObject2 = ((f)localObject3).bjp();
            localObject3 = d.iJ(l);
            if (localObject3 != null)
            {
              ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
              d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
            }
            com.tencent.mm.plugin.downloader.f.a.o(l, 14);
            ((com.tencent.mm.plugin.downloader.h.a)localObject2).o(l, true);
            continue;
          }
          if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status == 0) && (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_reserveInWifi))
          {
            localObject3 = f.bjl();
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
              ((f)localObject3).bjq().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
            } else {
              ((f)localObject3).bjm().a((com.tencent.mm.plugin.downloader.g.a)localObject2);
            }
          }
        }
      }
      label369:
      com.tencent.mm.plugin.downloader.model.a.bjg();
      AppMethodBeat.o(141089);
      return;
    }
    Object localObject1 = d.bjk();
    if (localObject1 != null)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
        ab.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId);
        localObject2 = f.bjl();
        l = ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadId;
        localObject3 = d.iJ(l);
        if ((localObject3 != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloaderType == 3))
        {
          ((f)localObject2).bjq().iE(l);
        }
        else
        {
          localObject2 = ((f)localObject2).bjp();
          localObject3 = d.iJ(l);
          if (localObject3 != null)
          {
            ((com.tencent.mm.plugin.downloader.g.a)localObject3).field_downloadType = 2;
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject3);
          }
          com.tencent.mm.plugin.downloader.f.a.o(l, 13);
          ((com.tencent.mm.plugin.downloader.h.a)localObject2).iB(l);
        }
      }
    }
    AppMethodBeat.o(141089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.a.a.1
 * JD-Core Version:    0.7.0.1
 */