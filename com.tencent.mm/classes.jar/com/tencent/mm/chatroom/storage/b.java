package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(194053);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "GroupBindApp") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS GroupBindAppUserNameIndex ON GroupBindApp ( chatRoomName )" };
    AppMethodBeat.o(194053);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "GroupBindApp", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final dps DA(String paramString)
  {
    AppMethodBeat.i(194052);
    paramString = this.db.query("GroupBindApp", null, "chatRoomName =?", new String[] { paramString }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(194052);
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
        dps localdps = new dps();
        localdps.parseFrom(locala.field_BindAppData);
        return localdps;
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
      AppMethodBeat.o(194052);
    }
    AppMethodBeat.o(194052);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.b
 * JD-Core Version:    0.7.0.1
 */