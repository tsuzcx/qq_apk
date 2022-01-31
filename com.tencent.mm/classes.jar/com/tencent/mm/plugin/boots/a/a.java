package com.tencent.mm.plugin.boots.a;

import com.tencent.mm.h.c.e;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends e
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.ujN.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.ujM = "key";
    locala.columns[1] = "mau";
    locala.ujN.put("mau", "INTEGER");
    localStringBuilder.append(" mau INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "dau";
    locala.ujN.put("dau", "INTEGER");
    localStringBuilder.append(" dau INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "useTime";
    locala.ujN.put("useTime", "LONG");
    localStringBuilder.append(" useTime LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a.a
 * JD-Core Version:    0.7.0.1
 */