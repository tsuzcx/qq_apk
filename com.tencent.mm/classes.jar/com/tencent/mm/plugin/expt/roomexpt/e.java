package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends fc
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(122444);
    c.a locala = new c.a();
    locala.GvF = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroom";
    locala.GvH.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "daySec";
    locala.GvH.put("daySec", "TEXT");
    localStringBuilder.append(" daySec TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickname";
    locala.GvH.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "isMute";
    locala.GvH.put("isMute", "INTEGER");
    localStringBuilder.append(" isMute INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "unReadCount";
    locala.GvH.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "sendCount";
    locala.GvH.put("sendCount", "INTEGER");
    localStringBuilder.append(" sendCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "enterCount";
    locala.GvH.put("enterCount", "INTEGER");
    localStringBuilder.append(" enterCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "disRedDotCount";
    locala.GvH.put("disRedDotCount", "INTEGER");
    localStringBuilder.append(" disRedDotCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "stayTime";
    locala.GvH.put("stayTime", "LONG");
    localStringBuilder.append(" stayTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "score";
    locala.GvH.put("score", "FLOAT");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.e
 * JD-Core Version:    0.7.0.1
 */