package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.h.c.cj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends cj
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "svrId";
    locala.ujN.put("svrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" svrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "svrId";
    locala.columns[1] = "isRead";
    locala.ujN.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "title";
    locala.ujN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.ujN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "pushTime";
    locala.ujN.put("pushTime", "LONG");
    localStringBuilder.append(" pushTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "msgType";
    locala.ujN.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "descUrl";
    locala.ujN.put("descUrl", "TEXT");
    localStringBuilder.append(" descUrl TEXT");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.g
 * JD-Core Version:    0.7.0.1
 */