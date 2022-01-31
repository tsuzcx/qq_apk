package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.mm.h.c.ds;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends ds
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroom";
    locala.ujN.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "daySec";
    locala.ujN.put("daySec", "TEXT");
    localStringBuilder.append(" daySec TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.ujN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "isMute";
    locala.ujN.put("isMute", "INTEGER");
    localStringBuilder.append(" isMute INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "unReadCount";
    locala.ujN.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "sendCount";
    locala.ujN.put("sendCount", "INTEGER");
    localStringBuilder.append(" sendCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "enterCount";
    locala.ujN.put("enterCount", "INTEGER");
    localStringBuilder.append(" enterCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "disRedDotCount";
    locala.ujN.put("disRedDotCount", "INTEGER");
    localStringBuilder.append(" disRedDotCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "stayTime";
    locala.ujN.put("stayTime", "LONG");
    localStringBuilder.append(" stayTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "score";
    locala.ujN.put("score", "FLOAT");
    localStringBuilder.append(" score FLOAT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    return String.format("name[%s %s] daySec[%s] isMute[%d] unRead[%d] send[%d] enter[%d] disRedRod[%d] stayTime[%d] score[%f] systemRowid[%d]", new Object[] { this.field_chatroom, this.field_nickname, this.field_daySec, Integer.valueOf(this.field_isMute), Integer.valueOf(this.field_unReadCount), Integer.valueOf(this.field_sendCount), Integer.valueOf(this.field_enterCount), Integer.valueOf(this.field_disRedDotCount), Long.valueOf(this.field_stayTime), Float.valueOf(this.field_score), Long.valueOf(this.ujK) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.e
 * JD-Core Version:    0.7.0.1
 */