package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ia;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ia
{
  static final IAutoDBItem.MAutoDBInfo kLR;
  
  static
  {
    AppMethodBeat.i(227533);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "permissionDemo";
    localMAutoDBInfo.colsMap.put("permissionDemo", "INTEGER default 'false' ");
    localStringBuilder.append(" permissionDemo INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "versiontime";
    localMAutoDBInfo.colsMap.put("versiontime", "LONG");
    localStringBuilder.append(" versiontime LONG");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    kLR = localMAutoDBInfo;
    AppMethodBeat.o(227533);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return kLR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.b
 * JD-Core Version:    0.7.0.1
 */