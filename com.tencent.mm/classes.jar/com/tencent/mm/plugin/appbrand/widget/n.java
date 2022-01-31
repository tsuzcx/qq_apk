package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends ga
{
  public static c.a fkk;
  
  static
  {
    AppMethodBeat.i(70662);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.yrM.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appIdHash";
    locala.columns[1] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "openDebug";
    locala.yrM.put("openDebug", "INTEGER");
    localStringBuilder.append(" openDebug INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(70662);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.n
 * JD-Core Version:    0.7.0.1
 */