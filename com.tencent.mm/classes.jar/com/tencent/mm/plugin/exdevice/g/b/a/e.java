package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dp;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends dp
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(23557);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "rankID";
    localMAutoDBInfo.colsMap.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appusername";
    localMAutoDBInfo.colsMap.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "INTEGER default '0' ");
    localStringBuilder.append(" timestamp INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "liketips";
    localMAutoDBInfo.colsMap.put("liketips", "TEXT default '' ");
    localStringBuilder.append(" liketips TEXT default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(23557);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */