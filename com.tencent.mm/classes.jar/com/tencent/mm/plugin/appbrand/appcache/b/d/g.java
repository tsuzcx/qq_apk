package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.h.c.fj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends fj
{
  static final c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "appVersion";
    locala.ujN.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "reportId";
    locala.ujN.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.g
 * JD-Core Version:    0.7.0.1
 */