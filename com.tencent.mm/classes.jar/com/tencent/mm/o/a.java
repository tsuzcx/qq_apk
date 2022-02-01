package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends bb
{
  public static IAutoDBItem.MAutoDBInfo info;
  public static final String jxD;
  
  static
  {
    AppMethodBeat.i(42762);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[29];
    localMAutoDBInfo.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgCount";
    localMAutoDBInfo.colsMap.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[2] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "chatmode";
    localMAutoDBInfo.colsMap.put("chatmode", "INTEGER default '0' ");
    localStringBuilder.append(" chatmode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "conversationTime";
    localMAutoDBInfo.colsMap.put("conversationTime", "LONG default '0' ");
    localStringBuilder.append(" conversationTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "customNotify";
    localMAutoDBInfo.colsMap.put("customNotify", "TEXT default '' ");
    localStringBuilder.append(" customNotify TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "showTips";
    localMAutoDBInfo.colsMap.put("showTips", "INTEGER default '0' ");
    localStringBuilder.append(" showTips INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "digestUser";
    localMAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hasTrunc";
    localMAutoDBInfo.colsMap.put("hasTrunc", "INTEGER default '0' ");
    localStringBuilder.append(" hasTrunc INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "parentRef";
    localMAutoDBInfo.colsMap.put("parentRef", "TEXT");
    localStringBuilder.append(" parentRef TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "attrflag";
    localMAutoDBInfo.colsMap.put("attrflag", "INTEGER default '0' ");
    localStringBuilder.append(" attrflag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "atCount";
    localMAutoDBInfo.colsMap.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "sightTime";
    localMAutoDBInfo.colsMap.put("sightTime", "LONG default '0' ");
    localStringBuilder.append(" sightTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "unReadMuteCount";
    localMAutoDBInfo.colsMap.put("unReadMuteCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadMuteCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "lastSeq";
    localMAutoDBInfo.colsMap.put("lastSeq", "LONG");
    localStringBuilder.append(" lastSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "UnDeliverCount";
    localMAutoDBInfo.colsMap.put("UnDeliverCount", "INTEGER");
    localStringBuilder.append(" UnDeliverCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "UnReadInvite";
    localMAutoDBInfo.colsMap.put("UnReadInvite", "INTEGER");
    localStringBuilder.append(" UnReadInvite INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "firstUnDeliverSeq";
    localMAutoDBInfo.colsMap.put("firstUnDeliverSeq", "LONG");
    localStringBuilder.append(" firstUnDeliverSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "editingQuoteMsgId";
    localMAutoDBInfo.colsMap.put("editingQuoteMsgId", "LONG default '0' ");
    localStringBuilder.append(" editingQuoteMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "hasTodo";
    localMAutoDBInfo.colsMap.put("hasTodo", "INTEGER default '0' ");
    localStringBuilder.append(" hasTodo INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "hbMarkRed";
    localMAutoDBInfo.colsMap.put("hbMarkRed", "INTEGER default '0' ");
    localStringBuilder.append(" hbMarkRed INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "remitMarkRed";
    localMAutoDBInfo.colsMap.put("remitMarkRed", "INTEGER default '0' ");
    localStringBuilder.append(" remitMarkRed INTEGER default '0' ");
    localMAutoDBInfo.columns[29] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    jxD = null;
    AppMethodBeat.o(42762);
  }
  
  public a() {}
  
  public a(String paramString)
  {
    AppMethodBeat.i(42759);
    setUsername(paramString);
    AppMethodBeat.o(42759);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void rn(int paramInt)
  {
    AppMethodBeat.i(42760);
    int i = this.field_attrflag | paramInt;
    if ((this.field_attrflag >= 0) && (this.field_attrflag < 536870912) && ((i >= 536870912) || (i < 0)) && (this.field_username.contains("@")))
    {
      Log.i("Conversition", "wrong add attr flag: %s, %s, %s, %s", new Object[] { this.field_username, Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), Util.getStack() });
      f.Iyx.a(20435, new Object[] { Integer.valueOf(2), Integer.valueOf(this.field_attrflag), Integer.valueOf(paramInt), this.field_username });
    }
    pL(this.field_attrflag | paramInt);
    AppMethodBeat.o(42760);
  }
  
  public final void ro(int paramInt)
  {
    AppMethodBeat.i(42761);
    pL(this.field_attrflag & (paramInt ^ 0xFFFFFFFF));
    AppMethodBeat.o(42761);
  }
  
  public final boolean rp(int paramInt)
  {
    return (this.field_attrflag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.o.a
 * JD-Core Version:    0.7.0.1
 */