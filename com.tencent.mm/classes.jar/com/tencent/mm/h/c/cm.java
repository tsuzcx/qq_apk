package com.tencent.mm.h.c;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cm
  extends c
{
  private static final int cNV = "logId".hashCode();
  private static final int cNW = "liftTime".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  public long field_liftTime;
  public int field_logId;
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "logId";
    locala.ujN.put("logId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" logId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "logId";
    locala.columns[1] = "liftTime";
    locala.ujN.put("liftTime", "LONG");
    localStringBuilder.append(" liftTime LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.cm
 * JD-Core Version:    0.7.0.1
 */