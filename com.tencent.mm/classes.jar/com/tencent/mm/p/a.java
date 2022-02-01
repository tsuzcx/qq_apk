package com.tencent.mm.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends ba
{
  public static final String gfl;
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(42762);
    c.a locala = new c.a();
    locala.IhA = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgCount";
    locala.IhC.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "username";
    locala.IhC.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[2] = "unReadCount";
    locala.IhC.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatmode";
    locala.IhC.put("chatmode", "INTEGER default '0' ");
    localStringBuilder.append(" chatmode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "status";
    locala.IhC.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isSend";
    locala.IhC.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "conversationTime";
    locala.IhC.put("conversationTime", "LONG default '0' ");
    localStringBuilder.append(" conversationTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "content";
    locala.IhC.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "msgType";
    locala.IhC.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "customNotify";
    locala.IhC.put("customNotify", "TEXT default '' ");
    localStringBuilder.append(" customNotify TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "showTips";
    locala.IhC.put("showTips", "INTEGER default '0' ");
    localStringBuilder.append(" showTips INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "flag";
    locala.IhC.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "digest";
    locala.IhC.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "digestUser";
    locala.IhC.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "hasTrunc";
    locala.IhC.put("hasTrunc", "INTEGER default '0' ");
    localStringBuilder.append(" hasTrunc INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "parentRef";
    locala.IhC.put("parentRef", "TEXT");
    localStringBuilder.append(" parentRef TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "attrflag";
    locala.IhC.put("attrflag", "INTEGER default '0' ");
    localStringBuilder.append(" attrflag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "editingMsg";
    locala.IhC.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "atCount";
    locala.IhC.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "sightTime";
    locala.IhC.put("sightTime", "LONG default '0' ");
    localStringBuilder.append(" sightTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "unReadMuteCount";
    locala.IhC.put("unReadMuteCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadMuteCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "lastSeq";
    locala.IhC.put("lastSeq", "LONG");
    localStringBuilder.append(" lastSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[22] = "UnDeliverCount";
    locala.IhC.put("UnDeliverCount", "INTEGER");
    localStringBuilder.append(" UnDeliverCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "UnReadInvite";
    locala.IhC.put("UnReadInvite", "INTEGER");
    localStringBuilder.append(" UnReadInvite INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "firstUnDeliverSeq";
    locala.IhC.put("firstUnDeliverSeq", "LONG");
    localStringBuilder.append(" firstUnDeliverSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[25] = "editingQuoteMsgId";
    locala.IhC.put("editingQuoteMsgId", "LONG default '0' ");
    localStringBuilder.append(" editingQuoteMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[26] = "hasTodo";
    locala.IhC.put("hasTodo", "INTEGER default '0' ");
    localStringBuilder.append(" hasTodo INTEGER default '0' ");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    gfl = null;
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
  
  public final void lO(int paramInt)
  {
    AppMethodBeat.i(42760);
    int i = this.field_attrflag | paramInt;
    if ((this.field_attrflag >= 0) && (this.field_attrflag < 536870912) && ((i >= 536870912) || (i < 0)) && (this.field_username.contains("@")))
    {
      ad.i("Conversition", "wrong add attr flag: %s, %s, %s, %s", new Object[] { this.field_username, Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), bt.flS() });
      e.ygI.f(20435, new Object[] { Integer.valueOf(2), Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), this.field_username });
    }
    kt(this.field_attrflag | paramInt);
    AppMethodBeat.o(42760);
  }
  
  public final void lP(int paramInt)
  {
    AppMethodBeat.i(42761);
    kt(this.field_attrflag & (paramInt ^ 0xFFFFFFFF));
    AppMethodBeat.o(42761);
  }
  
  public final boolean lQ(int paramInt)
  {
    return (this.field_attrflag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.p.a
 * JD-Core Version:    0.7.0.1
 */