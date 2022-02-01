package com.tencent.mm.plugin.lite.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends a
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(198889);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "host";
    localMAutoDBInfo.colsMap.put("host", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" host TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "host";
    localMAutoDBInfo.columns[1] = "param";
    localMAutoDBInfo.colsMap.put("param", "TEXT");
    localStringBuilder.append(" param TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "headerMap";
    localMAutoDBInfo.colsMap.put("headerMap", "TEXT");
    localStringBuilder.append(" headerMap TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "paramMap";
    localMAutoDBInfo.colsMap.put("paramMap", "TEXT");
    localStringBuilder.append(" paramMap TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(198889);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.c
 * JD-Core Version:    0.7.0.1
 */