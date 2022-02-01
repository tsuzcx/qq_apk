package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ea;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ea
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(220208);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "liveId";
    locala.IBN.put("liveId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" liveId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "liveId";
    locala.columns[1] = "hostRoomId";
    locala.IBN.put("hostRoomId", "TEXT default '' ");
    localStringBuilder.append(" hostRoomId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "liveName";
    locala.IBN.put("liveName", "TEXT default '' ");
    localStringBuilder.append(" liveName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "thumbUrl";
    locala.IBN.put("thumbUrl", "TEXT default '' ");
    localStringBuilder.append(" thumbUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "anchorUsername";
    locala.IBN.put("anchorUsername", "TEXT default '' ");
    localStringBuilder.append(" anchorUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isSender";
    locala.IBN.put("isSender", "INTEGER default 'false' ");
    localStringBuilder.append(" isSender INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "timeStamp";
    locala.IBN.put("timeStamp", "LONG default '0' ");
    localStringBuilder.append(" timeStamp LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(220208);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.c.b
 * JD-Core Version:    0.7.0.1
 */