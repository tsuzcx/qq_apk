package com.tencent.mm.plugin.aa.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends com.tencent.mm.g.c.a
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(63420);
    c.a locala = new c.a();
    locala.GvF = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "payMsgId";
    locala.GvH.put("payMsgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "payMsgId";
    locala.columns[1] = "insertmsg";
    locala.GvH.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "chatroom";
    locala.GvH.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgId";
    locala.GvH.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(63420);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.a
 * JD-Core Version:    0.7.0.1
 */