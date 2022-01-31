package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.h.c.ax;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends ax
{
  public static c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.ujN.put("id", "TEXT");
    localStringBuilder.append(" id TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cacheKey";
    locala.ujN.put("cacheKey", "TEXT");
    localStringBuilder.append(" cacheKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "data";
    locala.ujN.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "interval";
    locala.ujN.put("interval", "INTEGER");
    localStringBuilder.append(" interval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "updateTime";
    locala.ujN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g
 * JD-Core Version:    0.7.0.1
 */