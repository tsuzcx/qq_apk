package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ba
  extends hn
{
  static final c.a jGU;
  
  static
  {
    AppMethodBeat.i(188620);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IhC.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appId";
    locala.columns[1] = "permissionProtoBlob";
    locala.IhC.put("permissionProtoBlob", "BLOB");
    localStringBuilder.append(" permissionProtoBlob BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    jGU = locala;
    AppMethodBeat.o(188620);
  }
  
  public final c.a getDBInfo()
  {
    return jGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */