package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.s;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends s
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(44664);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appId";
    locala.columns[1] = "recommendCard";
    locala.IBN.put("recommendCard", "BLOB");
    localStringBuilder.append(" recommendCard BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(44664);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.a
 * JD-Core Version:    0.7.0.1
 */