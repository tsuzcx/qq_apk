package com.tencent.mm.plugin.downloader_app.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ax
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(136200);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.yrM.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appId";
    locala.columns[1] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "modifyTime";
    locala.yrM.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(136200);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a
 * JD-Core Version:    0.7.0.1
 */