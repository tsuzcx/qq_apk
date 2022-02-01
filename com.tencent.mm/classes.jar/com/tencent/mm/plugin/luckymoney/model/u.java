package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.el;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class u
  extends el
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(65223);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "subtype";
    localMAutoDBInfo.colsMap.put("subtype", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" subtype INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "subtype";
    localMAutoDBInfo.columns[1] = "bubbleMd5";
    localMAutoDBInfo.colsMap.put("bubbleMd5", "TEXT");
    localStringBuilder.append(" bubbleMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "coverMd5";
    localMAutoDBInfo.colsMap.put("coverMd5", "TEXT");
    localStringBuilder.append(" coverMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "minilogoMd5";
    localMAutoDBInfo.colsMap.put("minilogoMd5", "TEXT");
    localStringBuilder.append(" minilogoMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(65223);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.u
 * JD-Core Version:    0.7.0.1
 */