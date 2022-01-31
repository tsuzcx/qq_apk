package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.h.c.fm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class l
  extends fm
{
  public static c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appIdHash";
    locala.ujN.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appIdHash";
    locala.columns[1] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "openDebug";
    locala.ujN.put("openDebug", "INTEGER");
    localStringBuilder.append(" openDebug INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.l
 * JD-Core Version:    0.7.0.1
 */