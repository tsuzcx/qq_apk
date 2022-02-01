package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ef;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class p
  extends ef
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(65223);
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "subtype";
    locala.IhC.put("subtype", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" subtype INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "subtype";
    locala.columns[1] = "bubbleMd5";
    locala.IhC.put("bubbleMd5", "TEXT");
    localStringBuilder.append(" bubbleMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "coverMd5";
    locala.IhC.put("coverMd5", "TEXT");
    localStringBuilder.append(" coverMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "minilogoMd5";
    locala.IhC.put("minilogoMd5", "TEXT");
    localStringBuilder.append(" minilogoMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "version";
    locala.IhC.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(65223);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.p
 * JD-Core Version:    0.7.0.1
 */