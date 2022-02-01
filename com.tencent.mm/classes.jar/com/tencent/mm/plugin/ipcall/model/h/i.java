package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends dw
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(25551);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "countryCode";
    localMAutoDBInfo.colsMap.put("countryCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "countryCode";
    localMAutoDBInfo.columns[1] = "callTimeCount";
    localMAutoDBInfo.colsMap.put("callTimeCount", "LONG");
    localStringBuilder.append(" callTimeCount LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lastCallTime";
    localMAutoDBInfo.colsMap.put("lastCallTime", "LONG");
    localStringBuilder.append(" lastCallTime LONG");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(25551);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.i
 * JD-Core Version:    0.7.0.1
 */