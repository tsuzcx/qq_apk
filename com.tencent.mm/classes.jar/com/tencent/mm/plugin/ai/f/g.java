package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hz;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends hz
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(239353);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ds";
    localMAutoDBInfo.colsMap.put("ds", "INTEGER");
    localStringBuilder.append(" ds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "hour";
    localMAutoDBInfo.colsMap.put("hour", "INTEGER");
    localStringBuilder.append(" hour INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lastSession";
    localMAutoDBInfo.colsMap.put("lastSession", "TEXT");
    localStringBuilder.append(" lastSession TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "currSession";
    localMAutoDBInfo.colsMap.put("currSession", "TEXT");
    localStringBuilder.append(" currSession TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nextSession";
    localMAutoDBInfo.colsMap.put("nextSession", "TEXT");
    localStringBuilder.append(" nextSession TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "enterMs";
    localMAutoDBInfo.colsMap.put("enterMs", "LONG");
    localStringBuilder.append(" enterMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "quitMs";
    localMAutoDBInfo.colsMap.put("quitMs", "LONG");
    localStringBuilder.append(" quitMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "stayMs";
    localMAutoDBInfo.colsMap.put("stayMs", "LONG");
    localStringBuilder.append(" stayMs LONG");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(239353);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.g
 * JD-Core Version:    0.7.0.1
 */