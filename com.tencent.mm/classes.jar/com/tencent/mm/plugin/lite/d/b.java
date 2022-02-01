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
    AppMethodBeat.i(208159);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.GvH.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "appId";
    locala.columns[1] = "signatureKey";
    locala.GvH.put("signatureKey", "TEXT");
    localStringBuilder.append(" signatureKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pkgPath";
    locala.GvH.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgType";
    locala.GvH.put("pkgType", "TEXT");
    localStringBuilder.append(" pkgType TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "patchId";
    locala.GvH.put("patchId", "TEXT");
    localStringBuilder.append(" patchId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(208159);
  }
  
  public final boolean cWv()
  {
    AppMethodBeat.i(208158);
    boolean bool = "debug".equals(this.field_pkgType);
    AppMethodBeat.o(208158);
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