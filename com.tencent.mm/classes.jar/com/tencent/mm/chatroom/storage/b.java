package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(213426);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "GroupBindApp") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS GroupBindAppUserNameIndex ON GroupBindApp ( chatRoomName )" };
    AppMethodBeat.o(213426);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "GroupBindApp", INDEX_CREATE);
    this.db = parame;
  }
  
  public final cwe uO(String paramString)
  {
    AppMethodBeat.i(213425);
    paramString = this.db.query("GroupBindApp", null, "chatRoomName =?", new String[] { paramString }, null, null, null);
    if (paramString == null)
    {
      AppMethodBeat.o(213425);
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
          ad.i("MicroMsg.GroupBindAppStorage", "BindAppData is null");
          return null;
        }
        cwe localcwe = new cwe();
        localcwe.parseFrom(locala.field_BindAppData);
        return localcwe;
      }
      paramString.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.GroupBindAppStorage", localException.getMessage());
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(213425);
    }
    AppMethodBeat.o(213425);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.b
 * JD-Core Version:    0.7.0.1
 */