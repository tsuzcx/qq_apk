package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dh
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(23551);
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "championUrl";
    locala.IhC.put("championUrl", "TEXT");
    localStringBuilder.append(" championUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "championMotto";
    locala.IhC.put("championMotto", "TEXT");
    localStringBuilder.append(" championMotto TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(23551);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */