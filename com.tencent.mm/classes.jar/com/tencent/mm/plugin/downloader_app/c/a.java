package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends bd
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(8961);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appId";
    locala.columns[1] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "modifyTime";
    locala.IBN.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(8961);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.a
 * JD-Core Version:    0.7.0.1
 */