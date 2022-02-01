package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.i;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends i
{
  static final c.a hGW;
  
  static
  {
    AppMethodBeat.i(44463);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.IBN.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "usernameHash";
    locala.columns[1] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    hGW = locala;
    AppMethodBeat.o(44463);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.b
 * JD-Core Version:    0.7.0.1
 */