package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class ab
  extends eo
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(42763);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[24];
    localMAutoDBInfo.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isShowTimer";
    localMAutoDBInfo.colsMap.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "imgPath";
    localMAutoDBInfo.colsMap.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved";
    localMAutoDBInfo.colsMap.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "talkerId";
    localMAutoDBInfo.colsMap.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "transContent";
    localMAutoDBInfo.colsMap.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "transBrandWording";
    localMAutoDBInfo.colsMap.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bizClientMsgId";
    localMAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "bizChatId";
    localMAutoDBInfo.colsMap.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "bizChatUserId";
    localMAutoDBInfo.colsMap.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "msgSeq";
    localMAutoDBInfo.colsMap.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "solitaireFoldInfo";
    localMAutoDBInfo.colsMap.put("solitaireFoldInfo", "BLOB");
    localStringBuilder.append(" solitaireFoldInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "fromUsername";
    localMAutoDBInfo.colsMap.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "toUsername";
    localMAutoDBInfo.colsMap.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "historyId";
    localMAutoDBInfo.colsMap.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    localMAutoDBInfo.columns[24] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(42763);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.ab
 * JD-Core Version:    0.7.0.1
 */