package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.if;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class m
  extends if
{
  public static IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(76411);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appIdHash";
    localMAutoDBInfo.colsMap.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appIdHash";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "openDebug";
    localMAutoDBInfo.colsMap.put("openDebug", "INTEGER");
    localStringBuilder.append(" openDebug INTEGER");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(76411);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.m
 * JD-Core Version:    0.7.0.1
 */