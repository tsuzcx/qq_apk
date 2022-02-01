package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends cn
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(24949);
    c.a locala = new c.a();
    locala.IBL = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "ssidmd5";
    locala.IBN.put("ssidmd5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "ssidmd5";
    locala.columns[1] = "ssid";
    locala.IBN.put("ssid", "TEXT");
    localStringBuilder.append(" ssid TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mid";
    locala.IBN.put("mid", "TEXT");
    localStringBuilder.append(" mid TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "url";
    locala.IBN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "connectState";
    locala.IBN.put("connectState", "INTEGER default '-1' ");
    localStringBuilder.append(" connectState INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expiredTime";
    locala.IBN.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiType";
    locala.IBN.put("wifiType", "INTEGER default '1' ");
    localStringBuilder.append(" wifiType INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "action";
    locala.IBN.put("action", "INTEGER default '0' ");
    localStringBuilder.append(" action INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "showUrl";
    locala.IBN.put("showUrl", "TEXT");
    localStringBuilder.append(" showUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "showWordEn";
    locala.IBN.put("showWordEn", "TEXT");
    localStringBuilder.append(" showWordEn TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "showWordCn";
    locala.IBN.put("showWordCn", "TEXT");
    localStringBuilder.append(" showWordCn TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "showWordTw";
    locala.IBN.put("showWordTw", "TEXT");
    localStringBuilder.append(" showWordTw TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "mac";
    locala.IBN.put("mac", "TEXT");
    localStringBuilder.append(" mac TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "verifyResult";
    locala.IBN.put("verifyResult", "INTEGER default '1' ");
    localStringBuilder.append(" verifyResult INTEGER default '1' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(24949);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.c
 * JD-Core Version:    0.7.0.1
 */