package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends ci
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(19489);
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "rankID";
    locala.yrM.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appusername";
    locala.yrM.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.yrM.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "timestamp";
    locala.yrM.put("timestamp", "INTEGER default '0' ");
    localStringBuilder.append(" timestamp INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "liketips";
    locala.yrM.put("liketips", "TEXT default '' ");
    localStringBuilder.append(" liketips TEXT default '' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(19489);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.a.e
 * JD-Core Version:    0.7.0.1
 */