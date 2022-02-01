package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends af
{
  public static final int hRm;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(124174);
    hRm = j.hSi.hSl;
    c.a locala = new c.a();
    locala.IhA = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatId";
    locala.IhC.put("bizChatId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "bizChatId";
    locala.columns[1] = "brandUserName";
    locala.IhC.put("brandUserName", "TEXT");
    localStringBuilder.append(" brandUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "unReadCount";
    locala.IhC.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newUnReadCount";
    locala.IhC.put("newUnReadCount", "INTEGER");
    localStringBuilder.append(" newUnReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastMsgID";
    locala.IhC.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "lastMsgTime";
    locala.IhC.put("lastMsgTime", "LONG");
    localStringBuilder.append(" lastMsgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "digest";
    locala.IhC.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "digestUser";
    locala.IhC.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "atCount";
    locala.IhC.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "editingMsg";
    locala.IhC.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatType";
    locala.IhC.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.IhC.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "isSend";
    locala.IhC.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "msgType";
    locala.IhC.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "msgCount";
    locala.IhC.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "flag";
    locala.IhC.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "atAll";
    locala.IhC.put("atAll", "INTEGER default '0' ");
    localStringBuilder.append(" atAll INTEGER default '0' ");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124174);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.a
 * JD-Core Version:    0.7.0.1
 */