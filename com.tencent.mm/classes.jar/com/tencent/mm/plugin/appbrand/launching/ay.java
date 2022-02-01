package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ay
  extends dx
{
  public static final c.a jGU;
  
  static
  {
    AppMethodBeat.i(146070);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "launchPB";
    locala.IhC.put("launchPB", "BLOB");
    localStringBuilder.append(" launchPB BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    jGU = locala;
    AppMethodBeat.o(146070);
  }
  
  public final c.a getDBInfo()
  {
    return jGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ay
 * JD-Core Version:    0.7.0.1
 */