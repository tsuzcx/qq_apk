package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends dl
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(23554);
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appusername";
    locala.IhC.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "rankID";
    locala.IhC.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "step";
    locala.IhC.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "sort";
    locala.IhC.put("sort", "INTEGER default '0' ");
    localStringBuilder.append(" sort INTEGER default '0' ");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(23554);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(23553);
    String str = "{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername;
    str = str + "}";
    AppMethodBeat.o(23553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */