package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends aq
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(112784);
    c.a locala = new c.a();
    locala.GvF = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "code_id";
    locala.GvH.put("code_id", "TEXT");
    localStringBuilder.append(" code_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "card_id";
    locala.GvH.put("card_id", "TEXT");
    localStringBuilder.append(" card_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "code";
    locala.GvH.put("code", "TEXT");
    localStringBuilder.append(" code TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112784);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.k
 * JD-Core Version:    0.7.0.1
 */