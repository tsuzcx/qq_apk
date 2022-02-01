package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends dr
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(25557);
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "phonenumber";
    locala.IhC.put("phonenumber", "TEXT");
    localStringBuilder.append(" phonenumber TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "calltime";
    locala.IhC.put("calltime", "LONG");
    localStringBuilder.append(" calltime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "duration";
    locala.IhC.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "addressId";
    locala.IhC.put("addressId", "LONG default '-1' ");
    localStringBuilder.append(" addressId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "phoneType";
    locala.IhC.put("phoneType", "INTEGER default '-1' ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.k
 * JD-Core Version:    0.7.0.1
 */