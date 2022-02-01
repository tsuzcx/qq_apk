package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class aa
  extends ei
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(42763);
    c.a locala = new c.a();
    locala.IhA = new Field[24];
    locala.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.IhC.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isSend";
    locala.IhC.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowTimer";
    locala.IhC.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "talker";
    locala.IhC.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.IhC.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgPath";
    locala.IhC.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved";
    locala.IhC.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "lvbuffer";
    locala.IhC.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "talkerId";
    locala.IhC.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "transContent";
    locala.IhC.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "transBrandWording";
    locala.IhC.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "bizClientMsgId";
    locala.IhC.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bizChatId";
    locala.IhC.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizChatUserId";
    locala.IhC.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "msgSeq";
    locala.IhC.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "flag";
    locala.IhC.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "solitaireFoldInfo";
    locala.IhC.put("solitaireFoldInfo", "BLOB");
    localStringBuilder.append(" solitaireFoldInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "fromUsername";
    locala.IhC.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "toUsername";
    locala.IhC.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "historyId";
    locala.IhC.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    locala.columns[24] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(42763);
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.aa
 * JD-Core Version:    0.7.0.1
 */