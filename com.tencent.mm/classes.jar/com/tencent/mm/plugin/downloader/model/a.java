package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final HashMap<Long, Integer> oeI;
  private static HashSet<Long> oeJ;
  
  static
  {
    AppMethodBeat.i(88906);
    oeI = new HashMap();
    oeJ = new HashSet();
    AppMethodBeat.o(88906);
  }
  
  public static void bQm()
  {
    AppMethodBeat.i(88905);
    oeJ.clear();
    Object localObject1 = d.apS();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject3;
    Object localObject2;
    while (bt.gL((List)localObject1))
    {
      AppMethodBeat.o(88905);
      return;
      ad.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=4")));
      localObject3 = ((b)localObject1).rawQuery("select * from FileDownloadInfo where status=4", new String[0]);
      localObject2 = new LinkedList();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        while (((Cursor)localObject3).moveToNext())
        {
          localObject1 = new com.tencent.mm.plugin.downloader.g.a();
          ((com.tencent.mm.plugin.downloader.g.a)localObject1).convertFrom((Cursor)localObject3);
          ((LinkedList)localObject2).add(localObject1);
        }
        ((Cursor)localObject3).close();
        localObject1 = localObject2;
      }
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    label318:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
      if (d.So(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
      {
        ad.i("MicroMsg.DownloadRetry", "hasDuplicatedTask");
        d.Sl(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(710L, 26L, 1L, false);
      }
      else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) && (com.tencent.mm.vfs.i.eK(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)))
      {
        int i = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode;
        if ((i == com.tencent.mm.plugin.downloader.a.a.ocf) || (i == com.tencent.mm.plugin.downloader.a.a.ocj) || (i == com.tencent.mm.plugin.downloader.a.a.oci)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label318;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.cn(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, false);
          if ((localObject3 == null) || (!((g)localObject3).CZ()) || (!oe(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId))) {
            break;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadType = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.bQt().h((com.tencent.mm.plugin.downloader.g.a)localObject2);
          oeJ.add(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId));
          oeI.put(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), Integer.valueOf(1));
          break;
        }
      }
    }
    AppMethodBeat.o(88905);
  }
  
  public static boolean oe(long paramLong)
  {
    AppMethodBeat.i(88903);
    if (System.currentTimeMillis() - paramLong <= 259200000L)
    {
      AppMethodBeat.o(88903);
      return true;
    }
    AppMethodBeat.o(88903);
    return false;
  }
  
  public static boolean of(long paramLong)
  {
    AppMethodBeat.i(88904);
    if ((ay.isWifi(aj.getContext())) && (oe(paramLong)) && (oeJ.contains(Long.valueOf(paramLong))))
    {
      if ((oeI.containsKey(Long.valueOf(paramLong))) && (((Integer)oeI.get(Long.valueOf(paramLong))).intValue() >= 2)) {}
      for (int i = 0; i != 0; i = 1)
      {
        com.tencent.e.h.Iye.q(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(88902);
            com.tencent.mm.plugin.downloader.g.a locala = d.oq(this.oeK);
            if ((locala != null) && (a.pv(locala.field_status))) {
              f.bQt().h(locala);
            }
            int i = bt.a((Integer)a.biV().get(Long.valueOf(this.oeK)), 0);
            a.biV().put(Long.valueOf(this.oeK), Integer.valueOf(i + 1));
            AppMethodBeat.o(88902);
          }
        }, 300000L);
        AppMethodBeat.o(88904);
        return true;
      }
    }
    AppMethodBeat.o(88904);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a
 * JD-Core Version:    0.7.0.1
 */