package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fc
{
  static final c.a hGW;
  
  static
  {
    AppMethodBeat.i(44432);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IBN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "username";
    locala.columns[1] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "startTime";
    locala.IBN.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "endTime";
    locala.IBN.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "sceneList";
    locala.IBN.put("sceneList", "TEXT");
    localStringBuilder.append(" sceneList TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "cgiList";
    locala.IBN.put("cgiList", "TEXT");
    localStringBuilder.append(" cgiList TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportId";
    locala.IBN.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    hGW = locala;
    AppMethodBeat.o(44432);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(44431);
    String str = "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
    AppMethodBeat.o(44431);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.a
 * JD-Core Version:    0.7.0.1
 */