package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.h.c.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends b
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "billNo";
    locala.ujN.put("billNo", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" billNo TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "billNo";
    locala.columns[1] = "insertmsg";
    locala.ujN.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "localMsgId";
    locala.ujN.put("localMsgId", "LONG");
    localStringBuilder.append(" localMsgId LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.ujN.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.b.c
 * JD-Core Version:    0.7.0.1
 */