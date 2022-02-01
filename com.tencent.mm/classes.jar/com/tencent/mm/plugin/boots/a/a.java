package com.tencent.mm.plugin.boots.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.e;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends e
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(123715);
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.IBN.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.IBM = "key";
    locala.columns[1] = "mau";
    locala.IBN.put("mau", "INTEGER");
    localStringBuilder.append(" mau INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "dau";
    locala.IBN.put("dau", "INTEGER");
    localStringBuilder.append(" dau INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "useTime";
    locala.IBN.put("useTime", "LONG");
    localStringBuilder.append(" useTime LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(123715);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a.a
 * JD-Core Version:    0.7.0.1
 */