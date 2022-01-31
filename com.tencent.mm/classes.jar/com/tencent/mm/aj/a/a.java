package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends aa
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(11489);
    c.a locala = new c.a();
    locala.yrK = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatId";
    locala.yrM.put("bizChatId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "bizChatId";
    locala.columns[1] = "brandUserName";
    locala.yrM.put("brandUserName", "TEXT");
    localStringBuilder.append(" brandUserName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "unReadCount";
    locala.yrM.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "newUnReadCount";
    locala.yrM.put("newUnReadCount", "INTEGER");
    localStringBuilder.append(" newUnReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "lastMsgID";
    locala.yrM.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "lastMsgTime";
    locala.yrM.put("lastMsgTime", "LONG");
    localStringBuilder.append(" lastMsgTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.yrM.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "digest";
    locala.yrM.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "digestUser";
    locala.yrM.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "atCount";
    locala.yrM.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "editingMsg";
    locala.yrM.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatType";
    locala.yrM.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.yrM.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "isSend";
    locala.yrM.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "msgType";
    locala.yrM.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "msgCount";
    locala.yrM.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "flag";
    locala.yrM.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(11489);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.a.a
 * JD-Core Version:    0.7.0.1
 */