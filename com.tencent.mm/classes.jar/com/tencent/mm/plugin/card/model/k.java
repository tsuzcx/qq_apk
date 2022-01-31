package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.al;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends al
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(87842);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "code_id";
    locala.yrM.put("code_id", "TEXT");
    localStringBuilder.append(" code_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "card_id";
    locala.yrM.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "code";
    locala.yrM.put("code", "TEXT");
    localStringBuilder.append(" code TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(87842);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.k
 * JD-Core Version:    0.7.0.1
 */