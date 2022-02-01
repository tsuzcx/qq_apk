package com.tencent.mm.plugin.lite.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends a
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(214624);
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IhC.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appId";
    locala.columns[1] = "signatureKey";
    locala.IhC.put("signatureKey", "TEXT");
    localStringBuilder.append(" signatureKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pkgPath";
    locala.IhC.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgType";
    locala.IhC.put("pkgType", "TEXT");
    localStringBuilder.append(" pkgType TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "patchId";
    locala.IhC.put("patchId", "TEXT");
    localStringBuilder.append(" patchId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(214624);
  }
  
  public final boolean dfH()
  {
    AppMethodBeat.i(214623);
    boolean bool = "debug".equals(this.field_pkgType);
    AppMethodBeat.o(214623);
    return bool;
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d.b
 * JD-Core Version:    0.7.0.1
 */