package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends hh
{
  public static c.a hlR;
  
  static
  {
    AppMethodBeat.i(76411);
    c.a locala = new c.a();
    locala.GvF = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.GvH.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "appIdHash";
    locala.columns[1] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "openDebug";
    locala.GvH.put("openDebug", "INTEGER");
    localStringBuilder.append(" openDebug INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(76411);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.n
 * JD-Core Version:    0.7.0.1
 */