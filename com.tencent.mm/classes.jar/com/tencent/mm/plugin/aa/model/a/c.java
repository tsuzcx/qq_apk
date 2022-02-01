package com.tencent.mm.plugin.aa.model.a;

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
    AppMethodBeat.i(63423);
    c.a locala = new c.a();
    locala.GvF = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "billNo";
    locala.GvH.put("billNo", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" billNo TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "billNo";
    locala.columns[1] = "insertmsg";
    locala.GvH.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "localMsgId";
    locala.GvH.put("localMsgId", "LONG");
    localStringBuilder.append(" localMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.GvH.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(63423);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.c
 * JD-Core Version:    0.7.0.1
 */