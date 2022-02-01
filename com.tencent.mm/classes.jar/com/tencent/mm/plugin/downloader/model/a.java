package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final HashMap<Long, Integer> oIk;
  private static HashSet<Long> oIl;
  
  static
  {
    AppMethodBeat.i(88906);
    oIk = new HashMap();
    oIl = new HashSet();
    AppMethodBeat.o(88906);
  }
  
  public static void bXC()
  {
    AppMethodBeat.i(88905);
    oIl.clear();
    Object localObject1 = d.awH();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject3;
    Object localObject2;
    while (bs.gY((List)localObject1))
    {
      AppMethodBeat.o(88905);
      return;
      ac.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=4")));
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
      if (d.WA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
      {
        ac.i("MicroMsg.DownloadRetry", "hasDuplicatedTask");
        d.Wx(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(710L, 26L, 1L, false);
      }
      else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) && (com.tencent.mm.vfs.i.eA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)))
      {
        int i = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode;
        if ((i == com.tencent.mm.plugin.downloader.a.a.oFE) || (i == com.tencent.mm.plugin.downloader.a.a.oFI) || (i == com.tencent.mm.plugin.downloader.a.a.oFH)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label318;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.ct(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, false);
          if ((localObject3 == null) || (!((g)localObject3).CC()) || (!rQ(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId))) {
            break;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadType = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.bXJ().h((com.tencent.mm.plugin.downloader.g.a)localObject2);
          oIl.add(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId));
          oIk.put(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), Integer.valueOf(1));
          break;
        }
      }
    }
    AppMethodBeat.o(88905);
  }
  
  public static boolean rQ(long paramLong)
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
  
  public static boolean rR(long paramLong)
  {
    AppMethodBeat.i(88904);
    if ((ax.isWifi(ai.getContext())) && (rQ(paramLong)) && (oIl.contains(Long.valueOf(paramLong))))
    {
      if ((oIk.containsKey(Long.valueOf(paramLong))) && (((Integer)oIk.get(Long.valueOf(paramLong))).intValue() >= 2)) {}
      for (int i = 0; i != 0; i = 1)
      {
        com.tencent.e.h.JZN.q(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(88902);
            com.tencent.mm.plugin.downloader.g.a locala = d.sc(this.oIm);
            if ((locala != null) && (a.qj(locala.field_status))) {
              f.bXJ().h(locala);
            }
            int i = bs.a((Integer)a.oIk.get(Long.valueOf(this.oIm)), 0);
            a.oIk.put(Long.valueOf(this.oIm), Integer.valueOf(i + 1));
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