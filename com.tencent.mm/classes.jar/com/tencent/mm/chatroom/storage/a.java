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
    AppMethodBeat.i(213424);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatRoomName";
    locala.IhC.put("chatRoomName", "TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(" chatRoomName TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "chatRoomName";
    locala.columns[1] = "BindAppData";
    locala.IhC.put("BindAppData", "BLOB");
    localStringBuilder.append(" BindAppData BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(213424);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(213423);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(213423);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.a
 * JD-Core Version:    0.7.0.1
 */