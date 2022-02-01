package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ez;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ez
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151325);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "acctTypeId";
    localMAutoDBInfo.colsMap.put("acctTypeId", "TEXT");
    localStringBuilder.append(" acctTypeId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "language";
    localMAutoDBInfo.colsMap.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "accTypeRec";
    localMAutoDBInfo.colsMap.put("accTypeRec", "BLOB");
    localStringBuilder.append(" accTypeRec BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(151325);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.e.a
 * JD-Core Version:    0.7.0.1
 */