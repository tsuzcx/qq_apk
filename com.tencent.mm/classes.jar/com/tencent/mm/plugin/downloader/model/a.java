package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final HashMap<Long, Integer> qHY;
  private static HashSet<Long> qHZ;
  
  static
  {
    AppMethodBeat.i(88906);
    qHY = new HashMap();
    qHZ = new HashSet();
    AppMethodBeat.o(88906);
  }
  
  public static boolean Cl(long paramLong)
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
  
  public static boolean Cm(long paramLong)
  {
    AppMethodBeat.i(88904);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (Cl(paramLong)) && (qHZ.contains(Long.valueOf(paramLong))))
    {
      if ((qHY.containsKey(Long.valueOf(paramLong))) && (((Integer)qHY.get(Long.valueOf(paramLong))).intValue() >= 2)) {}
      for (int i = 0; i != 0; i = 1)
      {
        com.tencent.f.h.RTc.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(88902);
            com.tencent.mm.plugin.downloader.g.a locala = d.Cw(this.qIa);
            if ((locala != null) && (a.uF(locala.field_status))) {
              f.cBv().h(locala);
            }
            int i = Util.nullAs((Integer)a.qHY.get(Long.valueOf(this.qIa)), 0);
            a.qHY.put(Long.valueOf(this.qIa), Integer.valueOf(i + 1));
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
  
  public static void cBp()
  {
    AppMethodBeat.i(88905);
    qHZ.clear();
    Object localObject1 = d.aSU();
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
      if (d.alf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl))
      {
        Log.i("MicroMsg.DownloadRetry", "hasDuplicatedTask");
        d.alc(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(710L, 26L, 1L, false);
      }
      else if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) && (s.YS(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)))
      {
        int i = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode;
        if ((i == com.tencent.mm.plugin.downloader.a.a.qFs) || (i == com.tencent.mm.plugin.downloader.a.a.qFw) || (i == com.tencent.mm.plugin.downloader.a.a.qFv)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label318;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.cX(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, false);
          if ((localObject3 == null) || (!((g)localObject3).NA()) || (!Cl(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId))) {
            break;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadType = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.cBv().h((com.tencent.mm.plugin.downloader.g.a)localObject2);
          qHZ.add(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId));
          qHY.put(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), Integer.valueOf(1));
          break;
        }
      }
    }
    AppMethodBeat.o(88905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a
 * JD-Core Version:    0.7.0.1
 */