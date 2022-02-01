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
    AppMethodBeat.i(195640);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "liveId";
    locala.IhC.put("liveId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" liveId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "liveId";
    locala.columns[1] = "hostRoomId";
    locala.IhC.put("hostRoomId", "TEXT default '' ");
    localStringBuilder.append(" hostRoomId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "liveName";
    locala.IhC.put("liveName", "TEXT default '' ");
    localStringBuilder.append(" liveName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "thumbUrl";
    locala.IhC.put("thumbUrl", "TEXT default '' ");
    localStringBuilder.append(" thumbUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "anchorUsername";
    locala.IhC.put("anchorUsername", "TEXT default '' ");
    localStringBuilder.append(" anchorUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "isSender";
    locala.IhC.put("isSender", "INTEGER default 'false' ");
    localStringBuilder.append(" isSender INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "timeStamp";
    locala.IhC.put("timeStamp", "LONG default '0' ");
    localStringBuilder.append(" timeStamp LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(195640);
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