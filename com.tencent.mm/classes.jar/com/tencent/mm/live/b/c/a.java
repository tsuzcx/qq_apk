package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hg
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(203915);
    c.a locala = new c.a();
    locala.EYt = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "liveId";
    locala.EYv.put("liveId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" liveId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "liveId";
    locala.columns[1] = "hostRoomId";
    locala.EYv.put("hostRoomId", "TEXT default '' ");
    localStringBuilder.append(" hostRoomId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "liveName";
    locala.EYv.put("liveName", "TEXT default '' ");
    localStringBuilder.append(" liveName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "thumbUrl";
    locala.EYv.put("thumbUrl", "TEXT default '' ");
    localStringBuilder.append(" thumbUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "anchorUsername";
    locala.EYv.put("anchorUsername", "TEXT default '' ");
    localStringBuilder.append(" anchorUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isSender";
    locala.EYv.put("isSender", "INTEGER default 'false' ");
    localStringBuilder.append(" isSender INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "timeStamp";
    locala.EYv.put("timeStamp", "LONG default '0' ");
    localStringBuilder.append(" timeStamp LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(203915);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.c.a
 * JD-Core Version:    0.7.0.1
 */