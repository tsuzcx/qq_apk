package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends dp
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(25548);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "svrId";
    locala.IhC.put("svrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" svrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "svrId";
    locala.columns[1] = "isRead";
    locala.IhC.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "pushTime";
    locala.IhC.put("pushTime", "LONG");
    localStringBuilder.append(" pushTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "msgType";
    locala.IhC.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "descUrl";
    locala.IhC.put("descUrl", "TEXT");
    localStringBuilder.append(" descUrl TEXT");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(25548);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.g
 * JD-Core Version:    0.7.0.1
 */