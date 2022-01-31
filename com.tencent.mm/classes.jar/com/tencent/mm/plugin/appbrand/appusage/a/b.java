package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.h.c.o;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends o
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.ujN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appId";
    locala.columns[1] = "userName";
    locala.ujN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "nickName";
    locala.ujN.put("nickName", "TEXT");
    localStringBuilder.append(" nickName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "logo";
    locala.ujN.put("logo", "TEXT");
    localStringBuilder.append(" logo TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "sessionId";
    locala.ujN.put("sessionId", "LONG");
    localStringBuilder.append(" sessionId LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "descInfo";
    locala.ujN.put("descInfo", "TEXT");
    localStringBuilder.append(" descInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "evaluateScore";
    locala.ujN.put("evaluateScore", "DOUBLE");
    localStringBuilder.append(" evaluateScore DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[7] = "words";
    locala.ujN.put("words", "TEXT");
    localStringBuilder.append(" words TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "recommendWxa";
    locala.ujN.put("recommendWxa", "BLOB");
    localStringBuilder.append(" recommendWxa BLOB");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.b
 * JD-Core Version:    0.7.0.1
 */