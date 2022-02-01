package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends db
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(23554);
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appusername";
    locala.GvH.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "rankID";
    locala.GvH.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "step";
    locala.GvH.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "sort";
    locala.GvH.put("sort", "INTEGER default '0' ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */