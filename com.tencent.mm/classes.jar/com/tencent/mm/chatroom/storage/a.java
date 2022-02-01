package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dd
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(217137);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatRoomName";
    locala.IBN.put("chatRoomName", "TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(" chatRoomName TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "chatRoomName";
    locala.columns[1] = "BindAppData";
    locala.IBN.put("BindAppData", "BLOB");
    localStringBuilder.append(" BindAppData BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(217137);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(217136);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(217136);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.a
 * JD-Core Version:    0.7.0.1
 */