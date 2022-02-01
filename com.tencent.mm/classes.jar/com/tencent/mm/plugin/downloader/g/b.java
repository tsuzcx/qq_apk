package com.tencent.mm.plugin.downloader.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(89097);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )" };
    AppMethodBeat.o(89097);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "FileDownloadInfo", null);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public static String U(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(89089);
    if (Util.isNullOrNil(paramLinkedList))
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
  
  public final a IQ(long paramLong)
  {
    a locala = null;
    AppMethodBeat.i(89090);
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
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
  
  public final a asU(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(89088);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
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
  
  public final boolean asV(String paramString)
  {
    AppMethodBeat.i(89093);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
      AppMethodBeat.o(89093);
      return false;
    }
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + paramString + "\"");
    AppMethodBeat.o(89093);
    return bool;
  }
  
  public final boolean asW(String paramString)
  {
    AppMethodBeat.i(89094);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
      AppMethodBeat.o(89094);
      return false;
    }
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + paramString + "\" or rawAppId=\"" + paramString + "\"");
    AppMethodBeat.o(89094);
    return bool;
  }
  
  public final a asX(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(89091);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
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
  
  public final boolean asY(String paramString)
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
  
  public final LinkedList<a> cPX()
  {
    AppMethodBeat.i(219132);
    Log.i("MicroMsg.FileDownloadInfoStorage", "getAllTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo")));
    Cursor localCursor = rawQuery("select * from FileDownloadInfo", new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localCursor == null)
    {
      AppMethodBeat.o(219132);
      return localLinkedList;
    }
    while (localCursor.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(localCursor);
      localLinkedList.add(locala);
    }
    localCursor.close();
    AppMethodBeat.o(219132);
    return localLinkedList;
  }
  
  public final boolean cQp()
  {
    AppMethodBeat.i(89092);
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo");
    AppMethodBeat.o(89092);
    return bool;
  }
  
  public final boolean dq(String paramString, int paramInt)
  {
    AppMethodBeat.i(89095);
    String str = String.format("update %s set %s=%d where %s=\"%s\"", new Object[] { "FileDownloadInfo", "status", Integer.valueOf(paramInt), "downloadUrl", paramString });
    boolean bool = execSQL("FileDownloadInfo", str);
    Log.i("MicroMsg.FileDownloadInfoStorage", "updateDownloadState, sql : %s\ndownloadUrl : %s, status : %d, ret : %s", new Object[] { str, paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    AppMethodBeat.o(89095);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.b
 * JD-Core Version:    0.7.0.1
 */