package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final HashMap<Long, Integer> xnf;
  private static HashSet<Long> xng;
  
  static
  {
    AppMethodBeat.i(88906);
    xnf = new HashMap();
    xng = new HashSet();
    AppMethodBeat.o(88906);
  }
  
  public static void dup()
  {
    AppMethodBeat.i(88905);
    xng.clear();
    Object localObject1 = d.bzH();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject3;
    Object localObject2;
    while (Util.isNullOrNil((List)localObject1))
    {
      AppMethodBeat.o(88905);
      return;
      Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=4")));
      localObject3 = ((b)localObject1).rawQuery("select * from FileDownloadInfo where status=4", new String[0]);
      localObject2 = new LinkedList();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        while (((Cursor)localObject3).moveToNext())
        {
          localObject1 = new com.tencent.mm.plugin.downloader.f.a();
          ((com.tencent.mm.plugin.downloader.f.a)localObject1).convertFrom((Cursor)localObject3);
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
      localObject2 = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject1).next();
      if (d.amN(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadUrl))
      {
        Log.i("MicroMsg.DownloadRetry", "hasDuplicatedTask");
        d.amK(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadUrl);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(710L, 26L, 1L, false);
      }
      else if ((((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloaderType == 3) && (y.ZC(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_filePath)))
      {
        int i = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_errCode;
        if ((i == com.tencent.mm.plugin.downloader.a.a.xkw) || (i == com.tencent.mm.plugin.downloader.a.a.xkA) || (i == com.tencent.mm.plugin.downloader.a.a.xkz)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label318;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.dV(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_appId, false);
          if ((localObject3 == null) || (!((g)localObject3).aqJ()) || (!kP(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId))) {
            break;
          }
          ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadType = 3;
          d.e((com.tencent.mm.plugin.downloader.f.a)localObject2);
          f.duv().h((com.tencent.mm.plugin.downloader.f.a)localObject2);
          xng.add(Long.valueOf(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId));
          xnf.put(Long.valueOf(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId), Integer.valueOf(1));
          break;
        }
      }
    }
    AppMethodBeat.o(88905);
  }
  
  public static boolean kP(long paramLong)
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
  
  public static boolean kQ(long paramLong)
  {
    AppMethodBeat.i(88904);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (kP(paramLong)) && (xng.contains(Long.valueOf(paramLong))))
    {
      if ((xnf.containsKey(Long.valueOf(paramLong))) && (((Integer)xnf.get(Long.valueOf(paramLong))).intValue() >= 2)) {}
      for (int i = 0; i != 0; i = 1)
      {
        com.tencent.threadpool.h.ahAA.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(88902);
            com.tencent.mm.plugin.downloader.f.a locala = d.la(this.sNk);
            if ((locala != null) && (a.access$000(locala.field_status))) {
              f.duv().h(locala);
            }
            int i = Util.nullAs((Integer)a.xnf.get(Long.valueOf(this.sNk)), 0);
            a.xnf.put(Long.valueOf(this.sNk), Integer.valueOf(i + 1));
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