package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends dv
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(25548);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "svrId";
    localMAutoDBInfo.colsMap.put("svrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" svrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "svrId";
    localMAutoDBInfo.columns[1] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pushTime";
    localMAutoDBInfo.colsMap.put("pushTime", "LONG");
    localStringBuilder.append(" pushTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "descUrl";
    localMAutoDBInfo.colsMap.put("descUrl", "TEXT");
    localStringBuilder.append(" descUrl TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(25548);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.g
 * JD-Core Version:    0.7.0.1
 */