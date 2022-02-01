package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends ay
{
  public static final String fIf;
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(42762);
    c.a locala = new c.a();
    locala.EYt = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgCount";
    locala.EYv.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "username";
    locala.EYv.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "username";
    locala.columns[2] = "unReadCount";
    locala.EYv.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatmode";
    locala.EYv.put("chatmode", "INTEGER default '0' ");
    localStringBuilder.append(" chatmode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "status";
    locala.EYv.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isSend";
    locala.EYv.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "conversationTime";
    locala.EYv.put("conversationTime", "LONG default '0' ");
    localStringBuilder.append(" conversationTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "content";
    locala.EYv.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "msgType";
    locala.EYv.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "customNotify";
    locala.EYv.put("customNotify", "TEXT default '' ");
    localStringBuilder.append(" customNotify TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "showTips";
    locala.EYv.put("showTips", "INTEGER default '0' ");
    localStringBuilder.append(" showTips INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "flag";
    locala.EYv.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "digest";
    locala.EYv.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "digestUser";
    locala.EYv.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "hasTrunc";
    locala.EYv.put("hasTrunc", "INTEGER default '0' ");
    localStringBuilder.append(" hasTrunc INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "parentRef";
    locala.EYv.put("parentRef", "TEXT");
    localStringBuilder.append(" parentRef TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "attrflag";
    locala.EYv.put("attrflag", "INTEGER default '0' ");
    localStringBuilder.append(" attrflag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "editingMsg";
    locala.EYv.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "atCount";
    locala.EYv.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "sightTime";
    locala.EYv.put("sightTime", "LONG default '0' ");
    localStringBuilder.append(" sightTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "unReadMuteCount";
    locala.EYv.put("unReadMuteCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadMuteCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "lastSeq";
    locala.EYv.put("lastSeq", "LONG");
    localStringBuilder.append(" lastSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[22] = "UnDeliverCount";
    locala.EYv.put("UnDeliverCount", "INTEGER");
    localStringBuilder.append(" UnDeliverCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "UnReadInvite";
    locala.EYv.put("UnReadInvite", "INTEGER");
    localStringBuilder.append(" UnReadInvite INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "firstUnDeliverSeq";
    locala.EYv.put("firstUnDeliverSeq", "LONG");
    localStringBuilder.append(" firstUnDeliverSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "editingQuoteMsgId";
    locala.EYv.put("editingQuoteMsgId", "LONG default '0' ");
    localStringBuilder.append(" editingQuoteMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[26] = "hasTodo";
    locala.EYv.put("hasTodo", "INTEGER default '0' ");
    localStringBuilder.append(" hasTodo INTEGER default '0' ");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    fIf = null;
    AppMethodBeat.o(42762);
  }
  
  public a() {}
  
  public a(String paramString)
  {
    AppMethodBeat.i(42759);
    setUsername(paramString);
    AppMethodBeat.o(42759);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final void lu(int paramInt)
  {
    AppMethodBeat.i(42760);
    jX(this.field_attrflag | paramInt);
    AppMethodBeat.o(42760);
  }
  
  public final void lv(int paramInt)
  {
    AppMethodBeat.i(42761);
    jX(this.field_attrflag & (paramInt ^ 0xFFFFFFFF));
    AppMethodBeat.o(42761);
  }
  
  public final boolean lw(int paramInt)
  {
    return (this.field_attrflag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.o.a
 * JD-Core Version:    0.7.0.1
 */