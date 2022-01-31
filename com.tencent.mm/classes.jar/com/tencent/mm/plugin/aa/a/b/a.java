package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends com.tencent.mm.h.c.a
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "payMsgId";
    locala.ujN.put("payMsgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "payMsgId";
    locala.columns[1] = "insertmsg";
    locala.ujN.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "chatroom";
    locala.ujN.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgId";
    locala.ujN.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.a
 * JD-Core Version:    0.7.0.1
 */