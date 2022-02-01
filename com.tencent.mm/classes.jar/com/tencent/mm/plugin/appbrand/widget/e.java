package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends bg
{
  public static IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(76398);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT");
    localStringBuilder.append(" id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "cacheKey";
    localMAutoDBInfo.colsMap.put("cacheKey", "TEXT");
    localStringBuilder.append(" cacheKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "data";
    localMAutoDBInfo.colsMap.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "interval";
    localMAutoDBInfo.colsMap.put("interval", "INTEGER");
    localStringBuilder.append(" interval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(76398);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e
 * JD-Core Version:    0.7.0.1
 */