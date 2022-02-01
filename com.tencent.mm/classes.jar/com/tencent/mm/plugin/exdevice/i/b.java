package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.do;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends do
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(23779);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[14];
    localMAutoDBInfo.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "deviceID";
    localMAutoDBInfo.colsMap.put("deviceID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" deviceID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "deviceID";
    localMAutoDBInfo.columns[1] = "brandName";
    localMAutoDBInfo.colsMap.put("brandName", "TEXT");
    localStringBuilder.append(" brandName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "mac";
    localMAutoDBInfo.colsMap.put("mac", "LONG");
    localStringBuilder.append(" mac LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "deviceType";
    localMAutoDBInfo.colsMap.put("deviceType", "TEXT");
    localStringBuilder.append(" deviceType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "connProto";
    localMAutoDBInfo.colsMap.put("connProto", "TEXT");
    localStringBuilder.append(" connProto TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "connStrategy";
    localMAutoDBInfo.colsMap.put("connStrategy", "INTEGER");
    localStringBuilder.append(" connStrategy INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "closeStrategy";
    localMAutoDBInfo.colsMap.put("closeStrategy", "INTEGER");
    localStringBuilder.append(" closeStrategy INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "md5Str";
    localMAutoDBInfo.colsMap.put("md5Str", "TEXT");
    localStringBuilder.append(" md5Str TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "authKey";
    localMAutoDBInfo.colsMap.put("authKey", "TEXT");
    localStringBuilder.append(" authKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "sessionKey";
    localMAutoDBInfo.colsMap.put("sessionKey", "BLOB");
    localStringBuilder.append(" sessionKey BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "sessionBuf";
    localMAutoDBInfo.colsMap.put("sessionBuf", "BLOB");
    localStringBuilder.append(" sessionBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "authBuf";
    localMAutoDBInfo.colsMap.put("authBuf", "BLOB");
    localStringBuilder.append(" authBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localMAutoDBInfo.columns[14] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(23779);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.b
 * JD-Core Version:    0.7.0.1
 */