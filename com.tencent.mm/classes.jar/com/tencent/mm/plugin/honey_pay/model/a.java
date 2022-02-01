package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends dn
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(64645);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "payMsgId";
    locala.IBN.put("payMsgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "payMsgId";
    locala.columns[1] = "msgId";
    locala.IBN.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(64645);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.a
 * JD-Core Version:    0.7.0.1
 */