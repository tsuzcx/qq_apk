package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cs;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends cs
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(24949);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[14];
    localMAutoDBInfo.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ssidmd5";
    localMAutoDBInfo.colsMap.put("ssidmd5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "ssidmd5";
    localMAutoDBInfo.columns[1] = "ssid";
    localMAutoDBInfo.colsMap.put("ssid", "TEXT");
    localStringBuilder.append(" ssid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "mid";
    localMAutoDBInfo.colsMap.put("mid", "TEXT");
    localStringBuilder.append(" mid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "connectState";
    localMAutoDBInfo.colsMap.put("connectState", "INTEGER default '-1' ");
    localStringBuilder.append(" connectState INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "expiredTime";
    localMAutoDBInfo.colsMap.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "wifiType";
    localMAutoDBInfo.colsMap.put("wifiType", "INTEGER default '1' ");
    localStringBuilder.append(" wifiType INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "action";
    localMAutoDBInfo.colsMap.put("action", "INTEGER default '0' ");
    localStringBuilder.append(" action INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "showUrl";
    localMAutoDBInfo.colsMap.put("showUrl", "TEXT");
    localStringBuilder.append(" showUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "showWordEn";
    localMAutoDBInfo.colsMap.put("showWordEn", "TEXT");
    localStringBuilder.append(" showWordEn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "showWordCn";
    localMAutoDBInfo.colsMap.put("showWordCn", "TEXT");
    localStringBuilder.append(" showWordCn TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "showWordTw";
    localMAutoDBInfo.colsMap.put("showWordTw", "TEXT");
    localStringBuilder.append(" showWordTw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "mac";
    localMAutoDBInfo.colsMap.put("mac", "TEXT");
    localStringBuilder.append(" mac TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "verifyResult";
    localMAutoDBInfo.colsMap.put("verifyResult", "INTEGER default '1' ");
    localStringBuilder.append(" verifyResult INTEGER default '1' ");
    localMAutoDBInfo.columns[14] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(24949);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.c
 * JD-Core Version:    0.7.0.1
 */