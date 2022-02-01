package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.be;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends be
{
  public static c.a hlR;
  
  static
  {
    AppMethodBeat.i(76398);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.GvH.put("id", "TEXT");
    localStringBuilder.append(" id TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cacheKey";
    locala.GvH.put("cacheKey", "TEXT");
    localStringBuilder.append(" cacheKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "data";
    locala.GvH.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "interval";
    locala.GvH.put("interval", "INTEGER");
    localStringBuilder.append(" interval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(76398);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f
 * JD-Core Version:    0.7.0.1
 */