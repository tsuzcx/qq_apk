package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.m;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends m
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(101760);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.yrM.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "key";
    locala.columns[1] = "data";
    locala.yrM.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "dataType";
    locala.yrM.put("dataType", "TEXT");
    localStringBuilder.append(" dataType TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "size";
    locala.yrM.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(101760);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.a
 * JD-Core Version:    0.7.0.1
 */