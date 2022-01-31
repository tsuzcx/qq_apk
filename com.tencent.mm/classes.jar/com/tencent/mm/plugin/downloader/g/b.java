package com.tencent.mm.plugin.downloader.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(2489);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )" };
    AppMethodBeat.o(2489);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "FileDownloadInfo", null);
  }
  
  public static String N(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(2483);
    String str = "";
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(2483);
      return "1=1";
    }
    int i = 0;
    while (i < paramLinkedList.size() - 1)
    {
      str = str + "appId=\"" + (String)paramLinkedList.get(i) + "\" or ";
      i += 1;
    }
    paramLinkedList = str + "appId=\"" + (String)paramLinkedList.get(paramLinkedList.size() - 1) + "\"";
    AppMethodBeat.o(2483);
    return paramLinkedList;
  }
  
  public final a JD(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(2482);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
      AppMethodBeat.o(2482);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where appId=\"" + paramString + "\"", new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(2482);
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
    AppMethodBeat.o(2482);
    return paramString;
  }
  
  public final boolean JE(String paramString)
  {
    AppMethodBeat.i(2487);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
      AppMethodBeat.o(2487);
      return false;
    }
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + paramString + "\"");
    AppMethodBeat.o(2487);
    return bool;
  }
  
  public final boolean JF(String paramString)
  {
    AppMethodBeat.i(2488);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
      AppMethodBeat.o(2488);
      return false;
    }
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + paramString + "\"");
    AppMethodBeat.o(2488);
    return bool;
  }
  
  public final a JG(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(2485);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
      AppMethodBeat.o(2485);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + paramString.hashCode(), new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(2485);
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
    AppMethodBeat.o(2485);
    return paramString;
  }
  
  public final boolean bjz()
  {
    AppMethodBeat.i(2486);
    boolean bool = execSQL("FileDownloadInfo", "delete from FileDownloadInfo");
    AppMethodBeat.o(2486);
    return bool;
  }
  
  public final a iU(long paramLong)
  {
    a locala = null;
    AppMethodBeat.i(2484);
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
      AppMethodBeat.o(2484);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where downloadId=".concat(String.valueOf(paramLong)), new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(2484);
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
    AppMethodBeat.o(2484);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.b
 * JD-Core Version:    0.7.0.1
 */