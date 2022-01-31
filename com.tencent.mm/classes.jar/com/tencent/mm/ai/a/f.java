package com.tencent.mm.ai.a;

import com.tencent.mm.h.c.ab;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends ab
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "brandUserName";
    locala.ujN.put("brandUserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "brandUserName";
    locala.columns[1] = "userId";
    locala.ujN.put("userId", "TEXT");
    localStringBuilder.append(" userId TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ai.a.f
 * JD-Core Version:    0.7.0.1
 */