package com.tencent.mm.plugin.downloader.f;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )" };
  
  public b(e parame)
  {
    super(parame, a.buS, "FileDownloadInfo", null);
  }
  
  public static String O(LinkedList<String> paramLinkedList)
  {
    String str = "";
    if (bk.dk(paramLinkedList)) {
      return "1=1";
    }
    int i = 0;
    while (i < paramLinkedList.size() - 1)
    {
      str = str + "appId=\"" + (String)paramLinkedList.get(i) + "\" or ";
      i += 1;
    }
    return str + "appId=\"" + (String)paramLinkedList.get(paramLinkedList.size() - 1) + "\"";
  }
  
  public static String P(LinkedList<Long> paramLinkedList)
  {
    String str = "(";
    int i = 0;
    while (i < paramLinkedList.size() - 1)
    {
      long l = ((Long)paramLinkedList.get(i)).longValue();
      str = str + l + ",";
      i += 1;
    }
    return str + paramLinkedList.get(i) + ")";
  }
  
  public final boolean aFX()
  {
    return gk("FileDownloadInfo", "delete from FileDownloadInfo");
  }
  
  public final a dr(long paramLong)
  {
    a locala1 = null;
    a locala2 = null;
    if (paramLong < 0L) {
      y.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
    }
    Cursor localCursor;
    do
    {
      do
      {
        return locala2;
        localCursor = rawQuery("select * from FileDownloadInfo where downloadId=" + paramLong, new String[0]);
      } while (localCursor == null);
      if (localCursor.moveToFirst())
      {
        locala1 = new a();
        locala1.d(localCursor);
      }
      locala2 = locala1;
    } while (localCursor == null);
    localCursor.close();
    return locala1;
  }
  
  public final a zH(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (bk.bl(paramString)) {
      y.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
    }
    Cursor localCursor;
    do
    {
      do
      {
        return localObject1;
        localCursor = rawQuery("select * from FileDownloadInfo where appId=\"" + paramString + "\"", new String[0]);
      } while (localCursor == null);
      paramString = localObject2;
      if (localCursor.moveToFirst())
      {
        paramString = new a();
        paramString.d(localCursor);
      }
      localObject1 = paramString;
    } while (localCursor == null);
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.b
 * JD-Core Version:    0.7.0.1
 */