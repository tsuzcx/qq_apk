package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ie;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends ie
{
  public static IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(2616);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "shareKeyHash";
    localMAutoDBInfo.colsMap.put("shareKeyHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "shareKeyHash";
    localMAutoDBInfo.columns[1] = "btnState";
    localMAutoDBInfo.colsMap.put("btnState", "INTEGER");
    localStringBuilder.append(" btnState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "msgState";
    localMAutoDBInfo.colsMap.put("msgState", "INTEGER");
    localStringBuilder.append(" msgState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "contentColor";
    localMAutoDBInfo.colsMap.put("contentColor", "TEXT");
    localStringBuilder.append(" contentColor TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updatePeroid";
    localMAutoDBInfo.colsMap.put("updatePeroid", "INTEGER");
    localStringBuilder.append(" updatePeroid INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(2616);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.a.c
 * JD-Core Version:    0.7.0.1
 */