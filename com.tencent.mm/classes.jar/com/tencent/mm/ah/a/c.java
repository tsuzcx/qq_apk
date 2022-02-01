package com.tencent.mm.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends hg
{
  public static c.a hlR;
  
  static
  {
    AppMethodBeat.i(2616);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shareKeyHash";
    locala.GvH.put("shareKeyHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "shareKeyHash";
    locala.columns[1] = "btnState";
    locala.GvH.put("btnState", "INTEGER");
    localStringBuilder.append(" btnState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgState";
    locala.GvH.put("msgState", "INTEGER");
    localStringBuilder.append(" msgState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.GvH.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "contentColor";
    locala.GvH.put("contentColor", "TEXT");
    localStringBuilder.append(" contentColor TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updatePeroid";
    locala.GvH.put("updatePeroid", "INTEGER");
    localStringBuilder.append(" updatePeroid INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(2616);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.a.c
 * JD-Core Version:    0.7.0.1
 */