package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends dz
{
  public static final c.a jGU;
  
  static
  {
    AppMethodBeat.i(76410);
    c.a locala = new c.a();
    locala.IhA = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.IhC.put("appIdHash", "INTEGER");
    localStringBuilder.append(" appIdHash INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pkgType";
    locala.IhC.put("pkgType", "INTEGER");
    localStringBuilder.append(" pkgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "widgetType";
    locala.IhC.put("widgetType", "INTEGER");
    localStringBuilder.append(" widgetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "launchAction";
    locala.IhC.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "jsApiInfo";
    locala.IhC.put("jsApiInfo", "BLOB");
    localStringBuilder.append(" jsApiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "versionInfo";
    locala.IhC.put("versionInfo", "BLOB");
    localStringBuilder.append(" versionInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "widgetSetting";
    locala.IhC.put("widgetSetting", "BLOB");
    localStringBuilder.append(" widgetSetting BLOB");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    jGU = locala;
    AppMethodBeat.o(76410);
  }
  
  public final c.a getDBInfo()
  {
    return jGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.k
 * JD-Core Version:    0.7.0.1
 */