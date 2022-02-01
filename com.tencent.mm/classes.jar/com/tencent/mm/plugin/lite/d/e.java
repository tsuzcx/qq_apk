package com.tencent.mm.plugin.lite.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends b
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(212383);
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appId";
    locala.columns[1] = "signatureKey";
    locala.IBN.put("signatureKey", "TEXT");
    localStringBuilder.append(" signatureKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pkgPath";
    locala.IBN.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "pkgType";
    locala.IBN.put("pkgType", "TEXT");
    localStringBuilder.append(" pkgType TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "patchId";
    locala.IBN.put("patchId", "TEXT");
    localStringBuilder.append(" patchId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(212383);
  }
  
  public final boolean diD()
  {
    AppMethodBeat.i(212382);
    boolean bool = "debug".equals(this.field_pkgType);
    AppMethodBeat.o(212382);
    return bool;
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d.e
 * JD-Core Version:    0.7.0.1
 */