package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.l;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends l
{
  public static final c.a fkk;
  
  static
  {
    AppMethodBeat.i(101783);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.yrM.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "key";
    locala.columns[1] = "value";
    locala.yrM.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(101783);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.b
 * JD-Core Version:    0.7.0.1
 */