package com.tencent.mm.plugin.expt.c;

import com.tencent.mm.h.c.bh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends bh
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "exptKey";
    locala.ujN.put("exptKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" exptKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "exptKey";
    locala.columns[1] = "exptId";
    locala.ujN.put("exptId", "INTEGER");
    localStringBuilder.append(" exptId INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.b
 * JD-Core Version:    0.7.0.1
 */