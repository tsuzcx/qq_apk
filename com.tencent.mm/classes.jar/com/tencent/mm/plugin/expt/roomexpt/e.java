package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends fm
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(122444);
    c.a locala = new c.a();
    locala.IBL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroom";
    locala.IBN.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "daySec";
    locala.IBN.put("daySec", "TEXT");
    localStringBuilder.append(" daySec TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.IBN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "isMute";
    locala.IBN.put("isMute", "INTEGER");
    localStringBuilder.append(" isMute INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "unReadCount";
    locala.IBN.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "sendCount";
    locala.IBN.put("sendCount", "INTEGER");
    localStringBuilder.append(" sendCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "enterCount";
    locala.IBN.put("enterCount", "INTEGER");
    localStringBuilder.append(" enterCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "disRedDotCount";
    locala.IBN.put("disRedDotCount", "INTEGER");
    localStringBuilder.append(" disRedDotCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "stayTime";
    locala.IBN.put("stayTime", "LONG");
    localStringBuilder.append(" stayTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "score";
    locala.IBN.put("score", "FLOAT");
    localStringBuilder.append(" score FLOAT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(122444);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122443);
    String str = String.format("name[%s %s] daySec[%s] isMute[%d] unRead[%d] send[%d] enter[%d] disRedRod[%d] stayTime[%d] score[%f] systemRowid[%d]", new Object[] { this.field_chatroom, this.field_nickname, this.field_daySec, Integer.valueOf(this.field_isMute), Integer.valueOf(this.field_unReadCount), Integer.valueOf(this.field_sendCount), Integer.valueOf(this.field_enterCount), Integer.valueOf(this.field_disRedDotCount), Long.valueOf(this.field_stayTime), Float.valueOf(this.field_score), Long.valueOf(this.systemRowid) });
    AppMethodBeat.o(122443);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.e
 * JD-Core Version:    0.7.0.1
 */