package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends hr
{
  public static c.a hEe;
  
  static
  {
    AppMethodBeat.i(76411);
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.IhC.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appIdHash";
    locala.columns[1] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "openDebug";
    locala.IhC.put("openDebug", "INTEGER");
    localStringBuilder.append(" openDebug INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(76411);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.n
 * JD-Core Version:    0.7.0.1
 */