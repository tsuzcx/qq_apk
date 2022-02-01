package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
{
  public static a IF(long paramLong)
  {
    AppMethodBeat.i(88951);
    Object localObject = bbS();
    if (localObject == null)
    {
      AppMethodBeat.o(88951);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.downloader.g.b)localObject).IQ(paramLong);
    AppMethodBeat.o(88951);
    return localObject;
  }
  
  public static boolean IG(long paramLong)
  {
    AppMethodBeat.i(88959);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfo id: [%s]", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88959);
      return false;
    }
    a locala = new a();
    locala.field_downloadId = paramLong;
    boolean bool = localb.delete(locala, new String[0]);
    AppMethodBeat.o(88959);
    return bool;
  }
  
  public static a asU(String paramString)
  {
    AppMethodBeat.i(88952);
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88952);
      return null;
    }
    paramString = localb.asU(paramString);
    AppMethodBeat.o(88952);
    return paramString;
  }
  
  public static boolean asV(String paramString)
  {
    AppMethodBeat.i(88956);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfoByURLIfExist url: [%s]", new Object[] { paramString });
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88956);
      return false;
    }
    boolean bool = localb.asV(paramString);
    AppMethodBeat.o(88956);
    return bool;
  }
  
  public static boolean asW(String paramString)
  {
    AppMethodBeat.i(88957);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfoByAppIdIfExist id: [%s]", new Object[] { paramString });
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88957);
      return false;
    }
    boolean bool = localb.asW(paramString);
    AppMethodBeat.o(88957);
    return bool;
  }
  
  public static a asX(String paramString)
  {
    AppMethodBeat.i(88958);
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88958);
      return null;
    }
    paramString = localb.asX(paramString);
    AppMethodBeat.o(88958);
    return paramString;
  }
  
  public static boolean asY(String paramString)
  {
    AppMethodBeat.i(88963);
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88963);
      return false;
    }
    boolean bool = localb.asY(paramString);
    AppMethodBeat.o(88963);
    return bool;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b bbS()
  {
    AppMethodBeat.i(88961);
    if (h.aHE().aGM())
    {
      h.aHE();
      if (!com.tencent.mm.kernel.b.aGE()) {}
    }
    else
    {
      Log.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
      AppMethodBeat.o(88961);
      return null;
    }
    if (h.ae(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      Log.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
      AppMethodBeat.o(88961);
      return null;
    }
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)h.ae(com.tencent.mm.plugin.downloader.a.d.class)).bbS();
    AppMethodBeat.o(88961);
    return localb;
  }
  
  public static LinkedList<a> cPW()
  {
    AppMethodBeat.i(88960);
    Object localObject = bbS();
    if (localObject == null)
    {
      AppMethodBeat.o(88960);
      return null;
    }
    Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=1 and downloadInWifi=1")));
    localObject = ((com.tencent.mm.plugin.downloader.g.b)localObject).rawQuery("select * from FileDownloadInfo where status=1 and downloadInWifi=1", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localObject == null)
    {
      AppMethodBeat.o(88960);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(88960);
    return localLinkedList;
  }
  
  public static LinkedList<a> cPX()
  {
    AppMethodBeat.i(219745);
    Object localObject = bbS();
    if (localObject == null)
    {
      AppMethodBeat.o(219745);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.downloader.g.b)localObject).cPX();
    AppMethodBeat.o(219745);
    return localObject;
  }
  
  public static LinkedList<a> cPY()
  {
    AppMethodBeat.i(88962);
    Object localObject1 = bbS();
    if (localObject1 == null)
    {
      AppMethodBeat.o(88962);
      return null;
    }
    Object localObject2 = String.format("select * from %s where %s<%d order by %s desc", new Object[] { "FileDownloadInfo", "updateTime", Long.valueOf(System.currentTimeMillis() - 604800000L), "updateTime" });
    Log.i("MicroMsg.FileDownloadInfoStorage", "getUpdateTimeBiggerThanTimeInterval, sql = ".concat(String.valueOf(localObject2)));
    localObject1 = ((com.tencent.mm.plugin.downloader.g.b)localObject1).rawQuery((String)localObject2, new String[0]);
    localObject2 = new LinkedList();
    if (localObject1 == null)
    {
      AppMethodBeat.o(88962);
      return localObject2;
    }
    while (((Cursor)localObject1).moveToNext())
    {
      a locala = new a();
      locala.convertFrom((Cursor)localObject1);
      ((LinkedList)localObject2).add(locala);
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(88962);
    return localObject2;
  }
  
  public static long d(a parama)
  {
    AppMethodBeat.i(88953);
    if (parama == null)
    {
      AppMethodBeat.o(88953);
      return -1L;
    }
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88953);
      return -1L;
    }
    asW(parama.field_appId);
    asV(parama.field_downloadUrl);
    asW(parama.field_rawAppId);
    parama.field_updateTime = System.currentTimeMillis();
    boolean bool = localb.insert(parama);
    Log.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + parama.field_downloadId + ", ret=" + bool);
    long l = parama.field_downloadId;
    AppMethodBeat.o(88953);
    return l;
  }
  
  public static boolean dq(String paramString, int paramInt)
  {
    AppMethodBeat.i(88955);
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
    if (localb == null)
    {
      AppMethodBeat.o(88955);
      return false;
    }
    boolean bool = localb.dq(paramString, paramInt);
    AppMethodBeat.o(88955);
    return bool;
  }
  
  public static long e(a parama)
  {
    AppMethodBeat.i(88954);
    if (parama == null)
    {
      AppMethodBeat.o(88954);
      return -1L;
    }
    com.tencent.mm.plugin.downloader.g.b localb = bbS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d
 * JD-Core Version:    0.7.0.1
 */