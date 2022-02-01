package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.o;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends o
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(146932);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "key";
    localMAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "key";
    localMAutoDBInfo.columns[1] = "data";
    localMAutoDBInfo.colsMap.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "dataType";
    localMAutoDBInfo.colsMap.put("dataType", "TEXT");
    localStringBuilder.append(" dataType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(146932);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c
 * JD-Core Version:    0.7.0.1
 */