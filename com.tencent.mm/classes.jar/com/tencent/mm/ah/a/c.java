package com.tencent.mm.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hs;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends hs
{
  public static c.a hGW;
  
  static
  {
    AppMethodBeat.i(2616);
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shareKeyHash";
    locala.IBN.put("shareKeyHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "shareKeyHash";
    locala.columns[1] = "btnState";
    locala.IBN.put("btnState", "INTEGER");
    localStringBuilder.append(" btnState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgState";
    locala.IBN.put("msgState", "INTEGER");
    localStringBuilder.append(" msgState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.IBN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "contentColor";
    locala.IBN.put("contentColor", "TEXT");
    localStringBuilder.append(" contentColor TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updatePeroid";
    locala.IBN.put("updatePeroid", "INTEGER");
    localStringBuilder.append(" updatePeroid INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    hGW = locala;
    AppMethodBeat.o(2616);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.a.c
 * JD-Core Version:    0.7.0.1
 */