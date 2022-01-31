package com.tencent.mm.plugin.card.model;

import com.tencent.mm.h.c.ak;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends ak
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "code_id";
    locala.ujN.put("code_id", "TEXT");
    localStringBuilder.append(" code_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "card_id";
    locala.ujN.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "code";
    locala.ujN.put("code", "TEXT");
    localStringBuilder.append(" code TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.k
 * JD-Core Version:    0.7.0.1
 */