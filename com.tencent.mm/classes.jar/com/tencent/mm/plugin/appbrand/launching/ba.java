package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ba
  extends hp
{
  static final c.a jJU;
  
  static
  {
    AppMethodBeat.i(222779);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appId";
    locala.columns[1] = "permissionProtoBlob";
    locala.IBN.put("permissionProtoBlob", "BLOB");
    localStringBuilder.append(" permissionProtoBlob BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    jJU = locala;
    AppMethodBeat.o(222779);
  }
  
  public final c.a getDBInfo()
  {
    return jJU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */