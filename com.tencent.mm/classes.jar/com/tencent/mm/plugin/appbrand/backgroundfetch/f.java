package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.k;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends k
{
  static final c.a fkk;
  
  static
  {
    AppMethodBeat.i(143068);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.yrM.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "token";
    locala.yrM.put("token", "TEXT");
    localStringBuilder.append(" token TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(143068);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.f
 * JD-Core Version:    0.7.0.1
 */