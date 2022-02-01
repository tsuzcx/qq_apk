package com.tencent.mm.ah;

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
    locala.IBL = new Field[24];
    locala.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IBN.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.IBN.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isSend";
    locala.IBN.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowTimer";
    locala.IBN.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "talker";
    locala.IBN.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.IBN.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgPath";
    locala.IBN.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved";
    locala.IBN.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "lvbuffer";
    locala.IBN.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "talkerId";
    locala.IBN.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "transContent";
    locala.IBN.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "transBrandWording";
    locala.IBN.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "bizClientMsgId";
    locala.IBN.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bizChatId";
    locala.IBN.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizChatUserId";
    locala.IBN.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "msgSeq";
    locala.IBN.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "flag";
    locala.IBN.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "solitaireFoldInfo";
    locala.IBN.put("solitaireFoldInfo", "BLOB");
    localStringBuilder.append(" solitaireFoldInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "fromUsername";
    locala.IBN.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "toUsername";
    locala.IBN.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "historyId";
    locala.IBN.put("historyId", "TEXT");
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
 * Qualified Name:     com.tencent.mm.ah.aa
 * JD-Core Version:    0.7.0.1
 */