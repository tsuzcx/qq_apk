package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends hl
{
  static final c.a hEe;
  
  static
  {
    AppMethodBeat.i(44444);
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "appVersion";
    locala.IhC.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "reportId";
    locala.IhC.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(44444);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.g
 * JD-Core Version:    0.7.0.1
 */