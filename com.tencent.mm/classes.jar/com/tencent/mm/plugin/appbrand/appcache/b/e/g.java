package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends hm
{
  static final c.a hGW;
  
  static
  {
    AppMethodBeat.i(44444);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "appVersion";
    locala.IBN.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "reportId";
    locala.IBN.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    hGW = locala;
    AppMethodBeat.o(44444);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.g
 * JD-Core Version:    0.7.0.1
 */