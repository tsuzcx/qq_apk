package com.tencent.mm.plugin.aa.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends b
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(40666);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "billNo";
    locala.yrM.put("billNo", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" billNo TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "billNo";
    locala.columns[1] = "insertmsg";
    locala.yrM.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "localMsgId";
    locala.yrM.put("localMsgId", "LONG");
    localStringBuilder.append(" localMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.yrM.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(40666);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.c
 * JD-Core Version:    0.7.0.1
 */