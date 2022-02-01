package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.co;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends co
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(24955);
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.IBN.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "id";
    locala.columns[1] = "protocolNumber";
    locala.IBN.put("protocolNumber", "INTEGER");
    localStringBuilder.append(" protocolNumber INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "logContent";
    locala.IBN.put("logContent", "TEXT");
    localStringBuilder.append(" logContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(24955);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.e
 * JD-Core Version:    0.7.0.1
 */