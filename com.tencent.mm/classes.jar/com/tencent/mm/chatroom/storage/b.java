package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(217139);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "GroupBindApp") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS GroupBindAppUserNameIndex ON GroupBindApp ( chatRoomName )" };
    AppMethodBeat.o(217139);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "GroupBindApp", INDEX_CREATE);
    this.db = parame;
  }
  
  public final cwy vj(String paramString)
  {
    AppMethodBeat.i(217138);
    paramString = this.db.query("GroupBindApp", null, "chatRoomName =?", new String[] { paramString }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(217138);
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
          ae.i("MicroMsg.GroupBindAppStorage", "BindAppData is null");
          return null;
        }
        cwy localcwy = new cwy();
        localcwy.parseFrom(locala.field_BindAppData);
        return localcwy;
      }
      paramString.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.i("MicroMsg.GroupBindAppStorage", localException.getMessage());
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(217138);
    }
    AppMethodBeat.o(217138);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.b
 * JD-Core Version:    0.7.0.1
 */