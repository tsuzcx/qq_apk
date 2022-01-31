package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends bv
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(20879);
    c.a locala = new c.a();
    locala.yrK = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "ssidmd5";
    locala.yrM.put("ssidmd5", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "ssidmd5";
    locala.columns[1] = "ssid";
    locala.yrM.put("ssid", "TEXT");
    localStringBuilder.append(" ssid TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mid";
    locala.yrM.put("mid", "TEXT");
    localStringBuilder.append(" mid TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "connectState";
    locala.yrM.put("connectState", "INTEGER default '-1' ");
    localStringBuilder.append(" connectState INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expiredTime";
    locala.yrM.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "wifiType";
    locala.yrM.put("wifiType", "INTEGER default '1' ");
    localStringBuilder.append(" wifiType INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "action";
    locala.yrM.put("action", "INTEGER default '0' ");
    localStringBuilder.append(" action INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "showUrl";
    locala.yrM.put("showUrl", "TEXT");
    localStringBuilder.append(" showUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "showWordEn";
    locala.yrM.put("showWordEn", "TEXT");
    localStringBuilder.append(" showWordEn TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "showWordCn";
    locala.yrM.put("showWordCn", "TEXT");
    localStringBuilder.append(" showWordCn TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "showWordTw";
    locala.yrM.put("showWordTw", "TEXT");
    localStringBuilder.append(" showWordTw TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "mac";
    locala.yrM.put("mac", "TEXT");
    localStringBuilder.append(" mac TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "verifyResult";
    locala.yrM.put("verifyResult", "INTEGER default '1' ");
    localStringBuilder.append(" verifyResult INTEGER default '1' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(20879);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.c
 * JD-Core Version:    0.7.0.1
 */