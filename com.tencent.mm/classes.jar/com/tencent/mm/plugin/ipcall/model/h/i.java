package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends de
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(25551);
    c.a locala = new c.a();
    locala.EYt = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "countryCode";
    locala.EYv.put("countryCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "countryCode";
    locala.columns[1] = "callTimeCount";
    locala.EYv.put("callTimeCount", "LONG");
    localStringBuilder.append(" callTimeCount LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "lastCallTime";
    locala.EYv.put("lastCallTime", "LONG");
    localStringBuilder.append(" lastCallTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(25551);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.i
 * JD-Core Version:    0.7.0.1
 */