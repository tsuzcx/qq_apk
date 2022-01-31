package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
{
  public static b FC()
  {
    if (g.DN().Dc())
    {
      g.DN();
      if (!com.tencent.mm.kernel.a.CW()) {}
    }
    else
    {
      y.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
      return null;
    }
    if (g.r(com.tencent.mm.plugin.downloader.a.c.class) == null)
    {
      y.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
      return null;
    }
    return ((com.tencent.mm.plugin.downloader.a.c)g.r(com.tencent.mm.plugin.downloader.a.c.class)).FC();
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.f.a> M(LinkedList<String> paramLinkedList)
  {
    LinkedList localLinkedList = null;
    Object localObject = FC();
    if (localObject == null) {
      paramLinkedList = localLinkedList;
    }
    do
    {
      do
      {
        return paramLinkedList;
        paramLinkedList = b.O(paramLinkedList);
        localObject = ((b)localObject).rawQuery("select * from FileDownloadInfo where " + paramLinkedList, new String[0]);
        paramLinkedList = localLinkedList;
      } while (localObject == null);
      localLinkedList = new LinkedList();
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          paramLinkedList = new com.tencent.mm.plugin.downloader.f.a();
          paramLinkedList.d((Cursor)localObject);
          localLinkedList.add(paramLinkedList);
        } while (((Cursor)localObject).moveToNext());
      }
      paramLinkedList = localLinkedList;
    } while (localObject == null);
    ((Cursor)localObject).close();
    return localLinkedList;
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.f.a> aFN()
  {
    Object localObject = FC();
    if (localObject == null) {
      localObject = null;
    }
    Cursor localCursor;
    LinkedList localLinkedList;
    do
    {
      return localObject;
      y.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = " + "select * from FileDownloadInfo where status=1 and downloadInWifi=1");
      localCursor = ((b)localObject).rawQuery("select * from FileDownloadInfo where status=1 and downloadInWifi=1", new String[0]);
      localLinkedList = new LinkedList();
      localObject = localLinkedList;
    } while (localCursor == null);
    while (localCursor.moveToNext())
    {
      localObject = new com.tencent.mm.plugin.downloader.f.a();
      ((com.tencent.mm.plugin.downloader.f.a)localObject).d(localCursor);
      localLinkedList.add(localObject);
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.f.a> aFO()
  {
    Object localObject = FC();
    if (localObject == null) {
      localObject = null;
    }
    Cursor localCursor;
    LinkedList localLinkedList;
    do
    {
      return localObject;
      y.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = " + "select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1");
      localCursor = ((b)localObject).rawQuery("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1", new String[0]);
      localLinkedList = new LinkedList();
      localObject = localLinkedList;
    } while (localCursor == null);
    while (localCursor.moveToNext())
    {
      localObject = new com.tencent.mm.plugin.downloader.f.a();
      ((com.tencent.mm.plugin.downloader.f.a)localObject).d(localCursor);
      localLinkedList.add(localObject);
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public static long c(com.tencent.mm.plugin.downloader.f.a parama)
  {
    if (parama == null) {}
    b localb;
    do
    {
      return -1L;
      localb = FC();
    } while (localb == null);
    boolean bool = localb.b(parama);
    y.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + parama.field_downloadId + ", ret=" + bool);
    return parama.field_downloadId;
  }
  
  public static long d(com.tencent.mm.plugin.downloader.f.a parama)
  {
    if (parama == null) {}
    b localb;
    do
    {
      return -1L;
      localb = FC();
    } while (localb == null);
    boolean bool = localb.c(parama, new String[0]);
    y.d("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", new Object[] { Long.valueOf(parama.field_downloadId), Boolean.valueOf(bool), Integer.valueOf(parama.field_status) });
    return parama.field_downloadId;
  }
  
  public static com.tencent.mm.plugin.downloader.f.a dk(long paramLong)
  {
    b localb = FC();
    if (localb == null) {
      return null;
    }
    return localb.dr(paramLong);
  }
  
  public static boolean dl(long paramLong)
  {
    b localb = FC();
    if (localb == null) {
      return false;
    }
    com.tencent.mm.plugin.downloader.f.a locala = new com.tencent.mm.plugin.downloader.f.a();
    locala.field_downloadId = paramLong;
    return localb.a(locala, new String[0]);
  }
  
  public static boolean j(long paramLong, int paramInt)
  {
    b localb = FC();
    if (localb == null) {
      return false;
    }
    return localb.gk("FileDownloadInfo", "update FileDownloadInfo set status = " + paramInt + " where downloadId = " + paramLong);
  }
  
  public static com.tencent.mm.plugin.downloader.f.a zH(String paramString)
  {
    b localb = FC();
    if (localb == null) {
      return null;
    }
    return localb.zH(paramString);
  }
  
  public static boolean zI(String paramString)
  {
    b localb = FC();
    if (localb == null) {
      return false;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
      return false;
    }
    return localb.gk("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + paramString + "\"");
  }
  
  public static boolean zJ(String paramString)
  {
    b localb = FC();
    if (localb == null) {
      return false;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
      return false;
    }
    return localb.gk("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + paramString + "\"");
  }
  
  public static com.tencent.mm.plugin.downloader.f.a zK(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = FC();
    if (localObject3 == null) {}
    do
    {
      do
      {
        return localObject1;
        if (bk.bl(paramString))
        {
          y.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
          return null;
        }
        localObject3 = ((b)localObject3).rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + paramString.hashCode(), new String[0]);
      } while (localObject3 == null);
      paramString = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        paramString = new com.tencent.mm.plugin.downloader.f.a();
        paramString.d((Cursor)localObject3);
      }
      localObject1 = paramString;
    } while (localObject3 == null);
    ((Cursor)localObject3).close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c
 * JD-Core Version:    0.7.0.1
 */