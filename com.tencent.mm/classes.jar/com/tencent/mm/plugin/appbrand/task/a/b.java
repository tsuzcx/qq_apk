package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ho;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ho
{
  static final c.a jJU;
  
  static
  {
    AppMethodBeat.i(223016);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appId";
    locala.columns[1] = "permissionDemo";
    locala.IBN.put("permissionDemo", "INTEGER default 'false' ");
    localStringBuilder.append(" permissionDemo INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "versiontime";
    locala.IBN.put("versiontime", "LONG");
    localStringBuilder.append(" versiontime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    jJU = locala;
    AppMethodBeat.o(223016);
  }
  
  public final c.a getDBInfo()
  {
    return jJU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.b
 * JD-Core Version:    0.7.0.1
 */