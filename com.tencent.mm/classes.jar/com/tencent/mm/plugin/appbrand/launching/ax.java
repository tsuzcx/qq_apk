package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ax
  extends hd
{
  static final c.a jmW;
  
  static
  {
    AppMethodBeat.i(186839);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.GvH.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "appId";
    locala.columns[1] = "permissionProtoBlob";
    locala.GvH.put("permissionProtoBlob", "BLOB");
    localStringBuilder.append(" permissionProtoBlob BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    jmW = locala;
    AppMethodBeat.o(186839);
  }
  
  public final c.a getDBInfo()
  {
    return jmW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */