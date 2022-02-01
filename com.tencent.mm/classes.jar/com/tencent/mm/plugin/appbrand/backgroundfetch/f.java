package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.k;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends k
{
  static final c.a hEe;
  
  static
  {
    AppMethodBeat.i(44739);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "token";
    locala.IhC.put("token", "TEXT");
    localStringBuilder.append(" token TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    hEe = locala;
    AppMethodBeat.o(44739);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.f
 * JD-Core Version:    0.7.0.1
 */