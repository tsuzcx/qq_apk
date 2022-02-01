package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dj
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(194051);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatRoomName";
    localMAutoDBInfo.colsMap.put("chatRoomName", "TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(" chatRoomName TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "chatRoomName";
    localMAutoDBInfo.columns[1] = "BindAppData";
    localMAutoDBInfo.colsMap.put("BindAppData", "BLOB");
    localStringBuilder.append(" BindAppData BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(194051);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(194050);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(194050);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.a
 * JD-Core Version:    0.7.0.1
 */