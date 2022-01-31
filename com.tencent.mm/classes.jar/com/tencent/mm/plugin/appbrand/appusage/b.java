package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.i;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends i
{
  static final c.a fkk;
  
  static
  {
    AppMethodBeat.i(129531);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.yrM.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "username";
    locala.columns[1] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(129531);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.b
 * JD-Core Version:    0.7.0.1
 */