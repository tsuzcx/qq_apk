package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.o;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends o
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(146932);
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.IBN.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "key";
    locala.columns[1] = "data";
    locala.IBN.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "dataType";
    locala.IBN.put("dataType", "TEXT");
    localStringBuilder.append(" dataType TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "size";
    locala.IBN.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(146932);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c
 * JD-Core Version:    0.7.0.1
 */