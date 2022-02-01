package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends ba
{
  public static final String ghD;
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(42762);
    c.a locala = new c.a();
    locala.IBL = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgCount";
    locala.IBN.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "username";
    locala.IBN.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[2] = "unReadCount";
    locala.IBN.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatmode";
    locala.IBN.put("chatmode", "INTEGER default '0' ");
    localStringBuilder.append(" chatmode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "status";
    locala.IBN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isSend";
    locala.IBN.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "conversationTime";
    locala.IBN.put("conversationTime", "LONG default '0' ");
    localStringBuilder.append(" conversationTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "content";
    locala.IBN.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "msgType";
    locala.IBN.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "customNotify";
    locala.IBN.put("customNotify", "TEXT default '' ");
    localStringBuilder.append(" customNotify TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "showTips";
    locala.IBN.put("showTips", "INTEGER default '0' ");
    localStringBuilder.append(" showTips INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "flag";
    locala.IBN.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "digest";
    locala.IBN.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "digestUser";
    locala.IBN.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "hasTrunc";
    locala.IBN.put("hasTrunc", "INTEGER default '0' ");
    localStringBuilder.append(" hasTrunc INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "parentRef";
    locala.IBN.put("parentRef", "TEXT");
    localStringBuilder.append(" parentRef TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "attrflag";
    locala.IBN.put("attrflag", "INTEGER default '0' ");
    localStringBuilder.append(" attrflag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "editingMsg";
    locala.IBN.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "atCount";
    locala.IBN.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "sightTime";
    locala.IBN.put("sightTime", "LONG default '0' ");
    localStringBuilder.append(" sightTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "unReadMuteCount";
    locala.IBN.put("unReadMuteCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadMuteCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "lastSeq";
    locala.IBN.put("lastSeq", "LONG");
    localStringBuilder.append(" lastSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[22] = "UnDeliverCount";
    locala.IBN.put("UnDeliverCount", "INTEGER");
    localStringBuilder.append(" UnDeliverCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "UnReadInvite";
    locala.IBN.put("UnReadInvite", "INTEGER");
    localStringBuilder.append(" UnReadInvite INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "firstUnDeliverSeq";
    locala.IBN.put("firstUnDeliverSeq", "LONG");
    localStringBuilder.append(" firstUnDeliverSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "editingQuoteMsgId";
    locala.IBN.put("editingQuoteMsgId", "LONG default '0' ");
    localStringBuilder.append(" editingQuoteMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[26] = "hasTodo";
    locala.IBN.put("hasTodo", "INTEGER default '0' ");
    localStringBuilder.append(" hasTodo INTEGER default '0' ");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    ghD = null;
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
  
  public final void lQ(int paramInt)
  {
    AppMethodBeat.i(42760);
    int i = this.field_attrflag | paramInt;
    if ((this.field_attrflag >= 0) && (this.field_attrflag < 536870912) && ((i >= 536870912) || (i < 0)) && (this.field_username.contains("@")))
    {
      ae.i("Conversition", "wrong add attr flag: %s, %s, %s, %s", new Object[] { this.field_username, Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), bu.fpN() });
      e.ywz.f(20435, new Object[] { Integer.valueOf(2), Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), this.field_username });
    }
    kv(this.field_attrflag | paramInt);
    AppMethodBeat.o(42760);
  }
  
  public final void lR(int paramInt)
  {
    AppMethodBeat.i(42761);
    kv(this.field_attrflag & (paramInt ^ 0xFFFFFFFF));
    AppMethodBeat.o(42761);
  }
  
  public final boolean lS(int paramInt)
  {
    return (this.field_attrflag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.o.a
 * JD-Core Version:    0.7.0.1
 */