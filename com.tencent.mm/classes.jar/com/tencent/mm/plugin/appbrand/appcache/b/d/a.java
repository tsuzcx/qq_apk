package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.h.c.di;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends di
{
  static final c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "startTime";
    locala.ujN.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "endTime";
    locala.ujN.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "sceneList";
    locala.ujN.put("sceneList", "TEXT");
    localStringBuilder.append(" sceneList TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "cgiList";
    locala.ujN.put("cgiList", "TEXT");
    localStringBuilder.append(" cgiList TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportId";
    locala.ujN.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
  
  public final String toString()
  {
    return "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.a
 * JD-Core Version:    0.7.0.1
 */