package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends bf
{
  public static c.a hEe;
  
  static
  {
    AppMethodBeat.i(76398);
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.IhC.put("id", "TEXT");
    localStringBuilder.append(" id TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cacheKey";
    locala.IhC.put("cacheKey", "TEXT");
    localStringBuilder.append(" cacheKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "data";
    locala.IhC.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "interval";
    locala.IhC.put("interval", "INTEGER");
    localStringBuilder.append(" interval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(76398);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f
 * JD-Core Version:    0.7.0.1
 */