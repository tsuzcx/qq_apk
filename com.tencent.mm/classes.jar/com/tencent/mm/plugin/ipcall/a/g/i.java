package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.h.c.ck;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends ck
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "countryCode";
    locala.ujN.put("countryCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "countryCode";
    locala.columns[1] = "callTimeCount";
    locala.ujN.put("callTimeCount", "LONG");
    localStringBuilder.append(" callTimeCount LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "lastCallTime";
    locala.ujN.put("lastCallTime", "LONG");
    localStringBuilder.append(" lastCallTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.i
 * JD-Core Version:    0.7.0.1
 */