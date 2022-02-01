package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Map;

public final class c
  extends cn
{
  public static IAutoDBItem.MAutoDBInfo info;
  public SimpleDateFormat kxO = null;
  
  static
  {
    AppMethodBeat.i(238940);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ds";
    localMAutoDBInfo.colsMap.put("ds", "INTEGER");
    localStringBuilder.append(" ds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "hour";
    localMAutoDBInfo.colsMap.put("hour", "INTEGER");
    localStringBuilder.append(" hour INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "actionMs";
    localMAutoDBInfo.colsMap.put("actionMs", "LONG");
    localStringBuilder.append(" actionMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isGoToFinderUI";
    localMAutoDBInfo.colsMap.put("isGoToFinderUI", "INTEGER");
    localStringBuilder.append(" isGoToFinderUI INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(238940);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238939);
    String str = "FinderRedDotHistory{field_ds=" + this.field_ds + ", field_hour=" + this.field_hour + ", field_actionMs=" + this.field_actionMs + ", field_isGoToFinderUI=" + this.field_isGoToFinderUI + ", systemRowid=" + this.systemRowid + '}';
    AppMethodBeat.o(238939);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.c
 * JD-Core Version:    0.7.0.1
 */