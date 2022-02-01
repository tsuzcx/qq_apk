package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ax
  extends gz
{
  static final c.a iMP;
  
  static
  {
    AppMethodBeat.i(196015);
    c.a locala = new c.a();
    locala.EYt = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.EYv.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "appId";
    locala.columns[1] = "permissionProtoBlob";
    locala.EYv.put("permissionProtoBlob", "BLOB");
    localStringBuilder.append(" permissionProtoBlob BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    iMP = locala;
    AppMethodBeat.o(196015);
  }
  
  public final c.a getDBInfo()
  {
    return iMP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */