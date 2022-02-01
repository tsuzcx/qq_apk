package com.tencent.mm.ai.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends hq
{
  public static c.a hEe;
  
  static
  {
    AppMethodBeat.i(2616);
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shareKeyHash";
    locala.IhC.put("shareKeyHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "shareKeyHash";
    locala.columns[1] = "btnState";
    locala.IhC.put("btnState", "INTEGER");
    localStringBuilder.append(" btnState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgState";
    locala.IhC.put("msgState", "INTEGER");
    localStringBuilder.append(" msgState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "contentColor";
    locala.IhC.put("contentColor", "TEXT");
    localStringBuilder.append(" contentColor TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updatePeroid";
    locala.IhC.put("updatePeroid", "INTEGER");
    localStringBuilder.append(" updatePeroid INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(2616);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.a.c
 * JD-Core Version:    0.7.0.1
 */