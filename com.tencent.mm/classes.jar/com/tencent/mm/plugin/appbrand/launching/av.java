package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class av
  extends dn
{
  public static final c.a jmW;
  
  static
  {
    AppMethodBeat.i(146070);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "launchPB";
    locala.GvH.put("launchPB", "BLOB");
    localStringBuilder.append(" launchPB BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    jmW = locala;
    AppMethodBeat.o(146070);
  }
  
  public final c.a getDBInfo()
  {
    return jmW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av
 * JD-Core Version:    0.7.0.1
 */