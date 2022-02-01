package com.tencent.mm.plugin.lite.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends a
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(212376);
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "host";
    locala.IBN.put("host", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" host TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "host";
    locala.columns[1] = "param";
    locala.IBN.put("param", "TEXT");
    localStringBuilder.append(" param TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "headerMap";
    locala.IBN.put("headerMap", "TEXT");
    localStringBuilder.append(" headerMap TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "paramMap";
    locala.IBN.put("paramMap", "TEXT");
    localStringBuilder.append(" paramMap TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(212376);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d.c
 * JD-Core Version:    0.7.0.1
 */