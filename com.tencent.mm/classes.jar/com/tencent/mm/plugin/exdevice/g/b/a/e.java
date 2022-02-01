package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends cz
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(23557);
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "rankID";
    locala.GvH.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appusername";
    locala.GvH.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "timestamp";
    locala.GvH.put("timestamp", "INTEGER default '0' ");
    localStringBuilder.append(" timestamp INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "liketips";
    locala.GvH.put("liketips", "TEXT default '' ");
    localStringBuilder.append(" liketips TEXT default '' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(23557);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */