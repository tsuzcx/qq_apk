package com.tencent.mm.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends fz
{
  public static c.a fkk;
  
  static
  {
    AppMethodBeat.i(51123);
    c.a locala = new c.a();
    locala.yrK = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "shareKeyHash";
    locala.yrM.put("shareKeyHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "shareKeyHash";
    locala.columns[1] = "btnState";
    locala.yrM.put("btnState", "INTEGER");
    localStringBuilder.append(" btnState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "msgState";
    locala.yrM.put("msgState", "INTEGER");
    localStringBuilder.append(" msgState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.yrM.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "contentColor";
    locala.yrM.put("contentColor", "TEXT");
    localStringBuilder.append(" contentColor TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "updatePeroid";
    locala.yrM.put("updatePeroid", "INTEGER");
    localStringBuilder.append(" updatePeroid INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(51123);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.af.a.b
 * JD-Core Version:    0.7.0.1
 */