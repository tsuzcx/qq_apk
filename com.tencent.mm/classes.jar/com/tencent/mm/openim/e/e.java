package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends dl
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(78990);
    c.a locala = new c.a();
    locala.yrK = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appid";
    locala.yrM.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "wordingId";
    locala.yrM.put("wordingId", "TEXT");
    localStringBuilder.append(" wordingId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "language";
    locala.yrM.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "wording";
    locala.yrM.put("wording", "TEXT");
    localStringBuilder.append(" wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "pinyin";
    locala.yrM.put("pinyin", "TEXT");
    localStringBuilder.append(" pinyin TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "quanpin";
    locala.yrM.put("quanpin", "TEXT");
    localStringBuilder.append(" quanpin TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.yrM.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(78990);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.e.e
 * JD-Core Version:    0.7.0.1
 */