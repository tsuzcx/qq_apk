package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d
{
  public static com.tencent.mm.plugin.downloader.g.a JD(String paramString)
  {
    AppMethodBeat.i(2397);
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2397);
      return null;
    }
    paramString = localb.JD(paramString);
    AppMethodBeat.o(2397);
    return paramString;
  }
  
  public static boolean JE(String paramString)
  {
    AppMethodBeat.i(2400);
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2400);
      return false;
    }
    boolean bool = localb.JE(paramString);
    AppMethodBeat.o(2400);
    return bool;
  }
  
  public static boolean JF(String paramString)
  {
    AppMethodBeat.i(2401);
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2401);
      return false;
    }
    boolean bool = localb.JF(paramString);
    AppMethodBeat.o(2401);
    return bool;
  }
  
  public static com.tencent.mm.plugin.downloader.g.a JG(String paramString)
  {
    AppMethodBeat.i(2402);
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2402);
      return null;
    }
    paramString = localb.JG(paramString);
    AppMethodBeat.o(2402);
    return paramString;
  }
  
  public static b YG()
  {
    AppMethodBeat.i(2405);
    if (g.RJ().QU())
    {
      g.RJ();
      if (!com.tencent.mm.kernel.a.QP()) {}
    }
    else
    {
      ab.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
      AppMethodBeat.o(2405);
      return null;
    }
    if (g.E(com.tencent.mm.plugin.downloader.a.d.class) == null)
    {
      ab.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
      AppMethodBeat.o(2405);
      return null;
    }
    b localb = ((com.tencent.mm.plugin.downloader.a.d)g.E(com.tencent.mm.plugin.downloader.a.d.class)).YG();
    AppMethodBeat.o(2405);
    return localb;
  }
  
  public static LinkedList<com.tencent.mm.plugin.downloader.g.a> bjk()
  {
    AppMethodBeat.i(2404);
    Object localObject = YG();
    if (localObject == null)
    {
      AppMethodBeat.o(2404);
      return null;
    }
    ab.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=1 and downloadInWifi=1")));
    localObject = ((b)localObject).rawQuery("select * from FileDownloadInfo where status=1 and downloadInWifi=1", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localObject == null)
    {
      AppMethodBeat.o(2404);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = new com.tencent.mm.plugin.downloader.g.a();
      locala.convertFrom((Cursor)localObject);
      localLinkedList.add(locala);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public static long d(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(2398);
    if (parama == null)
    {
      AppMethodBeat.o(2398);
      return -1L;
    }
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2398);
      return -1L;
    }
    parama.field_updateTime = System.currentTimeMillis();
    boolean bool = localb.insert(parama);
    ab.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + parama.field_downloadId + ", ret=" + bool);
    long l = parama.field_downloadId;
    AppMethodBeat.o(2398);
    return l;
  }
  
  public static long e(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(2399);
    if (parama == null)
    {
      AppMethodBeat.o(2399);
      return -1L;
    }
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2399);
      return -1L;
    }
    parama.field_updateTime = System.currentTimeMillis();
    boolean bool = localb.update(parama, new String[0]);
    ab.i("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", new Object[] { Long.valueOf(parama.field_downloadId), Boolean.valueOf(bool), Integer.valueOf(parama.field_status) });
    long l = parama.field_downloadId;
    AppMethodBeat.o(2399);
    return l;
  }
  
  public static com.tencent.mm.plugin.downloader.g.a iJ(long paramLong)
  {
    AppMethodBeat.i(2396);
    Object localObject = YG();
    if (localObject == null)
    {
      AppMethodBeat.o(2396);
      return null;
    }
    localObject = ((b)localObject).iU(paramLong);
    AppMethodBeat.o(2396);
    return localObject;
  }
  
  public static boolean iK(long paramLong)
  {
    AppMethodBeat.i(2403);
    b localb = YG();
    if (localb == null)
    {
      AppMethodBeat.o(2403);
      return false;
    }
    com.tencent.mm.plugin.downloader.g.a locala = new com.tencent.mm.plugin.downloader.g.a();
    locala.field_downloadId = paramLong;
    boolean bool = localb.delete(locala, new String[0]);
    AppMethodBeat.o(2403);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d
 * JD-Core Version:    0.7.0.1
 */