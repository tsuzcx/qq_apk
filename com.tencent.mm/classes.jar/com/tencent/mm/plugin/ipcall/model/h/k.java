package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends dh
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(25557);
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "phonenumber";
    locala.GvH.put("phonenumber", "TEXT");
    localStringBuilder.append(" phonenumber TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "calltime";
    locala.GvH.put("calltime", "LONG");
    localStringBuilder.append(" calltime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "duration";
    locala.GvH.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "addressId";
    locala.GvH.put("addressId", "LONG default '-1' ");
    localStringBuilder.append(" addressId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "phoneType";
    locala.GvH.put("phoneType", "INTEGER default '-1' ");
    localStringBuilder.append(" phoneType INTEGER default '-1' ");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(25557);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.k
 * JD-Core Version:    0.7.0.1
 */