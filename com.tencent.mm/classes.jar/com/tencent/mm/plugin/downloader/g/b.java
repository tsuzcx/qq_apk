package com.tencent.mm.plugin.downloader.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(89097);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )" };
    AppMethodBeat.o(89097);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "FileDownloadInfo", null);
  }
  
  public static String T(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(89089);
    if (bt.gL(paramLinkedList))
    {
      AppMethodBeat.o(89089);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int i = 0;
    while (i < paramLinkedList.size() - 2)
    {
      localStringBuilder.append("\"").append((String)paramLinkedList.get(i)).append("\",");
      i += 1;
    }
    localStringBuilder.append("\"").append((String)paramLinkedList.get(paramLinkedList.size() - 1)).append("\")");
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(89089);
    return paramLinkedList;
  }
  
  public final a Sk(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(89088);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
      AppMethodBeat.o(89088);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where appId=\"" + paramString + "\" or rawAppId=\"" + paramString + "\"", new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(89088);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(89088);
    return paramString;
  }
  
  public final boolean Sl(String paramString)
  {
    AppMethodBeat.i(89093);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
      AppMethodBeat.o(89093);
      return false;
    }
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + paramString + "\"");
    AppMethodBeat.o(89093);
    return bool;
  }
  
  public final boolean Sm(String paramString)
  {
    AppMethodBeat.i(89094);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
      AppMethodBeat.o(89094);
      return false;
    }
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + paramString + "\" or rawAppId=\"" + paramString + "\"");
    AppMethodBeat.o(89094);
    return bool;
  }
  
  public final a Sn(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(89091);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
      AppMethodBeat.o(89091);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where downloadUrl=\"" + paramString + "\"", new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(89091);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(89091);
    return paramString;
  }
  
  public final boolean So(String paramString)
  {
    AppMethodBeat.i(89096);
    paramString = rawQuery(String.format("select count(*) from %s where %s=\"%s\"", new Object[] { "FileDownloadInfo", "downloadUrl", paramString }), new String[0]);
    if ((paramString != null) && (paramString.moveToFirst()))
    {
      int i = paramString.getInt(0);
      paramString.close();
      if (i > 1)
      {
        AppMethodBeat.o(89096);
        return true;
      }
      AppMethodBeat.o(89096);
      return false;
    }
    AppMethodBeat.o(89096);
    return false;
  }
  
  public final boolean bQG()
  {
    AppMethodBeat.i(89092);
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo");
    AppMethodBeat.o(89092);
    return bool;
  }
  
  public final LinkedList<a> bQr()
  {
    AppMethodBeat.i(189079);
    ad.i("MicroMsg.FileDownloadInfoStorage", "getAllTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo")));
    Cursor localCursor = rawQuery("select * from FileDownloadInfo", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null)
    {
      AppMethodBeat.o(189079);
      return localLinkedList;
    }
    while (localCursor.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(localCursor);
      localLinkedList.add(locala);
    }
    localCursor.close();
    AppMethodBeat.o(189079);
    return localLinkedList;
  }
  
  public final boolean cF(String paramString, int paramInt)
  {
    AppMethodBeat.i(89095);
    String str = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "FileDownloadInfo", "status", Integer.valueOf(paramInt), "downloadUrl", paramString });
    boolean bool = execSQL("FileDownloadInfo", str);
    ad.i("MicroMsg.FileDownloadInfoStorage", "updateDownloadState, sql : %s\ndownloadUrl : %s, status : %d, ret : %s", new Object[] { str, paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(89095);
    return bool;
  }
  
  public final a oC(long paramLong)
  {
    a locala = null;
    AppMethodBeat.i(89090);
    if (paramLong < 0L)
    {
      ad.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
      AppMethodBeat.o(89090);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where downloadId=".concat(String.valueOf(paramLong)), new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(89090);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      locala = new a();
      locala.convertFrom(localCursor);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(89090);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.b
 * JD-Core Version:    0.7.0.1
 */