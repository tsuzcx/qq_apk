package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final HashMap<Long, Integer> pst;
  private static HashSet<Long> psu;
  
  static
  {
    AppMethodBeat.i(88906);
    pst = new HashMap();
    psu = new HashSet();
    AppMethodBeat.o(88906);
  }
  
  public static void cdu()
  {
    AppMethodBeat.i(88905);
    psu.clear();
    Object localObject1 = d.azM();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject3;
    Object localObject2;
    while (bu.ht((List)localObject1))
    {
      AppMethodBeat.o(88905);
      return;
      ae.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=4")));
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
      if (d.aaY(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
      {
        ae.i("MicroMsg.DownloadRetry", "hasDuplicatedTask");
        d.aaV(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 26L, 1L, false);
      }
      else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) && (o.fB(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)))
      {
        int i = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode;
        if ((i == com.tencent.mm.plugin.downloader.a.a.ppN) || (i == com.tencent.mm.plugin.downloader.a.a.ppR) || (i == com.tencent.mm.plugin.downloader.a.a.ppQ)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label318;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.cC(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, false);
          if ((localObject3 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject3).Ee()) || (!ug(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId))) {
            break;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadType = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.cdA().h((com.tencent.mm.plugin.downloader.g.a)localObject2);
          psu.add(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId));
          pst.put(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), Integer.valueOf(1));
          break;
        }
      }
    }
    AppMethodBeat.o(88905);
  }
  
  public static boolean ug(long paramLong)
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
  
  public static boolean uh(long paramLong)
  {
    AppMethodBeat.i(88904);
    if ((az.isWifi(ak.getContext())) && (ug(paramLong)) && (psu.contains(Long.valueOf(paramLong))))
    {
      if ((pst.containsKey(Long.valueOf(paramLong))) && (((Integer)pst.get(Long.valueOf(paramLong))).intValue() >= 2)) {}
      for (int i = 0; i != 0; i = 1)
      {
        com.tencent.e.h.MqF.r(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(88902);
            com.tencent.mm.plugin.downloader.g.a locala = d.ur(this.psv);
            if ((locala != null) && (a.qN(locala.field_status))) {
              f.cdA().h(locala);
            }
            int i = bu.a((Integer)a.pst.get(Long.valueOf(this.psv)), 0);
            a.pst.put(Long.valueOf(this.psv), Integer.valueOf(i + 1));
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