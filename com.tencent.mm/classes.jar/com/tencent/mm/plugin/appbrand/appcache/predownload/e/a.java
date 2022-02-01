package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fk;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fk
{
  static final IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(44432);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "sceneList";
    localMAutoDBInfo.colsMap.put("sceneList", "TEXT");
    localStringBuilder.append(" sceneList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "cgiList";
    localMAutoDBInfo.colsMap.put("cgiList", "TEXT");
    localStringBuilder.append(" cgiList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "INTEGER");
    localStringBuilder.append(" reportId INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(44432);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(44431);
    String str = "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
    AppMethodBeat.o(44431);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e.a
 * JD-Core Version:    0.7.0.1
 */