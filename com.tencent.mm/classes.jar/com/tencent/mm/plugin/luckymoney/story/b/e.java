package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ee;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends ee
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(199015);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "send_id";
    locala.IhC.put("send_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" send_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "send_id";
    locala.columns[1] = "open_count";
    locala.IhC.put("open_count", "INTEGER");
    localStringBuilder.append(" open_count INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(199015);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.e
 * JD-Core Version:    0.7.0.1
 */