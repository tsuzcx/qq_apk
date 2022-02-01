package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends ct
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(24955);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "protocolNumber";
    localMAutoDBInfo.colsMap.put("protocolNumber", "INTEGER");
    localStringBuilder.append(" protocolNumber INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "logContent";
    localMAutoDBInfo.colsMap.put("logContent", "TEXT");
    localStringBuilder.append(" logContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(24955);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.e
 * JD-Core Version:    0.7.0.1
 */