package com.tencent.mm.plugin.boots.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.e;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends e
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(123715);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "key";
    localMAutoDBInfo.colsMap.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "key";
    localMAutoDBInfo.columns[1] = "mau";
    localMAutoDBInfo.colsMap.put("mau", "INTEGER");
    localStringBuilder.append(" mau INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "dau";
    localMAutoDBInfo.colsMap.put("dau", "INTEGER");
    localStringBuilder.append(" dau INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "useTime";
    localMAutoDBInfo.colsMap.put("useTime", "LONG");
    localStringBuilder.append(" useTime LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(123715);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a.a
 * JD-Core Version:    0.7.0.1
 */