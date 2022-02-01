package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
{
  public static com.tencent.mm.plugin.downloader.g.a Cw(long paramLong)
  {
    AppMethodBeat.i(88951);
    Object localObject = aSU();
    if (localObject == null)
    {
      AppMethodBeat.o(88951);
      return null;
    }
    localObject = ((b)localObject).CH(paramLong);
    AppMethodBeat.o(88951);
    return localObject;
  }
  
  public static boolean Cx(long paramLong)
  {
    AppMethodBeat.i(88959);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfo id: [%s]", new Object[] { Long.valueOf(paramLong) });
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88959);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = new com.tencent.mm.plugin.downloader.g.a();
    locala.field_downloadId = paramLong;
    boolean bool = localb.delete(locala, new String[0]);
    AppMethodBeat.o(88959);
    return bool;
  }
  
  public static b aSU()
  {
    AppMethodBeat.i(88961);
    if (g.aAf().azp())
    {
      g.aAf();
      if (!com.tencent.mm.kernel.a.azj()) {}
    }
    else
    {
      Log.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
      AppMethodBeat.o(88961);
      return null;
    }
    if (g.af(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      Log.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
      AppMethodBeat.o(88961);
      return null;
    }
    b localb = ((com.tencent.mm.plugin.downloader.a.d)g.af(com.tencent.mm.plugin.downloader.a.d.class)).aSU();
    AppMethodBeat.o(88961);
    return localb;
  }
  
  public static com.tencent.mm.plugin.downloader.g.a alb(String paramString)
  {
    AppMethodBeat.i(88952);
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88952);
      return null;
    }
    paramString = localb.alb(paramString);
    AppMethodBeat.o(88952);
    return paramString;
  }
  
  public static boolean alc(String paramString)
  {
    AppMethodBeat.i(88956);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfoByURLIfExist url: [%s]", new Object[] { paramString });
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88956);
      return false;
    }
    boolean bool = localb.alc(paramString);
    AppMethodBeat.o(88956);
    return bool;
  }
  
  public static boolean ald(String paramString)
  {
    AppMethodBeat.i(88957);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfoByAppIdIfExist id: [%s]", new Object[] { paramString });
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88957);
      return false;
    }
    boolean bool = localb.ald(paramString);
    AppMethodBeat.o(88957);
    return bool;
  }
  
  public static com.tencent.mm.plugin.downloader.g.a ale(String paramString)
  {
    AppMethodBeat.i(88958);
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88958);
      return null;
    }
    paramString = localb.ale(paramString);
    AppMethodBeat.o(88958);
    return paramString;
  }
  
  public static boolean alf(String paramString)
  {
    AppMethodBeat.i(88963);
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88963);
      return false;
    }
    boolean bool = localb.alf(paramString);
    AppMethodBeat.o(88963);
    return bool;
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.g.a> cBs()
  {
    AppMethodBeat.i(88960);
    Object localObject = aSU();
    if (localObject == null)
    {
      AppMethodBeat.o(88960);
      return null;
    }
    Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=1 and downloadInWifi=1")));
    localObject = ((b)localObject).rawQuery("select * from FileDownloadInfo where status=1 and downloadInWifi=1", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localObject == null)
    {
      AppMethodBeat.o(88960);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = new com.tencent.mm.plugin.downloader.g.a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(88960);
    return localLinkedList;
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.g.a> cBt()
  {
    AppMethodBeat.i(192257);
    Object localObject = aSU();
    if (localObject == null)
    {
      AppMethodBeat.o(192257);
      return null;
    }
    localObject = ((b)localObject).cBt();
    AppMethodBeat.o(192257);
    return localObject;
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.g.a> cBu()
  {
    AppMethodBeat.i(88962);
    Object localObject1 = aSU();
    if (localObject1 == null)
    {
      AppMethodBeat.o(88962);
      return null;
    }
    Object localObject2 = String.format("select * from %s where %s<%d order by %s desc", new Object[] { "FileDownloadInfo", "updateTime", Long.valueOf(System.currentTimeMillis() - 604800000L), "updateTime" });
    Log.i("MicroMsg.FileDownloadInfoStorage", "getUpdateTimeBiggerThanTimeInterval, sql = ".concat(String.valueOf(localObject2)));
    localObject1 = ((b)localObject1).rawQuery((String)localObject2, new String[0]);
    localObject2 = new LinkedList();
    if (localObject1 == null)
    {
      AppMethodBeat.o(88962);
      return localObject2;
    }
    while (((Cursor)localObject1).moveToNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = new com.tencent.mm.plugin.downloader.g.a();
      locala.convertFrom((Cursor)localObject1);
      ((LinkedList)localObject2).add(locala);
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(88962);
    return localObject2;
  }
  
  public static boolean cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(88955);
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88955);
      return false;
    }
    boolean bool = localb.cW(paramString, paramInt);
    AppMethodBeat.o(88955);
    return bool;
  }
  
  public static long d(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88953);
    if (parama == null)
    {
      AppMethodBeat.o(88953);
      return -1L;
    }
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88953);
      return -1L;
    }
    ald(parama.field_appId);
    alc(parama.field_downloadUrl);
    ald(parama.field_rawAppId);
    parama.field_updateTime = System.currentTimeMillis();
    boolean bool = localb.insert(parama);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + parama.field_downloadId + ", ret=" + bool);
    long l = parama.field_downloadId;
    AppMethodBeat.o(88953);
    return l;
  }
  
  public static long e(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(88954);
    if (parama == null)
    {
      AppMethodBeat.o(88954);
      return -1L;
    }
    b localb = aSU();
    if (localb == null)
    {
      AppMethodBeat.o(88954);
      return -1L;
    }
    parama.field_updateTime = System.currentTimeMillis();
    boolean bool = localb.update(parama, new String[0]);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", new Object[] { Long.valueOf(parama.field_downloadId), Boolean.valueOf(bool), Integer.valueOf(parama.field_status) });
    long l = parama.field_downloadId;
    AppMethodBeat.o(88954);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d
 * JD-Core Version:    0.7.0.1
 */