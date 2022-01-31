package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.h.c.cq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends cq
{
  public static final c.a fCU;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.ujN.put("appIdHash", "INTEGER");
    localStringBuilder.append(" appIdHash INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pkgType";
    locala.ujN.put("pkgType", "INTEGER");
    localStringBuilder.append(" pkgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "widgetType";
    locala.ujN.put("widgetType", "INTEGER");
    localStringBuilder.append(" widgetType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "launchAction";
    locala.ujN.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    locala.columns[5] = "jsApiInfo";
    locala.ujN.put("jsApiInfo", "BLOB");
    localStringBuilder.append(" jsApiInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "versionInfo";
    locala.ujN.put("versionInfo", "BLOB");
    localStringBuilder.append(" versionInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "widgetSetting";
    locala.ujN.put("widgetSetting", "BLOB");
    localStringBuilder.append(" widgetSetting BLOB");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    fCU = locala;
  }
  
  protected final c.a rM()
  {
    return fCU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j
 * JD-Core Version:    0.7.0.1
 */