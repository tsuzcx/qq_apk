package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ci
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(24943);
    c.a locala = new c.a();
    locala.GvF = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.GvH.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "key";
    locala.columns[1] = "value";
    locala.GvH.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "modifyTime";
    locala.GvH.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(24943);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.a
 * JD-Core Version:    0.7.0.1
 */