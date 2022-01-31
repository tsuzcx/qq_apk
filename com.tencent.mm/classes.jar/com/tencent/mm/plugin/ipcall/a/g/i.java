package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends cp
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(21936);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "countryCode";
    locala.yrM.put("countryCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "countryCode";
    locala.columns[1] = "callTimeCount";
    locala.yrM.put("callTimeCount", "LONG");
    localStringBuilder.append(" callTimeCount LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "lastCallTime";
    locala.yrM.put("lastCallTime", "LONG");
    localStringBuilder.append(" lastCallTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(21936);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.i
 * JD-Core Version:    0.7.0.1
 */