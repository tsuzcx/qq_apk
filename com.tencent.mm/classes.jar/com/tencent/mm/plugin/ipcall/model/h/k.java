package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends dx
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(25557);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "phonenumber";
    localMAutoDBInfo.colsMap.put("phonenumber", "TEXT");
    localStringBuilder.append(" phonenumber TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "calltime";
    localMAutoDBInfo.colsMap.put("calltime", "LONG");
    localStringBuilder.append(" calltime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "duration";
    localMAutoDBInfo.colsMap.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "addressId";
    localMAutoDBInfo.colsMap.put("addressId", "LONG default '-1' ");
    localStringBuilder.append(" addressId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "phoneType";
    localMAutoDBInfo.colsMap.put("phoneType", "INTEGER default '-1' ");
    localStringBuilder.append(" phoneType INTEGER default '-1' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(25557);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.k
 * JD-Core Version:    0.7.0.1
 */