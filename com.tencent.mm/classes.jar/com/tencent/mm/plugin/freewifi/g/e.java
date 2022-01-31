package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends bw
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(20885);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.yrM.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "id";
    locala.columns[1] = "protocolNumber";
    locala.yrM.put("protocolNumber", "INTEGER");
    localStringBuilder.append(" protocolNumber INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "logContent";
    locala.yrM.put("logContent", "TEXT");
    localStringBuilder.append(" logContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.yrM.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(20885);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.e
 * JD-Core Version:    0.7.0.1
 */