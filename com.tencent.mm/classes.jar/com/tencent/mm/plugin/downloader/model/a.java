package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final HashMap<Long, Integer> kXX;
  private static HashSet<Long> kXY;
  
  static
  {
    AppMethodBeat.i(141058);
    kXX = new HashMap();
    kXY = new HashSet();
    AppMethodBeat.o(141058);
  }
  
  public static void bjg()
  {
    AppMethodBeat.i(141057);
    kXY.clear();
    Object localObject1 = d.YG();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject3;
    Object localObject2;
    while (bo.es((List)localObject1))
    {
      AppMethodBeat.o(141057);
      return;
      ab.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=4")));
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
    label276:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.downloader.g.a)((Iterator)localObject1).next();
      if ((((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) && (com.tencent.mm.vfs.e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)))
      {
        int i = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode;
        if ((i == com.tencent.mm.plugin.downloader.a.a.kVv) || (i == com.tencent.mm.plugin.downloader.a.a.kVz) || (i == com.tencent.mm.plugin.downloader.a.a.kVy)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label276;
          }
          localObject3 = g.bZ(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, false);
          if ((localObject3 == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject3).vY()) || (!ix(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId))) {
            break;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadType = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.bjl().f((com.tencent.mm.plugin.downloader.g.a)localObject2);
          kXY.add(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId));
          kXX.put(Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId), Integer.valueOf(1));
          break;
        }
      }
    }
    AppMethodBeat.o(141057);
  }
  
  public static boolean ix(long paramLong)
  {
    AppMethodBeat.i(141055);
    if (System.currentTimeMillis() - paramLong <= 259200000L)
    {
      AppMethodBeat.o(141055);
      return true;
    }
    AppMethodBeat.o(141055);
    return false;
  }
  
  public static boolean iy(long paramLong)
  {
    AppMethodBeat.i(141056);
    if ((at.isWifi(ah.getContext())) && (ix(paramLong)) && (kXY.contains(Long.valueOf(paramLong))))
    {
      if ((kXX.containsKey(Long.valueOf(paramLong))) && (((Integer)kXX.get(Long.valueOf(paramLong))).intValue() >= 2)) {}
      for (int i = 0; i != 0; i = 1)
      {
        com.tencent.mm.sdk.g.d.ysm.r(new a.1(paramLong), 300000L);
        AppMethodBeat.o(141056);
        return true;
      }
    }
    AppMethodBeat.o(141056);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a
 * JD-Core Version:    0.7.0.1
 */