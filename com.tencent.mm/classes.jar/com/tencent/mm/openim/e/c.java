package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends dk
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(78985);
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appid";
    locala.yrM.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "language";
    locala.yrM.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appRec";
    locala.yrM.put("appRec", "BLOB");
    localStringBuilder.append(" appRec BLOB");
    localStringBuilder.append(", ");
    locala.columns[3] = "updateTime";
    locala.yrM.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "acctTypeId";
    locala.yrM.put("acctTypeId", "TEXT");
    localStringBuilder.append(" acctTypeId TEXT");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(78985);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.e.c
 * JD-Core Version:    0.7.0.1
 */