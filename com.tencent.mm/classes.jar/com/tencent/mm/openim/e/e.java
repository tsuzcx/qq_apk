package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.et;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends et
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(151334);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appid";
    locala.IhC.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "wordingId";
    locala.IhC.put("wordingId", "TEXT");
    localStringBuilder.append(" wordingId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "language";
    locala.IhC.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "wording";
    locala.IhC.put("wording", "TEXT");
    localStringBuilder.append(" wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "pinyin";
    locala.IhC.put("pinyin", "TEXT");
    localStringBuilder.append(" pinyin TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "quanpin";
    locala.IhC.put("quanpin", "TEXT");
    localStringBuilder.append(" quanpin TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.IhC.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(151334);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.e.e
 * JD-Core Version:    0.7.0.1
 */