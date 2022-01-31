package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.h.c.cl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends cl
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "phonenumber";
    locala.ujN.put("phonenumber", "TEXT");
    localStringBuilder.append(" phonenumber TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "calltime";
    locala.ujN.put("calltime", "LONG");
    localStringBuilder.append(" calltime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "duration";
    locala.ujN.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "addressId";
    locala.ujN.put("addressId", "LONG default '-1' ");
    localStringBuilder.append(" addressId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "phoneType";
    locala.ujN.put("phoneType", "INTEGER default '-1' ");
    localStringBuilder.append(" phoneType INTEGER default '-1' ");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.k
 * JD-Core Version:    0.7.0.1
 */