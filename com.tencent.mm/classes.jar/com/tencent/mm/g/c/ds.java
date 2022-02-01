package com.tencent.mm.g.c;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ds
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fgD = "logId".hashCode();
  private static final int fgE = "liftTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fgB = true;
  private boolean fgC = true;
  public long field_liftTime;
  public int field_logId;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "logId";
    locala.IhC.put("logId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" logId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "logId";
    locala.columns[1] = "liftTime";
    locala.IhC.put("liftTime", "LONG");
    localStringBuilder.append(" liftTime LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ds
 * JD-Core Version:    0.7.0.1
 */