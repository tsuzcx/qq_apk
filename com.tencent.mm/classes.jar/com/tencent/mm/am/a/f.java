package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends ah
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(124242);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "brandUserName";
    locala.IhC.put("brandUserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "brandUserName";
    locala.columns[1] = "userId";
    locala.IhC.put("userId", "TEXT");
    localStringBuilder.append(" userId TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124242);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.f
 * JD-Core Version:    0.7.0.1
 */