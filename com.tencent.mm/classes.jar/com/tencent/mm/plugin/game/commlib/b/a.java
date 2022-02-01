package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.em;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends em
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(89949);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "key";
    locala.GvH.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "key";
    locala.columns[1] = "value";
    locala.GvH.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(89949);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.a
 * JD-Core Version:    0.7.0.1
 */