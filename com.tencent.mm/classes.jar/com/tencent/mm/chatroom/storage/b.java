package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b
  extends MAutoStorage<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(241386);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "GroupBindApp") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS GroupBindAppUserNameIndex ON GroupBindApp ( chatRoomName )" };
    AppMethodBeat.o(241386);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "GroupBindApp", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final esu CX(String paramString)
  {
    AppMethodBeat.i(241390);
    paramString = this.db.query("GroupBindApp", null, "chatRoomName =?", new String[] { paramString }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(241390);
      return null;
    }
    try
    {
      if (paramString.moveToNext())
      {
        a locala = new a();
        locala.convertFrom(paramString);
        if ((locala.field_BindAppData != null) && (locala.field_BindAppData.length <= 0))
        {
          Log.i("MicroMsg.GroupBindAppStorage", "BindAppData is null");
          return null;
        }
        esu localesu = new esu();
        localesu.parseFrom(locala.field_BindAppData);
        return localesu;
      }
      paramString.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.GroupBindAppStorage", localException.getMessage());
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(241390);
    }
    AppMethodBeat.o(241390);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.b
 * JD-Core Version:    0.7.0.1
 */