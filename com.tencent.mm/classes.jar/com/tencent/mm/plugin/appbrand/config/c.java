package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.l;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends l
{
  public static final c.a hlR;
  
  static
  {
    AppMethodBeat.i(146955);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.GvH.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "key";
    locala.columns[1] = "value";
    locala.GvH.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(146955);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.c
 * JD-Core Version:    0.7.0.1
 */