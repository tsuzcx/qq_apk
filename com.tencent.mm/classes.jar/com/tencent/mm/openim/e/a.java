package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.er;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends er
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(151325);
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "acctTypeId";
    locala.IBN.put("acctTypeId", "TEXT");
    localStringBuilder.append(" acctTypeId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "language";
    locala.IBN.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "accTypeRec";
    locala.IBN.put("accTypeRec", "BLOB");
    localStringBuilder.append(" accTypeRec BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.IBN.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(151325);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.e.a
 * JD-Core Version:    0.7.0.1
 */