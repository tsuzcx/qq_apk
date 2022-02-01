package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends bq
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(122445);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "exptKey";
    locala.GvH.put("exptKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" exptKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "exptKey";
    locala.columns[1] = "exptId";
    locala.GvH.put("exptId", "INTEGER");
    localStringBuilder.append(" exptId INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(122445);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.a
 * JD-Core Version:    0.7.0.1
 */